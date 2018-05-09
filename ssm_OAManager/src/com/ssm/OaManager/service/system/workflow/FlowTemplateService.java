package com.ssm.OaManager.service.system.workflow;

import java.util.List;

import com.ssm.OaManager.entity.workflow.FlowTemplate;

public interface FlowTemplateService {

	/**
	 * 添加
	 * @param flow
	 * @return
	 */
	int insert(FlowTemplate flow);

	/**
	 * 查询所有流程
	 * @return
	 */
	List<FlowTemplate> findAll();

	/**
	 * 删除
	 * @param flow
	 * @return
	 */
	Integer delete(FlowTemplate flow);

}
