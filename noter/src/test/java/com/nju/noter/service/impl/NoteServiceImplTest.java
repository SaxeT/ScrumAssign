package com.nju.noter.service.impl;

import com.nju.noter.service.NoteService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.NoteVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NoteServiceImplTest {
    @Resource
    private NoteService noteService;

    @Test
    void testAddNote(){
        assertTrue(noteService.addNote(new NoteVO("noteVoTitle", "noteVoContent", "noteVoCategory", 1, 1)).getResult());
        assertFalse(noteService.addNote(new NoteVO("noteVoTitle", "noteVoContent", "noteVoCategory", 1, -1)).getResult());
    }

    @Test
    void testGetNote(){
        ResponseData responseData1 = noteService.getNote(1);
        assertTrue(responseData1.getResult());
        ResponseData responseData2 =  noteService.getNote(-1);
        assertFalse(responseData2.getResult());
    }

    @Test
    void testGetAllNotes(){
        ResponseData responseData1 = noteService.getAllNotes(1);
        assertTrue(responseData1.getResult());
        ResponseData responseData2 = noteService.getAllNotes(0);
        assertTrue(responseData2.getResult());
    }

    @Test
    void testGetNotesByCategory(){
        ResponseData responseData1 = noteService.getNotesByCategory(1, "学习");
        assertTrue(responseData1.getResult());
        ResponseData responseData2 = noteService.getNotesByCategory(1, "none");
        assertTrue(responseData2.getResult());
    }

    @Test
    void testGetNotesByNotebook(){
        ResponseData responseData1 = noteService.getNotesByNotebook(1, 1);
        assertTrue(responseData1.getResult());
        ResponseData responseData2 = noteService.getNotesByNotebook(1, 4);
        assertTrue(responseData2.getResult());
    }

    @Test
    void testDeleteNote(){
        ResponseData responseData1 = noteService.deleteNote(1, 1);
        assertTrue(responseData1.getResult());
        ResponseData responseData2 = noteService.deleteNote(1, 1);
        assertFalse(responseData2.getResult());
    }

    @Test
    void testGetNotesByTitle(){
        ResponseData responseData1 = noteService.getNotesByTitle(1, "English note");
        assertTrue(responseData1.getResult());
        ResponseData responseData2 = noteService.getNotesByTitle(1, "英语学习");
        assertTrue(responseData2.getResult());
    }

    @Test
    void testGetNotesByContent(){
        assertNull(noteService.getNotesByContent(1, "蛋炒饭"));
    }

    @Test
    void testGetNotesByTimestamps(){
         assertNull(noteService.getNotesByTimestamps(1, null, null));
    }




}
