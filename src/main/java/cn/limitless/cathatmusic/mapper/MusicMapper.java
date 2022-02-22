package cn.limitless.cathatmusic.mapper;

import cn.limitless.cathatmusic.dto.MusicCreateRequest;
import cn.limitless.cathatmusic.dto.MusicDto;
import cn.limitless.cathatmusic.dto.MusicUpdateRequest;
import cn.limitless.cathatmusic.entity.Music;
import cn.limitless.cathatmusic.vo.MusicVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/21
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Mapper(componentModel = "spring")
public interface MusicMapper {

	MusicDto toDto(Music music);

	MusicVo toVo(MusicDto musicDto);

	Music createEntity(MusicCreateRequest musicCreateRequest);

	Music updateEntity(@MappingTarget Music music, MusicUpdateRequest musicUpdateRequest);
}
