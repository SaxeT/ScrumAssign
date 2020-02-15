package com.nju.noter.service;

import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.MemoVO;

public interface MemoService {
    ResponseData<String> addMemo(MemoVO vo);

    ResponseData<String> modifyMemo(MemoVO vo);

    ResponseData<String> checkMemo(int id);

    ResponseData<String> deleteMemo(int id);

    ResponseData<String> getMemoList();
}
