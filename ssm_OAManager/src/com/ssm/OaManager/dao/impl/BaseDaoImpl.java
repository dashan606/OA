package com.ssm.OaManager.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.utils.PageBean;
/**
 * @Description: 泛型类，基础的DAO实现类
 * 
 */
public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements
		BaseDao<T> {
	@Autowired
	// mybatis-spring 1.0无需此方法；mybatis-spring1.2必须注入。
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	private String ns; // 命名空间

	public String getNs() {
		return ns;
	}

	public void setNs(String ns) {
		this.ns = ns;
	}
	/**带条件分页查询，条件可以为null，既没有条件；返回list对象集合*/
	public List<T> findByPage(PageBean<T> pageBean) {
		List<T> oList = this.getSqlSession().selectList(ns + ".findByPage", pageBean);
		return oList;
	}
	/**只查询一个，常用于修改*/
	public T findById(Serializable id) {
		return this.getSqlSession().selectOne(ns + ".findById", id);
	}
	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(T entity) {
		return this.getSqlSession().insert(ns + ".insert", entity);
	}
	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int update(T entity) {
		return this.getSqlSession().update(ns + ".update", entity);
	}
	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int deleteById(Serializable id) {
		return this.getSqlSession().delete(ns + ".deleteById", id);
	}
	/**
	 * 批量删除；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int delete(Serializable[] ids) {
		Map<String, Serializable> map = new  HashMap<String, Serializable>();
		map.put("ids", ids);
		return this.getSqlSession().delete(ns + ".delete", map);
	}
	/**
	 * 查询全部
	 * @param entity
	 */
	public List<T> findAll() {
		List<T> oList = this.getSqlSession().selectList(ns + ".findAll");
		return oList;
	}
	/**
	 * 查询记录数
	 * @param entity
	 */
	public int findCount(PageBean<T> pageBean) {
		int num = this.getSqlSession().selectOne(ns + ".findCount", pageBean);
		return num;
	}
}
