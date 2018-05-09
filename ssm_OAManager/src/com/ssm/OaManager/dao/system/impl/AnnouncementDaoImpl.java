package com.ssm.OaManager.dao.system.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.AnnouncementDao;
import com.ssm.OaManager.entity.Announcement;
import com.ssm.OaManager.entity.User;

@Repository
public class AnnouncementDaoImpl extends BaseDaoImpl<Announcement> implements
		AnnouncementDao {
	public AnnouncementDaoImpl() {
		super.setNs(Announcement.class.getName());
	}

	public List<Announcement> findByStateAnnouncement() {
		return this.getSqlSession().selectList(Announcement.class.getName()+".findByState");
	}

	public List<Announcement> findByNewnotice() {
		return this.getSqlSession().selectList(Announcement.class.getName()+".findByNewnotice" );
	}
}
