package com.ssm.OaManager.dao.stationery.impl;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.stationery.GivebackDao;
import com.ssm.OaManager.entity.stationery.Giveback;
@Repository
public class GivebackDaoimpl extends BaseDaoImpl<Giveback> implements GivebackDao{

	//利用默认构造方法初始化命名空间
		public  GivebackDaoimpl() {
			super.setNs( Giveback.class.getName());
		}
}
