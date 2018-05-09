package com.ssm.OaManager.dao.hrm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.hrm.EmployeeDao;
import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.hrm.Position;

@Repository
public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements
		EmployeeDao {
	// 利用默认构造方法初始化命名空间
	public EmployeeDaoImpl() {
		super.setNs(Employee.class.getName());
	}
	//更换头像
	public  int updateImg(Employee emp){
		return  this.getSqlSession().update(Employee.class.getName()+".updateByUserId", emp);
	}
	
	public Employee getEmpIdByEmpName(Employee emp) {
		return this.getSqlSession().selectOne(Employee.class.getName()+".getEmployeeIdByEmpName", emp);
	}

	public Employee getEmployeeByUserId(Integer userId) {
		 return super.getSqlSession().selectOne(Employee.class.getName()+".findByUserId",userId);
	}
 
	
	/**
	 * 通过职位查询员工
	 * @param pos
	 * @return
	 */
	public List<Employee> findAllByPos(Position pos) {
		return this.getSqlSession().selectList(Employee.class.getName()+".findAllByPos", pos);
	}
	
	public List<String> getEmpNumber() {
		return this.getSqlSession().selectList(Employee.class.getName()+".getEmployeeNumber");
	}




}
