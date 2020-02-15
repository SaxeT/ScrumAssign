package com.nju.noter.test;

import com.nju.noter.controller.NoteController;
import com.nju.noter.entity.Note;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/testNote")
public class testNoteController {

    @Autowired
    NoteController noteController;

    @RequestMapping(value = "/addNote", method = RequestMethod.POST)
    public void addNote() {
        NoteVO noteVO = new NoteVO("华农兄弟", "烤竹鼠", "美食", 2, 4);
        ResponseData responseData = noteController.addNote(noteVO);
        System.out.println(responseData.getMessage());
    }

    @RequestMapping(value = "/getNote", method = RequestMethod.GET)
    public void getNote() {
        int noteID = 4;
        ResponseData responseData = noteController.getNote(noteID);
        if (responseData.getResult() == true) {
            System.out.println(responseData.getData().toString());
        }
        else {
            System.out.println("test getNote failed!");
        }
    }

    @RequestMapping(value = "/allNotes", method = RequestMethod.GET)
    public void allNotes() {
        int userID = 1;
        ResponseData responseData = noteController.allNotes(userID);
        if (responseData.getResult() == true) {
            List<Note> list = (List<Note>)responseData.getData();
            System.out.println(responseData.getMessage());
            for (Note note:list){
                System.out.println(note.toString());
            }
        } else {
            System.out.println("test allNotes failed!");
        }


    }




}
