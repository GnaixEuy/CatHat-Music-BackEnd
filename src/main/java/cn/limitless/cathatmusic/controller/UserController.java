package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.dto.UserCreateRequest;
import cn.limitless.cathatmusic.dto.UserDto;
import cn.limitless.cathatmusic.dto.UserUpdateRequest;
import cn.limitless.cathatmusic.mapper.UserMapper;
import cn.limitless.cathatmusic.service.UserService;
import cn.limitless.cathatmusic.vo.UserVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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

//	@GetMapping(value = {"/"})
//	public List<UserVo> list() {
//		return userService.list()
//				.stream()
//				.map(this.userMapper::toDto)
//				.map(this.userMapper::toVo)
//				.collect(Collectors.toList());
//	}

	@GetMapping(value = {"/"})
	public Page<UserVo> search(Page page) {
		page = this.userService.search(page);
		final List<UserVo> collect = ((List<UserDto>) page.getRecords())
				.stream()
				.map(this.userMapper::toVo)
				.collect(Collectors.toList());
		page.setRecords(collect);
		return page;
	}

	@PostMapping(value = {"/"})
	public UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest) {
		return this.userMapper.toVo(this.userService.create(userCreateRequest));
	}

	@GetMapping(value = {"/{id}"})
	UserVo get(@PathVariable String id) {
		return this.userMapper.toVo(
				this.userMapper.toDto(
						this.userService.getById(id)
				)
		);
	}

	@PutMapping(value = {"/{id}"})
	UserVo update(@PathVariable String id, @Validated @RequestBody UserUpdateRequest userUpdateRequest) {
		return null;
	}

	@DeleteMapping(value = {"/{id}"})
	void delete(@PathVariable String id) {
		this.userService.removeById(id);
	}

}
