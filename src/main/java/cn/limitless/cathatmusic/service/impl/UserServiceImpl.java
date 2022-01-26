package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dao.UserDao;
import cn.limitless.cathatmusic.dto.UserCreateDto;
import cn.limitless.cathatmusic.dto.UserDto;
import cn.limitless.cathatmusic.entity.User;
import cn.limitless.cathatmusic.exception.BizException;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.mapper.UserMapper;
import cn.limitless.cathatmusic.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/25
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Service
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
	public UserDto create(UserCreateDto userCreateDto) {
		final String userName = userCreateDto.getUsername();
		this.checkUserName(userName);
		try {
			final User user = this.userMapper.createEntity(userCreateDto);
			user.setPassword(this.passwordEncoder.encode(user.getPassword()));
			final int result = this.userDao.insert(user);
			if (result == 1) {
				final List<User> users = this.userDao.selectByMap(new HashMap<>(1) {{
					put("username", userName);
				}});
				if (users.size() == 1) {
					return this.userMapper.toDto(users.get(0));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizException(ExceptionType.USER_INSERT_ERROR);
		}
		throw new BizException(ExceptionType.USER_INSERT_ERROR);
	}

	private void checkUserName(String userName) {
		final List<User> users = this.userDao.selectByMap(new HashMap<>(1) {{
			put("username", userName);
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
