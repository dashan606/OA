package com.ssm.OaManager.web.stationery;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.stationery.Stationery;
import com.ssm.OaManager.entity.stationery.StationeryStatus;
import com.ssm.OaManager.entity.stationery.Stationerytype;
import com.ssm.OaManager.service.stationery.StationeryService;
import com.ssm.OaManager.service.stationery.StationeryStatusService;
import com.ssm.OaManager.service.stationery.StationerytypeService;
import com.ssm.OaManager.utils.PrivilegeFilter;

@Controller
public class StationeryController {
	@Resource
	private StationeryService stationeryService;
	
	@Resource
	private StationerytypeService stationerytypeService;

	@Resource
	private StationeryStatusService stationeryStatusService;
	
	@Resource
	private PrivilegeFilter privilegeFilter;
	
	public void setStationeryService(StationeryService stationeryService) {
		this.stationeryService = stationeryService;
	}
	
	public void setStationerytypeService(StationerytypeService stationerytypeService) {
		this.stationerytypeService = stationerytypeService;
	}
	
	public void setStationeryStatusService(
			StationeryStatusService stationeryStatusService) {
		this.stationeryStatusService = stationeryStatusService;
	}

	/**
	 * 分页查询所有
	 * @param model
	 * @return
	 */
	@RequestMapping("/pages_stationery/StationeryByPage.action")
	public String findAll(Model model,HttpServletRequest request){
		List<Stationery> pageBean = this.stationeryService.findAll();
		
		model.addAttribute("pageBean", pageBean);
		return "/pages_stationery/Stationery.jsp";
		
	}
	
	@RequestMapping("/pages_stationery/findByAllUAM.action")
	public String findByAllUAM(HttpServletResponse response,HttpServletRequest request){
		try {
			List<Stationerytype> stationerytype = this.stationerytypeService.findAll();

				String functions = JSON.toJSONString(stationerytype);
				// 发送给客户端
				response.getWriter().write(functions);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 添加
	 * @param stationery
	 * @param request
	 * @return
	 */
	@RequestMapping("/pages_stationery/insertStationery.action")
	public String insert(Stationery stationery,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		stationery.setStationeryDate(new Date(System.currentTimeMillis()));

		int num = this.stationeryService.insert(stationery);
		if(num==-1){
			request.setAttribute("result", "权限不足！");
		}
		return "/pages_stationery/StationeryByPage.action";
	}
	
	/**
	 * 根据ID删除
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/pages_stationery/deleteById.action")
	public String deleteById(Integer id,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		List<StationeryStatus> stationeryStatus=this.stationeryStatusService.findBystationeryId(id);
		if(stationeryStatus.isEmpty()){
			int num = this.stationeryService.deleteById(id);
			if(num==-1){
				request.setAttribute("result", "权限不足！");
			}
		}else{
			request.setAttribute("result", "删除失败！");
		}
		return "/pages_stationery/StationeryByPage.action";
	}
	
	/**
	 * 查询
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/pages_stationery/findBytypeId.action")
	public String findBytypeId(Integer statitypeId,HttpServletResponse response,HttpServletRequest request ){
				try {
					List<Stationery> stas = this.stationeryService.findByTypeId(statitypeId);
				
						String functions = JSON.toJSONString(stas);
						// 发送给客户端
						response.getWriter().write(functions);
				
				} catch (IOException e) {
					e.printStackTrace();
				}
			return null;
			
	}
	/**
	 * 根据ID查询
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/pages_stationery/findByStationery.action")
	public String findById(Integer id,HttpServletResponse response,HttpServletRequest request){
		try {
			Stationery stationery = this.stationeryService.findById(id);
			
				String functions = JSON.toJSONString(stationery);
				// 发送给客户端
				response.getWriter().write(functions);
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 修改
	 * @param stationery
	 * @param request
	 * @return
	 */
	@RequestMapping("/pages_stationery/updateStationery.action")
	public String update(Stationery stationery,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		int num = this.stationeryService.update(stationery);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "/pages_stationery/StationeryByPage.action";
	}
	
	
	/**
	 * 修改
	 * @param stationery
	 * @param request
	 * @return
	 */
	@RequestMapping("/pages_stationery/insertTwoStationery.action")
	public String insertTwo(Stationery stationery,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		Stationery stationery2 = this.stationeryService.findById(stationery.getStationeryId());
		if(stationery2.getStationeryAmount()>=stationery.getStationeryAmount()){
			stationery2.setStationeryAmount(stationery2.getStationeryAmount()-stationery.getStationeryAmount());
			int num = this.stationeryService.update(stationery2);
			stationery2.setStationerytype(stationery.getStationerytype());
			stationery2.setStationeryAmount(stationery.getStationeryAmount());
			stationery2.setStationeryDate(new Date(System.currentTimeMillis()));
			 num = this.stationeryService.insert(stationery2);
			
			if(num==-1){
				request.setAttribute("result", "权限不足");
			}
		}else{
			request.setAttribute("result", "调拨失败！库存不足");
		}
		return "/pages_stationery/findAll.action";
	}

	public void setPrivilegeFilterUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}
	
}
