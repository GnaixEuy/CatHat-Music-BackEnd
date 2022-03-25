package cn.limitless.cathatmusic.mapper;

import cn.limitless.cathatmusic.dto.FileDto;
import cn.limitless.cathatmusic.entity.File;
import cn.limitless.cathatmusic.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/13
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public abstract class FileMapperDecorator implements FileMapper {

	@Autowired
	@Qualifier("delegate")
	private FileMapper delegate;

	@Autowired
	private Map<String, StorageService> storageServices;

	@Override
	public FileDto toDto(File file) {
		FileDto fileDto = delegate.toDto(file);

		if (fileDto == null) {
			return null;
		}
		if (fileDto.getStorage() == null) {
			return null;
		}
		fileDto.setUri(storageServices.get(fileDto.getStorage().name()).getFileUri(fileDto.getKey()));
		return fileDto;
	}
}