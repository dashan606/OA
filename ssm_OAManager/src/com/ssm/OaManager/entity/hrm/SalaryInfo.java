package com.ssm.OaManager.entity.hrm;

public class SalaryInfo {
	private int empId;
	private String  empNumber;
	private String  empName;
	private int  empSalary;
	private String  date;
	private int  evTime;
	private int evCuse;
	private int leTime;
	private int leCute;
	private int tax;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
		this.tax = (int) (empSalary*0.1);
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getEvTime() {
		return evTime;
	}
	public void setEvTime(int evTime) {
		this.evTime = evTime;
	}
	public int getEvCuse() {
		return evCuse;
	}
	public void setEvCuse(int evCuse) {
		this.evCuse = evCuse;
	}
	public int getLeTime() {
		return leTime;
	}
	public void setLeTime(int leTime) {
		this.leTime = leTime;
		this.leCute = ((int)(this.getEmpSalary()/30))*leTime;
	}
	public int getLeCute() {
		return leCute;
	}
	public void setLeCute(int leCute) {
		this.leCute = leCute;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	
	public SalaryInfo(){
		
	}
	
	

}
