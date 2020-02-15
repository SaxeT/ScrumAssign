package com.nju.noter.service;

import com.nju.noter.entity.Notebook;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.NoteBookVO;
import com.nju.noter.vo.deleteNoteBookVO;
import com.nju.noter.vo.listNoteBooksVO;
import com.nju.noter.vo.modfiyNoteBookVO;

import java.util.List;

public interface NotebookService {

    ResponseData<List<Notebook>> findAllNoteBook(listNoteBooksVO vo);
    ResponseData<Notebook> addNewNoteBook(NoteBookVO vo);
    ResponseData<Notebook> modifyNoteBook(modfiyNoteBookVO vo);
    ResponseData deleteNoteBook(deleteNoteBookVO vo);
}
