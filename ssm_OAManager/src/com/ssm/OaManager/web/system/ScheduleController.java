package com.ssm.OaManager.web.system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.OaManager.entity.Schedule;
import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.service.system.ScheduleService;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.web.BaseController;

@Controller
public class ScheduleController extends BaseController {
	@Resource
	private ScheduleService scheduleService;

	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	@Resource
	private PrivilegeFilter privilegeFilter;

	public void setPrivilegeFilterUser(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}

	/**
	 * 分页查询全部
	 * 
	 * @param currentPage
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/sys_schedule/findBySchedulePage.action")
	public String findByPage(String scheduleDate, Model model,
			HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = null;
		if (scheduleDate != null && !"".equals(scheduleDate)) {
			map.put("scheduleDate", scheduleDate);

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = (Date) format.parse(scheduleDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		User user = (User) request.getSession().getAttribute("user");
		map.put("userId", user.getUserId());
		List<Schedule> schedule = this.scheduleService.findByUserAll(map);

		model.addAttribute("scheduleDate", date);
		model.addAttribute("pageBean", schedule);
		return "/pages_personal/personal_calendars.jsp";

	}

	/**
	 * 查询全部
	 * 
	 * @param currentPage
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/sys_schedule/findByScheduleAll.action")
	public String findAll(String scheduleDate, Model model,
			HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User) request.getSession().getAttribute("user");
		map.put("userId", user.getUserId());
		List<Schedule> schedule = this.scheduleService.findByUserAll(map);
		model.addAttribute("pageBean", schedule);
		return "/pages_personal/public_schedule.jsp";

	}

	/**
	 * 添加
	 * 
	 * @param Schedule
	 * @param request
	 * @return
	 */
	@RequestMapping("/sys_schedule/saveSchedule.action")
	public String insert(Schedule schedule, HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		User user = (User) request.getSession().getAttribute("user");
		schedule.setUser(user);
		int num = this.scheduleService.insert(schedule);
		if (num == -1) {
			request.setAttribute("result", "权限不足！");
		}
		return "/sys_schedule/findByScheduleAll.action";
	}

	/**
	 * 根据ID删除
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/sys_schedule/delete.action")
	public String deleteByIds(Integer id, HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		int num = this.scheduleService.deleteById(id);
		if (num == -1) {
			request.setAttribute("result", "权限不足！");
		}
		return "/sys_schedule/findByScheduleAll.action";

	}

	/**
	 * ajax 根据ID删除
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/sys_schedule/deleteSchedule.action")
	public void deleteById(Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		setPrivilegeFilterUser(request);
		try {
			int num = this.scheduleService.deleteById(id);
			if (num > 0) {
				// 发送给客户端
				response.getWriter().write("1");
			} else {
				// 发送给客户端
				response.getWriter().write("2");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 查询
	 * 
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/sys_schedule/findByScheduleId.action")
	public String findById(Integer id, HttpServletResponse response,
			HttpServletRequest request) {

		Schedule schedule = this.scheduleService.findById(id);
		request.setAttribute("data", schedule);
		return "/pages_personal/public_schedule_edit.jsp";
	}

	/**
	 * 修改
	 * 
	 * @param Schedule
	 * @param request
	 * @return
	 */
	@RequestMapping("/sys_schedule/updateSchedule.action")
	public String update(Schedule schedule, HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		User user = (User) request.getSession().getAttribute("user");
		schedule.setUser(user);
		int num = this.scheduleService.update(schedule);
		if (num == -1) {
			request.setAttribute("result", "权限不足！");
		}
		return "/sys_schedule/findByScheduleAll.action";
	}

}
