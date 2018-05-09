package com.ssm.OaManager.entity.stationery;

import java.util.Date;

/**
 * 办公用品库表
 * @author 梦想
 *
 */
public class Stationerylibrary {
	/*
	STATILIBRARY_ID	Int	否		主键，自增	库ID
	STATILIBRARY_NAME	Varchar(50)	否			库名称
	STATILIBRARY_DATE	date	否	当前时间		添加时间
	STATILIBRARY_descripti	Varchar(50)	是			库描述
	*/
	/**库ID*/
	private Integer statilibraryId;

	/**库名称*/
    private String statilibraryName;

    /**添加时间*/
    private Date statilibraryDate;

    /**库描述*/
    private String statilibraryDescripti;

    public Integer getStatilibraryId() {
        return statilibraryId;
    }

    public void setStatilibraryId(Integer statilibraryId) {
        this.statilibraryId = statilibraryId;
    }

    public String getStatilibraryName() {
        return statilibraryName;
    }

    public void setStatilibraryName(String statilibraryName) {
        this.statilibraryName = statilibraryName == null ? null : statilibraryName.trim();
    }

    public Date getStatilibraryDate() {
        return statilibraryDate;
    }

    public void setStatilibraryDate(Date statilibraryDate) {
        this.statilibraryDate = statilibraryDate;
    }

    public String getStatilibraryDescripti() {
        return statilibraryDescripti;
    }

    public void setStatilibraryDescripti(String statilibraryDescripti) {
        this.statilibraryDescripti = statilibraryDescripti == null ? null : statilibraryDescripti.trim();
    }
}
