package com.nju.noter.dao;

import com.nju.noter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByMail(String mail);

    User findByID(int id);
}
