package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dto.UserDto;
import cn.limitless.cathatmusic.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/13
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
@Transactional
class UserServiceImplTest {

	private final UserService userService;

	@Test
	void search() {
		final Page<UserDto> userDtoPage = new Page<>();
		userDtoPage
				.setSize(2)
				.setPages(1);
		final Page<UserDto> searchList = this.userService.search(userDtoPage);
		Assertions.assertNotNull(searchList);
		searchList.getRecords().forEach(System.out::println);
	}

	@Test
	void create() {
	}

	@Test
	void update() {
	}

	@Test
	void delete() {
	}

	@Test
	void loadUserByUsername() {
	}

	@Test
	void get() {
	}

	@Test
	void createToken() {
	}

	@Test
	void getCurrentUser() {
	}

}