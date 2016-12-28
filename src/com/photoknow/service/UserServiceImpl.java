package com.photoknow.service;

import javax.annotation.Resource;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.photoknow.dao.UserDao;
import com.photoknow.entity.User;
import com.photoknow.entity.UserData;

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
	
	
	
}
