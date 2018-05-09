package com.ssm.OaManager.entity.privilege;

import java.util.List;


/**
 * 功能实体类
 * @author TYX
 *
 */
public class Function {
	private Integer funId;//功能编号
	
	private String funName;//功能名称
	
	private String funUrl;//功能菜单
	
	private Integer funForbidden;//是否禁用
	
	private String funDescripti;//描述
	
	private List<Role> roles;

	public Integer getFunId() {
		return funId;
	}

	public void setFunId(Integer funId) {
		this.funId = funId;
	}

	public String getFunName() {
		return funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

	public String getFunUrl() {
		return funUrl;
	}

	public void setFunUrl(String funUrl) {
		this.funUrl = funUrl;
	}

	public Integer getFunForbidden() {
		return funForbidden;
	}

	public void setFunForbidden(Integer funForbidden) {
		this.funForbidden = funForbidden;
	}

	public String getFunDescripti() {
		return funDescripti;
	}

	public void setFunDescripti(String funDescripti) {
		this.funDescripti = funDescripti;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((funDescripti == null) ? 0 : funDescripti.hashCode());
		result = prime * result
				+ ((funForbidden == null) ? 0 : funForbidden.hashCode());
		result = prime * result + ((funId == null) ? 0 : funId.hashCode());
		result = prime * result + ((funName == null) ? 0 : funName.hashCode());
		result = prime * result + ((funUrl == null) ? 0 : funUrl.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
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
		Function other = (Function) obj;
		if (funDescripti == null) {
			if (other.funDescripti != null)
				return false;
		} else if (!funDescripti.equals(other.funDescripti))
			return false;
		if (funForbidden == null) {
			if (other.funForbidden != null)
				return false;
		} else if (!funForbidden.equals(other.funForbidden))
			return false;
		if (funId == null) {
			if (other.funId != null)
				return false;
		} else if (!funId.equals(other.funId))
			return false;
		if (funName == null) {
			if (other.funName != null)
				return false;
		} else if (!funName.equals(other.funName))
			return false;
		if (funUrl == null) {
			if (other.funUrl != null)
				return false;
		} else if (!funUrl.equals(other.funUrl))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		return true;
	}
	
	

}
