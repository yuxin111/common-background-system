package com.medso.cn.base.controller;

public interface IBaseController<T> {

	public void save(T t);

	public void delete(int id);

	public void update(int id,T t);

	public T select(int id);

}
