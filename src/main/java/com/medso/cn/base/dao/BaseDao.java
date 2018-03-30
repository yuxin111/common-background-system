package com.medso.cn.base.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.medso.cn.util.MyUtil;

public class BaseDao<T> implements IBaseDao<T>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	protected void init(){
		Type type = getClass().getGenericSuperclass();
		if(type instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType)type;
			clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		}else{
			clazz = null;
		}
		System.out.println(clazz);
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(T t) {
		this.getSession().save(t);
	}

	@Override
	public void update(int id,T t) {
		Object object = this.getSession().get(getClazz(), id);
		object = MyUtil.merge(t, object);
		this.getSession().update(object);
	}

	@Override
	public void delete(T t) {
		this.getSession().delete(t);
	}

	@Override
	public void delete(Serializable id) {
		@SuppressWarnings("unchecked")
		T t = (T) this.getSession().load(getClazz(), id);
		delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Serializable id) {
		return (T) this.getSession().get(getClazz(), id);
	}

	public Class<T> getClazz() {
		init();
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	
	
}
