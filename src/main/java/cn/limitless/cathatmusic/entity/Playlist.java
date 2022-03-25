package cn.limitless.cathatmusic.entity;

import cn.limitless.cathatmusic.enums.PlayListStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/12
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Entity
@Data
public class Playlist extends BaseEntity {
	private String name;

	private String description;

	@OneToOne
	private File cover;

	@Enumerated(EnumType.STRING)
	private PlayListStatus status;

	@OneToOne
	private User creator;

	@ManyToMany
	@JoinTable(name = "playlist_music", joinColumns = @JoinColumn(name = "playlist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
	private List<Music> musicList;
}