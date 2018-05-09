package com.ssm.OaManager.service.hrm;

import java.util.List;

import com.ssm.OaManager.entity.hrm.Position;
import com.ssm.OaManager.utils.PageBean;

public interface PositionService {

	/**只查询一个，常用于修改*/
	public Position findById(int id);	
	
	/**
	 * 分页查询所有名称
	 */
	public List<Position> findAll();
	
	/**
	 * 修改一条记录
	 */
	public int updateById(Position t);
	
	/**
	 * 根据id删除一条记录
	 */
	public int deleteById(int id);	
	
	/**
	 * 添加一条记录
	 */
	public int insert(Position position);
	
	/**
	 * 设置分页对象属性
	 */
	public void findPageBean(PageBean<Position> pageBean);


}
