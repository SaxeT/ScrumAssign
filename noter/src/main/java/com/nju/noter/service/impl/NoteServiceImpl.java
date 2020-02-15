package com.nju.noter.service.impl;

import com.nju.noter.dao.NoteDao;
import com.nju.noter.entity.Note;
import com.nju.noter.service.NoteService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteDao noteDao;

    @Override
    public ResponseData<String> addNote(NoteVO noteVO) {
        ResponseData<String> responseData = new ResponseData<>();
        Note note = new Note(noteVO.getTitle(),
                noteVO.getContent(),
                noteVO.getCategory(),
                noteVO.getUID(),
                noteVO.getNBID());
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

}
