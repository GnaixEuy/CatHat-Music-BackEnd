package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.dto.TokenCreateRequest;
import cn.limitless.cathatmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/1
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@RestController
@RequestMapping(value = {"/tokens"})
public class TokenController {

	private final UserService userService;

	@Autowired
	public TokenController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = {""})
	public String create(@RequestBody TokenCreateRequest tokenCreateRequest) {
		return this.userService.createToken(tokenCreateRequest);
	}
}