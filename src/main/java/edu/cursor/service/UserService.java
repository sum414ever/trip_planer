package edu.cursor.service;

import edu.cursor.entities.User;
import edu.cursor.exceptions.DataNotFoundException;
import edu.cursor.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new DataNotFoundException("User doesn't found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User user) {

        User existedUser = userRepository.findById(id).orElseThrow(() -> new DataNotFoundException("User doesn't found"));

        existedUser.setName(user.getName());
        existedUser.setEmail(user.getEmail());

        return userRepository.save(existedUser);
    }
}
