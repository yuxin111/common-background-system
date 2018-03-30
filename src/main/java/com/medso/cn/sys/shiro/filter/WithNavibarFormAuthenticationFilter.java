package com.medso.cn.sys.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

public class WithNavibarFormAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		System.out.println("loginSuccess");
		return super.onLoginSuccess(token, subject, request, response);
	}
	@Override
	protected boolean executeLogin(ServletRequest request,
			ServletResponse response) throws Exception {
		System.out.println("正在登陆");
		return super.executeLogin(request, response);
	}
	@Override
	protected boolean onLoginFailure(AuthenticationToken token,
			AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		System.out.println("登陆失败");
		return super.onLoginFailure(token, e, request, response);
	}
}
