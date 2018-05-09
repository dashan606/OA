package com.ssm.OaManager.dao.system;

import java.io.Serializable;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.privilege.Middle;

public interface MiddleDao extends BaseDao<Middle> {
	
	/**
	 * 根据角色编号查询
	 * @param rid
	 * @return
	 */
	public Middle findByRoleId(Serializable id);
	
	/**
	 * 根据功能编号查询
	 * @param fid
	 * @return
	 */
	public Middle findByFunId(Serializable id);
	
	/**
	 * 根据角色编号删除
	 * @param ids
	 * @return
	 */
	public int deleteByRoleId(Serializable[] ids);
	
	/**
	 * 根据功能编号删除
	 * @param ids
	 * @return
	 */
	public int deleteByFunId(Serializable[] ids);

}
