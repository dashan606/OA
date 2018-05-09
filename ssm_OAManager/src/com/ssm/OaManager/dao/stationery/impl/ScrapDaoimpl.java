package com.ssm.OaManager.dao.stationery.impl;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.stationery.ScrapDao;
import com.ssm.OaManager.entity.stationery.Scrap;
@Repository
public class ScrapDaoimpl extends BaseDaoImpl<Scrap> implements ScrapDao{

	//利用默认构造方法初始化命名空间
		public  ScrapDaoimpl() {
			super.setNs( Scrap.class.getName());
		}
}
