package com.nju.noter.service;

import com.nju.noter.entity.Note;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.NoteVO;

import java.sql.Timestamp;
import java.util.List;

public interface NoteService {

    /**
     * 新建、保存笔记.
     * NoteVO中ID=-1新建；否则按照原有ID保存.
     */
    ResponseData<String> addNote(NoteVO noteVO);

    ResponseData<Note> getNote(int noteID);

    ResponseData<List<Note>> getAllNotes(int userID);

    ResponseData<List<Note>> getNotesByCategory(int userID, String category);

    ResponseData<List<Note>> getNotesByNotebook(int userID, int notebookID);

    ResponseData<String> deleteNote(int userID, int noteID);

    // 迭代二 时间戳区间查询，模糊查询
    ResponseData<List<Note>> getNotesByTitle(int userID, String title);

    ResponseData<List<Note>> getNotesByContent(int userID, String content);

    ResponseData<List<Note>> getNotesByTimestamps(int userID, Timestamp timestamp1, Timestamp timestamp2);

    // 前端各种字体修饰美化
    // 语音图片等
    // 共享

}
