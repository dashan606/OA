package com.ssm.OaManager.dao.system.accessory;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.accessory.AskForLeave;

public interface AskForLeaveDao extends BaseDao<AskForLeave>{

	/**
	 * 插入并返回主键
	 * @param askLeave
	 */
	void insertAndGetId(AskForLeave askLeave);

	/**
	 * 根据对象查找
	 * @param askLeave
	 * @return
	 */
	AskForLeave findByAskForLeave(AskForLeave askLeave);

}
