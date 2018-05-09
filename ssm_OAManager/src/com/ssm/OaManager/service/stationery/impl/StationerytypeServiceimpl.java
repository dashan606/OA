package com.ssm.OaManager.service.stationery.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.stationery.StationerytypeDao;
import com.ssm.OaManager.entity.stationery.Stationerytype;
import com.ssm.OaManager.service.stationery.StationerytypeService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;

@Service
public class StationerytypeServiceimpl implements StationerytypeService{

	@Resource
	public StationerytypeDao stationerytypeDao;
	
	public void setStationerytypeDao(StationerytypeDao stationerytypeDao) {
		this.stationerytypeDao = stationerytypeDao;
	}

	/**带条件分页查询，条件可以为null，既没有条件；返回list对象集合*/
	public List<Stationerytype> findByPage(PageBean<Stationerytype> pageBean) {
		List<Stationerytype> stationerytype = this.stationerytypeDao.findByPage(pageBean);
		if(stationerytype==null){
			stationerytype = new ArrayList<Stationerytype>();
		}
		return stationerytype;
	}

	/**只查询一个，常用于修改*/
	public Stationerytype findById(Serializable id) {
		Stationerytype stationerytype = this.stationerytypeDao.findById(id);
		if(stationerytype==null){
			stationerytype = new Stationerytype();
		}
		return stationerytype;
	}

	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	@MyAnnotation(methodNames = "redact")
	public int insert(Stationerytype entity) {
		return this.stationerytypeDao.insert(entity);
	}

	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	@MyAnnotation(methodNames = "redact")
	public int update(Stationerytype entity) {
		return this.stationerytypeDao.update(entity);
	}

	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param entity
	 */
	@MyAnnotation(methodNames = "redact")
	public int deleteById(Serializable id) {
		return this.stationerytypeDao.deleteById(id);
	}

	/**
	 * 批量删除；支持整数型和字符串类型ID
	 * @param entity
	 */
	@MyAnnotation(methodNames = "redact")
	public int delete(Serializable[] ids) {
		return this.stationerytypeDao.delete(ids);
	}

	/**
	 * 查询全部
	 * @param entity
	 */
	public List<Stationerytype> findAll() {
		List<Stationerytype> stationerytype =this.stationerytypeDao.findAll();
		if(stationerytype==null){
			stationerytype = new ArrayList<Stationerytype>();
		}
		return stationerytype;
	}

	/**
	 * 查询记录数
	 * @param entity
	 */
	public int findCount(PageBean<Stationerytype> pageBean) {
		return this.stationerytypeDao.findCount(pageBean);
	}
	public List<Stationerytype> findBylibraryId(Serializable statilibraryId) {
		List<Stationerytype> stationerytype =this.stationerytypeDao.findBylibraryId(statilibraryId);
		if(stationerytype==null){
			stationerytype = new ArrayList<Stationerytype>();
		}
		return stationerytype;
	}
}
