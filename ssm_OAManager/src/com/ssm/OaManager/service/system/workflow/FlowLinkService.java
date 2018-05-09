package com.ssm.OaManager.service.system.workflow;

import java.util.List;

import com.ssm.OaManager.entity.workflow.FlowLink;
import com.ssm.OaManager.entity.workflow.FlowTemplate;

public interface FlowLinkService {

	/**
	 * 批量插入流程步骤
	 * @param userList
	 * @return
	 */
	int insertBatch(List<FlowLink> flowLinkList);

	/**
	 * 根据流程获取流程链路
	 * @param flow
	 * @return
	 */
	List<FlowLink> findByFlow(FlowTemplate flow);

	Integer deleteByFlowTemplate(FlowTemplate flow);

	
}
