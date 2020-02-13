package com.nju.noter.service.impl;

import com.nju.noter.dao.UserDao;
import com.nju.noter.entity.User;
import com.nju.noter.service.UserService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.loginVO;
import com.nju.noter.vo.newPasswordVO;
import com.nju.noter.vo.newUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public ResponseData<String> addUser(newUserVO vo) {
        ResponseData<String> responseData = new ResponseData<>();
        try{
            if (userDao.findByMail(vo.getMail())!=null){
                responseData.setResult(false);
                responseData.setMessage("User Exists!");
            }else{
                User user = new User(vo.getMail(), vo.getPassword(), vo.getUserName());
                userDao.save(user);
                responseData.setResult(true);
                responseData.setMessage("Success!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setResult(false);
            responseData.setMessage("Something wrong!");
        }
        return responseData;
    }

    @Override
    public ResponseData<Integer> checkUser(loginVO vo) {
        ResponseData<Integer> responseData = new ResponseData<>();
        try{
            User user = userDao.findByMail(vo.getMail());
            if (user==null){
                responseData.setResult(false);
                responseData.setMessage("There is No Such User!");
            }
            else{
                String password = user.getPassword();
                if (vo.getPassword().equals(password)){
                    responseData.setResult(true);
                    responseData.setMessage("Success!");
                    responseData.setData(user.getID());
                }
                else{
                    responseData.setResult(false);
                    responseData.setMessage("Password Wrong!");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            responseData.setResult(false);
            responseData.setMessage("Something wrong!");
        }
        return responseData;
    }

    @Override
    public ResponseData<String> modifyUser(newPasswordVO vo) {
        ResponseData<String> responseData = new ResponseData<>();
        try{
            User user = userDao.findByID(vo.getID());
            String password = user.getPassword();
            if (vo.getOldPassword().equals(password)){
                user.setPassword(vo.getNewPassword());
                userDao.save(user);
                responseData.setResult(true);
                responseData.setMessage("Success!");
            }
            else{
                responseData.setResult(false);
                responseData.setMessage("Old Password Wrong!");
            }
        }catch (Exception e){
            e.printStackTrace();
            responseData.setResult(false);
            responseData.setMessage("Something wrong!");
        }
        return responseData;
    }
}
