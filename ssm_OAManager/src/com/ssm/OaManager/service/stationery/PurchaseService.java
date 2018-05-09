package com.ssm.OaManager.service.stationery;

import java.io.Serializable;
import java.util.List;

import com.ssm.OaManager.entity.stationery.Purchase;
import com.ssm.OaManager.utils.PageBean;


public interface PurchaseService{
	
	/**带条件分页查询，条件可以为null，既没有条件；返回list对象集合*/
	public List<Purchase> findByPage(PageBean<Purchase> pageBean);	
	
	/**只查询一个，常用于修改*/
	public Purchase findById(Serializable id);	
	
	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(Purchase entity);
	
	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int update(Purchase entity);	
	
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
	public List<Purchase> findAll();
	
	/**
	 * 查询记录数
	 * @param entity
	 */
	public int findCount(PageBean<Purchase> pageBean);
}
