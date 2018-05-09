package com.ssm.OaManager.entity.accessory;

/**
 * 请假类型实体类
 * @author Administrator
 *
 */
public class AflType {

	/*aflType_ID	Int	否		主键, 自增	主键，无意义
	aflType_name	varchar(30)	否			类型名称
	aflType_descripti	Varchar(50)	是			类型描述*/
	private Integer aflTypeId;
	private String aflTypeName;
	private String aflTypeDescripti;
	
	public AflType() {
	}

	public AflType(Integer aflTypeId, String aflTypeName,
			String aflTypeDescripti) {
		super();
		this.aflTypeId = aflTypeId;
		this.aflTypeName = aflTypeName;
		this.aflTypeDescripti = aflTypeDescripti;
	}

	public Integer getaflTypeId() {
		return aflTypeId;
	}

	public void setaflTypeId(Integer aflTypeId) {
		this.aflTypeId = aflTypeId;
	}

	public String getaflTypeName() {
		return aflTypeName;
	}

	public void setaflTypeName(String aflTypeName) {
		this.aflTypeName = aflTypeName;
	}

	public String getaflTypeDescripti() {
		return aflTypeDescripti;
	}

	public void setaflTypeDescripti(String aflTypeDescripti) {
		this.aflTypeDescripti = aflTypeDescripti;
	}
	
	
}
