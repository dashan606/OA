package com.ssm.OaManager.dao.stationery.impl;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.stationery.ReceiveDao;
import com.ssm.OaManager.entity.stationery.Receive;
@Repository
public class ReceiveDaoimpl extends BaseDaoImpl<Receive> implements ReceiveDao{
	//利用默认构造方法初始化命名空间
		public  ReceiveDaoimpl() {
			super.setNs( Receive.class.getName());
		}
}
