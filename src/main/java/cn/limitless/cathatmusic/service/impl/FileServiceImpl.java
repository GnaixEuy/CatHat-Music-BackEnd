package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dto.FileDto;
import cn.limitless.cathatmusic.dto.FileUploadDto;
import cn.limitless.cathatmusic.dto.FileUploadRequest;
import cn.limitless.cathatmusic.entity.File;
import cn.limitless.cathatmusic.enums.FileStatus;
import cn.limitless.cathatmusic.enums.Storage;
import cn.limitless.cathatmusic.exception.BizException;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.mapper.FileMapper;
import cn.limitless.cathatmusic.repository.FileRepository;
import cn.limitless.cathatmusic.service.FileService;
import cn.limitless.cathatmusic.service.StorageService;
import cn.limitless.cathatmusic.utils.FileTypeTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
public class FileServiceImpl extends BaseService implements FileService {

	private final Map<String, StorageService> storageServices;

	private final FileRepository repository;

	private final FileMapper mapper;

	@Override
	@Transactional
	public FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException {
		// 创建File实体
		File file = mapper.createEntity(fileUploadRequest);
		file.setType(FileTypeTransformer.getFileTypeFromExt(fileUploadRequest.getExt()));
		file.setStorage(getDefaultStorage());
		file.setCreatedBy(getCurrentUserEntity());
		file.setUpdatedBy(getCurrentUserEntity());
		File savedFile = repository.save(file);
		// 通过接口获取STS令牌
		FileUploadDto fileUploadDto = storageServices.get(getDefaultStorage().name()).initFileUpload();

		fileUploadDto.setKey(savedFile.getKey());
		fileUploadDto.setFileId(savedFile.getId());
		return fileUploadDto;
	}

	@Override
	public FileDto finishUpload(String id) {
		File file = getFileEntity(id);
		// Todo: 是否是SUPER_ADMIN
		if (!Objects.equals(file.getCreatedBy().getId(), getCurrentUserEntity().getId())) {
			throw new BizException(ExceptionType.FILE_NOT_PERMISSION);
		}

		// Todo: 验证远程文件是否存在

		file.setStatus(FileStatus.UPLOADED);
		return mapper.toDto(repository.save(file));
	}

	// Todo: 后台设置当前Storage
	@Override
	public Storage getDefaultStorage() {
		return Storage.COS;
	}

	@Override
	public File getFileEntity(String id) {
		Optional<File> fileOptional = repository.findById(id);
		if (!fileOptional.isPresent()) {
			throw new BizException(ExceptionType.FILE_NOT_FOUND);
		}
		return fileOptional.get();
	}
}
