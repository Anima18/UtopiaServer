package com.photoknow.service;

import com.photoknow.entity.User;
import com.photoknow.entity.UserData;

public interface UserService {

	public boolean register(User user) throws Exception;
	public boolean login(User user);
	public void saveUserData(UserData userData) throws Exception;
}
