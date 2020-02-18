package com.nju.noter.controller;

import com.nju.noter.service.MemoService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.memoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/memo")
public class MemoController {
    @Autowired
    MemoService memoService;

    @RequestMapping(value = "/saveMemo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData saveMemo(memoVO vo){
        return null;
    }

    @RequestMapping(value = "/deleteMemo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData deleteMemo(memoVO vo){
        return null;
    }

    @RequestMapping(value = "/checkMemo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData checkMemo(memoVO vo){
        return null;
    }

    @RequestMapping(value = "/getMemoList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData getMemoList(){
        return null;
    }
}
