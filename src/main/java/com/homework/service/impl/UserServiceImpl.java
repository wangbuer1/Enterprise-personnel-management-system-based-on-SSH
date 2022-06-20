package com.homework.service.impl;

import com.homework.dao.UserDao;
import com.homework.model.User;
import com.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/30
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Transactional
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
    @Transactional
    public void add(User user) {
        user.setRole("管理员");
        userDao.add(user);
    }
}
