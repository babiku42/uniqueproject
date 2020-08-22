package com.vastika.uis.dao;

import java.util.List;

import com.vastika.uis.model.User;

public interface UserDao {
int saveUserInfo(User user);
int updateUserInfo(User user);
int deleteUserInfo(int id);
User getUserById(int id);
List<User> getAllUser();


}
