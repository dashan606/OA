package com.ssm.OaManager.entity.hrm;

public class Salary {
	//salary(sal_id,date_s,basic_salary,cut_money,bonus,tax,final_sal)
	private Integer salId;
	private String  salDate;
	private Integer basicSal;
	private Integer cutMoney;
	private Integer bonus;
	private Integer tax;
	private Integer finalSal;
	private Employee emp;
	public Integer getSalId() {
		return salId;
	}
	public void setSalId(Integer salId) {
		this.salId = salId;
	}
	public String getSalDate() {
		return salDate;
	}
	public void setSalDate(String salDate) {
		this.salDate = salDate;
	}
	public Integer getBasicSal() {
		return basicSal;
	}
	public void setBasicSal(Integer basicSal) {
		this.basicSal = basicSal;
	}
	public Integer getCutMoney() {
		return cutMoney;
	}
	public void setCutMoney(Integer cutMoney) {
		this.cutMoney = cutMoney;
	}
	public Integer getBonus() {
		return bonus;
	}
	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}
	public Integer getTax() {
		return tax;
	}
	public void setTax(Integer tax) {
		this.tax = tax;
	}
	public Integer getFinalSal() {
		return finalSal;
	}
	public void setFinalSal(Integer finalSal) {
		this.finalSal = finalSal;
	}
	
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Salary(){
		
	}

}
