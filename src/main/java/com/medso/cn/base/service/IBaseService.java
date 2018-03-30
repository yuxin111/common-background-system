package com.medso.cn.base.service;

import java.io.Serializable;

public interface IBaseService<T> {
	public void save(T t);
	public void update(int id,T t);
	public void delete(T t);
	public void delete(Serializable id);
	public T getById(Serializable id);
	
}
