package com.ssm.OaManager.entity.hrm;

import java.util.Date;

public class Leave {
	
	private Integer leaId;
	private Date leaDate;
	private Integer leaTime;
	private String leaCause;
	private Employee emp;

	public Integer getLeaId() {
		return leaId;
	}

	public void setLeaId(Integer leaId) {
		this.leaId = leaId;
	}

	public Date getLeaDate() {
		return leaDate;
	}

	public void setLeaDate(Date leaDate) {
		this.leaDate = leaDate;
	}

	public Integer getLeaTime() {
		return leaTime;
	}

	public void setLeaTime(Integer leaTime) {
		this.leaTime = leaTime;
	}

	public String getLeaCause() {
		return leaCause;
	}

	public void setLeaCause(String leaCause) {
		this.leaCause = leaCause;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Leave() {

	}

}
