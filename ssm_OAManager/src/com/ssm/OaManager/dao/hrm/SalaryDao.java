package com.ssm.OaManager.dao.hrm;

import java.util.List;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.hrm.Salary;
import com.ssm.OaManager.entity.hrm.SalaryInfo;

public interface SalaryDao extends BaseDao<Salary> {
  
	public List<SalaryInfo> findToSal();
	
}
