package com.ssm.OaManager.dao.hrm;

import java.util.List;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.hrm.Position;

public interface EmployeeDao extends BaseDao<Employee>{

	/**
	 * 查询所有员工编号
	 * @return 员工编号集合
	 */
	public List<String> getEmpNumber();

	/**
	 * 根据用户id查询当前用户
	 * @param userId 用户id
	 * @return  员工
	 */
	public Employee getEmployeeByUserId(Integer userId);

	/**
	 * 通过职位查询员工
	 * @param pos
	 * @return
	 */
	public List<Employee> findAllByPos(Position pos);
	
	/***
	 * 根据员工姓名查询员工信息
	 * @return
	 */
	public Employee  getEmpIdByEmpName(Employee emp);
	
	/**
	 * 根据用户id修改头像
	 * @param emp
	 * @return
	 */
	public  int updateImg(Employee emp);

}
