package com.nju.noter.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notebook")
public class Notebook {

    @Id
    @Column(name = "id")
    private int ID;

    @Column(name ="name")
    private String bookname;

    @Column(name = "description")
    private String description;

    @Column(name = "uid")
    private int UID;

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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public Notebook(String bookname, String description, int UID) {
        this.bookname = bookname;
        this.description = description;
        this.UID = UID;
    }
}
