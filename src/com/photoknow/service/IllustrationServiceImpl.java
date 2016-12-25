package com.photoknow.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.photoknow.dao.IllustrationDao;
import com.photoknow.entity.Illustration;

@Service("illustrationService")
@Transactional
public class IllustrationServiceImpl implements IllustrationService{
	
	@Resource
	private IllustrationDao illustrationDao;

	@Override
	public void update(Illustration illustration) {
		// TODO Auto-generated method stub
		illustrationDao.update(illustration);
	}

	@Override
	public List<Illustration> getIllustrationList(String searchCriteria) {
		// TODO Auto-generated method stub
		return illustrationDao.getIllustrationList(searchCriteria);
	}

}
