package com.ssm.OaManager.entity.workflow;

import java.util.List;

/**
 * 步骤容器类
 * @author Administrator
 *
 */
public class FlowLinkModel {

	private List<FlowLink> flowLinks;

	public FlowLinkModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlowLinkModel(List<FlowLink> flowLinks) {
		super();
		this.flowLinks = flowLinks;
	}

	public List<FlowLink> getFlowLinks() {
		return flowLinks;
	}

	public void setFlowLinks(List<FlowLink> flowLinks) {
		this.flowLinks = flowLinks;
	}

	
	
}
