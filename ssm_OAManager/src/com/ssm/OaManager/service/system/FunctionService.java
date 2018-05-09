package com.ssm.OaManager.service.system;

import java.io.Serializable;
import java.util.List;

import com.ssm.OaManager.entity.privilege.Function;
import com.ssm.OaManager.utils.PageBean;

public interface FunctionService {
	
	/**只查询一个，常用于修改*/
	public Function findById(Serializable id);	

	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(Function entity);

	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int update(Function entity);	

	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int deleteById(Serializable id);	

	/**
	 * 批量删除；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int delete(Serializable[] ids);			

	/**
	 * 查询全部
	 * @param entity
	 */
	public List<Function> findAll();

	/**
	 * 设置分页对象属性
	 * @param pageBeapageBeann 分页对象
	 */
	public void findPageBean(PageBean<Function> pageBean);

	/**
	 * 禁用/使用
	 * @param entity
	 */
	public int findFunction(Function entity);
}
