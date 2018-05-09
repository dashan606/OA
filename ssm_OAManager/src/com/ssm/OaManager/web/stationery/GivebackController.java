package com.ssm.OaManager.web.stationery;

import java.util.Date;
import java.util.List;

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
 * 归还
 * 
 *
 */
@Controller
public class GivebackController extends BaseController {

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
	@RequestMapping("/pages_stationery/saveGiveback.action")
	public String insert(StationeryStatus stationeryStatus,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		Stationery stationery = this.stationeryService.findById(stationeryStatus.getStationery().getStationeryId());
		List<StationeryStatus> stationeryStatus2=this.stationeryStatusService.findBystationeryId(stationeryStatus.getStationery().getStationeryId());
		for(StationeryStatus s :stationeryStatus2){
			 if(s.getRegisterType().equals("借用")){
				  if(s.getAdditionMassage().equals("未归还")){
					  if(s.getAmount()==stationeryStatus.getAmount()){
							stationery.setStationeryAmount(stationery.getStationeryAmount()+stationeryStatus.getAmount());
						  	stationeryStatus.setStationeryStatusId(s.getStationeryStatusId());
						  	stationeryStatus.setAdditionMassage("已归还");
						  int num = 	this.stationeryService.update(stationery);
						  num =this.stationeryStatusService.update(stationeryStatus);
							if(num==-1){
								request.setAttribute("result", "权限不足！");
							}
					  }else if(s.getAmount()>stationeryStatus.getAmount()){
						  	stationeryStatus.setRegisterType("归还");
							stationery.setStationeryAmount(stationery.getStationeryAmount()+stationeryStatus.getAmount());
						  	stationeryStatus.setOparateDate(new Date(System.currentTimeMillis()));
							User user = (User) request.getSession().getAttribute("user");
							stationeryStatus.setOparateName(user);
							int num = this.stationeryService.update(stationery);
							num = 	this.stationeryStatusService.insert(stationeryStatus);
							if(num==-1){
								request.setAttribute("result", "权限不足！");
							}
					}else{
						request.setAttribute("result", "归还失败！");
					}
				  }
			 }
		}
		return "/pages_stationery/findAll.action";
	}
}
