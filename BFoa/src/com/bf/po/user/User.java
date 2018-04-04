package com.bf.po.user;

import java.io.Serializable;

import com.bf.po.emp.Employee;
import com.bf.po.group.Group;

public class User implements Serializable {
	public int getU_id() {
		return u_id;
	}

	public void setU_id(int uId) {
		u_id = uId;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String uName) {
		u_name = uName;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String uPwd) {
		u_pwd = uPwd;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	private int u_id; 		//员工id
	private String u_name;  //员工登录名
	private String u_pwd; 	//员工登陆密码
	private int flag;  		//标识，1为在职，有效
	private Group group;  	//所属部门
	private Employee emp;  	//员工信息
}
