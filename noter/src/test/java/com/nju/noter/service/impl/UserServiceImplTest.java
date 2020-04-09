package com.nju.noter.service.impl;

import com.nju.noter.service.UserService;
import com.nju.noter.vo.LoginVO;
import com.nju.noter.vo.NewPasswordVO;
import com.nju.noter.vo.NewUserVO;
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
        assertTrue(userService.addUser(new NewUserVO("testAddUser@t.t", "t", "t")).getResult());
        assertFalse(userService.addUser(new NewUserVO("testAddUser@t.t", "t", "t")).getResult());
    }

    @Test
    void checkUser() {
        assertFalse(userService.checkUser(new LoginVO("testCheckUser@t.t", "t")).getResult());
        userService.addUser(new NewUserVO("testCheckUser@t.t", "t", "t"));
        assertFalse(userService.checkUser(new LoginVO("testCheckUser@t.t", "tt")).getResult());
        assertTrue(userService.checkUser(new LoginVO("testCheckUser@t.t", "t")).getResult());
    }

    @Test
    void modifyUser() {
        String UserID = userService.addUser(new NewUserVO("testModifyUser@t.t", "t", "t")).getData();
        int id = Integer.parseInt(UserID);
        assertFalse(userService.modifyUser(new NewPasswordVO(id, "tt", "ttt")).getResult());
        assertTrue(userService.modifyUser(new NewPasswordVO(id, "t", "ttt")).getResult());
    }
}