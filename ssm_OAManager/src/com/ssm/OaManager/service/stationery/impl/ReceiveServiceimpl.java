package com.ssm.OaManager.service.stationery.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.stationery.ReceiveDao;
import com.ssm.OaManager.entity.stationery.Receive;
import com.ssm.OaManager.service.stationery.ReceiveService;
import com.ssm.OaManager.utils.PageBean;

@Service
public class ReceiveServiceimpl implements ReceiveService{
	
	@Resource
	public ReceiveDao receiveDao;
	
	public void setReceiveDao(ReceiveDao receiveDao) {
		this.receiveDao = receiveDao;
	}

	/**带条件分页查询，条件可以为null，既没有条件；返回list对象集合*/
	public List<Receive> findByPage(PageBean<Receive> pageBean) {
		return this.receiveDao.findByPage(pageBean);
	}

	/**只查询一个，常用于修改*/
	public Receive findById(Serializable id) {
		return this.receiveDao.findById(id);
	}

	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(Receive entity) {
		return this.receiveDao.insert(entity);
	}

	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int update(Receive entity) {
		return this.receiveDao.update(entity);
	}

	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int deleteById(Serializable id) {
		return this.receiveDao.deleteById(id);
	}

	/**
	 * 批量删除；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int delete(Serializable[] ids) {
		return this.receiveDao.delete(ids);
	}

	/**
	 * 查询全部
	 * @param entity
	 */
	public List<Receive> findAll() {
		return this.receiveDao.findAll();
	}

	/**
	 * 查询记录数
	 * @param entity
	 */
	public int findCount(PageBean<Receive> pageBean) {
		return this.receiveDao.findCount(pageBean);
	}
}
