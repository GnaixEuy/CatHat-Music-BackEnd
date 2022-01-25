package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dao.UserDao;
import cn.limitless.cathatmusic.dto.UserDto;
import cn.limitless.cathatmusic.entity.User;
import cn.limitless.cathatmusic.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

	private UserDao userDao;
	private UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserDao userDao, UserMapper userMapper) {
		this.userDao = userDao;
		this.userMapper = userMapper;
	}


	@Override
	public List<UserDto> getList() {
		final List<User> list = super.list();
		return list.stream().map(userMapper::toDto).collect(Collectors.toList());
	}
}
