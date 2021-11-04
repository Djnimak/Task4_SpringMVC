package com.nikita.task3spring.model.service;

import com.nikita.task3spring.model.dao.UserDao;
import com.nikita.task3spring.model.entity.User;

import java.util.List;


public class UserServiceImpl implements UserService{
    private final UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    public int createUser(User user) {
        return dao.create(user);
    }

    public List<User> findUserByEmail(String email) {
        return dao.findByEmail(email);
    }

    public List<User> findAllUsers() {
        return dao.findAll();
    }

    public int updateUser(User user, String newEmail, String newPassword) {
        return dao.update(user, newEmail, newPassword);
    }

    public int deleteUser(User user) {
        return dao.delete(user);
    }

    public int deleteAllUsers() {
        return dao.deleteAll();
    }

}
