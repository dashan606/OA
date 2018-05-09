package com.ssm.OaManager.service.system;

import java.io.Serializable;
import java.util.List;

import com.ssm.OaManager.entity.privilege.Middle;

public interface MiddleService {
	
	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(Middle entity);
	
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
	
	/**
	 * 查询全部
	 * @return
	 */
	public List<Middle> findAll();

}
