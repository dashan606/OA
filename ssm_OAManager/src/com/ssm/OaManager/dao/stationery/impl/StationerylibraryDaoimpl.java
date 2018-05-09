package com.ssm.OaManager.dao.stationery.impl;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.stationery.StationerylibraryDao;
import com.ssm.OaManager.entity.stationery.Stationerylibrary;

@Repository
public class StationerylibraryDaoimpl extends BaseDaoImpl<Stationerylibrary> implements StationerylibraryDao{
	
	//利用默认构造方法初始化命名空间
		public  StationerylibraryDaoimpl() {
			super.setNs( Stationerylibrary.class.getName());
		}
}
