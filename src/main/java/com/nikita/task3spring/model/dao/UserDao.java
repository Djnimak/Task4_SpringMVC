package com.nikita.task3spring.model.dao;

import com.nikita.task3spring.model.entity.User;

import java.util.List;

public interface UserDao {
    int create(User user);
    List<User> findByEmail(String email);
    List<User> findAll();
    int update(User user, String newEmail, String newPassword);
    int delete(User user);
    int deleteAll();
}
