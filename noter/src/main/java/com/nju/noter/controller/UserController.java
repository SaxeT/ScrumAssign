package com.nju.noter.controller;

import com.nju.noter.service.UserService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.LoginVO;
import com.nju.noter.vo.NewPasswordVO;
import com.nju.noter.vo.NewUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData signup(NewUserVO vo){
        return userService.addUser(vo);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData login(LoginVO vo){
        return userService.checkUser(vo);
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData changePassword(NewPasswordVO vo){
        return userService.modifyUser(vo);
    }

}
