package com.photoknow.service;

import com.photoknow.entity.User;
import com.photoknow.entity.UserData;
import com.photoknow.entity.UserSyncRecord;

public interface UserService {

	public boolean register(User user) throws Exception;
	public User login(User user);
	public void saveUserData(UserData userData) throws Exception;
	public boolean findSyncRecord(UserSyncRecord record) throws Exception;
	public void saveSyncRecord(UserSyncRecord record) throws Exception;
	public UserData getUserData(String userId) throws Exception;
}
