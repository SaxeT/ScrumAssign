package com.nju.noter.vo;

public class NoteVO {
    private Integer ID = -1;
    private String title;
    private String content;
    private String category;
    private Integer uid;
    private Integer nbid;

    public NoteVO(){

    }

    public NoteVO(String title, String content, String category, Integer UID, Integer nbid) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.uid = UID;
        this.nbid = nbid;
    }

    public NoteVO(int ID, String title, String content, String category, Integer UID, Integer nbid) {
        this.ID = ID;
        this.title = title;
        this.content = content;
        this.category = category;
        this.uid = UID;
        this.nbid = nbid;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getuid() {
        return uid;
    }

    public void setuid(Integer UID) {
        this.uid = UID;
    }

    public Integer getnbid() {
        return nbid;
    }

    public void setnbid(Integer NBID) {
        this.nbid = NBID;
    }

    @Override
    public String toString() {
        return "Note{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", UID=" + uid +
                ", nbid=" + nbid +
                '}';
    }
}
