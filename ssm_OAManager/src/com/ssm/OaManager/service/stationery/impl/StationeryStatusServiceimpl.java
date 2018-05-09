package com.ssm.OaManager.service.stationery.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.stationery.StationeryStatusDao;
import com.ssm.OaManager.entity.stationery.StationeryStatus;
import com.ssm.OaManager.service.stationery.StationeryStatusService;
import com.ssm.OaManager.utils.MyAnnotation;


@Service
public class StationeryStatusServiceimpl implements StationeryStatusService{
	
	@Resource
	public StationeryStatusDao stationeryStatusDao;

	public void setStationeryStatusDao(StationeryStatusDao stationeryStatusDao) {
		this.stationeryStatusDao = stationeryStatusDao;
	}
	@MyAnnotation(methodNames = "redact")
	public int insert(StationeryStatus entity) {
		return this.stationeryStatusDao.insert(entity);
	}
	public List<StationeryStatus> findAll() {
		List<StationeryStatus>  stationeryStatus = this.stationeryStatusDao.findAll();
		if(stationeryStatus==null){
			stationeryStatus = new ArrayList<StationeryStatus>();
		}
		return stationeryStatus;
	}
	@MyAnnotation(methodNames = "redact")
	public int update(StationeryStatus entity) {
		return this.stationeryStatusDao.update(entity);
	}
	public List<StationeryStatus> findWhereAll(Serializable id) {
		List<StationeryStatus>  stationeryStatus = this.stationeryStatusDao.findWhereAll(id);
		if(stationeryStatus==null){
			stationeryStatus = new ArrayList<StationeryStatus>();
		}
		return stationeryStatus;
	}
	public List<StationeryStatus> findBystationeryId(Serializable id) {
		List<StationeryStatus>  stationeryStatus = this.stationeryStatusDao.findBystationeryId(id);
		if(stationeryStatus==null){
			stationeryStatus = new ArrayList<StationeryStatus>();
		}
		return stationeryStatus;
	}
	

}
