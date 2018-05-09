package com.ssm.OaManager.service.hrm;

import java.util.List;

import com.ssm.OaManager.entity.hrm.Salary;
import com.ssm.OaManager.entity.hrm.SalaryInfo;

public interface SalaryService {
	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(Salary salary);
	
	/**
	 * 查询全部
	 * @param entity
	 */
	public List<Salary> findAll();
	
	
	public List<SalaryInfo> findToSal();
}
