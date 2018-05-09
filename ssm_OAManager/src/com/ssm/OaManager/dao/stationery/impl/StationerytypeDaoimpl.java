package com.ssm.OaManager.dao.stationery.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.stationery.StationerytypeDao;
import com.ssm.OaManager.entity.stationery.Stationerytype;

@Repository
public class StationerytypeDaoimpl extends BaseDaoImpl<Stationerytype> implements StationerytypeDao{

	//利用默认构造方法初始化命名空间
		public  StationerytypeDaoimpl() {
			super.setNs( Stationerytype.class.getName());
		}

		public List<Stationerytype> findBylibraryId(Serializable statilibraryId) {
			List<Stationerytype> oList = this.getSqlSession().selectList(Stationerytype.class.getName()+ ".findBylibraryId", statilibraryId);
			return oList;
		}
	
}
