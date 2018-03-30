package com.medso.cn.sys.user.dao;

import com.medso.cn.base.dao.IBaseDao;
import com.medso.cn.sys.user.model.User;

public interface IUserDao extends IBaseDao<User>{
	public User getUserByName(String username);
}
