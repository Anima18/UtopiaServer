package com.photoknow.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("photoknow");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{			
			tx.begin();

			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			em.close();
			emf.close();
		}
	}

}
