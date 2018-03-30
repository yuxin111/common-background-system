package com.medso.cn.sys.user.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medso.cn.base.service.BaseService;
import com.medso.cn.sys.user.dao.IUserDao;
import com.medso.cn.sys.user.model.User;
import com.medso.cn.sys.user.service.IUserService;

@Service
public class UserServiceImpl extends BaseService<User> implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public User getUserByName(String username) {
		return userDao.getUserByName(username);
	}
	

}
