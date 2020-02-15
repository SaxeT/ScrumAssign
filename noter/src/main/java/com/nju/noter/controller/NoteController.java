package com.nju.noter.controller;

import com.nju.noter.service.NoteService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/note")
public class NoteController {
    @Autowired
    NoteService noteService;

    @RequestMapping(value = "/addNote", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addNote(NoteVO noteVO){
        ResponseData responseData = noteService.addNote(noteVO);
        return responseData;
    }

    @RequestMapping(value = "/getNote", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getNote(int noteID){
        ResponseData responseData = noteService.getNote(noteID);
        return responseData;
    }

    @RequestMapping(value = "/allNotes", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData allNotes(int userID){
        ResponseData responseData = noteService.getAllNotes(userID);
        return responseData;
    }


}