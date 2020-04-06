package com.nju.noter.dao;

import com.nju.noter.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteDao extends JpaRepository<Note, Integer> {

    List<Note> findByUID(int UID);

    List<Note> findByUIDAndCategory(int UID, String category);

    List<Note> findByUIDAndNBID(int UID, int NBID);

    List<Note> findByTitle(String title);

    void deleteByUIDAndNBID(int UID, int NBID);


    //findByTimestamp
}
