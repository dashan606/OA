package com.ssm.OaManager.dao.system.accessory;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.accessory.Reimburse;

public interface ReimburseDao extends BaseDao<Reimburse>{

	/**
	 * 添加并返回主键
	 * @param reimburse
	 */
	void insertAndGetId(Reimburse reimburse);

	/**
	 * 查找
	 * @param reimburse
	 * @return
	 */
	Reimburse findByReimburse(Reimburse reimburse);

}
