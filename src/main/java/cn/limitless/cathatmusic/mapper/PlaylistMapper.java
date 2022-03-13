package cn.limitless.cathatmusic.mapper;

import cn.limitless.cathatmusic.dto.PlaylistDto;
import cn.limitless.cathatmusic.entity.Playlist;
import cn.limitless.cathatmusic.vo.PlaylistVo;
import org.mapstruct.Mapper;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/12
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Mapper(componentModel = "spring", uses = MusicMapper.class)
public interface PlaylistMapper {
	PlaylistDto toDto(Playlist playlist);

	PlaylistVo toVo(PlaylistDto playlistDto);
}