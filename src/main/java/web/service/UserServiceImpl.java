package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public User findUserById(Long id){
        return userDAO.findUserById(id);
    }
    @Override
    @Transactional
    public List<User> findAll(){
        return userDAO.findAll();
    }
    @Override
    @Transactional
    public void saveUser(User user){
        userDAO.save(user);
    }
    @Override
    @Transactional
    public void deleteUser(Long id){userDAO.delete(id);}
    @Override
    @Transactional
    public void editUser(User user) {
        userDAO.edit(user);
    }
}
