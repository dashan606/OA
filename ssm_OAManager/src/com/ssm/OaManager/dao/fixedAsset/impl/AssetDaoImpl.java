package com.ssm.OaManager.dao.fixedAsset.impl;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.fixedAsset.AssetDao;
import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.entity.fixedAsset.Asset;

/**
 * 固定资产dao层实现类
 * @author Administrator
 *
 */
@Repository
public class AssetDaoImpl extends BaseDaoImpl<Asset> implements AssetDao{

		//利用默认构造方法初始化命名空间
		public AssetDaoImpl() {
			super.setNs(Asset.class.getName());
		}
}
