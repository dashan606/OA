package com.ssm.OaManager.web.stationery;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.stationery.Stationerylibrary;
import com.ssm.OaManager.entity.stationery.Stationerytype;
import com.ssm.OaManager.service.stationery.StationerylibraryService;
import com.ssm.OaManager.service.stationery.StationerytypeService;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.web.BaseController;

/**
 * 办公用品业务层
 * @author 梦想
 *
 */
@Controller
public class StationerylibraryController extends BaseController {
	@Resource
	private StationerylibraryService stationerylibraryService;

	@Resource
	private StationerytypeService stationerytypeService;

	@Resource
	private PrivilegeFilter privilegeFilter;

	public void setStationerytypeService(StationerytypeService stationerytypeService) {
		this.stationerytypeService = stationerytypeService;
	}

	public void setStationerylibraryService(
			StationerylibraryService stationerylibraryService) {
		this.stationerylibraryService = stationerylibraryService;
	}



	@RequestMapping("/stationery/findAll.action")
	public String findAll(HttpServletRequest request,Stationerylibrary stationerylibrary){
		List<Stationerylibrary> pageBean = this.stationerylibraryService.findAll();
		request.setAttribute("pageBean", pageBean);

		return "/pages_stationery/Stationerylibrary.jsp";
	}

	/**
	 * 添加
	 * @param request
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/stationery/insert.action")
	public String insert(HttpServletRequest request,Stationerylibrary entity)throws Exception {
		setPrivilegeFilterUser(request);
		entity.setStatilibraryDate(new Date(System.currentTimeMillis()));
		int num = this.stationerylibraryService.insert(entity);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "forward:/stationery/findAll.action";
	}

	/**
	 * 删除
	 * @param request
	 * @param response
	 * @param students
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/stationery/deleteById.action")
	public String delete(HttpServletRequest request,int statilibraryId)throws Exception {
		setPrivilegeFilterUser(request);
		List<Stationerytype> s = this.stationerytypeService.findBylibraryId(statilibraryId);
		if(s.isEmpty()){
			int num =  stationerylibraryService.deleteById(statilibraryId);
			if(num==-1){
				request.setAttribute("result", "权限不足");
			}
		}else{
			request.setAttribute("result", "删除失败");
		}

		return "forward:/stationery/findAll.action";
	}

	/**
	 * 修改
	 * @param request
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/stationery/update.action")
	public String update(HttpServletRequest request,Stationerylibrary entity)throws Exception {
		setPrivilegeFilterUser(request);
		Integer num = stationerylibraryService.update(entity);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "forward:/stationery/findAll.action";
	}

	/**
	 * 按照ID查询
	 * @param request
	 * @param statilibraryId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/stationery/findById.action")
	public String select1(HttpServletResponse response,Integer statilibraryId,HttpServletRequest request)throws Exception {
		try {
			Stationerylibrary stationerylibrary = this.stationerylibraryService.findById(statilibraryId);

			String functions = JSON.toJSONString(stationerylibrary);
			// 发送给客户端
			response.getWriter().write(functions);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setPrivilegeFilterUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}
}
