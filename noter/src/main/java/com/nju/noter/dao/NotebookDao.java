package com.nju.noter.dao;

import com.nju.noter.entity.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface NotebookDao extends JpaRepository<Notebook, Integer> {

    Notebook findByID(int id);
    Notebook findByUIDAndAndBookname(int uid, String name);
    List<Notebook> findAll();
    List<Notebook> findByUID(int uid);
    void deleteByID(int id);
}
