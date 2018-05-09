package com.ssm.OaManager.dao.system;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.privilege.Role;

public interface RoleDao extends BaseDao<Role> {
	
	/**
	 * 查询最大编号
	 */
	public int findByMaxId();

}
