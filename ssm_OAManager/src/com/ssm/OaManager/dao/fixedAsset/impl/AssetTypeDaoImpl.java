package com.ssm.OaManager.dao.fixedAsset.impl;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.fixedAsset.AssetTypeDao;
import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.entity.fixedAsset.AssetType;

/**
 * 资产类别dao层实现类
 * @author Administrator
 *
 */
@Repository
public class AssetTypeDaoImpl extends BaseDaoImpl<AssetType> implements  AssetTypeDao{

		//利用默认构造方法初始化命名空间
		public AssetTypeDaoImpl() {
			super.setNs( AssetType.class.getName());
		}
}
