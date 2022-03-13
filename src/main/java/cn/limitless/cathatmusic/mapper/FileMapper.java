package cn.limitless.cathatmusic.mapper;

import cn.limitless.cathatmusic.dto.FileDto;
import cn.limitless.cathatmusic.dto.FileUploadRequest;
import cn.limitless.cathatmusic.entity.File;
import cn.limitless.cathatmusic.vo.FileVo;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/3
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Mapper(componentModel = "spring")
@DecoratedWith(FileMapperDecorator.class)
public interface FileMapper {
	File createEntity(FileUploadRequest fileUploadRequest);

	FileVo toVo(FileDto fileDto);

	FileDto toDto(File file);
}
