package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dao.UserDao;
import cn.limitless.cathatmusic.entity.User;
import cn.limitless.cathatmusic.exception.BizException;
import cn.limitless.cathatmusic.exception.ExceptionType;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/12
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseService {

	@Autowired
	private UserDao userDao;

	protected User getCurrentUserEntity() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		// todo
		return loadUserByUsername(authentication.getName());
	}

	protected User loadUserByUsername(String username) {
		final User user = this.userDao.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
		if (user == null) {
			throw new BizException(ExceptionType.USER_NOT_FOUND);
		} else {
			return user;
		}
	}
}
