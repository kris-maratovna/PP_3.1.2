package ru.semennikova.PP_312.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.semennikova.PP_312.model.User;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }
    @Override
    public List<User> showAll() {
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();
    }
    @Override
    public Optional<User> findById(Long id) {
        User user = entityManager.find(User.class, id);
        return Optional.ofNullable(user);
    }
    @Override
    public void edit (User user) {
            entityManager.merge(user);
    }
    @Override
    public void delete(Long id) {
        Optional<User> userById = findById(id);
        userById.ifPresent(user -> entityManager.remove(user));
    }
}
