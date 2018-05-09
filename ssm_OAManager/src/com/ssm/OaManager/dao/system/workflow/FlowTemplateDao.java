package com.ssm.OaManager.dao.system.workflow;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.workflow.FlowTemplate;

public interface FlowTemplateDao extends BaseDao<FlowTemplate>{

	/**
	 * 插入数据并返回主键
	 * @param flow
	 * @return
	 */
	void insertAndGetId(FlowTemplate flow);

}
