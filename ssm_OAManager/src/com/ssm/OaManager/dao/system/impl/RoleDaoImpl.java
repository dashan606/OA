package com.ssm.OaManager.dao.system.impl;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.RoleDao;
import com.ssm.OaManager.entity.privilege.Role;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
	
	public RoleDaoImpl(){
		super.setNs(Role.class.getName());
	}

	public int findByMaxId() {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne(Role.class.getName()+".findByMaxId");
	}
	
	
}
