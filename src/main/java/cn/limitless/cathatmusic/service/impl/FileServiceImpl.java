package cn.limitless.cathatmusic.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.limitless.cathatmusic.dao.FileDao;
import cn.limitless.cathatmusic.dto.FileDto;
import cn.limitless.cathatmusic.dto.FileUploadDto;
import cn.limitless.cathatmusic.dto.FileUploadRequest;
import cn.limitless.cathatmusic.entity.File;
import cn.limitless.cathatmusic.enums.FileStatus;
import cn.limitless.cathatmusic.enums.Storage;
import cn.limitless.cathatmusic.exception.BizException;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.mapper.FileMapper;
import cn.limitless.cathatmusic.service.FileService;
import cn.limitless.cathatmusic.service.StorageService;
import cn.limitless.cathatmusic.utils.FileTypeTransformer;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Service
@Builder
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
public class FileServiceImpl extends BaseService implements FileService {

	private final Map<String, StorageService> storageServiceMap;
	private final FileDao fileDao;
	private final FileMapper fileMapper;

	@Override
	@Transactional
	public FileUploadDto initUpload(FileUploadRequest fileUploadRequest) {
		// 创建File 实体
		final File file = this.fileMapper.createEntity(fileUploadRequest);
		file.setType(FileTypeTransformer.getFileTypeFromExt(fileUploadRequest.getExt()));
		file.setStorage(getDefaultStorage());
		file.setCreatedBy(getCurrentUserEntity());
		file.setUpdatedBy(getCurrentUserEntity());
		final int result = this.fileDao.insert(file);
		if (result == 1) {
			final String key = fileUploadRequest.getKey();
			final String name = fileUploadRequest.getName();
			final File resultFile = this.fileDao.selectOne(
					Wrappers.<File>lambdaQuery()
							.eq(File::getKey, key)
							.eq(File::getName, name));
			// 通过接口获取STS令牌
			final FileUploadDto fileUploadDto = this.storageServiceMap.get(getDefaultStorage().name()).initFileUpload();
			fileUploadDto.setKey(resultFile.getKey());
			fileUploadDto.setFileId(resultFile.getId());
			return fileUploadDto;
		} else {
			throw new BizException(ExceptionType.INNER_ERROR);
		}
	}

	@Override
	public FileDto finishUpload(String id) {
		final File file = this.fileDao.selectById(id);
		if (ObjectUtil.isNull(file)) {
			throw new BizException(ExceptionType.FILE_BOT_FOUND);
		}
		if (!Objects.equals(file.getCreatedBy().getId(), getCurrentUserEntity().getId())) {
			throw new BizException(ExceptionType.FILE_NOT_PERMISSION);
		}
		//TODO: 验证远程文件是否存在
		file.setFileStatus(FileStatus.UPLOADED);
		return this.fileMapper.toDto(file);
	}


	/**
	 * TODO: 后台设置当前Storage
	 */
	@Override
	public Storage getDefaultStorage() {
		return Storage.COS;
	}

}
