package com.nju.noter.service.impl;

import com.nju.noter.dao.MemoDao;
import com.nju.noter.service.MemoService;
import com.nju.noter.util.ResponseData;
import com.nju.noter.vo.MemoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemoServiceImpl implements MemoService {
    @Autowired
    MemoDao memoDao;

    @Override
    public ResponseData<String> addMemo(MemoVO vo) {
        return null;
    }

    @Override
    public ResponseData<String> modifyMemo(MemoVO vo) {
        return null;
    }

    @Override
    public ResponseData<String> checkMemo(int id) {
        return null;
    }

    @Override
    public ResponseData<String> deleteMemo(int id) {
        return null;
    }

    @Override
    public ResponseData<String> getMemoList() {
        return null;
    }
}
