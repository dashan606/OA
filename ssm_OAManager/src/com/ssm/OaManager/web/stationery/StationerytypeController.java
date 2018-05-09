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
import com.ssm.OaManager.entity.stationery.Stationery;
import com.ssm.OaManager.entity.stationery.Stationerylibrary;
import com.ssm.OaManager.entity.stationery.Stationerytype;
import com.ssm.OaManager.service.stationery.StationeryService;
import com.ssm.OaManager.service.stationery.StationerylibraryService;
import com.ssm.OaManager.service.stationery.StationerytypeService;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.web.BaseController;

@Controller
public class StationerytypeController extends BaseController{

	@Resource
	private StationerytypeService stationerytypeService;
	public void setStationerytypeService(StationerytypeService stationerytypeService) {
		this.stationerytypeService = stationerytypeService;
	}

	@Resource
	private StationeryService stationeryService;

	public void setStationeryService(StationeryService stationeryService) {
		this.stationeryService = stationeryService;
	}

	@Resource
	private StationerylibraryService stationerylibraryService;

	public void setStationerylibraryService(
			StationerylibraryService stationerylibraryService) {
		this.stationerylibraryService = stationerylibraryService;
	}

	@Resource
	private PrivilegeFilter privilegeFilter;

	/**
	 * 查询所有
	 * @param request
	 * @param stationerytype
	 * @return
	 */
	@RequestMapping("/stationery/findAll1.action")
	public String findAll(HttpServletRequest request,Stationerytype stationerytype){

		List<Stationerytype> pageBean = this.stationerytypeService.findAll();

		request.setAttribute("pageBean", pageBean);
		return "/pages_stationery/Stationerytype.jsp";
	}

	/**
	 * 添加
	 * @param request
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/stationery/insert1.action")
	public String insert(HttpServletRequest request,Stationerytype entity)throws Exception {
		setPrivilegeFilterUser(request);
		entity.setStatitypeDate(new Date(System.currentTimeMillis()));
		int num =  this.stationerytypeService.insert(entity);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "forward:/stationery/findAll1.action";
	}

	@RequestMapping("/stationerylibrary/findByAllUAM.action")
	public String findByAllUAM(HttpServletResponse response,HttpServletRequest request){

		try {
			List<Stationerylibrary> stationerylibrary = this.stationerylibraryService.findAll();


			String functions = JSON.toJSONString(stationerylibrary);
			// 发送给客户端
			response.getWriter().write(functions);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 删除
	 * @param request
	 * @param response
	 * @param students
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/stationery/deleteById1.action")
	public String delete(HttpServletRequest request,int statitypeId){
		setPrivilegeFilterUser(request);
		List<Stationery>stationery =  this.stationeryService.findByTypeId(statitypeId);
		if(stationery==null){
			int num = stationerytypeService.deleteById(statitypeId);
			if(num==-1){
				request.setAttribute("result", "权限不足");
			}
		}else{
			request.setAttribute("result", "删除失败!");
		}
		return "forward:/stationery/findAll1.action";
	}

	/**
	 * 修改
	 * @param request
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/stationery/update1.action")
	public String update(HttpServletRequest request,Stationerytype entity)throws Exception {
		setPrivilegeFilterUser(request);
		int num =  stationerytypeService.update(entity);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "forward:/stationery/findAll1.action";
	}

	/**
	 * 按照ID查询
	 * @param request
	 * @param statilibraryId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/stationery/findById1.action")
	public String select1(HttpServletResponse response,Integer statitypeId,HttpServletRequest request)throws Exception {

		try {
			Stationerytype stationerytype = this.stationerytypeService.findById(statitypeId);


			String functions = JSON.toJSONString(stationerytype);
			// 发送给客户端
			response.getWriter().write(functions);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/pages_stationery/findBylibararyId.action")
	public String findBylibararyId(Integer statilibraryId,HttpServletResponse response,HttpServletRequest request ){
		setPrivilegeFilterUser(request);
		try {
			List<Stationerytype> stas = this.stationerytypeService.findBylibraryId(statilibraryId);

			String functions = JSON.toJSONString(stas);
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
