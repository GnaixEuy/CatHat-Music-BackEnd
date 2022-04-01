package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.PlaylistDto;
import cn.limitless.cathatmusic.dto.PlaylistSearchFilter;
import cn.limitless.cathatmusic.entity.Playlist;
import org.springframework.data.domain.Page;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/25
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public interface PlaylistService extends GeneralService<Playlist, PlaylistDto> {
	Page<PlaylistDto> search(PlaylistSearchFilter playlistSearchFilter);

	PlaylistDto recommend(String id, Integer recommendFactor);

	PlaylistDto cancelRecommendation(String id);

	PlaylistDto makeSpecial(String id);

	PlaylistDto cancelSpecial(String id);
}
