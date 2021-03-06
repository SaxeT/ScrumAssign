package com.nju.noter.service.impl;

import com.nju.noter.dao.NotebookDao;
import com.nju.noter.entity.Notebook;
import com.nju.noter.service.NotebookService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.util.Time;
import com.nju.noter.vo.NoteBookVO;
import com.nju.noter.vo.DeleteNoteBookVO;
import com.nju.noter.vo.ListNoteBooksVO;
import com.nju.noter.vo.ModfiyNoteBookVO;
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
    public ResponseData<List<Notebook>> findAllNoteBook(ListNoteBooksVO vo) {
        ResponseData<List<Notebook>> responseData = new ResponseData<>();
        if(vo.getUserId() < 0) {
            responseData.setMessage("该用户没有笔记本");
            responseData.setResult(false);
        } else {
            try{
                List<Notebook> notebooks = notebookDao.findByUid(vo.getUserId());
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
                if (notebookDao.findByUidAndAndBookname(vo.getUserId(), vo.getBookname())!=null){
                    responseData.setResult(false);
                    responseData.setMessage("笔记本已经存在!");
                    logger.error(Time.getCurrentTime()+"  " + vo.getBookname() + "笔记本已经存在!");
                }else{
                    Notebook notebook = new Notebook(vo.getBookname(), vo.getDescription(), vo.getUserId());
                    notebookDao.save(notebook);
                    Notebook data = notebookDao.findByUidAndAndBookname(vo.getUserId(), vo.getBookname());
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
    public ResponseData<Notebook> modifyNoteBook(ModfiyNoteBookVO vo) {
        ResponseData<Notebook> responseData = new ResponseData<>();
        if(vo.getUserId() < 0) {
            responseData.setMessage("该用户没有笔记本");
            responseData.setResult(false);
        }
        else {
            try {
                if (notebookDao.findById(vo.getId()) == null) {
                    responseData.setResult(false);
                    responseData.setMessage("笔记本不存在!");
                    logger.error(Time.getCurrentTime() + "  " + vo.getId() + "笔记本不存在!");
                } else {
                    Notebook notebook = notebookDao.findById(vo.getId());
                    notebook.setBookname(vo.getNewBookname());
                    notebook.setDescription(vo.getNewDescription());
                    notebookDao.save(notebook);
                    responseData.setData(notebook);
                    responseData.setResult(true);
                    responseData.setMessage("笔记本修改成功!");
                    logger.warn(Time.getCurrentTime() + "  " + vo.getId() + "  新增笔记本成功！");
                }

            } catch (Exception e) {
                responseData.setResult(false);
                responseData.setMessage("修改笔记本失败");
                logger.error(Time.getCurrentTime() + "  " + vo.getId() + "修改笔记本失败" + e.getMessage());
            }
        }
        return responseData;
    }

    @Override
    public ResponseData deleteNoteBook(DeleteNoteBookVO vo) {
        ResponseData<Notebook> responseData = new ResponseData<>();
        if(vo.getId() < 0) {
            responseData.setMessage("无法删除笔记本");
            responseData.setResult(false);
        }
        else {
            try {
                if (notebookDao.findById(vo.getId()) == null) {
                    responseData.setResult(false);
                    responseData.setMessage("笔记本不存在!");
                    logger.error(Time.getCurrentTime() + "  " + vo.getId() + " 笔记本不存在!");
                } else {
                    notebookDao.deleteById(vo.getId());
                    responseData.setResult(true);
                    responseData.setMessage("删除本修改成功!");
                    logger.warn(Time.getCurrentTime() + "  " + vo.getId() + "  删除本修改成功!");
                }

            } catch (Exception e) {
                responseData.setResult(false);
                responseData.setMessage("删除笔记本失败");
                logger.error(Time.getCurrentTime() + "  " + vo.getId() + " 删除笔记本失败" + e.getMessage());
            }
        }
        return responseData;
    }


}
