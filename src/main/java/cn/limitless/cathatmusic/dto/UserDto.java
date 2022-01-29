package cn.limitless.cathatmusic.dto;

import cn.limitless.cathatmusic.enums.Gender;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/25
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */

@Data
public class UserDto {

	private String id;

	private String username;

	private String nickname;

	private List<RoleDto> roles;

	private Gender gender;

	private Boolean locked;

	private Boolean enabled;

	private String lastLoginIp;

	private Date lastLoginTime;
}
