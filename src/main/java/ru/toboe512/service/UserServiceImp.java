package ru.toboe512.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.toboe512.dao.UserDAO;
import ru.toboe512.models.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDAO.getUserByEmail(username);
    }
}
