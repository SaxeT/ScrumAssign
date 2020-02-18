package com.nju.noter.vo;

import com.nju.noter.entity.Memo;

import java.util.List;

public class memoListVO {
    private int UID;
    private List<Memo> memoList;

    public memoListVO(int UID, List<Memo> memoList) {
        this.UID = UID;
        this.memoList = memoList;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public List<Memo> getMemoList() {
        return memoList;
    }

    public void setMemoList(List<Memo> memoList) {
        this.memoList = memoList;
    }
}
