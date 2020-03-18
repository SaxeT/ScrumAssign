package com.nju.noter.controller;

import com.nju.noter.service.UserService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.loginVO;
import com.nju.noter.vo.newPasswordVO;
import com.nju.noter.vo.newUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData signup(newUserVO vo){
        System.out.println(vo.toString());
        ResponseData responseData = userService.addUser(vo);
        return responseData;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData login(loginVO vo){
        ResponseData responseData = userService.checkUser(vo);
        return responseData;
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData changePassword(newPasswordVO vo){
        ResponseData responseData = userService.modifyUser(vo);
        return responseData;
    }

//    cookie部分迭代二再做
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseData login(loginVO vo, HttpServletResponse httpServletResponse){
//        ResponseData responseData = userService.checkUser(vo);
//
//        if(responseData.isResult()){
//            Cookie cookie = new Cookie("ID", "");
//            cookie.setMaxAge(1000);
//            httpServletResponse.addCookie(cookie);
//        }
//
//        return responseData;
//    }
//
//    @RequestMapping(value = "/logout", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseData logout(HttpServletRequest request, HttpServletResponse response){
//        Cookie[] cookies = request.getCookies();
//
//        for (Cookie cookie: cookies) {
//            if (cookie.getName().equals("ID"))
//                cookie.setMaxAge(0);
//            response.addCookie(cookie);
//        }
//        return new ResponseData(true);
//    }



}
