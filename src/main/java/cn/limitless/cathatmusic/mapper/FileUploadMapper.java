package cn.limitless.cathatmusic.mapper;

import cn.limitless.cathatmusic.dto.FileUploadDto;
import cn.limitless.cathatmusic.vo.FileUploadVo;
import org.mapstruct.Mapper;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Mapper(componentModel = "spring")
public interface FileUploadMapper {

	FileUploadVo toVo(FileUploadDto fileUploadDto);
}
