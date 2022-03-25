package cn.limitless.cathatmusic.repository;

import cn.limitless.cathatmusic.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public interface UserRepository extends JpaRepository<User, String> {
	User getByUsername(String username);

	Optional<User> findByUsername(String username);

	User getById(String id);

	Page<User> findAll(Pageable pageable);

	User getByOpenId(String openId);
}