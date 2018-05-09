package com.ssm.OaManager.entity.accessory;

import java.util.Date;

import com.ssm.OaManager.entity.User;

/**
 * 请假实体类
 * @author Administrator
 *
 */
public class AskForLeave {

	/*AFL_ID	Int	否	自增	主键	主键，无意义
	USER_ID	Int	否		外键	用户ID
	AFL _ApplicationDate	Datetime	否	NOW()		申请日期
	AFL _StartDate	Datetime	否			开始日期
	AFL _EndDate	Datetime	否			结束日期
	AFL _Content	Nvarchar(Max)	否			请假事由
	AFL _TypeID	Int	否		外键	类型编号
	AFL _ApproveStatus	Nvarchar(50)	否	“批准”或
	“等待审核”
	或“不批准”		审核状态
	AFL _ ApproveContent	Nvarchar(Max)	否			审核回复
	AFL _ ApproveDate	Datetime	否			审核时间*/
	private Integer aflId;
	private User user;
	private Date aflApplicationDate;
	private Date aflStartDate;
	private Date aflEndDate;
	private String aflContent;
	private AflType aflType;
	private String aflApproveStatus;
	private String aflApproveContent;
	private Date aflApproveDate;
	
	public AskForLeave() {
	}

	public AskForLeave(Integer aflId, User user, Date aflApplicationDate,
			Date aflStartDate, Date aflEndDate, String aflContent,
			AflType aflType, String aflApproveStatus, String aflApproveContent,
			Date aflApproveDate) {
		super();
		this.aflId = aflId;
		this.user = user;
		this.aflApplicationDate = aflApplicationDate;
		this.aflStartDate = aflStartDate;
		this.aflEndDate = aflEndDate;
		this.aflContent = aflContent;
		this.aflType = aflType;
		this.aflApproveStatus = aflApproveStatus;
		this.aflApproveContent = aflApproveContent;
		this.aflApproveDate = aflApproveDate;
	}

	public Integer getAflId() {
		return aflId;
	}

	public void setAflId(Integer aflId) {
		this.aflId = aflId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getAflApplicationDate() {
		return aflApplicationDate;
	}

	public void setAflApplicationDate(Date aflApplicationDate) {
		this.aflApplicationDate = aflApplicationDate;
	}

	public Date getAflStartDate() {
		return aflStartDate;
	}

	public void setAflStartDate(Date aflStartDate) {
		this.aflStartDate = aflStartDate;
	}

	public Date getAflEndDate() {
		return aflEndDate;
	}

	public void setAflEndDate(Date aflEndDate) {
		this.aflEndDate = aflEndDate;
	}

	public String getAflContent() {
		return aflContent;
	}

	public void setAflContent(String aflContent) {
		this.aflContent = aflContent;
	}

	public AflType getAflType() {
		return aflType;
	}

	public void setAflType(AflType aflType) {
		this.aflType = aflType;
	}

	public String getAflApproveStatus() {
		return aflApproveStatus;
	}

	public void setAflApproveStatus(String aflApproveStatus) {
		this.aflApproveStatus = aflApproveStatus;
	}

	public String getAflApproveContent() {
		return aflApproveContent;
	}

	public void setAflApproveContent(String aflApproveContent) {
		this.aflApproveContent = aflApproveContent;
	}

	public Date getAflApproveDate() {
		return aflApproveDate;
	}

	public void setAflApproveDate(Date aflApproveDate) {
		this.aflApproveDate = aflApproveDate;
	}
	
	
}
