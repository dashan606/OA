package com.ssm.OaManager.dao.stationery.impl;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.stationery.MaintainDao;
import com.ssm.OaManager.entity.stationery.Maintain;

@Repository
public class MaintainDaoimpl extends BaseDaoImpl<Maintain> implements MaintainDao{
	
	//利用默认构造方法初始化命名空间
		public  MaintainDaoimpl() {
			super.setNs( Maintain.class.getName());
		}
}
