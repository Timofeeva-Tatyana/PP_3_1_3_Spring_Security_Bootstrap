package ru.kata.PP_3_1_3_Spring_Security_Bootstrap.service;

import ru.kata.PP_3_1_3_Spring_Security_Bootstrap.model.User;

import java.util.List;
public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User findUserById(Long id);
    void updateUser(User user);
    void deleteUser(Long id);

}
