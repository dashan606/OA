package com.ssm.OaManager.dao.stationery.impl;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.stationery.BorrowDao;
import com.ssm.OaManager.entity.stationery.Borrow;

@Repository
public class BorrowDaoimpl extends BaseDaoImpl<Borrow> implements BorrowDao{
	
//利用默认构造方法初始化命名空间
	public  BorrowDaoimpl() {
		super.setNs( Borrow.class.getName());
	}
}
