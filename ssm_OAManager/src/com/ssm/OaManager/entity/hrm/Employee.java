package com.ssm.OaManager.entity.hrm;

import java.util.Date;

import com.ssm.OaManager.entity.User;

/**
 * 员工实体类
 * @author Administrator
 *
 */
public class Employee {
	
	/*EMP_ID	Int	否		主键,自增	主键，无意义
	EMP_Number	varchar(5)	否		唯一	员工工号
	EMP_Name	varchar(30)	否			员工姓名
	USER_ID	int	否		外键	用户ID
	EMP_Sex	char(1)	否	‘男’或‘女’	检查	性别
	EMP_Brithday	Datetime	否			出生年月
	POS_ID	Int	否		外键	职位ID
	DEP_ID	Int	否		外键	部门ID
	EMP_Salary	Money	否			工资
	EMP_Telephone	varchar(20)	是			电话
	EMP_Address	varchar(50)	是			地址
	EMP_EntryDate	Datetime	否	NOW()		入职时间
	MaritalStatus	Int	否	0或1	0表示未婚1表示已婚	婚姻状况
	EMP_PhotoUrl	varchar(MAX)	否			照片地址*/
	private Integer empId;
	private String empNumber;
	private String empName;
	
	private String empSex;
	private Integer empAge;
	private Date empBrithday;
	
	private Double empSalary;
	private String empTelephone;
	private String empAddress;
	private Date empEntryDate;
	private Integer MaritalStatus;
	private String empPhotoUrl;
	
	private User user;
	
	/*private Integer posId;
	private Integer depId;*/
	private Department dep;
	
	private Position pos;
	
	public Employee() {
	}

	public Employee(Integer empId, String empNumber, String empName,Integer empAge,
			String empSex, Date empBrithday, Double empSalary,
			String empTelephone, String empAddress, Date empEntryDate,
			Integer maritalStatus, String empPhotoUrl, User user,
			Department dep, Position pos) {
		super();
		this.empId = empId;
		this.empNumber = empNumber;
		this.empName = empName;
		this.empSex = empSex;
		this.empAge = empAge;
		this.empBrithday = empBrithday;
		this.empSalary = empSalary;
		this.empTelephone = empTelephone;
		this.empAddress = empAddress;
		this.empEntryDate = empEntryDate;
		MaritalStatus = maritalStatus;
		this.empPhotoUrl = empPhotoUrl;
		this.user = user;
		this.dep = dep;
		this.pos = pos;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
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

	public String getEmpSex() {
		return empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public Integer getEmpAge() {
		return empAge;
	}

	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}

	public Date getEmpBrithday() {
		return empBrithday;
	}

	public void setEmpBrithday(Date empBrithday) {
		this.empBrithday = empBrithday;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpTelephone() {
		return empTelephone;
	}

	public void setEmpTelephone(String empTelephone) {
		this.empTelephone = empTelephone;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public Date getEmpEntryDate() {
		return empEntryDate;
	}

	public void setEmpEntryDate(Date empEntryDate) {
		this.empEntryDate = empEntryDate;
	}

	public Integer getMaritalStatus() {
		return MaritalStatus;
	}

	public void setMaritalStatus(Integer maritalStatus) {
		MaritalStatus = maritalStatus;
	}

	public String getEmpPhotoUrl() {
		return empPhotoUrl;
	}

	public void setEmpPhotoUrl(String empPhotoUrl) {
		this.empPhotoUrl = empPhotoUrl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}
	
	
	
}
