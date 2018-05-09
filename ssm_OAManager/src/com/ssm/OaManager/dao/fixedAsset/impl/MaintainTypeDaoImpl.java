package com.ssm.OaManager.dao.fixedAsset.impl;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.fixedAsset.MaintainTypeDao;
import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.entity.fixedAsset.MaintainType;

/**
 * 维护类型dao层实现类
 * @author Administrator
 *
 */
@Repository
public class MaintainTypeDaoImpl extends BaseDaoImpl<MaintainType> implements MaintainTypeDao{

		//利用默认构造方法初始化命名空间
		public MaintainTypeDaoImpl() {
			super.setNs(MaintainType.class.getName());
		}
}
