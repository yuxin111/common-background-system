package com.medso.cn.sys.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.medso.cn.sys.user.model.User;
import com.medso.cn.sys.user.service.IRoleService;
import com.medso.cn.sys.user.service.IUserService;

/**
 * 用户Realm
 * @author 79974
 *
 */
public class UserRealm extends AuthorizingRealm{

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = principals.getPrimaryPrincipal().toString();
		Set<String> sets = new HashSet<String>();
		sets.add("manager");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(sets);
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		String username = token.getPrincipal().toString();
		User user = userService.getUserByName(username);
		
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
			user.getUsername(),
			user.getPassword(),
			getName()
		);
		return authenticationInfo;
	}

}
