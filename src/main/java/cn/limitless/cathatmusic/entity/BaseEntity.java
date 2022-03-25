package cn.limitless.cathatmusic.entity;

import lombok.Data;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.Objects;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@MappedSuperclass
@Data
public abstract class BaseEntity {

	@Id
	@GeneratedValue(generator = "ksuid")
	@GenericGenerator(name = "ksuid", strategy = "cn.limitless.cathatmusic.utils.KsuidIdentifierGenerator")
	private String id;

	@CreationTimestamp
	private Date createdTime;

	@UpdateTimestamp
	private Date updatedTime;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
			return false;
		}
		BaseEntity that = (BaseEntity) o;
		return id != null && Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
