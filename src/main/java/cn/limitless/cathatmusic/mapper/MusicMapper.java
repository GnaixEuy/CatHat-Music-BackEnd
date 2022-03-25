package cn.limitless.cathatmusic.mapper;

import cn.limitless.cathatmusic.dto.ArtistDto;
import cn.limitless.cathatmusic.dto.MusicCreateRequest;
import cn.limitless.cathatmusic.dto.MusicDto;
import cn.limitless.cathatmusic.dto.MusicUpdateRequest;
import cn.limitless.cathatmusic.entity.Music;
import cn.limitless.cathatmusic.vo.MusicVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/21
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Mapper(componentModel = "spring",
		uses = {FileMapper.class},
		nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface MusicMapper extends MapperInterface<Music, MusicDto> {
	@Mapping(source = "fileId", target = "file.id")
	@Mapping(target = "artistList", source = "artistIds")
	MusicDto toDto(MusicCreateRequest musicCreateRequest);

	@Mapping(source = "fileId", target = "file.id")
	@Mapping(target = "artistList", source = "artistIds")
	MusicDto toDto(MusicUpdateRequest musicUpdateRequest);

	MusicVo toVo(MusicDto musicDto);


	default List<ArtistDto> mapArtistList(List<String> artistIds) {
		List<ArtistDto> artistList = new ArrayList<ArtistDto>();
		for (String id : artistIds) {
			ArtistDto artistDto = new ArtistDto();
			artistDto.setId(id);
			artistList.add(artistDto);
		}
		return artistList;
	}
}