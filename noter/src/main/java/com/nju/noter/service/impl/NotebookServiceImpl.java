package com.nju.noter.service.impl;

import com.nju.noter.dao.NotebookDao;
import com.nju.noter.entity.Notebook;
import com.nju.noter.service.NotebookService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.util.Time;
import com.nju.noter.vo.NoteBookVO;
import com.nju.noter.vo.deleteNoteBookVO;
import com.nju.noter.vo.listNoteBooksVO;
import com.nju.noter.vo.modfiyNoteBookVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    NotebookDao notebookDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ResponseData<List<Notebook>> findAllNoteBook(listNoteBooksVO vo) {
        ResponseData<List<Notebook>> responseData = new ResponseData<>();
        if(vo.getUserId() < 0) {
            responseData.setMessage("无法找到笔记本");
            responseData.setResult(false);
        } else {
            try{
                List<Notebook> notebooks = notebookDao.findByUID(vo.getUserId());
                ArrayList<Notebook> arrayList = new ArrayList<>(notebooks);
                Collections.sort(arrayList);
                responseData.setData(arrayList);
                responseData.setMessage("已成功找到全部的笔记本");
                responseData.setResult(true);
                logger.warn(Time.getCurrentTime()+"  "+ vo.getUserId()  + "  已成功找到全部的笔记本");
            }
            catch (Exception e) {
                responseData.setMessage("无法找到笔记本");
                responseData.setResult(false);
                logger.error(Time.getCurrentTime()+"  " + vo.getUserId() + "无法找到笔记本" + e.getMessage());
            }
        }

        return responseData;
    }

    @Override
    public ResponseData<Notebook> addNewNoteBook(NoteBookVO vo) {
        ResponseData<Notebook> responseData = new ResponseData<>();
        if(vo.getUserId() < 0) {
            responseData.setMessage("无法新增笔记本");
            responseData.setResult(false);
        } else {
          try{
                if (notebookDao.findByUIDAndAndBookname(vo.getUserId(), vo.getBookname())!=null){
                    responseData.setResult(false);
                    responseData.setMessage("笔记本已经存在!");
                    logger.error(Time.getCurrentTime()+"  " + vo.getBookname() + "笔记本已经存在!");
                }else{
                    Notebook notebook = new Notebook(vo.getBookname(), vo.getDescription(), vo.getUserId());
                    notebookDao.save(notebook);
                    Notebook data = notebookDao.findByUIDAndAndBookname(vo.getUserId(), vo.getBookname());
                    responseData.setData(data);
                    responseData.setResult(true);
                    responseData.setMessage("新增笔记本成功！");
                    logger.warn(Time.getCurrentTime()+"  "+ vo.getBookname()  + "  新增笔记本成功！");
                }
            } catch (Exception e) {
                responseData.setResult(false);
                responseData.setMessage("新增笔记本失败!");
                logger.error(Time.getCurrentTime()+"  " + vo.getBookname() + "新增笔记本失败!"+e.getMessage());
            }
        }
        return responseData;
    }

    @Override
    public ResponseData<Notebook> modifyNoteBook(modfiyNoteBookVO vo) {
        ResponseData<Notebook> responseData = new ResponseData<>();
        if(vo.getUserId() < 0) {
            responseData.setMessage("无法修改笔记本");
            responseData.setResult(false);
        }
        else {
            try {
                if (notebookDao.findByID(vo.getID()) == null) {
                    responseData.setResult(false);
                    responseData.setMessage("笔记本不存在!");
                    logger.error(Time.getCurrentTime() + "  " + vo.getID() + "笔记本不存在!");
                } else {
                    Notebook notebook = notebookDao.findByID(vo.getID());
                    notebook.setBookname(vo.getNewBookname());
                    notebook.setDescription(vo.getNewDescription());
                    notebookDao.save(notebook);
                    responseData.setData(notebook);
                    responseData.setResult(true);
                    responseData.setMessage("笔记本修改成功!");
                    logger.warn(Time.getCurrentTime() + "  " + vo.getID() + "  新增笔记本成功！");
                }

            } catch (Exception e) {
                responseData.setResult(false);
                responseData.setMessage("修改笔记本失败");
                logger.error(Time.getCurrentTime() + "  " + vo.getID() + "修改笔记本失败" + e.getMessage());
            }
        }
        return responseData;
    }

    @Override
    public ResponseData deleteNoteBook(deleteNoteBookVO vo) {
        ResponseData<Notebook> responseData = new ResponseData<>();
        if(vo.getID() < 0) {
            responseData.setMessage("无法删除笔记本");
            responseData.setResult(false);
        }
        else {
            try {
                if (notebookDao.findByID(vo.getID()) == null) {
                    responseData.setResult(false);
                    responseData.setMessage("笔记本不存在!");
                    logger.error(Time.getCurrentTime() + "  " + vo.getID() + " 笔记本不存在!");
                } else {
                    notebookDao.deleteByID(vo.getID());
                    responseData.setResult(true);
                    responseData.setMessage("删除本修改成功!");
                    logger.warn(Time.getCurrentTime() + "  " + vo.getID() + "  删除本修改成功!");
                }

            } catch (Exception e) {
                responseData.setResult(false);
                responseData.setMessage("删除笔记本失败");
                logger.error(Time.getCurrentTime() + "  " + vo.getID() + " 删除笔记本失败" + e.getMessage());
            }
        }
        return responseData;
    }


}
