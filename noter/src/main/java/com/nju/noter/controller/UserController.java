package com.nju.noter.controller;

import com.nju.noter.util.ResponseData;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData login(HttpRequest httpRequest, HttpServletResponse httpServletResponse){
        ResponseData responseData = null;

        if(responseData.isResult()){
            Cookie cookie = new Cookie("ID", "todo");
            cookie.setMaxAge(1000);
            httpServletResponse.addCookie(cookie);
        }

        return responseData;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData logout(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("ID"))
                cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return new ResponseData(true);
    }


}
