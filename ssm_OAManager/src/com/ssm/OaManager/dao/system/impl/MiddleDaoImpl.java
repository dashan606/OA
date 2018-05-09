package com.ssm.OaManager.dao.system.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.MiddleDao;
import com.ssm.OaManager.entity.privilege.Middle;

@Repository
public class MiddleDaoImpl extends BaseDaoImpl<Middle> implements MiddleDao {
	
	public MiddleDaoImpl(){
		super.setNs(Middle.class.getName());
	}

	public Middle findByRoleId(Serializable id) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(Middle.class.getName() + ".findByRoleId", id);
	}

	public Middle findByFunId(Serializable id) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(Middle.class.getName() + ".findByFunId", id);
	}

	public int deleteByRoleId(Serializable[] ids) {
		Map<String, Serializable> map = new  HashMap<String, Serializable>();
		map.put("ids", ids);
		return this.getSqlSession().delete(Middle.class.getName() + ".deleteByRoleId", map);
	}

	public int deleteByFunId(Serializable[] ids) {
		Map<String, Serializable> map = new  HashMap<String, Serializable>();
		map.put("ids", ids);
		return this.getSqlSession().delete(Middle.class.getName() + ".deleteByFunId", map);
	}

}
