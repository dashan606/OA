package com.ssm.OaManager.web.stationery;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.stationery.Stationery;
import com.ssm.OaManager.entity.stationery.StationeryStatus;
import com.ssm.OaManager.service.stationery.StationeryService;
import com.ssm.OaManager.service.stationery.StationeryStatusService;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.web.BaseController;

/**
 * 报废
 * 
 *
 */
@Controller
public class ScrapController extends BaseController {

	@Resource
	private StationeryStatusService stationeryStatusService;

	public void setStationeryStatusService(
			StationeryStatusService stationeryStatusService) {
		this.stationeryStatusService = stationeryStatusService;
	}

	@Resource
	private StationeryService stationeryService;
	
	public void setStationeryService(StationeryService stationeryService) {
		this.stationeryService = stationeryService;
	}
	
	@Resource
	private PrivilegeFilter privilegeFilter;
	
	public void setPrivilegeFilterUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}
	
	/**
	 * 添加
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/pages_stationery/saveScrap.action")
	public String insert(StationeryStatus stationeryStatus,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		stationeryStatus.setRegisterType("报废");
		stationeryStatus.setOparateDate(new Date(System.currentTimeMillis()));
		User user = (User) request.getSession().getAttribute("user");
		stationeryStatus.setOparateName(user);
		Stationery stationery = this.stationeryService.findById(stationeryStatus.getStationery().getStationeryId());
		if(stationery.getStationeryAmount()>=Long.valueOf(stationeryStatus.getAmount())){
				stationery.setStationeryAmount(stationery.getStationeryAmount()-Long.valueOf(stationeryStatus.getAmount()));
				int num = this.stationeryService.update(stationery);
				num = this.stationeryStatusService.insert(stationeryStatus);
				
				if(num==-1){
					request.setAttribute("result", "权限不足！");
				}
		}else{
			request.setAttribute("result", "报废失败！");
		}
		return "/pages_stationery/findAll.action";
	}
	
}
