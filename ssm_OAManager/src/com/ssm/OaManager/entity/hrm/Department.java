package com.ssm.OaManager.entity.hrm;

/**
 * 部门实体类
 * 
 * @author Administrator
 * 
 */
public class Department {

	private Integer deptId;//序号
	
	private String deptNumber;//部门编号

	private String deptName;//部门名称
	
	private String deptDescripti;//部门描述

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptNumber() {
		return deptNumber;
	}

	public void setDeptNumber(String deptNumber) {
		this.deptNumber = deptNumber;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDescripti() {
		return deptDescripti;
	}

	public void setDeptDescripti(String deptDescripti) {
		this.deptDescripti = deptDescripti;
	}
}
