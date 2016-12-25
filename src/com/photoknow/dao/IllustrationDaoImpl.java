package com.photoknow.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.photoknow.entity.Illustration;
import com.photoknow.util.StringUtil;

@Repository("illustrationDao")
public class IllustrationDaoImpl implements IllustrationDao{
	@PersistenceContext(unitName = "utopia")
	protected EntityManager em;

	@Override
	public void update(Illustration illustration) {
		// TODO Auto-generated method stub
		em.persist(illustration);
	}

	@Override
	public List<Illustration> getIllustrationList(String searchCriteria) {
		// TODO Auto-generated method stub
		List<Illustration> illustrationList = null;
		/*if(StringUtil.isNotEmpty(searchCriteria)){
			illustrationList = em.createNamedQuery("Illustration.findLikeName")
			.setParameter("name", searchCriteria+"%").getResultList();
		}else{
			illustrationList = em.createNamedQuery("Illustration.findAll").getResultList();
		}*/
		
		return illustrationList;
	}
	
}
