package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDao;

	@Autowired
	public UserServiceImpl(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public User findUser(int id) {
		if (userDao.findById(id).isPresent()) {
			User user = userDao.findById(id).get();
			return user;
		} else
			return null;
	}

}
