package com.medso.cn.sys.user.dao;

import java.util.Set;

import com.medso.cn.base.dao.IBaseDao;
import com.medso.cn.sys.user.model.Role;

public interface IRoleDao extends IBaseDao<Role>{

	Set<Role> getRolesByUserName(String username);
}
