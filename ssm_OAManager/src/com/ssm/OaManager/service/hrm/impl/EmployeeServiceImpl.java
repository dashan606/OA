package com.ssm.OaManager.service.hrm.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.hrm.EmployeeDao;
import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.hrm.Position;
import com.ssm.OaManager.service.hrm.EmployeeService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Resource
    private EmployeeDao employeeDao;
	
	@MyAnnotation(methodNames = "redact")
	public int delete(Serializable[] ids) {
		return employeeDao.delete(ids);
	}
	
	public Employee findById(Serializable id) {
		return employeeDao.findById(id);
	}
	
	public List<Employee> findByPage(PageBean<Employee> pageBean) {
		return employeeDao.findByPage(pageBean);
	}
	
	public int findCount(PageBean<Employee> pageBean) {
		return employeeDao.findCount(pageBean);
	}
	
	public List<String> findEmpNumber() {
		return employeeDao.getEmpNumber();
	}
	
	public Employee findEmployeeByUserId(Integer userId) {
		return employeeDao.getEmployeeByUserId(userId);
	}
	@MyAnnotation(methodNames = "redact")
	public int insert(Employee entity) {
		return employeeDao.insert(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int updateEmp(Employee entity) {
		return employeeDao.update(entity);
	}

	/**
	 * 通过职位查询员工
	 * @param pos
	 * @return
	 */
	@MyAnnotation(methodNames = "redact")
	public List<Employee> findAllByPos(Position pos) {
		return employeeDao.findAllByPos(pos);
	}
	@MyAnnotation(methodNames = "redact")
	public int updateImg(Employee emp) {
		return employeeDao.updateImg(emp);
	}
	
	public Employee findEmpIdByEmpName(Employee emp) {
		return employeeDao.getEmpIdByEmpName(emp);
	}
	@MyAnnotation(methodNames = "redact")
	public int deleteById(Integer empId){
		return employeeDao.deleteById(empId);
	}


}
