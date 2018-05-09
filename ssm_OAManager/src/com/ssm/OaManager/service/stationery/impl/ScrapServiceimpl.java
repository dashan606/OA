package com.ssm.OaManager.service.stationery.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.stationery.ScrapDao;
import com.ssm.OaManager.entity.stationery.Scrap;
import com.ssm.OaManager.service.stationery.ScrapService;
import com.ssm.OaManager.utils.PageBean;

@Service
public class ScrapServiceimpl implements ScrapService{

	@Resource
	public ScrapDao scrapDao;
	
	public void setScrapDao(ScrapDao scrapDao) {
		this.scrapDao = scrapDao;
	}

	/**带条件分页查询，条件可以为null，既没有条件；返回list对象集合*/
	public List<Scrap> findByPage(PageBean<Scrap> pageBean) {
		return this.scrapDao.findByPage(pageBean);
	}

	/**只查询一个，常用于修改*/
	public Scrap findById(Serializable id) {
		return this.scrapDao.findById(id);
	}

	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(Scrap entity) {
		return this.scrapDao.insert(entity);
	}

	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int update(Scrap entity) {
		return this.scrapDao.update(entity);
	}

	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int deleteById(Serializable id) {
		return this.scrapDao.deleteById(id);
	}

	/**
	 * 批量删除；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int delete(Serializable[] ids) {
		return this.scrapDao.delete(ids);
	}

	/**
	 * 查询全部
	 * @param entity
	 */
	public List<Scrap> findAll() {
		return this.scrapDao.findAll();
	}

	/**
	 * 查询记录数
	 * @param entity
	 */
	public int findCount(PageBean<Scrap> pageBean) {
		return this.scrapDao.findCount(pageBean);
	}
}
