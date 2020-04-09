package com.nju.noter.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "category")
    private String category;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "uid")
    private int uid;

    @Column(name = "nbid")
    private int nbid;

    public Note(String title, String content, String category, int uid, int nbid) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.uid = uid;
        this.nbid = nbid;
    }

    public Note(int id, String title, String content, String category, int uid, int nbid) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.uid = uid;
        this.nbid = nbid;
    }

    public Note() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getNbid() {
        return nbid;
    }

    public void setNbid(int nbid) {
        this.nbid = nbid;
    }

    @Override
    public String toString() {
        return "Note{" +
                "ID=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", time=" + time +
                ", UID=" + uid +
                ", NBID=" + nbid +
                '}';
    }
}
