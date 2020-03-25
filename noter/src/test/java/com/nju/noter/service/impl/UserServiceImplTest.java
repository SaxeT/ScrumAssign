package com.nju.noter.service.impl;

import com.nju.noter.service.UserService;
import com.nju.noter.vo.newUserVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    void addUser() {
        assertTrue(userService.addUser(new newUserVO("testAddUser@t.t", "t", "t")).getResult());
        assertFalse(userService.addUser(new newUserVO("testAddUser@t.t", "t", "t")).getResult());
    }

    @Test
    void checkUser() {
    }

    @Test
    void modifyUser() {
    }
}