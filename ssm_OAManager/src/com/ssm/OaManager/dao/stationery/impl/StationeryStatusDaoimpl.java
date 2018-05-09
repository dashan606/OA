package com.ssm.OaManager.dao.stationery.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.stationery.StationeryStatusDao;
import com.ssm.OaManager.entity.stationery.StationeryStatus;

@Repository
public class StationeryStatusDaoimpl extends BaseDaoImpl<StationeryStatus> implements StationeryStatusDao{
	
//利用默认构造方法初始化命名空间
	public  StationeryStatusDaoimpl() {
		super.setNs( StationeryStatus.class.getName());
	}

	public List<StationeryStatus> findWhereAll(Serializable id) {
		List<StationeryStatus> oList = this.getSqlSession().selectList(StationeryStatus.class.getName() + ".findAllUserId", id);
		return oList;
	}

	public List<StationeryStatus> findBystationeryId(Serializable id) {
		List<StationeryStatus> oList = this.getSqlSession().selectList(StationeryStatus.class.getName() + ".findBystationeryId", id);
		return oList;
	}
}
