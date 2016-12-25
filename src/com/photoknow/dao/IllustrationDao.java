package com.photoknow.dao;

import java.util.List;

import com.photoknow.entity.Illustration;

public interface IllustrationDao {

	public List<Illustration> getIllustrationList(String searchCriteria);
	public void update(Illustration illustration);
}
