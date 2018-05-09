package com.ssm.OaManager.service.hrm;

import java.io.Serializable;
import java.util.List;

import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.hrm.Position;
import com.ssm.OaManager.utils.PageBean;


public interface EmployeeService {
	public int delete(Serializable[] ids);

	public Employee findById(Serializable id) ;

	public List<Employee> findByPage(PageBean<Employee> pageBean) ;

	public int findCount(PageBean<Employee> pageBean) ;

	public List<String> findEmpNumber() ;

	public Employee findEmployeeByUserId(Integer userId);

	public int insert(Employee entity) ;

	public int updateEmp(Employee entity) ;
	
	/**
	 * 通过职位查询员工
	 * @param pos
	 * @return
	 */
	public List<Employee> findAllByPos(Position pos);
	
	public  int updateImg(Employee emp);
	
	/***
	 * 根据员工姓名查询员工信息
	 * @return
	 */
	public Employee  findEmpIdByEmpName(Employee emp);
	
	public int deleteById(Integer empId);
}
