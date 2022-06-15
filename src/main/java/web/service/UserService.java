package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findUserById(Long id);
    void saveUser(User user);
    void deleteUser(Long id);
    void editUser(User user);
}
