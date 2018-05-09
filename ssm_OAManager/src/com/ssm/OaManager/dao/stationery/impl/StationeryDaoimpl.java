package com.ssm.OaManager.dao.stationery.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.stationery.StationeryDao;
import com.ssm.OaManager.entity.stationery.Stationery;

@Repository
public class StationeryDaoimpl extends BaseDaoImpl<Stationery> implements StationeryDao{
	
	//利用默认构造方法初始化命名空间
		public  StationeryDaoimpl() {
			super.setNs( Stationery.class.getName());
		}

		public List<Stationery> findByTypeId(Serializable id) {
			List<Stationery> oList = this.getSqlSession().selectList( Stationery.class.getName() + ".findByTypeId", id);
			return oList;
		}
}
