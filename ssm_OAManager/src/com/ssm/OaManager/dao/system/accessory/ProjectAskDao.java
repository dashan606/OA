package com.ssm.OaManager.dao.system.accessory;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.accessory.ProjectAsk;

public interface ProjectAskDao extends BaseDao<ProjectAsk>{

	/**
	 * 插入并返回主键
	 * @param projectAsk
	 */
	void insertAndGetId(ProjectAsk projectAsk);

	/**
	 * 根据对象查找
	 * @param projectAsk
	 * @return
	 */
	ProjectAsk findByProject(ProjectAsk projectAsk);

}
