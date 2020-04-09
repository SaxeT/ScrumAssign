package com.nju.noter.service.impl;

import com.nju.noter.dao.NotebookDao;
import com.nju.noter.entity.Notebook;
import com.nju.noter.service.NotebookService;
import com.nju.noter.vo.NoteBookVO;
import com.nju.noter.vo.DeleteNoteBookVO;
import com.nju.noter.vo.ListNoteBooksVO;
import com.nju.noter.vo.ModfiyNoteBookVO;
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
        ListNoteBooksVO listvo = new ListNoteBooksVO(1);
        assertTrue(notebookService.findAllNoteBook(listvo).getResult());

        ListNoteBooksVO listvo2 = new ListNoteBooksVO(-1);
        assertFalse(notebookService.findAllNoteBook(listvo2).getResult());

    }

    @Test
    @Transactional
    void addNewNoteBook() {
        NoteBookVO vo = new NoteBookVO("bookname","description",1);
        assertTrue(notebookService.addNewNoteBook(vo).getResult());

        NoteBookVO vo2 = new NoteBookVO("bookname","description",-1);
        assertFalse(notebookService.addNewNoteBook(vo2).getResult());
    }

    @Test
    @Transactional
    void modifyNoteBook() {
        NoteBookVO vo = new NoteBookVO("bookname","description",1);
        notebookService.addNewNoteBook(vo);
        Notebook notebook = notebookDao.findByUIDAndAndBookname(1, "bookname");
        int ID = notebook.getId();
        ModfiyNoteBookVO mod = new ModfiyNoteBookVO(ID,"bookname","bookname",
                "description", "description",1);
        assertTrue(notebookService.modifyNoteBook(mod).getResult());

        ModfiyNoteBookVO mod2 = new ModfiyNoteBookVO(ID,"bookname","bookname",
                "description", "description",-1);
        assertFalse(notebookService.modifyNoteBook(mod2).getResult());

    }

    @Test
    @Transactional
    void deleteNoteBook() {
        NoteBookVO vo = new NoteBookVO("bookname","description",1);
        notebookService.addNewNoteBook(vo);
        Notebook notebook = notebookDao.findByUIDAndAndBookname(1, "bookname");
        int ID = notebook.getId();
        DeleteNoteBookVO del = new DeleteNoteBookVO(ID,"bookname",1);
        assertTrue(notebookService.deleteNoteBook(del).getResult());

        DeleteNoteBookVO del2 = new DeleteNoteBookVO(ID,"bookname",-1);
        assertFalse(notebookService.deleteNoteBook(del2).getResult());
    }
}