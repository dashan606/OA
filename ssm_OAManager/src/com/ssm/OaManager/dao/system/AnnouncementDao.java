package com.ssm.OaManager.dao.system;

import java.util.List;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.Announcement;

public interface AnnouncementDao extends BaseDao<Announcement> {
	/**
	 * 根据审核状态查询公告信息
	 * @return
	 */
	public List<Announcement> findByStateAnnouncement();
	
	/**
	 * 查询最新公告
	 * @return
	 */
	public  List<Announcement> findByNewnotice();
	
}
