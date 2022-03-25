package cn.limitless.cathatmusic.entity;

import lombok.Data;

import javax.persistence.Entity;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/25
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Entity
@Data
public class Role extends BaseEntity {

	private String name;

	private String title;

}
