package com.ssm.OaManager.dao.system.official;

import java.util.List;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.official.Approve;
import com.ssm.OaManager.entity.official.Official;

public interface ApproveDao extends BaseDao<Approve>{

	/**
	 * 根据公文查找审批历史
	 * @param official
	 * @return
	 */
	List<Approve> findByOffical(Official official);

	/**
	 * 批量删除
	 * @param approves
	 */
	void deleteBatch(List<Approve> approves);

}
