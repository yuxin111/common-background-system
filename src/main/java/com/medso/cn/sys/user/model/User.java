package com.medso.cn.sys.user.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;






import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.medso.cn.base.model.BaseModel;

/**
 * 用户实体
 * @author yuxin
 *
 */
@Entity
@Table(name="t_user")
public class User extends BaseModel{
	
	@Column(name="username",nullable=false,columnDefinition = "varchar(15) DEFAULT '' COMMENT '用户名'")
	private String username;
	
	@Column(name="password",nullable=false,columnDefinition = "varchar(255) DEFAULT '' COMMENT '密码'")
	private String password;
	
	@ManyToMany
	@Cascade(value={CascadeType.SAVE_UPDATE})
	@JoinTable(
		name="t_user_role",
		joinColumns={@JoinColumn(name="user_id")},
		inverseJoinColumns={@JoinColumn(name="role_id")}
	)
	private Set<Role> roles = new HashSet<Role>();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
