package com.medso.cn.sys.user.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medso.cn.base.controller.BaseController;
import com.medso.cn.sys.user.model.User;
import com.medso.cn.sys.user.service.IUserService;

@Controller
@RequestMapping("/api/user")
public class UserController extends BaseController<User>{
	
	@Autowired
	private IUserService userService;
	
//	@RequestMapping("/find/{username}")
//	@ResponseBody
//	public User findUser(
//		@PathVariable(value="username") String username
//	){
//		return userService.getUserByName(username);
//	}
//	@RequiresRoles("manager")
	@RequestMapping("/login")
	public String login(
			
	){
		return "login";
	}
	
//	@RequiresRoles("manager")
	@RequestMapping("/testRole")
	@ResponseBody
	public String testRole(
			
	){
		return "认证成功";
	}
	
	
}
