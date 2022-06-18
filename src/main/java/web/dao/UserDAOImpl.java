package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

   @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void save(User user) {
        entityManager.persist(user);

    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findUserById(id));
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }
    @Override
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u",User.class).getResultList();
    }
}
