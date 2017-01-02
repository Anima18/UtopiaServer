package com.photoknow.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.photoknow.entity.Idea;
import com.photoknow.entity.Plan;
import com.photoknow.entity.Role;
import com.photoknow.entity.Thing;
import com.photoknow.entity.ThingClasses;
import com.photoknow.entity.User;
import com.photoknow.entity.UserData;
import com.photoknow.entity.UserDevice;
import com.photoknow.entity.UserSyncRecord;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	@PersistenceContext(unitName = "utopia")
	protected EntityManager em;

	@Override
	public User login(User user) throws NoResultException {
		try{ 
			return (User)em.createNamedQuery("User.login").setParameter("name", user.getName())
					.setParameter("password", user.getPassword()).getSingleResult(); 
		}catch(NoResultException ex){ 
			ex.printStackTrace();
			throw ex;
		}
	}

	@Override
	public User findUserByEmail(String email) throws Exception {
		try {
			List<User> userList = (List<User>)em.createNamedQuery("User.getUserByEmail").setParameter("email", email).getResultList();
			if(userList != null && userList.size() != 0) {
				return userList.get(0);
			}else {
				return null;
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void saveUser(User user) throws Exception {
		try {
			user.setUserId(null);
			em.persist(user);
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void saveUserDevice(UserDevice userDevice) throws Exception {
		try {
			em.persist(userDevice);
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void saveUserData(UserData userData) throws Exception {
		try{ 
			User user = null;
			List<User> userList = (List<User>)em.createNamedQuery("User.getUserById").setParameter("userId", userData.getUser().getUserId()).getResultList();
			if(userList != null && userList.size() != 0) {
				user = userList.get(0);
				//em.createNativeQuery("delete from user where userId = '"+user.getUserId()+"'").executeUpdate();
				em.createNativeQuery("delete from idea where userId = '"+user.getUserId()+"'").executeUpdate();
				em.createNativeQuery("delete from thing_class where userId = '"+user.getUserId()+"'").executeUpdate();
				em.createNativeQuery("delete from thing where userId = '"+user.getUserId()+"'").executeUpdate();
				em.createNativeQuery("delete from role where userId = '"+user.getUserId()+"'").executeUpdate();
				em.createNativeQuery("delete from plan where userId = '"+user.getUserId()+"'").executeUpdate();
				
			}
			User nUser = userData.getUser();
			if(user != null) {
				user.setUpdateAt(nUser.getUpdateAt());
				user.setEmail(nUser.getEmail());
				user.setGender(nUser.getGender());
				user.setIntroduce(nUser.getIntroduce());
				user.setName(nUser.getName());
			}else {
				em.persist(nUser);
			}
			
			
			for(Idea idea : userData.getIdeaList()) {
				idea.setUserId(nUser.getUserId());
				em.persist(idea);
			}
			
			for(ThingClasses classes : userData.getClassesList()) {
				classes.setUserId(nUser.getUserId());
				em.persist(classes);
			}
			
			for(Thing thing : userData.getThingList()) {
				thing.setUserId(nUser.getUserId());
				em.persist(thing);
			}
			
			for(Role role : userData.getRoleList()) {
				role.setUserId(nUser.getUserId());
				em.persist(role);
			}
			
			for(Plan plan : userData.getPlanList()) {
				plan.setUserId(nUser.getUserId());
				em.persist(plan);
			}
		}catch(Exception ex){ 
			ex.printStackTrace();
			throw ex;
		}
	}

	@Override
	public UserSyncRecord findSyncRecord(UserSyncRecord record) throws NoResultException {
		try{ 
			return (UserSyncRecord)em.createNamedQuery("UserSyncRecord.getRecord").setParameter("userId", record.getUserId())
					.setParameter("deviceId", record.getDeviceId()).setParameter("syncDate", record.getSyncDate())
					.getSingleResult(); 
		}catch(NoResultException ex){ 
			ex.printStackTrace();
			throw ex;
		}
	}

	@Override
	public UserSyncRecord findSyncRecord2(UserSyncRecord record) throws NoResultException {
		try{ 
			return (UserSyncRecord)em.createNamedQuery("UserSyncRecord.findRecord").setParameter("userId", record.getUserId())
					.getSingleResult(); 
		}catch(NoResultException ex){ 
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public void saveUserSyncRecord(UserSyncRecord record) throws Exception {
		try {
			em.persist(record);
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public User findUserById(String userId) throws NoResultException {
		try{ 
			return (User)em.createNamedQuery("User.getUserById").setParameter("userId", userId).getSingleResult(); 
		}catch(NoResultException ex){ 
			ex.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Idea> findIdeaByUserId(String userId) throws Exception {
		try{ 
			return (List<Idea>)em.createNamedQuery("Idea.getIdeaByUserId").setParameter("userId", userId).getResultList(); 
		}catch(Exception ex){ 
			ex.printStackTrace();
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Plan> findPlanByUserId(String userId) throws Exception {
		try{ 
			return (List<Plan>)em.createNamedQuery("Plan.getPlanByUserId").setParameter("userId", userId).getResultList(); 
		}catch(Exception ex){ 
			ex.printStackTrace();
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findRoleByUserId(String userId) throws Exception {
		try{ 
			return (List<Role>)em.createNamedQuery("Role.getRoleByUserId").setParameter("userId", userId).getResultList(); 
		}catch(Exception ex){ 
			ex.printStackTrace();
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Thing> findThingByUserId(String userId) throws Exception {
		try{ 
			return (List<Thing>)em.createNamedQuery("Thing.getThingByUserId").setParameter("userId", userId).getResultList(); 
		}catch(Exception ex){ 
			ex.printStackTrace();
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThingClasses> findClassesByUserId(String userId) throws Exception {
		try{ 
			return (List<ThingClasses>)em.createNamedQuery("ThingClasses.getThingClassesByUserId").setParameter("userId", userId).getResultList(); 
		}catch(Exception ex){ 
			ex.printStackTrace();
			throw ex;
		}
	}	
	
}
