package com.vastika.uis.service;

import java.util.List;

import com.vastika.uis.dao.UserDao;
import com.vastika.uis.dao.UserDaoImpl;
import com.vastika.uis.model.User;

public class UserServieImpl implements UserService {
UserDao userDao = new UserDaoImpl();
	
	public int updateUserInfo(User user) {
		return userDao.updateUserInfo(user);
	}

	@Override
	public int deleteUserInfo(int id) {
		return userDao.deleteUserInfo(id);
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public int saveUserInfo(User user) {
		
		return userDao.saveUserInfo(user);
	}

}
