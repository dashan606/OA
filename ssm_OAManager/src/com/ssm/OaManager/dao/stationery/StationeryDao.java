package com.ssm.OaManager.dao.stationery;

import java.io.Serializable;
import java.util.List;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.stationery.Stationery;


public interface StationeryDao extends BaseDao<Stationery>{
	
	/**
	 * 根据类型编号查询
	 * @param id
	 * @return
	 */
	public List<Stationery> findByTypeId(Serializable id);
}
