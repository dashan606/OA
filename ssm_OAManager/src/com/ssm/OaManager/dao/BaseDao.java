package com.ssm.OaManager.dao;

import java.io.Serializable;
import java.util.List;

import com.ssm.OaManager.utils.PageBean;

/**
 * @Description: 泛型类，基础的DAO接口
 * 
 */
public interface BaseDao<T> {
	
	/**带条件分页查询，条件可以为null，既没有条件；返回list对象集合*/
	public List<T> findByPage(PageBean<T> pageBean);	
	
	/**只查询一个，常用于修改*/
	public T findById(Serializable id);	
	
	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(T entity);
	
	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int update(T entity);	
	
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
	public List<T> findAll();
	
	/**
	 * 查询记录数
	 * @param entity
	 */
	public int findCount(PageBean<T> pageBean);
	
}
