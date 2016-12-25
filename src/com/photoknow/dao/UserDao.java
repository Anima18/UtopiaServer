package com.photoknow.dao;

import com.photoknow.entity.User;
import com.photoknow.entity.UserData;

public interface UserDao {
	
	public User login(User user);
	
	public void saveUserData(UserData userData) throws Exception;

}
