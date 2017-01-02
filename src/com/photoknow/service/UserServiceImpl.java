package com.photoknow.service;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.photoknow.dao.UserDao;
import com.photoknow.entity.Idea;
import com.photoknow.entity.Plan;
import com.photoknow.entity.Role;
import com.photoknow.entity.Thing;
import com.photoknow.entity.ThingClasses;
import com.photoknow.entity.User;
import com.photoknow.entity.UserData;
import com.photoknow.entity.UserSyncRecord;

@Service("uerService")
@Transactional
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;

	@Override
	public boolean register(User user) throws Exception{
		User dbUser = userDao.findUserByEmail(user.getEmail());
		if(dbUser == null) {
			userDao.saveUser(dbUser);
			/*UserDevice userDevice = new UserDevice(dbUser.getUserId(), user.getDeviceId(), DateUtil.toFormatString(new Date(), "yyyy-MM-dd HH:mm:ss"));
			userDao.saveUserDevice(userDevice);*/
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean login(User user) {
		try {
			userDao.login(user);
			return true;
		} catch(NoResultException e) {
			return false;
		}
		
	}

	@Override
	public void saveUserData(UserData userData) throws Exception {
		try {
			userDao.saveUserData(userData);
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean findSyncRecord(UserSyncRecord record) throws NoResultException {
		try {
			UserSyncRecord data = userDao.findSyncRecord(record);
			return data != null ? true : false;
		} catch(NoResultException ex) {
			return false;
		}
		
	}

	@Override
	public void saveSyncRecord(UserSyncRecord record) throws Exception {
		UserSyncRecord dbRecord = userDao.findSyncRecord2(record);
		if(dbRecord != null) {
			dbRecord.setDeviceId(record.getDeviceId());
			dbRecord.setSyncDate(record.getSyncDate());
		}else {
			dbRecord = record;
		}
		userDao.saveUserSyncRecord(dbRecord);
	}

	@Override
	public UserData getUserData(String userId) throws Exception {
		User user = userDao.findUserById(userId);
		if(user != null) {
			List<Idea> ideaList = userDao.findIdeaByUserId(userId);
			List<Plan> planList = userDao.findPlanByUserId(userId);
			List<Role> roleList = userDao.findRoleByUserId(userId);
			List<Thing> thingList = userDao.findThingByUserId(userId);
			List<ThingClasses> classesList = userDao.findClassesByUserId(userId);
			
			return new UserData(user, roleList, classesList, ideaList, planList, thingList);
		}else {
			return new UserData();
		}
	}
	
	
	
}
