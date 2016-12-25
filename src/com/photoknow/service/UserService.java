package com.photoknow.service;

import com.photoknow.entity.User;
import com.photoknow.entity.UserData;

public interface UserService {

	public User login(User user);
	public void saveUserData(UserData userData) throws Exception;
}
