package com.cdac.lab11.dao.impl;



import org.springframework.stereotype.Component;

import com.cdac.lab11.dao.UserDao;
import com.cdac.lab11.domain.User;
@Component
public class UserDaoImpl implements UserDao {

	public boolean validateUser(User u) {
		if(u.getUsername().equals("pallavi@gmail.com") && u.getPassword().equals("efg@123456")) {
			return true;
		}
		return false;
	}
}
