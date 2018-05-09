package com.ssm.OaManager.entity.privilege;


/**
 * 中间表的实体类
 * @author TYX
 *
 */
public class Middle {
	private Role role;//角色
	
	private Function function;//功能

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

}
