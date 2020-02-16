package com.nju.noter.service.impl;

import com.nju.noter.dao.NoteDao;
import com.nju.noter.entity.Note;
import com.nju.noter.service.NoteService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteDao noteDao;

    @Override
    public ResponseData<String> addNote(NoteVO noteVO) {
        ResponseData<String> responseData = new ResponseData<>();
        Note note;
        if (noteVO.getID() == -1) {
            note = new Note(noteVO.getTitle(),
                    noteVO.getContent(),
                    noteVO.getCategory(),
                    noteVO.getUID(),
                    noteVO.getNBID());
        } else {
            note = new Note(noteVO.getID(),
                    noteVO.getTitle(),
                    noteVO.getContent(),
                    noteVO.getCategory(),
                    noteVO.getUID(),
                    noteVO.getNBID());
        }

        try{
            Note notePO = noteDao.save(note);
            responseData.setResult(true);
            responseData.setMessage(notePO.getID()+"");
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setResult(false);
            responseData.setMessage("添加失败!");
        }
        return responseData;
    }

    @Override
    public ResponseData<Note> getNote(int noteID) {
        ResponseData<Note> responseData = new ResponseData<>();
        try{
            Note note = noteDao.findById(noteID).get();
            responseData.setResult(true);
            responseData.setData(note);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setResult(false);
            responseData.setMessage("未找到笔记!");
        }
        return responseData;
    }

    @Override
    public ResponseData<List<Note>> getAllNotes(int userID) {
        ResponseData<List<Note>> responseData = new ResponseData<>();
        try{
            List<Note> list = noteDao.findByUID(userID);
            responseData.setResult(true);
            responseData.setMessage("note size:"+list.size());
            responseData.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setResult(false);
            responseData.setMessage("Something's wrong!");
        }
        return responseData;
    }

    @Override
    public ResponseData<List<Note>> getNotesByCategory(int userID, String category) {
        ResponseData<List<Note>> responseData = new ResponseData<>();
        try{
            List<Note> list = noteDao.findByUIDAndCategory(userID, category);
            responseData.setResult(true);
            responseData.setMessage("note size:"+list.size());
            responseData.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setResult(false);
            responseData.setMessage("Something's wrong!");
        }
        return responseData;
    }

    @Override
    public ResponseData<List<Note>> getNotesByNotebook(int userID, int notebookID) {
        ResponseData<List<Note>> responseData = new ResponseData<>();
        try{
            List<Note> list = noteDao.findByUIDAndNBID(userID, notebookID);
            responseData.setResult(true);
            responseData.setMessage("note size:"+list.size());
            responseData.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setResult(false);
            responseData.setMessage("Something's wrong!");
        }
        return responseData;
    }

    @Override
    public ResponseData<String> deleteNote(int userID, int noteID) {
        ResponseData<String> responseData = new ResponseData<>();
        try{
            Note note = noteDao.findById(noteID).get();
            if (note.getUID() != userID) {
                responseData.setResult(false);
                responseData.setMessage("note not belong to userID:"+userID);
            } else{
                noteDao.deleteById(noteID);
                responseData.setResult(true);
                responseData.setMessage("delete succeed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setResult(false);
            responseData.setMessage("cannot find this noteID:"+noteID);
        }
        return responseData;
    }

    @Override
    public ResponseData<List<Note>> getNotesByTitle(int userID, String title) {
        return null;
    }

    @Override
    public ResponseData<List<Note>> getNotesByContent(int userID, String content) {
        return null;
    }

    @Override
    public ResponseData<List<Note>> getNotesByTimestamps(int userID, Timestamp timestamp1, Timestamp timestamp2) {
        return null;
    }

}
