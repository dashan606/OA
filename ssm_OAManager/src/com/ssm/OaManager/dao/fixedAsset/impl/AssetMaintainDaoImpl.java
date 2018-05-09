package com.ssm.OaManager.dao.fixedAsset.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.fixedAsset.AssetMaintainDao;
import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.entity.fixedAsset.AssetMaintain;

/**
 * 固定资产维护dao层实现类
 * @author Administrator
 *
 */
@Repository
public class AssetMaintainDaoImpl extends BaseDaoImpl<AssetMaintain> implements AssetMaintainDao{

		//利用默认构造方法初始化命名空间
		public AssetMaintainDaoImpl() {
			super.setNs(AssetMaintain.class.getName());
		}

		public List<AssetMaintain> findBymaintaintypeId(Serializable id) {
			List<AssetMaintain> oList = this.getSqlSession().selectList(AssetMaintain.class.getName()+ ".findBymaintaintypeId", id);
			return oList;
		}
}
