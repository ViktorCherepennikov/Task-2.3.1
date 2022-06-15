package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    void save(User user);
    void delete(Long id);
    void edit(User user);
    User findUserById(Long id);
}
