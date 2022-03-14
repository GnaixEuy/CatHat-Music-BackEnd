package cn.limitless.cathatmusic.vo;

import cn.limitless.cathatmusic.enums.Gender;
import lombok.*;

import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/25
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo extends BaseVo {

	private String username;

	private String nickname;

	private Gender gender;

	private Boolean locked;

	private Boolean enabled;

	private List<RoleVo> roles;
}
