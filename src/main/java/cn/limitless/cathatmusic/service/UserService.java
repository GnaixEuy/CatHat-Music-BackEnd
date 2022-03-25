package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.TokenCreateRequest;
import cn.limitless.cathatmusic.dto.UserCreateRequest;
import cn.limitless.cathatmusic.dto.UserDto;
import cn.limitless.cathatmusic.dto.UserUpdateRequest;
import cn.limitless.cathatmusic.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/25
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public interface UserService extends UserDetailsService {
	UserDto create(UserCreateRequest userCreateRequest);

	@Override
	User loadUserByUsername(String username);

	UserDto get(String id);

	UserDto update(String id, UserUpdateRequest userUpdateRequest);

	void delete(String id);

	Page<UserDto> search(Pageable pageable);

	String createToken(TokenCreateRequest tokenCreateRequest);

	UserDto getCurrentUser();

	String createTokenByOpenId(String openId);
}
