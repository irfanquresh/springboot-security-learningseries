package com.intellocent.springboot.dao;

import com.intellocent.springboot.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
