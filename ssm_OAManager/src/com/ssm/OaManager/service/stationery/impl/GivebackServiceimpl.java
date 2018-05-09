package com.ssm.OaManager.service.stationery.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.stationery.GivebackDao;
import com.ssm.OaManager.entity.stationery.Giveback;
import com.ssm.OaManager.service.stationery.GivebackService;
import com.ssm.OaManager.utils.PageBean;

@Service
public class GivebackServiceimpl implements GivebackService{

	@Resource
	public GivebackDao givebackDao;
	
	public void setGivebackDao(GivebackDao givebackDao) {
		this.givebackDao = givebackDao;
	}

	/**带条件分页查询，条件可以为null，既没有条件；返回list对象集合*/
	public List<Giveback> findByPage(PageBean<Giveback> pageBean) {
		return this.givebackDao.findByPage(pageBean);
	}

	/**只查询一个，常用于修改*/
	public Giveback findById(Serializable id) {
		return this.givebackDao.findById(id);
	}

	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(Giveback entity) {
		return this.givebackDao.insert(entity);
	}

	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int update(Giveback entity) {
		return this.givebackDao.update(entity);
	}

	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int deleteById(Serializable id) {
		return this.givebackDao.deleteById(id);
	}

	/**
	 * 批量删除；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int delete(Serializable[] ids) {
		return this.givebackDao.delete(ids);
	}

	/**
	 * 查询全部
	 * @param entity
	 */
	public List<Giveback> findAll() {
		return this.givebackDao.findAll();
	}

	/**
	 * 查询记录数
	 * @param entity
	 */
	public int findCount(PageBean<Giveback> pageBean) {
		return this.givebackDao.findCount(pageBean);
	}
}
