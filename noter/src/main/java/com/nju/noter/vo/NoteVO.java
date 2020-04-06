package com.nju.noter.vo;

public class NoteVO {
    private Integer id = -1;
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

    public NoteVO(int id, String title, String content, String category, Integer UID, Integer nbid) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.uid = UID;
        this.nbid = nbid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", UID=" + uid +
                ", nbid=" + nbid +
                '}';
    }
}
