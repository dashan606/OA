package com.ssm.OaManager.dao.hrm.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.hrm.DeptDAO;
import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.entity.hrm.Department;
import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.hrm.Position;

@Repository
public class DeptDAOImpl extends BaseDaoImpl<Department> implements DeptDAO {

	public DeptDAOImpl() {
		super.setNs(Department.class.getName());
	}

	public List<Employee> findAllEmp(Serializable id) {
		return this.getSqlSession().selectList(Employee.class.getName()+".getEmpNumber", id);
	}
	
	/**
	 * 查询
	 * @param pos
	 * @return
	 */
	public Position findByPos(Position pos) {
		return this.getSqlSession().selectOne(Department.class.getName()+".findByPos",pos);
	}

}
