package com.medso.cn.sys.user.service;

import com.medso.cn.base.service.IBaseService;
import com.medso.cn.sys.user.model.User;

public interface IUserService extends IBaseService<User>{
	
	public User getUserByName(String username);
}
