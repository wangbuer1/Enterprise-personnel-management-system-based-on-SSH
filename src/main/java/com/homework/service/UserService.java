package com.homework.service;

import com.homework.model.User;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/30
 */
public interface UserService {
    User getUserByUsername(String username);

    void add(User user);
}
