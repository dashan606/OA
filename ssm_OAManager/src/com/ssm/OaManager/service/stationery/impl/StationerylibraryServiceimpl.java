package com.ssm.OaManager.service.stationery.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.stationery.StationerylibraryDao;
import com.ssm.OaManager.entity.stationery.Stationerylibrary;
import com.ssm.OaManager.service.stationery.StationerylibraryService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;


@Service
public class StationerylibraryServiceimpl implements StationerylibraryService{
	
	@Resource
	public StationerylibraryDao stationerylibraryDao;
	
	public void setStationerylibraryDao(StationerylibraryDao stationerylibraryDao) {
		this.stationerylibraryDao = stationerylibraryDao;
	}

	/**只查询一个，常用于修改*/
	public Stationerylibrary findById(Serializable id) {
		Stationerylibrary stationerylibrary = this.stationerylibraryDao.findById(id);
		if(stationerylibrary==null){
			stationerylibrary = new Stationerylibrary();
		}
		return stationerylibrary;
	}

	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	@MyAnnotation(methodNames = "redact")
	public int insert(Stationerylibrary entity) {
		return this.stationerylibraryDao.insert(entity);
	}

	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	@MyAnnotation(methodNames = "redact")
	public int update(Stationerylibrary entity) {
		return this.stationerylibraryDao.update(entity);
	}

	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param entity
	 */
	@MyAnnotation(methodNames = "redact")
	public int deleteById(Serializable id) {
		return this.stationerylibraryDao.deleteById(id);
	}

	/**
	 * 批量删除；支持整数型和字符串类型ID
	 * @param entity
	 */
	@MyAnnotation(methodNames = "redact")
	public int delete(Serializable[] ids) {
		return this.stationerylibraryDao.delete(ids);
	}

	/**
	 * 查询全部
	 * @param entity
	 */
	public List<Stationerylibrary> findAll() {
		List<Stationerylibrary> stationerylibrary =this.stationerylibraryDao.findAll();
		if(stationerylibrary==null){
			stationerylibrary = new ArrayList<Stationerylibrary>();
		}
		return stationerylibrary;
	}
	public void findPageBean(PageBean<Stationerylibrary> pageBean) {
		// TODO Auto-generated method stub
		//获得记录数
		Integer totalCount = this.stationerylibraryDao.findCount(pageBean);
		//设置入分页对象
		if(totalCount != null){
			pageBean.setTotalCount(totalCount);
		}
		//设置当前页
		if(pageBean.getCurrentPage() < 1){
			pageBean.setCurrentPage(1);
		}
		//判断当前页
		if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
			pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		
		pageBean.setFirstPage((pageBean.getCurrentPage()-1)*pageBean.getPageSize());
		// 获得分页数据
		List<Stationerylibrary> datas = this.stationerylibraryDao.findByPage(pageBean);

		pageBean.setDatas(datas);

	}
}
