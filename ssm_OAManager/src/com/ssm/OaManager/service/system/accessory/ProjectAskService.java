package com.ssm.OaManager.service.system.accessory;

import com.ssm.OaManager.entity.accessory.ProjectAsk;

public interface ProjectAskService {

	/**
	 * 插入并返回主键
	 * @param projectAsk
	 * @return 
	 */
	Integer insertAndGetId(ProjectAsk projectAsk);

	/**
	 * 根据对象查找
	 * @param projectAsk
	 * @return
	 */
	ProjectAsk findByProject(ProjectAsk projectAsk);

}
