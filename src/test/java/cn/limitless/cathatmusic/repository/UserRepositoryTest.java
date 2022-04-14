/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

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