package com.ssm.OaManager.service.stationery.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.stationery.BorrowDao;
import com.ssm.OaManager.entity.stationery.Borrow;
import com.ssm.OaManager.service.stationery.BorrowService;
import com.ssm.OaManager.utils.PageBean;

@Service
public class BorrowServiceimpl implements BorrowService{

	@Resource
	private BorrowDao borrowDao;
	
	public void setBorrowDao(BorrowDao borrowDao) {
		this.borrowDao = borrowDao;
	}

	/**带条件分页查询，条件可以为null，既没有条件；返回list对象集合*/
	public List<Borrow> findByPage(PageBean<Borrow> pageBean) {
		return this.borrowDao.findByPage(pageBean);
	}

	/**只查询一个，常用于修改*/
	public Borrow findById(Serializable id) {
		return this.borrowDao.findById(id);
	}

	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(Borrow entity) {
		return this.borrowDao.insert(entity);
	}

	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int update(Borrow entity) {
		return this.borrowDao.update(entity);
	}

	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int deleteById(Serializable id) {
		return this.borrowDao.deleteById(id);
	}

	/**
	 * 批量删除；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int delete(Serializable[] ids) {
		return this.borrowDao.delete(ids);
	}

	/**
	 * 查询全部
	 * @param entity
	 */
	public List<Borrow> findAll() {
		return this.borrowDao.findAll();
	}

	/**
	 * 查询记录数
	 * @param entity
	 */
	public int findCount(PageBean<Borrow> pageBean) {
		return this.borrowDao.findCount(pageBean);
	}
	
}
