package com.ssm.OaManager.dao.system.impl;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.FunctionDao;
import com.ssm.OaManager.entity.privilege.Function;

@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements FunctionDao {
	
	public FunctionDaoImpl(){
		super.setNs(Function.class.getName());
	}

}
