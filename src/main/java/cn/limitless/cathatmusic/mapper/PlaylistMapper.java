package cn.limitless.cathatmusic.mapper;

import cn.limitless.cathatmusic.dto.PlaylistCreateRequest;
import cn.limitless.cathatmusic.dto.PlaylistDto;
import cn.limitless.cathatmusic.entity.Playlist;
import cn.limitless.cathatmusic.vo.PlaylistVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/12
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Mapper(componentModel = "spring", uses = {FileMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PlaylistMapper extends MapperInterface<Playlist, PlaylistDto> {

	@Mapping(source = "coverId", target = "cover.id")
	PlaylistDto toDto(PlaylistCreateRequest playlistCreateRequest);

	PlaylistVo toVo(PlaylistDto playlistDto);
}