package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.dto.UserCreateDto;
import cn.limitless.cathatmusic.mapper.UserMapper;
import cn.limitless.cathatmusic.service.UserService;
import cn.limitless.cathatmusic.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/25
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@RestController
@RequestMapping(value = {"/users"})
public class UserController {

	private final UserService userService;
	private final UserMapper userMapper;

	@Autowired
	public UserController(UserService userService, UserMapper userMapper) {
		this.userService = userService;
		this.userMapper = userMapper;
	}

	@GetMapping(value = {"/"})
	public List<UserVo> list() {
		return userService.list()
				.stream()
				.map(this.userMapper::toDto)
				.map(this.userMapper::toVo)
				.collect(Collectors.toList());
	}

	@PostMapping(value = {"/"})
	public UserVo create(@RequestBody UserCreateDto userCreateDto) {
		return this.userMapper.toVo(this.userService.create(userCreateDto));
	}

}
