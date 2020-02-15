package com.nju.noter.service.impl;

import com.nju.noter.dao.NotebookDao;
import com.nju.noter.entity.Notebook;
import com.nju.noter.service.NotebookService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.NoteBookVO;
import com.nju.noter.vo.deleteNoteBookVO;
import com.nju.noter.vo.listNoteBooksVO;
import com.nju.noter.vo.modfiyNoteBookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    NotebookDao notebookDao;

    @Override
    public ResponseData<List<Notebook>> findAllNoteBook(listNoteBooksVO vo) {
        ResponseData<List<Notebook>> responseData = new ResponseData<>();
        try{
            List<Notebook> notebooks = notebookDao.findByUID(vo.getUserId());
            responseData.setData(notebooks);
            responseData.setMessage("已成功找到全部的笔记本");
            responseData.setResult(true);
        }
        catch (Exception e) {
            responseData.setMessage("无法找到笔记本");
            responseData.setResult(true);
        }

        return responseData;
    }

    @Override
    public ResponseData<Notebook> addNewNoteBook(NoteBookVO vo) {
        ResponseData<Notebook> responseData = new ResponseData<>();
        try{
            if (notebookDao.findByUIDAndAndBookname(vo.getUserId(), vo.getBookname())!=null){
                responseData.setResult(false);
                responseData.setMessage("笔记本已经存在!");
            }else{
                Notebook notebook = new Notebook(vo.getBookname(), vo.getDescription(), vo.getUserId());
                notebookDao.save(notebook);
                Notebook data = notebookDao.findByUIDAndAndBookname(vo.getUserId(), vo.getBookname());
                responseData.setData(data);
                responseData.setResult(true);
                responseData.setMessage("新增笔记本成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setResult(false);
            responseData.setMessage("新增笔记本失败!");
        }
        return responseData;
    }

    @Override
    public ResponseData<Notebook> modifyNoteBook(modfiyNoteBookVO vo) {
        ResponseData<Notebook> responseData = new ResponseData<>();
        try{
            if(notebookDao.findByID(vo.getID()) == null) {
                responseData.setResult(false);
                responseData.setMessage("笔记本不存在!");
            } else if(notebookDao.findByBookname(vo.getOldBookname()).getUID() != vo.getUserId()) {
                responseData.setResult(false);
                responseData.setMessage("不拥有对本笔记的访问权限");
            } else if(notebookDao.findByBookname(vo.getOldBookname()).getID() != vo.getID()) {
                responseData.setResult(false);
                responseData.setMessage("笔记本ID与笔记本name冲突，修改失败");
            }
            else {
                Notebook notebook = notebookDao.findByID(vo.getID());
                notebook.setBookname(vo.getNewBookname());
                notebook.setDescription(vo.getNewDescription());
                notebookDao.save(notebook);
                responseData.setData(notebook);
                responseData.setResult(true);
                responseData.setMessage("笔记本修改成功!");
            }

        }catch (Exception e){
            e.printStackTrace();
            responseData.setResult(false);
            responseData.setMessage("修改笔记本失败");
        }
        return responseData;
    }

    @Override
    public ResponseData deleteNoteBook(deleteNoteBookVO vo) {
        ResponseData<Notebook> responseData = new ResponseData<>();
        try{
            if(notebookDao.findByID(vo.getID()) == null) {
                responseData.setResult(false);
                responseData.setMessage("笔记本不存在!");
            } else if(notebookDao.findByBookname(vo.getBookname()).getUID() != vo.getUserId()) {
                responseData.setResult(false);
                responseData.setMessage("不拥有对本笔记的访问权限");
            } else {
                notebookDao.deleteByID(vo.getID());
                responseData.setResult(true);
                responseData.setMessage("删除本修改成功!");
            }

        }catch (Exception e){
            e.printStackTrace();
            responseData.setResult(false);
            responseData.setMessage("删除笔记本失败");
        }
        return responseData;
    }


}
