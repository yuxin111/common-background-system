package com.medso.cn.sys.user.service.impl;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medso.cn.base.service.BaseService;
import com.medso.cn.sys.user.dao.IRoleDao;
import com.medso.cn.sys.user.model.Role;
import com.medso.cn.sys.user.service.IRoleService;

@Service
public class RoleServiceImpl extends BaseService<Role> implements IRoleService{

	@Autowired
	private IRoleDao roleDao;
	
	@Override
	public Set<String> getRolesByUserName(String username) {
		Set<Role> roles = roleDao.getRolesByUserName(username);
		Set<String> roleString = new HashSet<String>(roles.size());
		for (Role role : roles) {
			roleString.add(role.getRoleName());
		}
		return roleString;
	}

	

}
