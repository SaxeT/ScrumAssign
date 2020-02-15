package com.nju.noter.controller;

import com.nju.noter.entity.Notebook;
import com.nju.noter.service.NotebookService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.NoteBookVO;
import com.nju.noter.vo.deleteNoteBookVO;
import com.nju.noter.vo.listNoteBooksVO;
import com.nju.noter.vo.modfiyNoteBookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/notebook")
public class NotebookController {

    @Autowired
    NotebookService notebookService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData list(listNoteBooksVO vo) {
        ResponseData responseData = notebookService.findAllNoteBook(vo);
        return responseData;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData add(NoteBookVO vo) {
        ResponseData responseData = notebookService.addNewNoteBook(vo);
        return responseData;
    }


    @PostMapping("/modify")
    @ResponseBody
    public ResponseData modify(modfiyNoteBookVO vo) {
        ResponseData responseData = notebookService.modifyNoteBook(vo);
        return responseData;
    }

    @PostMapping("/delete")
    @ResponseBody
    public ResponseData delete(deleteNoteBookVO vo) {
        ResponseData responseData = notebookService.deleteNoteBook(vo);
        return responseData;
    }


    //TODO 删除笔记本下全部的笔记





}
