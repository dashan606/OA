package com.ssm.OaManager.dao.hrm.impl;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.hrm.LeaveDao;
import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.entity.hrm.Leave;

@Repository
public class LeaveDaoImpl extends BaseDaoImpl<Leave> implements LeaveDao {
	// 利用默认构造方法初始化命名空间
	public LeaveDaoImpl() {
		super.setNs(Leave.class.getName());
	}
}
