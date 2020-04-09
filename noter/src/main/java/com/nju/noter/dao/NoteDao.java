package com.nju.noter.dao;

import com.nju.noter.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteDao extends JpaRepository<Note, Integer> {

    List<Note> findByUid(int uid);

    List<Note> findByUidAndCategory(int uid, String category);

    List<Note> findByUidAndNbid(int uid, int nbid);

    void deleteByUidAndNbid(int uid, int nbid);

}
