package cn.limitless.cathatmusic.dao;

import cn.limitless.cathatmusic.entity.User;
import cn.limitless.cathatmusic.enums.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@SpringBootTest
@Transactional
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void testSelectList() {
		final List<User> users = this.userDao.selectList(null);
		users.forEach(System.out::println);
	}

	@Test
	void testSelectById() {
		final User user = this.userDao.selectById(1);
		final User user2 = this.userDao.selectById(2);
	}

	@Test
	public void testInsert() {
		final User user = new User();
		user.setUsername("GnaixEuyTest");
		user.setNickname("programmer: GnaixEuy");
		user.setEnabled(true);
		user.setLocked(false);
		user.setPassword("2333333");
		user.setGender(Gender.MALE);
		user.setLastLoginIp("127.0.0.1");
		user.setLastLoginTime(new Date());
		final int insert = this.userDao.insert(user);
		Assertions.assertEquals(1, insert);
		final Map<String, Object> stringStringMapMap = new HashMap<>();
		stringStringMapMap.put("username", "GnaixEuyTest");
		final List<User> users = this.userDao.selectByMap(stringStringMapMap);
		users.forEach(System.out::println);
	}


}