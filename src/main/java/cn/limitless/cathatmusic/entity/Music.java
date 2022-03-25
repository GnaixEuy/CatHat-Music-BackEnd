package cn.limitless.cathatmusic.entity;

import cn.limitless.cathatmusic.enums.MusicStatus;
import lombok.Data;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/19
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
@Entity
public class Music extends BaseEntity {
	private String name;

	@Enumerated(EnumType.STRING)
	private MusicStatus status;

	@ManyToMany
	@JoinTable(name = "artist_music", joinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
	@ToString.Exclude
	private List<Artist> artistList;

	private String description;

	@OneToOne
	private File file;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
			return false;
		}
		Music music = (Music) o;
		return getId() != null && Objects.equals(getId(), music.getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
