package com.medso.cn.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medso.cn.base.service.IBaseService;


public class BaseController<T> implements IBaseController<T>{
	
	@Autowired
	protected IBaseService<T> baseService;
	
	@GetMapping(value="/add")
	@Override
	public void save(T t) {
		baseService.save(t);
	}
	
	@GetMapping(value="/delete/{id}")
	@Override
	public void delete(
		@PathVariable("id") int id
	) {
		baseService.delete(id);
	}
	
	@GetMapping(value="/update/{id}")
	@Override
	public void update(
		@PathVariable("id") int id,
		T t
	) {
		System.out.println("controller:"+t.getClass().getName());
		baseService.update(id,t);
	}
	
	@GetMapping(value="/select/{id}")
	@ResponseBody
	public T select(
		@PathVariable("id") int id
	) {
		return baseService.getById(id);
	}
}
