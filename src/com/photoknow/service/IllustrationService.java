package com.photoknow.service;

import java.util.List;

import com.photoknow.entity.Illustration;

public interface IllustrationService {

	public List<Illustration> getIllustrationList(String searchCriteria);
	
	public void update(Illustration illustration);
}
