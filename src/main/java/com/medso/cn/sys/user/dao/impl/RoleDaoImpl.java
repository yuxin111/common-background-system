package com.medso.cn.sys.user.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medso.cn.base.dao.BaseDao;
import com.medso.cn.sys.user.dao.IRoleDao;
import com.medso.cn.sys.user.model.Role;

@Repository
public class RoleDaoImpl extends BaseDao<Role> implements IRoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private final String GET_ROLES_BY_USER_ID = "SELECT r FROM Role r INNER JOIN r.users WHERE r.users.username = :username"; 
	
	@Override
	public Set<Role> getRolesByUserName(String username) {
		Session session = getSession();
		@SuppressWarnings("unchecked")
		List<Role> roles = (List<Role>)session.createQuery(GET_ROLES_BY_USER_ID).setParameter("username", username).list();
		return new HashSet<Role>(roles);
	}
}
