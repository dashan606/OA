package com.ssm.OaManager.service.system.workflow;

import java.util.List;

import com.ssm.OaManager.entity.workflow.FlowType;

public interface FlowTypeService {

	/**
	 * 获取所有流程类型
	 * @return
	 */
	List<FlowType> findAll();

}
