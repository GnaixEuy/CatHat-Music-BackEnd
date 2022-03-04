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
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
public class FileServiceImpl extends ServiceImpl<FileDao, File> implements FileService {

	private final Map<String, StorageService> storageServiceMap;
	private final FileDao fileDao;
	private final FileMapper fileMapper;

	@Override
	@Transactional
	public FileUploadDto initUpload(FileUploadRequest fileUploadRequest) {

		// 创建File 实体
		final int result = this.fileDao.insert(this.fileMapper.createEntity(fileUploadRequest));
		if (result == 1) {
			final String key = fileUploadRequest.getKey();
			final String name = fileUploadRequest.getName();
			final File file = this.fileDao.selectOne(
					Wrappers.<File>lambdaQuery()
							.eq(File::getKey, key)
							.eq(File::getName, name));
			// 通过接口获取STS令牌
			final FileUploadDto fileUploadDto = this.storageServiceMap.get(getDefaultStorage().name()).initFileUpload();
			fileUploadDto.setKey(file.getKey());
			fileUploadDto.setFileId(file.getId());
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
		//TODO: 只有上传者才能给更新finish； 鉴权

		//TODO: 验证远程文件是否存在
		file.setFileStatus(FileStatus.UPLOADED);
		return this.fileMapper.toDto(file);
	}


	/**
	 * TODO: 后台设置当前Storage
	 */
	private Storage getDefaultStorage() {
		return Storage.COS;
	}

}
