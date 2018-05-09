package com.ssm.OaManager.entity.workflow;

/**
 * 流程链路实体类
 * @author Administrator
 *
 */
public class FlowLink {

	 /*flow_link_id         int not null,
	   from_step            int,
	   to_step1             int,
	   to_step2             int,
	   to_step3             int,
	   to_step4             int,*/
	private Integer flowLinkId;
	/*private Integer fromStep;
	private Integer toStep1;
	private Integer toStep2;
	private Integer toStep3;
	private Integer toStep4;*/
	private FlowTemplate flow;
	private StepTemplate fromStep;
	private StepTemplate toStep1;
	private StepTemplate toStep2;
	private StepTemplate toStep3;
	private StepTemplate toStep4;
	
	
	public static final Integer STARTSTEP = 1;
	public static final Integer ENDSTEP = 7;
	
	public FlowLink() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlowLink(Integer flowLinkId, StepTemplate fromStep,
			StepTemplate toStep1, StepTemplate toStep2, StepTemplate toStep3,
			StepTemplate toStep4) {
		super();
		this.flowLinkId = flowLinkId;
		this.fromStep = fromStep;
		this.toStep1 = toStep1;
		this.toStep2 = toStep2;
		this.toStep3 = toStep3;
		this.toStep4 = toStep4;
	}

	public Integer getFlowLinkId() {
		return flowLinkId;
	}

	public void setFlowLinkId(Integer flowLinkId) {
		this.flowLinkId = flowLinkId;
	}

	public StepTemplate getFromStep() {
		return fromStep;
	}

	public void setFromStep(StepTemplate fromStep) {
		this.fromStep = fromStep;
	}

	public StepTemplate getToStep1() {
		return toStep1;
	}

	public void setToStep1(StepTemplate toStep1) {
		this.toStep1 = toStep1;
	}

	public StepTemplate getToStep2() {
		return toStep2;
	}

	public void setToStep2(StepTemplate toStep2) {
		this.toStep2 = toStep2;
	}

	public StepTemplate getToStep3() {
		return toStep3;
	}

	public void setToStep3(StepTemplate toStep3) {
		this.toStep3 = toStep3;
	}

	public StepTemplate getToStep4() {
		return toStep4;
	}

	public void setToStep4(StepTemplate toStep4) {
		this.toStep4 = toStep4;
	}

	public FlowTemplate getFlow() {
		return flow;
	}

	public void setFlow(FlowTemplate flow) {
		this.flow = flow;
	}
	
	
	
}
