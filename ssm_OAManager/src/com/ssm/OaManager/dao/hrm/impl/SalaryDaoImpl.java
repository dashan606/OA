package com.ssm.OaManager.dao.hrm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.hrm.SalaryDao;
import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.entity.hrm.Salary;
import com.ssm.OaManager.entity.hrm.SalaryInfo;

@Repository
public class SalaryDaoImpl extends BaseDaoImpl<Salary> implements SalaryDao   {
	// 利用默认构造方法初始化命名空间
	public SalaryDaoImpl() {
		super.setNs(Salary.class.getName());
	}
	
	public List<SalaryInfo> findToSal (){
		return super.getSqlSession().selectList(super.getNs()+".selectEvectionToSal");
	}
}
