package com.medso.cn.base.dao;

import java.io.Serializable;

public interface IBaseDao<T> {
	/**
	 * 保存实体
	 * @param t
	 */
	public void save(T t);
	
	/**
	 * 更新实体
	 * @param id 
	 * @param t
	 */
	public void update(int id, T t);
	
	/**
	 * 删除实体
	 * @param t
	 */
	public void delete(T t);
	
	/**
	 * 根据id删除实体
	 * @param t
	 */
	public void delete(Serializable id);
	
	/**
	 * 获取某一实体
	 * @param id
	 * @return
	 */
	public T getById(Serializable id);
	
}
