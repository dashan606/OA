package com.ssm.OaManager.entity;

import com.ssm.OaManager.entity.privilege.Role;

/**
 * 用户角色中间表
 * @author Administrator
 *
 */
public class RuMiddle {
	
	private User user;//用户
	
	private Role role;//角色

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
