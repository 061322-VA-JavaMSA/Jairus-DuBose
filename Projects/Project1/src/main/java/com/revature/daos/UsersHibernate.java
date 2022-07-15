package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.models.Users;
import com.revature.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


public class UsersHibernate implements UsersDAO{

	@Override
	public Users insertUser(Users u) {
		u.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(u); 
			
			u.setId(id);
			tx.commit();
		}catch(ConstraintViolationException e) {
			
		}
		return u;
	}
	
	@Override
	public Users getUserById(int id) {
		Users user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			user = s.get(Users.class, id);
		}
		
		return user;
	}

	@Override
	public Users getUserByusername(String username) {
		Users user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Users> cq = cb.createQuery(Users.class);
			Root<Users> root = cq.from(Users.class);
			
			Predicate predicateForUsername = cb.equal(root.get("username"), username);
			
			cq.select(root).where(predicateForUsername);
			
			user = (Users) s.createQuery(cq).getSingleResult();
		}
		
		return user;
	}

	@Override
	public List<Users> getUsers() {
		List<Users> users = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			users = s.createQuery("from User", Users.class).list();
		}
		
		return users;
	}
	
}
