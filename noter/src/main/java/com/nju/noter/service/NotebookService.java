package com.nju.noter.service;

import com.nju.noter.entity.Notebook;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.NoteBookVO;
import com.nju.noter.vo.DeleteNoteBookVO;
import com.nju.noter.vo.ListNoteBooksVO;
import com.nju.noter.vo.ModfiyNoteBookVO;

import java.util.List;

public interface NotebookService {

    ResponseData<List<Notebook>> findAllNoteBook(ListNoteBooksVO vo);
    ResponseData<Notebook> addNewNoteBook(NoteBookVO vo);
    ResponseData<Notebook> modifyNoteBook(ModfiyNoteBookVO vo);
    ResponseData deleteNoteBook(DeleteNoteBookVO vo);
}
