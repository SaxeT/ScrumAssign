package com.nju.noter.controller;

import com.nju.noter.service.NotebookService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.NoteBookVO;
import com.nju.noter.vo.DeleteNoteBookVO;
import com.nju.noter.vo.ListNoteBooksVO;
import com.nju.noter.vo.ModfiyNoteBookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/notebook")
public class NotebookController {

    @Autowired
    NotebookService notebookService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData list(ListNoteBooksVO vo) {
        return notebookService.findAllNoteBook(vo);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData add(NoteBookVO vo) {
        return notebookService.addNewNoteBook(vo);
    }


    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modify(ModfiyNoteBookVO vo) {
        return notebookService.modifyNoteBook(vo);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData delete(DeleteNoteBookVO vo) {
        return notebookService.deleteNoteBook(vo);
    }

}
