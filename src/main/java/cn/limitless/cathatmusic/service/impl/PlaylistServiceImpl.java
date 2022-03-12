package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dao.PlaylistDao;
import cn.limitless.cathatmusic.dto.PlaylistDto;
import cn.limitless.cathatmusic.entity.Playlist;
import cn.limitless.cathatmusic.exception.BizException;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.mapper.PlaylistMapper;
import cn.limitless.cathatmusic.service.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/12
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Service
@AllArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
public class PlaylistServiceImpl implements PlaylistService {

	private final PlaylistDao playlistDao;
	private final PlaylistMapper playlistMapper;

	@Override
	public PlaylistDto get(String id) {
		final Playlist playlist = this.playlistDao.selectById(id);
		if (playlist == null) {
			throw new BizException(ExceptionType.PLAYLIST_NOT_FOUND);
		}
		return this.playlistMapper.toDto(playlist);
	}
}
