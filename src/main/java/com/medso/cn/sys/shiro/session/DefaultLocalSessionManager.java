package com.medso.cn.sys.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionContext;

public class DefaultLocalSessionManager extends DefaultSessionManager{
	@Override
	protected void onStart(Session session, SessionContext context) {
		System.out.println("onStart");
		super.onStart(session, context);
	}
	
	@Override
	protected Session doCreateSession(SessionContext context) {
		System.out.println("createSession");
		return super.doCreateSession(context);
	}
	
	
}
