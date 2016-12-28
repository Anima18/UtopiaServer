package com.photoknow.dao;

import javax.persistence.NoResultException;

import com.photoknow.entity.User;
import com.photoknow.entity.UserData;
import com.photoknow.entity.UserDevice;

public interface UserDao {
	
	public User findUserByEmail(String email) throws Exception;
	
	public void saveUser(User user) throws Exception;
	
	public void saveUserDevice(UserDevice userDevice) throws Exception;
	
	public User login(User user) throws NoResultException;
	
	public void saveUserData(UserData userData) throws Exception;

}
