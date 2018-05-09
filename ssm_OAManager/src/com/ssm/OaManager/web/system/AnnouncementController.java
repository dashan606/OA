package com.ssm.OaManager.web.system;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.ssm.OaManager.entity.Announcement;
import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.service.system.AnnouncementService;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.web.BaseController;

@Controller
public class AnnouncementController extends BaseController {

	@Resource
	private AnnouncementService announcementService;

	@Resource
	private PrivilegeFilter privilegeFilter;

	public void setPrivilegeFilterUser(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}

	// 查询所有公告
	@RequestMapping("/view/announcement/findAllAnnouncement.action")
	public String findAllAnnouncement(HttpServletRequest request) {
		List<Announcement> announcements = this.announcementService.findAll();

		// 绑定到作用域
		request.setAttribute("datas", announcements);
		return "/pages_public/public_notice.jsp";
	}

	@RequestMapping("/view/announcement/findAll.action")
	public String findAll(HttpServletRequest request) {
		// 查询数据(审核的公告)
		List<Announcement> announcements = this.announcementService
				.findByStateAnnouncement();
		// 绑定到作用域
		request.setAttribute("data", announcements);

		return "/pages_public/public_notice_list.jsp";
	}

	// 添加公告
	@RequestMapping("/view/announcement/insertAnnouncement.action")
	public String insertAnnouncement(Announcement announcement,
			HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		// 通过session 获得用户的id
		User user = (User) request.getSession().getAttribute("user");
		announcement.setUser(user);
		// 添加公告到数据库
		int num = this.announcementService.insert(announcement);
		if (num == -1) {
			request.setAttribute("result", "权限不足！");
		}
		return "/view/announcement/findAllAnnouncement.action";
	}

	// 修改公告
	@RequestMapping("/view/announcement/updateAnnouncement.action")
	public String updateAnnouncement(Announcement announcement,
			HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		// 通过session 获得用户的id
		User user = (User) request.getSession().getAttribute("user");
		announcement.setUser(user);
		// 修改公告到数据库
		int num = this.announcementService.update(announcement);
		if (num == -1) {
			request.setAttribute("result", "权限不足！");
		}
		return "/view/announcement/findAllAnnouncement.action";
	}

	// 查询一条公告
	// 用于修改
	@RequestMapping("/view/announcement/findByIdAnnouncement.action")
	public String findByIdAnnouncement(int amId, HttpServletRequest request) {

		Announcement announcement = this.announcementService.findById(amId);
		// 将数据绑定到作用域
		request.setAttribute("data", announcement);
		return "/pages_public/public_notice_edit.jsp";
	}

	// 删除公告
	@RequestMapping("/view/announcement/deleteByIdAnnouncement.action")
	public String deleteByIdAnnouncement(int amId, HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		int num = this.announcementService.deleteById(amId);
		if (num == -1) {
			request.setAttribute("result", "权限不足！");
		}
		// 将数据绑定到作用域
		return "/view/announcement/findAllAnnouncement.action";
	}

	// 审核公告
	@RequestMapping("/view/announcement/updateByAnnouncement.action")
	public String updateByAnnouncement(Announcement announcement,
			HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		// 通过session 获得用户的id
		User user = (User) request.getSession().getAttribute("user");
		announcement.setUser(user);
		// 审核(修改状态)
		announcement.setAmState(1);
		int num = this.announcementService.update(announcement);
		if (num == -1) {
			request.setAttribute("result", "权限不足！");
		}
		// 将数据绑定到作用域
		return "/view/announcement/findAllAnnouncement.action";
	}

	// 最新公告
	@RequestMapping("/view/announcement/findByNewnotice.action")
	public void findByNewnotice(HttpServletRequest request,
			HttpServletResponse response) {
		setPrivilegeFilterUser(request);

		try {
			// 查询最新公告
			List<Announcement> announcements = this.announcementService
					.findByNewnotice();

			String result = JSON.toJSONString(announcements);
			// 发送给客户端
			response.getWriter().write(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
