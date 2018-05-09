package com.ssm.OaManager.entity.official;

import java.util.Date;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.accessory.Reimburse;
import com.ssm.OaManager.entity.workflow.FlowTemplate;

/**
 * 公文实体类
 * @author Administrator
 *
 */
public class Official {

	/*OFFI_ID	Int	否		主键, 自增	主键，无意义
	OFFI_NAME	varchar(30)	否			公文名称
	flow_id	int	否			流程编号
	OFFI_DATE	DATE	否	默认当前时间		公文创建时间
	USER_ID	int	否		引用用户ID	外键
	OFFI_STATE	int	否	默认0	0 新建，1审核中，2结束	公文状态
	报销ID
	ACCESSORY_NAME	Varchar(30)	是			附件名称
	
	OFFI_DESCRIPTI	varchar(50)	是			描述*/
	private Integer offiId;
	private String offiName;
	private FlowTemplate flow;
	private Date offiDate;
	private User user;
	private Integer offiState;
	private byte [] accessory;
	private String accessoryName;
	private String offiDescripti;
	
	public static Integer NEW = 0;
	public static Integer ING = 1;
	public static Integer END = 2;

	
	public Official() {
		super();
	}


	public Official(Integer offiId, String offiName, FlowTemplate flow,
			Date offiDate, User user, Integer offiState, byte[] accessory,
			String accessoryName, String offiDescripti) {
		super();
		this.offiId = offiId;
		this.offiName = offiName;
		this.flow = flow;
		this.offiDate = offiDate;
		this.user = user;
		this.offiState = offiState;
		this.accessory = accessory;
		this.accessoryName = accessoryName;
		this.offiDescripti = offiDescripti;
	}


	public Integer getOffiId() {
		return offiId;
	}


	public void setOffiId(Integer offiId) {
		this.offiId = offiId;
	}


	public String getOffiName() {
		return offiName;
	}


	public void setOffiName(String offiName) {
		this.offiName = offiName;
	}


	public FlowTemplate getFlow() {
		return flow;
	}


	public void setFlow(FlowTemplate flow) {
		this.flow = flow;
	}


	public Date getOffiDate() {
		return offiDate;
	}


	public void setOffiDate(Date offiDate) {
		this.offiDate = offiDate;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Integer getOffiState() {
		return offiState;
	}


	public void setOffiState(Integer offiState) {
		this.offiState = offiState;
	}


	public byte[] getAccessory() {
		return accessory;
	}


	public void setAccessory(byte[] accessory) {
		this.accessory = accessory;
	}


	public String getAccessoryName() {
		return accessoryName;
	}


	public void setAccessoryName(String accessoryName) {
		this.accessoryName = accessoryName;
	}


	public String getOffiDescripti() {
		return offiDescripti;
	}


	public void setOffiDescripti(String offiDescripti) {
		this.offiDescripti = offiDescripti;
	}

	
	
}
