package com.ssm.OaManager.entity.official;

import java.util.Date;

import com.ssm.OaManager.entity.User;

/**
 * 审批实体类
 * @author Administrator
 *
 */
public class Approve {

	/*Approve_ID	Int	否		主键, 自增	主键，无意义
	Approve_IDEA	varchar(30)	否			审批意见
	Approve_DATE	DATE	否	默认当前时间		审批时间
	USER_ID	int	否		引用用户ID	外键
	OFFI_ID	int	否		引用公文ID	外键
	AgreeOrNot	int	否	默认0	0是 1 否	是否同意*/
	
	//字段
	private Integer approveId;
	private String approveIdea;
	private Date approveDate;
	private User user;
	private Official official;
	private Integer agreeOrNot;
	
	
	public static final Integer YES = 0;
	public static final Integer NO = 1;
	//构造
	public Approve() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Approve(Integer approveId, String approveIdea, Date approveDate,
			User user, Official official, Integer agreeOrNot) {
		super();
		this.approveId = approveId;
		this.approveIdea = approveIdea;
		this.approveDate = approveDate;
		this.user = user;
		this.official = official;
		this.agreeOrNot = agreeOrNot;
	}
	
	//get set 方法
	public Integer getApproveId() {
		return approveId;
	}
	public void setApproveId(Integer approveId) {
		this.approveId = approveId;
	}
	public String getApproveIdea() {
		return approveIdea;
	}
	public void setApproveIdea(String approveIdea) {
		this.approveIdea = approveIdea;
	}
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Official getOfficial() {
		return official;
	}
	public void setOfficial(Official official) {
		this.official = official;
	}
	public Integer getAgreeOrNot() {
		return agreeOrNot;
	}
	public void setAgreeOrNot(Integer agreeOrNot) {
		this.agreeOrNot = agreeOrNot;
	}
	
	
	
}
