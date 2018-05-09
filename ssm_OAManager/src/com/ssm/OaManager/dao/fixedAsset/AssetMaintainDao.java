package com.ssm.OaManager.dao.fixedAsset;

import java.io.Serializable;
import java.util.List;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.fixedAsset.AssetMaintain;
/**
 * 固定资产维护dao层接口
 * @author Administrator
 *
 */
public interface AssetMaintainDao extends BaseDao<AssetMaintain> {

	public List<AssetMaintain> findBymaintaintypeId(Serializable id);
}
