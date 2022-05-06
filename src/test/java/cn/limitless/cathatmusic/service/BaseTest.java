/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.UserCreateRequest;
import cn.limitless.cathatmusic.dto.UserDto;
import cn.limitless.cathatmusic.entity.User;
import cn.limitless.cathatmusic.enums.Gender;
import cn.limitless.cathatmusic.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class BaseTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setDefaultUser() {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setUsername("GnaixEuy");
        userCreateRequest.setNickname("GnaixEuy");
        userCreateRequest.setPassword("niceworld");
        userCreateRequest.setGender(Gender.MALE);
        UserDto userDto = userService.create(userCreateRequest);

        User user = userService.loadUserByUsername(userDto.getUsername());
        userRepository.save(user);
    }
}
