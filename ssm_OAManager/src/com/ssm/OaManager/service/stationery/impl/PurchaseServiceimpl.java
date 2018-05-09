package com.ssm.OaManager.service.stationery.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.stationery.PurchaseDao;
import com.ssm.OaManager.entity.stationery.Purchase;
import com.ssm.OaManager.service.stationery.PurchaseService;
import com.ssm.OaManager.utils.PageBean;

@Service
public class PurchaseServiceimpl implements PurchaseService{
	@Resource
	public PurchaseDao purchaseDao;
	
	public void setPurchaseDao(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}

	/**带条件分页查询，条件可以为null，既没有条件；返回list对象集合*/
	public List<Purchase> findByPage(PageBean<Purchase> pageBean) {
		return this.purchaseDao.findByPage(pageBean);
	}

	/**只查询一个，常用于修改*/
	public Purchase findById(Serializable id) {
		return this.purchaseDao.findById(id);
	}

	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(Purchase entity) {
		return this.purchaseDao.insert(entity);
	}

	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int update(Purchase entity) {
		return this.purchaseDao.update(entity);
	}

	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int deleteById(Serializable id) {
		return this.purchaseDao.deleteById(id);
	}

	/**
	 * 批量删除；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int delete(Serializable[] ids) {
		return this.purchaseDao.delete(ids);
	}

	/**
	 * 查询全部
	 * @param entity
	 */
	public List<Purchase> findAll() {
		return this.purchaseDao.findAll();
	}

	/**
	 * 查询记录数
	 * @param entitys
	 */
	public int findCount(PageBean<Purchase> pageBean) {
		return this.purchaseDao.findCount(pageBean);
	}
}
