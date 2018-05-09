package com.ssm.OaManager.entity.hrm;

import java.util.Date;

public class Evection {
	
	private Integer evId;  
	private Date    date;
	private Integer time;
	private String  cause;
	private float   cost;
	private Employee emp;
	
	public Integer getEvId() {
		return evId;
	}
	public void setEvId(Integer evId) {
		this.evId = evId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
    
	public Evection(){
		
	}
}
