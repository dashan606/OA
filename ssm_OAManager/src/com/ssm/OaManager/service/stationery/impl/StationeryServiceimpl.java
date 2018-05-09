package com.ssm.OaManager.service.stationery.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.stationery.StationeryDao;
import com.ssm.OaManager.entity.stationery.Stationery;
import com.ssm.OaManager.service.stationery.StationeryService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;


@Service
public class StationeryServiceimpl implements StationeryService{
	
	@Resource
	public StationeryDao stationeryDao;
	
	public void setStationeryDao(StationeryDao stationeryDao) {
		this.stationeryDao = stationeryDao;
	}

	/**带条件分页查询，条件可以为null，既没有条件；返回list对象集合*/
	public List<Stationery> findByPage(PageBean<Stationery> pageBean) {
		List<Stationery> stationery = this.stationeryDao.findByPage(pageBean);
				if(stationery==null){
					stationery = new ArrayList<Stationery>();
				}
		return stationery;
	}

	/**只查询一个，常用于修改*/
	public Stationery findById(Serializable id) {
		Stationery stationery = this.stationeryDao.findById(id);
		if(stationery==null){
			stationery = new Stationery();
		}
		return stationery;
	}

	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	@MyAnnotation(methodNames = "redact")
	public int insert(Stationery entity) {
		return this.stationeryDao.insert(entity);
	}

	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	@MyAnnotation(methodNames = "redact")
	public int update(Stationery entity) {
		return this.stationeryDao.update(entity);
	}

	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param entity
	 */
	@MyAnnotation(methodNames = "redact")
	public int deleteById(Serializable id) {
		return this.stationeryDao.deleteById(id);
	}

	/**
	 * 批量删除；支持整数型和字符串类型ID
	 * @param entity
	 */
	@MyAnnotation(methodNames = "redact")
	public int delete(Serializable[] ids) {
		return this.stationeryDao.delete(ids);
	}

	/**
	 * 查询全部
	 * @param entity
	 */
	public List<Stationery> findAll() {
		List<Stationery> stationery = this.stationeryDao.findAll();
		if(stationery==null){
			stationery = new ArrayList<Stationery>();
		}
		return stationery;
	}

	/**
	 * 查询记录数
	 * @param entity
	 */
	public int findCount(PageBean<Stationery> pageBean) {
		return this.stationeryDao.findCount(pageBean);
	}
	public List<Stationery> findByTypeId(Serializable id) {
		List<Stationery> stationery = this.stationeryDao.findByTypeId(id);
		if(stationery==null){
			stationery = new ArrayList<Stationery>();
		}
		return stationery;
	}
}
