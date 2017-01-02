package com.photoknow.dao;

import java.util.List;

import javax.persistence.NoResultException;

import com.photoknow.entity.Idea;
import com.photoknow.entity.Plan;
import com.photoknow.entity.Role;
import com.photoknow.entity.Thing;
import com.photoknow.entity.ThingClasses;
import com.photoknow.entity.User;
import com.photoknow.entity.UserData;
import com.photoknow.entity.UserDevice;
import com.photoknow.entity.UserSyncRecord;

public interface UserDao {
	
	public User findUserByEmail(String email) throws Exception;
	
	public void saveUser(User user) throws Exception;
	
	public void saveUserDevice(UserDevice userDevice) throws Exception;
	
	public User login(User user) throws NoResultException;
	
	public void saveUserData(UserData userData) throws Exception;
	
	public UserSyncRecord findSyncRecord(UserSyncRecord record) throws NoResultException;
	
	public UserSyncRecord findSyncRecord2(UserSyncRecord record) throws NoResultException;
	
	public void saveUserSyncRecord(UserSyncRecord record) throws Exception;
	
	public User findUserById(String userId) throws NoResultException;
	
	public List<Idea> findIdeaByUserId(String userId) throws Exception;
	
	public List<Plan> findPlanByUserId(String userId) throws Exception;
	
	public List<Role> findRoleByUserId(String userId) throws Exception;
	
	public List<Thing> findThingByUserId(String userId) throws Exception;
	
	public List<ThingClasses> findClassesByUserId(String userId) throws Exception;

}
