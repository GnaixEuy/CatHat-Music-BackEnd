package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.dto.UserCreateRequest;
import cn.limitless.cathatmusic.dto.UserDto;
import cn.limitless.cathatmusic.dto.UserUpdateRequest;
import cn.limitless.cathatmusic.entity.User;
import cn.limitless.cathatmusic.exception.BizException;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.mapper.UserMapper;
import cn.limitless.cathatmusic.service.UserService;
import cn.limitless.cathatmusic.vo.UserVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
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
@Api(tags = {"用户"})
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {

	private final UserService userService;
	private final UserMapper userMapper;


//	@GetMapping(value = {"/"})
//	public List<UserVo> list() {
//		return userService.list()
//				.stream()
//				.map(this.userMapper::toDto)
//				.map(this.userMapper::toVo)
//				.collect(Collectors.toList());
//	}

	@GetMapping(value = {""})
	@ApiOperation(value = "用户检索")
	@RolesAllowed(value = {"ROLE_ADMIN"})
	public Page<UserVo> search(Page page) {
		page = this.userService.search(page);
		final List<UserVo> collect = ((List<UserDto>) page.getRecords())
				.stream()
				.map(this.userMapper::toVo)
				.collect(Collectors.toList());
		page.setRecords(collect);
		return page;
	}

	@PostMapping(value = {""})
	@RolesAllowed(value = {"ROLE_ADMIN"})
	public UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest) {
		return this.userMapper.toVo(this.userService.create(userCreateRequest));
	}

	@GetMapping(value = {"/{id}"})
	public UserVo get(@PathVariable String id) {
		final User user = this.userService.getById(id);
		if (user == null) {
			throw new BizException(ExceptionType.USER_NOT_FOUND);
		} else {
			return this.userMapper.toVo(this.userMapper.toDto(user));
		}
	}

	/**
	 * 时间自动更新bug 已修复，待全面测试
	 */
	@PutMapping(value = {"/{id}"})
	@RolesAllowed(value = {"ROLE_ADMIN"})
	public UserVo update(@PathVariable String id, @Validated @RequestBody UserUpdateRequest userUpdateRequest) {
		final UserDto userDto = this.userService.update(id, userUpdateRequest);
		return this.userMapper.toVo(userDto);
	}

	@DeleteMapping(value = {"/{id}"})
	@RolesAllowed(value = {"ROLE_ADMIN"})
	void delete(@PathVariable String id) {
		final boolean success = this.userService.removeById(id);
		if (!success) {
			throw new BizException(ExceptionType.USER_DELETE_ERROR);
		}
	}

	@GetMapping(value = {"/me"})
	UserVo me() {
		return this.userMapper.toVo(this.userService.getCurrentUser());
	}

}
