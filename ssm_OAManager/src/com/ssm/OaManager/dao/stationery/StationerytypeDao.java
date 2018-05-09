package com.ssm.OaManager.dao.stationery;

import java.io.Serializable;
import java.util.List;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.stationery.Stationerytype;


public interface StationerytypeDao extends BaseDao<Stationerytype>{
	
	
	/**
	 * 根据库编号查询
	 * @return
	 */
	public List<Stationerytype> findBylibraryId(Serializable statilibraryId);
	
}
