package ru.kata.PP_3_1_3_Spring_Security_Bootstrap.dao;

import org.springframework.stereotype.Repository;
import ru.kata.PP_3_1_3_Spring_Security_Bootstrap.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void updateUser(User updatedUser) {
        entityManager.merge(updatedUser);

    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));

    }

    @Override
    public User findByUserName(String email) {
        return entityManager.createQuery("SELECT user FROM User user JOIN FETCH user.roles roles " +
                        "WHERE user.email=:email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }
}
