package com.ssm.OaManager.web.system.official;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.official.Approve;
import com.ssm.OaManager.entity.official.Official;
import com.ssm.OaManager.entity.workflow.StepInstance;
import com.ssm.OaManager.service.system.official.ApproveService;
import com.ssm.OaManager.service.system.official.OfficialService;
import com.ssm.OaManager.service.system.workflow.FlowLinkService;
import com.ssm.OaManager.service.system.workflow.StepInstanceService;
import com.ssm.OaManager.utils.PrivilegeFilter;

/**
 * 审批控制层
 * @author Administrator
 *
 */
@Controller
public class ApproveController {

	//审批业务接口
	private ApproveService approveService;

	//公文业务接口
	private OfficialService officialService;

	//步骤实例业务接口
	private StepInstanceService stepInstanceService;

	//流程链路业务接口
	private FlowLinkService flowLinkService;

	//权限业务接口
	@Resource
	private PrivilegeFilter privilegeFilter;

	@Resource
	public void setFlowLinkService(FlowLinkService flowLinkService) {
		this.flowLinkService = flowLinkService;
	}


	@Resource
	public void setOfficialService(OfficialService officialService) {
		this.officialService = officialService;
	}


	@Resource
	public void setStepInstanceService(StepInstanceService stepInstanceService) {
		this.stepInstanceService = stepInstanceService;
	}



	@Resource
	public void setApproveService(ApproveService approveService) {
		this.approveService = approveService;
	}

	public void setPrivilegeFilterUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}

	/**
	 * 审批公文
	 * @return
	 */
	@RequestMapping(value="approve_official.action")
	public String approveOfficial(HttpServletRequest request,
			Approve approve,Official official){

		setPrivilegeFilterUser(request);
		
		//获取当前用户
		User user = (User) request.getSession().getAttribute("user");

		//设置审批公文
		approve.setOfficial(official);
		//设置审批意见
		approve.setApproveDate(new Date());
		//设置审批用户
		approve.setUser(user);

		//添加审批记录
		Integer num = approveService.add(approve);
		
		if(num==-1){
			request.setAttribute("result", "权限不足");

			return "forward:my_official.action";
		}


		/**修改步骤实例的状态*/
		List<StepInstance> steps = stepInstanceService.findStepInstancesByOfficial(official);
		
		if(steps==null){
			request.setAttribute("result", "权限不足");

			return "forward:my_official.action";
		}
		
		for(StepInstance step : steps){
			if(step.getEmp().getEmpId()==user.getEmp().getEmpId()){
				step.setStatus(StepInstance.STOP);
				//-------------------------------------------
				Integer integer = stepInstanceService.update(step);
				//-------------------------------------------
				
				if(integer==-1){
					request.setAttribute("result", "权限不足");

					return "forward:my_official.action";
				}
			}
		}
		//转发至待审公文
		return "forward:my_official.action";
	}
}
