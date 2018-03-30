package com.medso.cn.sys.user.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medso.cn.base.dao.BaseDao;
import com.medso.cn.sys.user.dao.IUserDao;
import com.medso.cn.sys.user.model.User;

@Repository
public class UserDaoImpl extends BaseDao<User> implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private final String GET_USER_HQL = "From User u WHERE u.username = :username"; 
	
	@Override
	public User getUserByName(
		String username
	) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User)session
					.createQuery(GET_USER_HQL)
					.setString("username", username)
					.uniqueResult();
		return user;
	}
	
}
