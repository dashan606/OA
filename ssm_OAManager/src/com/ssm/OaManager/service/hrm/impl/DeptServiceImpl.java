package com.ssm.OaManager.service.hrm.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.hrm.DeptDAO;
import com.ssm.OaManager.entity.hrm.Department;
import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.hrm.Position;
import com.ssm.OaManager.service.hrm.DeptService;
import com.ssm.OaManager.utils.MyAnnotation;

@Service
public class DeptServiceImpl implements DeptService {
	@Resource
	private DeptDAO deptDAO;

	public void setDeptDAO(DeptDAO deptDAO) {
		this.deptDAO = deptDAO;
	}

	@MyAnnotation(methodNames = "redact")
	public int insert(Department department) {
		// TODO Auto-generated method stub
		return this.deptDAO.insert(department);
	}

	@MyAnnotation(methodNames = "redact")
	public int update(Department department) {
		// TODO Auto-generated method stub
		return this.deptDAO.update(department);
	}

	@MyAnnotation(methodNames = "redact")
	public int deleteById(Integer id) {
		List<Employee> emp = this.deptDAO.findAllEmp(id);
		
		if(!emp.isEmpty()){
			return -2;
		}else{
			return this.deptDAO.deleteById(id);
		}
		// TODO Auto-generated method stub
		
	}

	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		return this.deptDAO.findById(id);
	}

	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return this.deptDAO.findAll();
	}

	/**
	 * 查询
	 * @param pos
	 * @return
	 */
	public Position findByPos(Position pos) {
		return this.deptDAO.findByPos(pos);
	}
	
}
