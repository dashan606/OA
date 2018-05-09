package com.ssm.OaManager.web.stationery;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.stationery.StationeryStatus;
import com.ssm.OaManager.entity.stationery.Stationerylibrary;
import com.ssm.OaManager.service.stationery.StationeryStatusService;
import com.ssm.OaManager.service.stationery.StationerylibraryService;
import com.ssm.OaManager.service.system.UserService;
import com.ssm.OaManager.utils.PrivilegeFilter;

/**
 * 办公用品查询
 * @author Administrator
 *
 */
@Controller
public class StationeryStatusController {
	
	@Resource
	private StationeryStatusService stationeryStatusService;

	@Resource
	private UserService userService;
	
	@Resource
	private StationerylibraryService  stationerylibraryService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public void setStationeryStatusService(
			StationeryStatusService stationeryStatusService) {
		this.stationeryStatusService = stationeryStatusService;
	}
	
	@Resource
	private PrivilegeFilter privilegeFilter;
	
	public void setPrivilegeFilterUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}
	
	
	/**
	 * 分页查询全部
	 * @param currentPage
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/pages_stationery/findStationeryStatusByPage.action")
	public String findByPage(Model model, HttpServletRequest request){
		List<StationeryStatus> pageBean = this.stationeryStatusService.findAll();
		model.addAttribute("pageBean", pageBean);
		return "/pages_stationery/stationeryStatus_contact_list.jsp";
		
	}
	
	/**
	 * 查询当前用户管理的全部数据
	 * @param currentPage
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/pages_stationery/findStationeryStatusByUserAll.action")
	public String findByUserAll(Model model, HttpServletRequest request){

		User user = (User) request.getSession().getAttribute("user");
		List<StationeryStatus> pageBean = this.stationeryStatusService.findWhereAll(user.getUserId());
		
		model.addAttribute("pageBean", pageBean);
		return "/pages_stationery/stationery_user.jsp";
		
	}
	
	/**
	 * 查询
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/pages_stationery/findAll.action")
	public String findAll(Integer num ,Model model,HttpServletRequest request){
			List<Stationerylibrary> stas = this.stationerylibraryService.findAll();
			List<User> user = this.userService.findAll();
			model.addAttribute("users", user);
			model.addAttribute("stas", stas);
			List<StationeryStatus> pageBean = this.stationeryStatusService.findAll();
			model.addAttribute("pageBean", pageBean);
			return "/pages_stationery/stationeryStatus_contact_list.jsp";
	}
	
	
	

}
