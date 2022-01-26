package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dao.UserDao;
import cn.limitless.cathatmusic.entity.User;
import cn.limitless.cathatmusic.mapper.UserMapper;
import cn.limitless.cathatmusic.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
}
