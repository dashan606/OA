package com.ssm.OaManager.dao.hrm;

import java.io.Serializable;
import java.util.List;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.hrm.Department;
import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.hrm.Position;

public interface DeptDAO extends BaseDao<Department> {
	
	/**
	 * 根据员工id查询
	 * @param id
	 * @return
	 */
	public List<Employee> findAllEmp(Serializable id);
	

	/**
	 * 查询
	 * @param pos
	 * @return
	 */
	Position findByPos(Position pos);

}
