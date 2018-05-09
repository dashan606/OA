package com.ssm.OaManager.dao.hrm.impl;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.hrm.EvectionDao;
import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.entity.hrm.Evection;

@Repository
public class EvectionDaoImpl extends BaseDaoImpl<Evection> implements EvectionDao  {
	// 利用默认构造方法初始化命名空间
	public EvectionDaoImpl() {
		super.setNs(Evection.class.getName());
	}
}
