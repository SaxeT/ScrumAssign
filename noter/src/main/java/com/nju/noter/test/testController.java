package com.nju.noter.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

    @RequestMapping(value = "/test")
    public String getTest() {
        return "test";
    }
}
