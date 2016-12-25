package com.photoknow.service;

import javax.annotation.Resource;

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
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
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
