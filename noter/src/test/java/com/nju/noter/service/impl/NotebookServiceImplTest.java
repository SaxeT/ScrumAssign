package com.nju.noter.service.impl;

import com.nju.noter.dao.NotebookDao;
import com.nju.noter.entity.Notebook;
import com.nju.noter.service.NotebookService;
import com.nju.noter.vo.NoteBookVO;
import com.nju.noter.vo.deleteNoteBookVO;
import com.nju.noter.vo.listNoteBooksVO;
import com.nju.noter.vo.modfiyNoteBookVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class NotebookServiceImplTest {
    @Autowired
    private NotebookService notebookService;

    @Autowired
    NotebookDao notebookDao;

    @Test
    @Transactional
    void findAllNoteBook() {
        // assertTrue(userService.addUser(new newUserVO("testAddUser@t.t", "t", "t")).getResult());
        NoteBookVO vo = new NoteBookVO("bookname","description",1);
        notebookService.addNewNoteBook(vo);
        listNoteBooksVO listvo = new listNoteBooksVO(1);
        assertTrue(notebookService.findAllNoteBook(listvo).getResult());
    }

    @Test
    @Transactional
    void addNewNoteBook() {
        NoteBookVO vo = new NoteBookVO("bookname","description",1);
        assertTrue(notebookService.addNewNoteBook(vo).getResult());
    }

    @Test
    @Transactional
    void modifyNoteBook() {
        NoteBookVO vo = new NoteBookVO("bookname","description",1);
        notebookService.addNewNoteBook(vo);
        Notebook notebook = notebookDao.findByUIDAndAndBookname(1, "bookname");
        int ID = notebook.getID();
        modfiyNoteBookVO mod = new modfiyNoteBookVO(ID,"bookname","bookname",
                "description", "description",1);
        assertTrue(notebookService.modifyNoteBook(mod).getResult());

    }

    @Test
    @Transactional
    void deleteNoteBook() {
        NoteBookVO vo = new NoteBookVO("bookname","description",1);
        notebookService.addNewNoteBook(vo);
        Notebook notebook = notebookDao.findByUIDAndAndBookname(1, "bookname");
        int ID = notebook.getID();
        deleteNoteBookVO del = new deleteNoteBookVO(ID,"bookname",1);
        assertTrue(notebookService.deleteNoteBook(del).getResult());
    }
}