package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.PlaylistDto;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/12
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public interface PlaylistService {
	PlaylistDto get(String id);
}
