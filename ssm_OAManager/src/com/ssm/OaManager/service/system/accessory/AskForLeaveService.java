package com.ssm.OaManager.service.system.accessory;

import com.ssm.OaManager.entity.accessory.AskForLeave;

public interface AskForLeaveService {

	/**
	 * 插入并返回主键
	 * @param askLeave
	 * @return 
	 */
	Integer insertAndGetId(AskForLeave askLeave);

	/**
	 * 通过对象进行查找
	 * @param askLeave
	 * @return
	 */
	AskForLeave findByAskForLeave(AskForLeave askLeave);

}
