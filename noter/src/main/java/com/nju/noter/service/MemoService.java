package com.nju.noter.service;

import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.memoVO;

public interface MemoService {
    ResponseData<String> addMemo(memoVO vo);

    ResponseData<String> modifyMemo(memoVO vo);

    ResponseData<String> checkMemo(int id);

    ResponseData<String> deleteMemo(int id);

    ResponseData<String> getMemoList();
}
