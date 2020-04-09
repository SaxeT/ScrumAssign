package com.nju.noter.service.impl;

import com.nju.noter.dao.NoteDao;
import com.nju.noter.dao.NotebookDao;
import com.nju.noter.entity.Note;
import com.nju.noter.entity.Notebook;
import com.nju.noter.service.NoteService;
import com.nju.noter.service.NotebookService;
import com.nju.noter.util.Common;
import com.nju.noter.util.ResponseData;
import com.nju.noter.util.Time;
import com.nju.noter.vo.NoteBookVO;
import com.nju.noter.vo.NoteVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteDao noteDao;
    @Autowired
    NotebookService notebookService;
    @Autowired
    NotebookDao notebookDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ResponseData<Note> addNote(NoteVO noteVO) {
        ResponseData<Note> responseData = new ResponseData<>();
        Note note;
        if (noteVO.getId() == -1) {
            int nbid = noteVO.getnbid();
            if ( -1 == nbid) {
                Notebook notebook = notebookDao.findByUIDAndAndBookname(noteVO.getuid(), Common.NOTEBOOK_DEFAULT_NAME);
                if (notebook == null) {
                    ResponseData<Notebook> responseData1 =
                            notebookService.addNewNoteBook(new NoteBookVO(Common.NOTEBOOK_DEFAULT_NAME,
                                    Common.NOTEBOOK_DEFAULT_DESCRIPTION, noteVO.getuid()));
                    if (responseData1.getResult()) {
                        notebook = responseData1.getData();
                        nbid = notebook.getId();
                    } else {
                        logger.error(Time.getCurrentTime()+" Failed to create default notebook: "+ noteVO.toString());
                        responseData.setResult(false);
                        responseData.setMessage("添加失败!");
                        return responseData;
                    }
                } else {
                    nbid = notebook.getId();
                }
            }
            note = new Note(noteVO.getTitle(),
                    noteVO.getContent(),
                    noteVO.getCategory(),
                    noteVO.getuid(),
                    nbid);
        } else {
            note = new Note(noteVO.getId(),
                    noteVO.getTitle(),
                    noteVO.getContent(),
                    noteVO.getCategory(),
                    noteVO.getuid(),
                    noteVO.getnbid()
            );
        }

        try{
            Note notePO = noteDao.save(note);
            responseData.setResult(true);
            responseData.setData(notePO);
        } catch (Exception e) {
            logger.error(Time.getCurrentTime()+" Failed to create Note: "+ noteVO.toString()+
                    " "+ e.getMessage());
            responseData.setResult(false);
            responseData.setMessage("添加失败!");
        }
        return responseData;
    }

    @Override
    public ResponseData<Note> getNote(int noteID) {
        ResponseData<Note> responseData = new ResponseData<>();
        try{
            Optional optional = noteDao.findById(noteID);
            Note note;
            if (optional.isPresent()) {
                note = (Note) optional.get();
                responseData.setResult(true);
                responseData.setData(note);
            } else {
                responseData.setResult(false);
                responseData.setMessage("未找到该笔记ID:"+noteID);
            }
        } catch (Exception e) {
            logger.error(Time.getCurrentTime()+" Failed to get note. noteID:"+ noteID+
                    " "+ e.getMessage());
            responseData.setResult(false);
            responseData.setMessage("获取笔记失败");
        }
        return responseData;
    }

    @Override
    public ResponseData<List<Note>> getAllNotes(int userID) {
        ResponseData<List<Note>> responseData = new ResponseData<>();
        try{
            List<Note> list = noteDao.findByUID(userID);
            responseData.setResult(true);
            responseData.setMessage("笔记数量:"+list.size());
            responseData.setData(list);
        } catch (Exception e) {
            logger.error(Time.getCurrentTime()+" Failed to get all notes for userID:"+ userID +
                    " "+ e.getMessage());
            responseData.setResult(false);
            responseData.setMessage("获取全部笔记失败!");
        }
        return responseData;
    }

    @Override
    public ResponseData<List<Note>> getNotesByCategory(int userID, String category) {
        ResponseData<List<Note>> responseData = new ResponseData<>();
        try{
            List<Note> list = noteDao.findByUIDAndCategory(userID, category);
            responseData.setResult(true);
            responseData.setMessage("数量:"+list.size());
            responseData.setData(list);
        } catch (Exception e) {
            logger.error(Time.getCurrentTime()+" Failed to get all notes by category for userID:"+ userID +
                    ", category:" + category + " " + e.getMessage());
            responseData.setResult(false);
            responseData.setMessage("获取笔记列表失败!");
        }
        return responseData;
    }

    @Override
    public ResponseData<List<Note>> getNotesByNotebook(int userID, int notebookID) {
        ResponseData<List<Note>> responseData = new ResponseData<>();
        try{
            List<Note> list = noteDao.findByUIDAndNBID(userID, notebookID);
            responseData.setResult(true);
            responseData.setMessage("数量:"+list.size());
            responseData.setData(list);
        } catch (Exception e) {
            logger.error(Time.getCurrentTime()+" Failed to get all notes in a notebook for userID:"+ userID +
                    ", notebookID:" + notebookID + " " + e.getMessage());
            responseData.setResult(false);
            responseData.setMessage("获取笔记本中笔记失败!");
        }
        return responseData;
    }

    @Override
    public ResponseData<String> deleteNote(int userID, int noteID) {
        ResponseData<String> responseData = new ResponseData<>();
        try{
            Optional optional = noteDao.findById(noteID);
            Note note;
            if (optional.isPresent()) {
                note = (Note) optional.get();
                if (note.getUid() != userID) {
                    responseData.setResult(false);
                    responseData.setMessage("删除失败!该笔记不属于用户:"+userID);
                } else{
                    noteDao.deleteById(noteID);
                    responseData.setResult(true);
                    responseData.setMessage("删除成功");
                }
            } else {
                responseData.setResult(false);
                responseData.setMessage("未找到该笔记:"+noteID);
            }
        } catch (Exception e) {
            logger.error(Time.getCurrentTime()+" Failed to delete note for userID:"+ userID +
                    ", noteID:" + noteID + " " + e.getMessage());
            responseData.setResult(false);
            responseData.setMessage("删除失败!");
        }

        return responseData;
    }

    @Override
    public ResponseData<String> deleteNotebook(int userID, int notebookID) {
        noteDao.deleteByUIDAndNBID(userID, notebookID);
        ResponseData<String> responseData = new ResponseData<>();
        responseData.setResult(true);
        responseData.setMessage("删除成功");
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
