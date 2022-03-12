package cn.limitless.cathatmusic.entity;

import cn.limitless.cathatmusic.enums.PlayListStatus;

import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/12
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public class Playlist extends BaseEntity {
	private String name;

	private String description;

	private File cover;

	private PlayListStatus status;

	private User creator;

	/**
	 * @Description: TODO： 增加持久层一对多对象映射
	 */
	private List<Music> musicList;
}
