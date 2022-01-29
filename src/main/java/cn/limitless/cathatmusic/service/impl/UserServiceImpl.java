package cn.limitless.cathatmusic.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.limitless.cathatmusic.dao.UserDao;
import cn.limitless.cathatmusic.dto.UserCreateRequest;
import cn.limitless.cathatmusic.dto.UserDto;
import cn.limitless.cathatmusic.entity.User;
import cn.limitless.cathatmusic.exception.BizException;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.mapper.UserMapper;
import cn.limitless.cathatmusic.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/25
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

	private final UserMapper userMapper;
	private final UserDao userDao;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserMapper userMapper, UserDao userDao, PasswordEncoder passwordEncoder) {
		this.userMapper = userMapper;
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Page<UserDto> search(Page page) {

		page = this.userDao.selectPage(page, Wrappers.<User>lambdaQuery().orderByAsc(User::getCreatedTime));

		final List<UserDto> userDtoList = ((List<User>) page.getRecords())
				.stream()
				.map(this.userMapper::toDto)
				.collect(Collectors.toList());
		log.info(userDtoList.toString());
		page.setRecords(userDtoList);
		return page;
	}

	@Override
	public UserDto create(UserCreateRequest userCreateRequest) {
		final String username = userCreateRequest.getUsername();
		this.checkUserName(username);
		try {
			final User user = this.userMapper.createEntity(userCreateRequest);
			user.setPassword(this.passwordEncoder.encode(user.getPassword()));
			final int result = this.userDao.insert(user);
			if (result == 1) {
				final User resultUser = this.userDao.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
				if (ObjectUtil.isNotNull(resultUser)) {
					return this.userMapper.toDto(resultUser);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizException(ExceptionType.USER_INSERT_ERROR);
		}
		throw new BizException(ExceptionType.USER_INSERT_ERROR);
	}

	private void checkUserName(String username) {
		final List<User> users = this.userDao.selectByMap(new HashMap<>(1) {{
			put("username", username);
		}});
		if (!users.isEmpty()) {
			throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
		}
	}

	@Override
	public User loadUserByUsername(String username) {
		User user = this.userDao.selectByMap(new HashMap<>(1) {{
			put("username", username);
		}}).get(0);
		if (user == null) {
			throw new BizException(ExceptionType.USER_NOT_FOUND);
		}
		return user;
	}
}
