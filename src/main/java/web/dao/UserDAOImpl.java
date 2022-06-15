package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

   @Autowired
    private EntityManager entityManager;
    @Override
    @Transactional
    public void save(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findUserById(id));
        entityManager.getTransaction().commit();
    }

    @Override
    @Transactional
    public void edit(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }
    @Override
    @Transactional
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    @Transactional
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u",User.class).getResultList();
    }
}
