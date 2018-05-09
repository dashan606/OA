package com.ssm.OaManager.service.system.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.AnnouncementDao;
import com.ssm.OaManager.entity.Announcement;
import com.ssm.OaManager.service.system.AnnouncementService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
	@Resource
	private AnnouncementDao announcementDao;
	
	public Announcement findById(Serializable id) {
		Announcement announcement = this.announcementDao.findById(id);
		if(announcement==null){
			announcement = new Announcement();
		}
		return announcement;
	}
	@MyAnnotation(methodNames = "redact")
	public int insert(Announcement entity) {
		return this.announcementDao.insert(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int update(Announcement entity) {
		return this.announcementDao.update(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int deleteById(Serializable id) {
		return this.announcementDao.deleteById(id);
	}
	@MyAnnotation(methodNames = "redact")
	public int delete(Serializable[] ids) {
		return this.announcementDao.delete(ids);
	}

	public List<Announcement> findAll() {
		List<Announcement> announcement =  this.announcementDao.findAll();
		if(announcement==null){
			announcement = new ArrayList<Announcement>();
		}
		return announcement;
	}

	public List<Announcement> findByStateAnnouncement() {
		List<Announcement> announcement = this.announcementDao.findByStateAnnouncement();
		if(announcement==null){
			announcement = new ArrayList<Announcement>();
		}
		return announcement;
	}

	public List<Announcement> findByNewnotice() {
		List<Announcement> announcement = this.announcementDao.findByNewnotice();
		if(announcement==null){
			announcement = new ArrayList<Announcement>();
		}
		return announcement;
	}

	public void findPageBean(PageBean<Announcement> pageBean) {
		// 获得总记录数
		Integer totalCount = this.announcementDao.findCount(pageBean);
		// 设置入分页对象
		if (totalCount != null) {
			pageBean.setTotalCount(totalCount);
		}
		if (pageBean.getCurrentPage() < 1) {
			pageBean.setCurrentPage(1);
		}

		if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
			pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		pageBean.getParaMap().put("firstPage",
				(pageBean.getCurrentPage() - 1) * pageBean.getPageSize());
		pageBean.getParaMap().put("lastPage",
				pageBean.getCurrentPage() * pageBean.getPageSize());

		// 获得分页数据
		List<Announcement> datas = this.announcementDao.findByPage(pageBean);

		pageBean.setDatas(datas);
	}

	

}
