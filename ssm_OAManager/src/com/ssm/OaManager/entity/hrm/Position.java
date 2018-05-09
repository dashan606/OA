package com.ssm.OaManager.entity.hrm;

/**
 * 岗位实体类
 * @author Administrator
 *
 */
public class Position {

	/*POS_ID	Int	否		主键, 自增	主键，无意义
	POS_Nmae	varchar(30)	否			职位名称
	POS_DESCRIPTI	varchar(50)	是			描述*/
	private Integer posId;
	private String posName;
	private String posDescriti;
	
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Position(Integer posId, String posName, String posDescriti) {
		super();
		this.posId = posId;
		this.posName = posName;
		this.posDescriti = posDescriti;
	}

	public Integer getPosId() {
		return posId;
	}

	public void setPosId(Integer posId) {
		this.posId = posId;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public String getPosDescriti() {
		return posDescriti;
	}

	public void setPosDescriti(String posDescriti) {
		this.posDescriti = posDescriti;
	}
	
	
}
