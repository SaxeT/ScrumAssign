package com.nju.noter.dao;

import com.nju.noter.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteDao extends JpaRepository<Note, Integer> {

    List<Note> findByUID(int uid);

    List<Note> findByUIDAndCategory(int uid, String category);

    List<Note> findByUIDAndNBID(int uid, int nbid);

    List<Note> findByTitle(String title);

    void deleteByUIDAndNBID(int uid, int nbid);


    //findByTimestamp
}
