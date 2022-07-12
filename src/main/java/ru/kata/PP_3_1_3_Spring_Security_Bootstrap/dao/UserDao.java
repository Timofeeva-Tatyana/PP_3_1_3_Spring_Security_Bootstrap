package ru.kata.PP_3_1_3_Spring_Security_Bootstrap.dao;

import ru.kata.PP_3_1_3_Spring_Security_Bootstrap.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void saveUser(User user);
    User findUserById(Long id);
    void updateUser(User updatedUser);
    void deleteUser(Long id);
    User findByUserName(String email);
}
