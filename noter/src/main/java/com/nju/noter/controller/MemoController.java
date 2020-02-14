package com.nju.noter.controller;

import com.nju.noter.entity.Memo;
import com.nju.noter.service.MemoService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.MemoVO;
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
    public ResponseData saveMemo(MemoVO vo){
        return null;
    }

    @RequestMapping(value = "/deleteMemo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData deleteMemo(MemoVO vo){
        return null;
    }

    @RequestMapping(value = "/checkMemo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData checkMemo(MemoVO vo){
        return null;
    }

    @RequestMapping(value = "/getMemoList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData getMemoList(){
        return null;
    }
}
