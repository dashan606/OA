package com.ssm.OaManager.service.stationery;

import java.io.Serializable;
import java.util.List;

import com.ssm.OaManager.entity.stationery.StationeryStatus;



public interface StationeryStatusService{

	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(StationeryStatus entity);
	
	
	/**
	 * 查询全部
	 * @param entity
	 */
	public List<StationeryStatus> findAll();
	
	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int update(StationeryStatus entity);	
	
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
