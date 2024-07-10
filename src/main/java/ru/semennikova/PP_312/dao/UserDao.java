package ru.semennikova.PP_312.dao;

import ru.semennikova.PP_312.model.User;


import java.util.List;
import java.util.Optional;

public interface UserDao {
    void add(User user);
    List<User> showAll();
    Optional<User> findById(Long id);
    void edit(User user);
    void delete(Long id);
}
