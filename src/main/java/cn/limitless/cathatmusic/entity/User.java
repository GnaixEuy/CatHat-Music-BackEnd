package cn.limitless.cathatmusic.entity;

import cn.limitless.cathatmusic.enums.Gender;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

import java.util.Date;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class User extends AbstractEntity {

	@TableField(value = "username")
	private String userName;

	@TableField(value = "nickname")
	private String nickName;

	@TableField(value = "password")
	private String password;

	@TableField(value = "gender")
	private Gender gender;

	@TableField(value = "locked")
	private Boolean locked;

	@TableField(value = "enabled")
	private Boolean enabled;

	@TableField(value = "last_login_ip")
	private String lastLoginIp;

	@TableField(value = "last_login_time")
	private Date lastLoginTime;
	
}
