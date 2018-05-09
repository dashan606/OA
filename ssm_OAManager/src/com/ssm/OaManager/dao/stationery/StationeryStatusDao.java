package com.ssm.OaManager.dao.stationery;

import java.io.Serializable;
import java.util.List;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.stationery.StationeryStatus;

public interface StationeryStatusDao extends BaseDao<StationeryStatus>{
	
	/**
	 * 条件查询全部
	 */
	public List<StationeryStatus> findWhereAll(Serializable id);
	
	/**
	 * 根据办公用品查询
	 * @param id
	 * @return
	 */
	public List<StationeryStatus> findBystationeryId(Serializable id);
	
}
