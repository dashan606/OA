package com.ssm.OaManager.service.hrm;

import java.util.List;

import com.ssm.OaManager.entity.hrm.Department;
import com.ssm.OaManager.entity.hrm.Position;

public interface DeptService {
	
	/**
	 * 插入，用实体作为参数
	 * 
	 * @param entity
	 */
	public int insert(Department department);
	/**
	 * 修改，用实体作为参数
	 * 
	 * @param entity
	 */
	public int update(Department department);
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id);
	
	/**只查询一个，常用于修改*/
	public Department findById(Integer id);	
	
	/**
	 * 查询全部
	 * @return
	 */
	public List<Department> findAll();
	
	/**
	 * 查询
	 * @param pos
	 * @return
	 */
	public Position findByPos(Position pos);

}
