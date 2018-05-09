package com.ssm.OaManager.entity.accessory;

/**
 * 报销类型实体类
 * @author Administrator
 *
 */
public class ReimType {

	/*reimType_ID	Int	否		主键, 自增
	reimType_name	varchar(30)	否		
	reimType_descripti	Varchar(50)	是		*/
	private Integer reimTypeId;
	private String reimTypeName;
	private String reimTypeDescripti;
	
	public ReimType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimType(Integer reimTypeId, String reimTypeName,
			String reimTypeDescripti) {
		super();
		this.reimTypeId = reimTypeId;
		this.reimTypeName = reimTypeName;
		this.reimTypeDescripti = reimTypeDescripti;
	}

	public Integer getReimTypeId() {
		return reimTypeId;
	}

	public void setReimTypeId(Integer reimTypeId) {
		this.reimTypeId = reimTypeId;
	}

	public String getReimTypeName() {
		return reimTypeName;
	}

	public void setReimTypeName(String reimTypeName) {
		this.reimTypeName = reimTypeName;
	}

	public String getReimTypeDescripti() {
		return reimTypeDescripti;
	}

	public void setReimTypeDescripti(String reimTypeDescripti) {
		this.reimTypeDescripti = reimTypeDescripti;
	}
	
	
}
