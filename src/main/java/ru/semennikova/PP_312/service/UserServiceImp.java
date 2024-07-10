package ru.semennikova.PP_312.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.semennikova.PP_312.dao.UserDao;
import ru.semennikova.PP_312.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> showAll() {
        return userDao.showAll();
    }
    @Override
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }
    @Override
    public void edit(User user) {
        userDao.edit(user);
    }
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}
