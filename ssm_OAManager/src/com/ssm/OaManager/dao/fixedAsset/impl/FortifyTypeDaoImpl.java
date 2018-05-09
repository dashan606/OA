package com.ssm.OaManager.dao.fixedAsset.impl;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.fixedAsset.FortifyTypeDao;
import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.entity.fixedAsset.FortifyType;

/**
 * 增加类别dao层实现类
 * @author Administrator
 *
 */
@Repository
public class FortifyTypeDaoImpl extends BaseDaoImpl<FortifyType> implements FortifyTypeDao{

		//利用默认构造方法初始化命名空间
		public FortifyTypeDaoImpl() {
			super.setNs(FortifyType.class.getName());
		}
}
