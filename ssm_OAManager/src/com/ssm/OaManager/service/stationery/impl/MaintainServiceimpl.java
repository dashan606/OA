package com.ssm.OaManager.service.stationery.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.stationery.MaintainDao;
import com.ssm.OaManager.entity.stationery.Maintain;
import com.ssm.OaManager.service.stationery.MaintainService;
import com.ssm.OaManager.utils.PageBean;


@Service
public class MaintainServiceimpl implements MaintainService{
	
	@Resource
	public MaintainDao maintainDao;
	
	public void setMaintainDao(MaintainDao maintainDao) {
		this.maintainDao = maintainDao;
	}

	/**带条件分页查询，条件可以为null，既没有条件；返回list对象集合*/
	public List<Maintain> findByPage(PageBean<Maintain> pageBean) {
		return this.maintainDao.findByPage(pageBean);
	}

	/**只查询一个，常用于修改*/
	public Maintain findById(Serializable id) {
		return this.maintainDao.findById(id);
	}

	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(Maintain entity) {
		return this.maintainDao.insert(entity);
	}

	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int update(Maintain entity) {
		return this.maintainDao.update(entity);
	}

	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int deleteById(Serializable id) {
		return this.maintainDao.deleteById(id);
	}

	/**
	 * 批量删除；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int delete(Serializable[] ids) {
		return this.maintainDao.delete(ids);
	}

	/**
	 * 查询全部
	 * @param entity
	 */
	public List<Maintain> findAll() {
		return this.maintainDao.findAll();
	}

	/**
	 * 查询记录数
	 * @param entity
	 */
	public int findCount(PageBean<Maintain> pageBean) {
		return this.maintainDao.findCount(pageBean);
	}
}
