package com.nju.noter.test;

import com.nju.noter.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {
    @Autowired
    UserController userController;

    @RequestMapping(value = "/test")
    public String getTest() {
//        newUserVO vo = new newUserVO("a@b.c", "testAdd", "test");
//        System.out.println(userController.signup(vo).getMessage());

//        loginVO vo = new loginVO("a@b.c", "test");
//        System.out.println(userController.login(vo).getMessage());

        // newPasswordVO vo = new newPasswordVO(3, "t", "test");
        // System.out.println(userController.changePassword(vo).getMessage());
        return "test";
    }

}
