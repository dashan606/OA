package com.ssm.OaManager.dao.system.workflow;

import java.util.List;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.workflow.FlowLink;
import com.ssm.OaManager.entity.workflow.FlowTemplate;
import com.ssm.OaManager.entity.workflow.StepTemplate;

public interface FlowLinkDao extends BaseDao<FlowLink>{

	/**
	 * 批量插入流程步骤
	 * @param stepList
	 * @return
	 */
	void insertBatch(List<FlowLink> flowLinkList);

	/**
	 * 通过ID查询所有
	 * @param flowId
	 * @return
	 */
	List<FlowLink> findAllByFlow(FlowTemplate flow);

	
	Integer deleteByFlowTemplate(FlowTemplate flow);

}
