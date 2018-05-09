package com.ssm.OaManager.entity.privilege;

import java.util.List;

import com.ssm.OaManager.entity.User;

/**
 * 角色实体类
 * @author TYX
 *
 */
public class Role {
	private Integer roleId;//角色编号

	private String roleName;//角色名称

	private String roleDescripti;//角色详细

	private List<User> users;
	
	private List<Function> functions;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescripti() {
		return roleDescripti;
	}

	public void setRoleDescripti(String roleDescripti) {
		this.roleDescripti = roleDescripti;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((functions == null) ? 0 : functions.hashCode());
		result = prime * result
				+ ((roleDescripti == null) ? 0 : roleDescripti.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result
				+ ((roleName == null) ? 0 : roleName.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (functions == null) {
			if (other.functions != null)
				return false;
		} else if (!functions.equals(other.functions))
			return false;
		if (roleDescripti == null) {
			if (other.roleDescripti != null)
				return false;
		} else if (!roleDescripti.equals(other.roleDescripti))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	
	
}
