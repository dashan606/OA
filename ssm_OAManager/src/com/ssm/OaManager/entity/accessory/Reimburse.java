package com.ssm.OaManager.entity.accessory;

import java.util.Date;

import com.ssm.OaManager.entity.User;

/**
 * 报销实体类
 * @author Administrator
 *
 */
public class Reimburse {

	/*RE_ID	Int	否		主键,自增	主键，无意义
	User_id	Int	否		外键	用户ID
	RE_ApplicationDate	Datetime	否	NOW()		申请日期
	RE_Content	Nvarchar(MAX)	否			申请内容
	RE_Money	money	否			金额
	RE_TypeID	Int	否		外键	报销类型ID
	RE_ApproveStatus	Nvarchar(50)	否			报销状态*/
	private Integer reId;
	private User user;
	private Date reApplicateionDate;
	private String reContent;
	private Double reMoney;
	private ReimType reimType;
	private String reApproveStatus;
	
	public static final String WILL = "选择附件";
	
	public static final String ALREADY = "更换附件";
	
	public Reimburse() {
		super();
	}

	public Reimburse(Integer reId, User user, Date reApplicateionDate,
			String reContent, Double reMoney, ReimType reimType,
			String reApproveStatus) {
		super();
		this.reId = reId;
		this.user = user;
		this.reApplicateionDate = reApplicateionDate;
		this.reContent = reContent;
		this.reMoney = reMoney;
		this.reimType = reimType;
		this.reApproveStatus = reApproveStatus;
	}

	public Integer getReId() {
		return reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getReApplicateionDate() {
		return reApplicateionDate;
	}

	public void setReApplicateionDate(Date reApplicateionDate) {
		this.reApplicateionDate = reApplicateionDate;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public Double getReMoney() {
		return reMoney;
	}

	public void setReMoney(Double reMoney) {
		this.reMoney = reMoney;
	}

	public ReimType getReimType() {
		return reimType;
	}

	public void setReimType(ReimType reimType) {
		this.reimType = reimType;
	}

	public String getReApproveStatus() {
		return reApproveStatus;
	}

	public void setReApproveStatus(String reApproveStatus) {
		this.reApproveStatus = reApproveStatus;
	}
	
	
}
