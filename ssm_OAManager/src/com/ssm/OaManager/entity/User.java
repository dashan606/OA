package com.ssm.OaManager.entity;

import java.util.List;

import com.ssm.OaManager.entity.hrm.Department;
import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.privilege.Role;

/**
 * 用户实体类
 * 
 * @author Administrator
 * 
 */
public class User {


	private Integer userId;//用户编号

	private String userName;//账号

	private String userPassword ;//密码

	/*private Integer  empId;// 员工 一对一*/	
	private Employee emp;//员工 一对一
	
	private Department dep;//部门
	
   private List<Role> roles;
   
	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	private String userEmail;//邮箱

	private Integer state;// 状态码

	private String code;// 激活码

	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	

}
