package com.nikita.task3spring.model.service;

import com.nikita.task3spring.model.entity.User;

import java.util.List;

public interface UserService {
    int createUser(User user);
    int updateUser(User user, String newEmail, String newPassword);
    int deleteUser(User user);
    int deleteAllUsers();
    List<User> findUserByEmail(String email);
    List<User> findAllUsers();
}
