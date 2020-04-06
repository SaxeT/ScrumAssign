package com.nju.noter.controller;

import com.nju.noter.service.NoteService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseData addNote(@RequestBody NoteVO noteVO){
        return noteService.addNote(noteVO);
    }

    @RequestMapping(value = "/getNote", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getNote(int noteID){
        return noteService.getNote(noteID);
    }

    @RequestMapping(value = "/allNotes", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData allNotes(int userID){
        return noteService.getAllNotes(userID);
    }

    @RequestMapping(value = "/getNotesByCategory", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getNotesByCategory(int userID, String category){
        return noteService.getNotesByCategory(userID, category);
    }

    @RequestMapping(value = "/getNotesByNotebook", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getNotesByNotebook(int userID, int notebookID){
        return noteService.getNotesByNotebook(userID, notebookID);
    }

    @RequestMapping(value = "/deleteNote", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData deleteNote(int userID, int noteID){
        return noteService.deleteNote(userID, noteID);
    }

    @RequestMapping(value = "/deleteNotebook", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData deleteNotes(int userID, int notebookID){
        return noteService.deleteNotebook(userID, notebookID);
    }


}
