package cn.limitless.cathatmusic.mapper;

import cn.limitless.cathatmusic.dto.ArtistCreateRequest;
import cn.limitless.cathatmusic.dto.ArtistDto;
import cn.limitless.cathatmusic.dto.ArtistUpdateRequest;
import cn.limitless.cathatmusic.entity.Artist;
import cn.limitless.cathatmusic.vo.ArtistVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/13
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Mapper(componentModel = "spring", uses = {FileMapper.class, MusicMapper.class})
public interface ArtistMapper {

	@Mapping(source = "photoId", target = "photo.id")
	Artist createEntity(ArtistCreateRequest artistCreateRequest);

	@Mapping(source = "photoId", target = "photo.id")
	Artist updateEntity(@MappingTarget Artist artist, ArtistUpdateRequest artistUpdateRequest);

	ArtistDto toDto(Artist artist);

	ArtistVo toVo(ArtistDto artistDto);
}