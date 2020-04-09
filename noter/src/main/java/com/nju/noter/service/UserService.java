package com.nju.noter.service;

import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.LoginVO;
import com.nju.noter.vo.NewPasswordVO;
import com.nju.noter.vo.NewUserVO;


public interface UserService {
    ResponseData<String> addUser(NewUserVO vo);

    ResponseData<Integer> checkUser(LoginVO vo);

    ResponseData<String> modifyUser(NewPasswordVO vo);

}
