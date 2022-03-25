package cn.limitless.cathatmusic.repository;

import cn.limitless.cathatmusic.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/25
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@SpringBootTest
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	void getByUsername() {
	}

	@Test
	void findByUsername() {
		final Optional<User> admin = this.userRepository.findByUsername("admin");
		if (admin.isPresent()) {
			System.out.println(admin.get());
		} else {
			System.out.println("草");
		}
	}

	@Test
	void getById() {
	}

	@Test
	void findAll() {
	}

	@Test
	void getByOpenId() {
	}
}