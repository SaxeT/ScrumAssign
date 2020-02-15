package com.nju.noter.dao;

import com.nju.noter.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteDao extends JpaRepository<Note, Integer> {

    List<Note> findByUID(int UID);

    List<Note> findByTitle(String title);

    List<Note> findByCategory(String category);

    //findByTimestamp
}
