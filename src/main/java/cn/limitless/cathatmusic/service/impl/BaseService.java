package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.entity.User;
import cn.limitless.cathatmusic.exception.BizException;
import cn.limitless.cathatmusic.exception.ExceptionType;
import cn.limitless.cathatmusic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/12
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public abstract class BaseService {

	private UserRepository userRepository;

	protected User getCurrentUserEntity() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		// todo
		return loadUserByUsername(authentication.getName());
	}

	protected User loadUserByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isEmpty()) {
			throw new BizException(ExceptionType.USER_NOT_FOUND);
		}
		return user.get();
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}