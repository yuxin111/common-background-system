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
 * 角色实体
 * @author yuxin
 *
 */
@Entity
@Table(name="t_role")
public class Role extends BaseModel{
	
	@Column(name="role_name",nullable=false,columnDefinition = "varchar(15) DEFAULT '' COMMENT '角色名'")
	private String roleName;

	@ManyToMany
	@Cascade(value={CascadeType.SAVE_UPDATE})
	@JoinTable(
		name="t_user_role",
		joinColumns={@JoinColumn(name="role_id")},
		inverseJoinColumns={@JoinColumn(name="user_id")}
	)
	private Set<User> users = new HashSet<User>();
	
	@ManyToMany
	@Cascade(value={CascadeType.SAVE_UPDATE})
	@JoinTable(
		name="t_role_permission",
		joinColumns={@JoinColumn(name="role_id")},
		inverseJoinColumns={@JoinColumn(name="permission_id")}
	)
	private Set<Permission> permissions = new HashSet<Permission>();

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
}
