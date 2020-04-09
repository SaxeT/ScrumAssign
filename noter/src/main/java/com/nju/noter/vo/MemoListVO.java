package com.nju.noter.vo;

import com.nju.noter.entity.Memo;

import java.util.List;

public class MemoListVO {
    private int uid;
    private List<Memo> memoList;

    public MemoListVO(int uid, List<Memo> memoList) {
        this.uid = uid;
        this.memoList = memoList;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public List<Memo> getMemoList() {
        return memoList;
    }

    public void setMemoList(List<Memo> memoList) {
        this.memoList = memoList;
    }
}
