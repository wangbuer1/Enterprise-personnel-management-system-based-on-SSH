package com.homework.dao;

import com.homework.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: AUTHOR
 * @Date: 2021/5/30
 */
@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public User getUserByUsername(String username) {
        String hql = "from User where username = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,username);
        return (User) query.uniqueResult();
    }

    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
