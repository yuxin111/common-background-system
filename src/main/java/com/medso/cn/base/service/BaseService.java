package com.medso.cn.base.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.medso.cn.base.dao.IBaseDao;

@Transactional(propagation=Propagation.REQUIRED)
public class BaseService<T> implements IBaseService<T>{

	@Autowired
	protected IBaseDao<T> baseDao;
	
	@Override
	public void save(T t) {
		baseDao.save(t);		
	}

	@Override
	public void update(int id,T t) {
		baseDao.update(id,t);
	}

	@Override
	public void delete(T t) {
		baseDao.delete(t);
	}

	@Override
	public void delete(Serializable id) {
		baseDao.delete(id);
	}

	@Override
	public T getById(Serializable id) {
		return baseDao.getById(id);
	}
	
}
