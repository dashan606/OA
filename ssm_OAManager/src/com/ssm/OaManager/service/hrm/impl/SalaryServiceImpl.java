package com.ssm.OaManager.service.hrm.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.hrm.SalaryDao;
import com.ssm.OaManager.entity.hrm.Salary;
import com.ssm.OaManager.entity.hrm.SalaryInfo;
import com.ssm.OaManager.service.hrm.SalaryService;
import com.ssm.OaManager.utils.MyAnnotation;

@Service
public class SalaryServiceImpl implements SalaryService {
    
	@Resource
	private SalaryDao dao;
	
	public List<Salary> findAll() {
		return dao.findAll();
	}
	
	public List<SalaryInfo> findToSal() {
		return dao.findToSal();
	}
	@MyAnnotation(methodNames = "redact")
	public int insert(Salary salary) {
		return dao.insert(salary);
	}

}
