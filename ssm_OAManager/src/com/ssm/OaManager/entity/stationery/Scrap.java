package com.ssm.OaManager.entity.stationery;

import com.ssm.OaManager.entity.User;

/**
 * 报废表
 * @author 梦想
 *
 */
public class Scrap {

	/*SCRAP_ID	Int	否		主键，自增	报废ID
	STATIONERY_ID	int	否		外键，引用办公用品ID	办公用品
	SCRAP_AMOUNT	int	否			数量
	User_id	int	否		外键，引用用户ID	登记人
	SCRAP_descripti	Varchar(50)	是			报废描述*/
	
	/**报废ID*/
	private Integer scrapId;

	/**引用办公用品ID*/
    private Stationery stationery;

    /**数量*/
    private Integer scrapAmount;

    /**引用用户ID*/
    private User user;

    /**报废描述*/
    private String scrapDescripti;

	public Integer getScrapId() {
		return scrapId;
	}

	public void setScrapId(Integer scrapId) {
		this.scrapId = scrapId;
	}

	public Stationery getStationery() {
		return stationery;
	}

	public void setStationery(Stationery stationery) {
		this.stationery = stationery;
	}

	public Integer getScrapAmount() {
		return scrapAmount;
	}

	public void setScrapAmount(Integer scrapAmount) {
		this.scrapAmount = scrapAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getScrapDescripti() {
		return scrapDescripti;
	}

	public void setScrapDescripti(String scrapDescripti) {
		this.scrapDescripti = scrapDescripti;
	}

   
}
