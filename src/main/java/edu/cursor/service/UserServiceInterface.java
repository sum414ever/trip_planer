package edu.cursor.service;

import edu.cursor.entities.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    void deleteUserById(Long id);

    User updateUser(Long id, User user);
}
