package com.medso.cn.sys.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medso.cn.base.controller.BaseController;
import com.medso.cn.sys.user.model.Role;
import com.medso.cn.sys.user.service.IRoleService;

@Controller
@RequestMapping("/api/role")
public class RoleController extends BaseController<Role>{
	
	@Autowired
	private IRoleService roleService;
	
}
