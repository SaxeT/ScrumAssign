package com.nju.noter.service;

import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.loginVO;
import com.nju.noter.vo.newPasswordVO;
import com.nju.noter.vo.newUserVO;

public interface UserService {
    ResponseData<String> addUser(newUserVO vo);

    ResponseData<Integer> checkUser(loginVO vo);

    ResponseData<String> modifyUser(newPasswordVO vo);

}
