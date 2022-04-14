/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.dto;

import cn.limitless.cathatmusic.enums.Gender;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
public class UserCreateRequest {

    @NotBlank(message = "用户名不能为空")
    @Size(min = 4, max = 64, message = "用户名长度应该在4个字符到64个字符之间")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 64, message = "密码长度应该在6个字符到64个字符之间")
    private String password;

    private String nickname;

    private Gender gender;

}
