package com.ssm.OaManager.dao.stationery.impl;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.stationery.PurchaseDao;
import com.ssm.OaManager.entity.stationery.Purchase;
@Repository
public class PurchaseDaoimpl extends BaseDaoImpl<Purchase> implements PurchaseDao{
	//利用默认构造方法初始化命名空间
		public  PurchaseDaoimpl() {
			super.setNs( Purchase.class.getName());
		}
}
