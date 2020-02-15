package com.nju.noter.dao;

import com.nju.noter.entity.Notebook;
import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface NotebookDao extends JpaRepository<Notebook, Integer> {

    Notebook findByID(int ID);
    Notebook findByUIDAndAndBookname(int uid, String name);
    Notebook findByBookname(String name);
    List<Notebook> findAll();
    List<Notebook> findByUID(int uid);
    void deleteByID(int id);
}
