package com.nju.noter.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notebook")
public class Notebook implements Comparable<Notebook> {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name ="name")
    private String bookname;

    @Column(name = "description")
    private String description;

    @Column(name = "uid")
    private int uid;

    public Notebook() {
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int UID) {
        this.uid = UID;
    }

    public Notebook(String bookname, String description, int uid) {
        this.bookname = bookname;
        this.description = description;
        this.uid = uid;
    }

    @Override
    public int compareTo(Notebook o) {
        if(this.getId() < o.getId()) return 1;
        else if(this.getId() > o.getId()) return -1;
        return 0;
    }
}
