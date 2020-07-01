package com.intellocent.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.intellocent.springboot.entity.User;
import com.intellocent.springboot.user.CrmUser;

public interface UserService extends UserDetailsService {

	User findByUserName(String userName);

	void save(CrmUser crmUser);
}
