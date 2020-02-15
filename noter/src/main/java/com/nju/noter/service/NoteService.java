package com.nju.noter.service;

import com.nju.noter.entity.Note;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.NoteVO;

import java.util.List;

public interface NoteService {

    ResponseData<String> addNote(NoteVO noteVO);

    ResponseData<Note> getNote(int noteID);

    ResponseData<List<Note>> getAllNotes(int userID);

//    ResponseData<List<Note>> getNotebook(int notebookID);

}
