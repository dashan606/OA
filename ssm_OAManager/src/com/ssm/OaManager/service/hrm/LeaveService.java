package com.ssm.OaManager.service.hrm;

import java.util.List;

import com.ssm.OaManager.entity.hrm.Evection;
import com.ssm.OaManager.entity.hrm.Leave;

public interface LeaveService {

	/**只查询一个，常用于修改*/
	public Leave findById(Integer id);	
	
	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(Leave entity);
	
	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int update(Leave entity);	
	
	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int deleteById(Integer id);	
	
	
	
	public List<Leave> findAll();
}
