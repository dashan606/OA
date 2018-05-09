package com.ssm.OaManager.service.hrm;

import java.util.List;

import com.ssm.OaManager.entity.hrm.Evection;

public interface EvectionService {
;	
	
	/**只查询一个，常用于修改*/
	public Evection findById(Integer id);	
	
	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(Evection entity);
	
	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int update(Evection entity);	
	
	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int deleteById(Integer id);	
	
	
	
	public List<Evection> findAll();
	
	
}
