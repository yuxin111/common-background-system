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
 * 权限实体
 * @author yuxin
 *
 */
@Entity
@Table(name="t_permission")
public class Permission extends BaseModel{
	
	@Column(name="permission_code",nullable=false,columnDefinition = "varchar(30) DEFAULT '' COMMENT '权限代码'")
	private String permissionCode;
	
	@Column(name="permission_desc",nullable=true,columnDefinition = "varchar(255) DEFAULT '' COMMENT '权限描述'")
	private String permissionDesc;
	
	@ManyToMany
	@Cascade(value={CascadeType.SAVE_UPDATE})
	@JoinTable(
		name="t_role_permission",
		joinColumns={@JoinColumn(name="permission_id")},
		inverseJoinColumns={@JoinColumn(name="role_id")}
	)
	private Set<Role> roles = new HashSet<Role>();

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getPermissionDesc() {
		return permissionDesc;
	}

	public void setPermissionDesc(String permissionDesc) {
		this.permissionDesc = permissionDesc;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
