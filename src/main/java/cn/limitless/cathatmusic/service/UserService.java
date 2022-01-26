package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.UserCreateDto;
import cn.limitless.cathatmusic.dto.UserDto;
import cn.limitless.cathatmusic.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/25
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public interface UserService extends IService<User>, UserDetailsService {

	UserDto create(UserCreateDto userCreateDto);

	@Override
	User loadUserByUsername(String username);
}
