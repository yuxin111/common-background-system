package com.medso.cn.sys.user.service;

import java.util.Set;

import com.medso.cn.base.service.IBaseService;
import com.medso.cn.sys.user.model.Role;

public interface IRoleService extends IBaseService<Role>{
	public Set<String> getRolesByUserName(String username);
}
