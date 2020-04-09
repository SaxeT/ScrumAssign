package com.nju.noter.dao;

import com.nju.noter.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoDao extends JpaRepository<Memo, Integer> {
    Memo findByID(int id);
}
