package com.nju.noter.test;

import com.nju.noter.dao.UserDao;
import com.nju.noter.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/test")
    public User getTest() {
        System.out.println(userDao.findByID(1).getName());
        return userDao.findByID(1);
    }
}
