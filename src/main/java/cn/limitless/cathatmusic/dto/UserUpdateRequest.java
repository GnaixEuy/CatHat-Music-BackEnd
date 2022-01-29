package cn.limitless.cathatmusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/29
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
public class UserUpdateRequest {

	@NotBlank(message = "用户名不能为空")
	@Size(min = 4, max = 64, message = "用户名长度应该在4个字符到64个字符之间")
	private String username;

	private String nickname;

	private String gender;
}