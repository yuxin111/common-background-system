package com.medso.cn.base.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BaseModel {
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name="id",unique=true,nullable=false)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
