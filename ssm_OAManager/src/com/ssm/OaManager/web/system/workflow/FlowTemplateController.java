package com.ssm.OaManager.web.system.workflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.workflow.FlowInstance;
import com.ssm.OaManager.entity.workflow.FlowLink;
import com.ssm.OaManager.entity.workflow.FlowLinkModel;
import com.ssm.OaManager.entity.workflow.FlowTemplate;
import com.ssm.OaManager.entity.workflow.FlowType;
import com.ssm.OaManager.entity.workflow.StepTemplate;
import com.ssm.OaManager.service.system.UserService;
import com.ssm.OaManager.service.system.workflow.FlowInstanceService;
import com.ssm.OaManager.service.system.workflow.FlowLinkService;
import com.ssm.OaManager.service.system.workflow.FlowTemplateService;
import com.ssm.OaManager.service.system.workflow.FlowTypeService;
import com.ssm.OaManager.service.system.workflow.StepTemplateService;
import com.ssm.OaManager.utils.PrivilegeFilter;

/**
 * 流程模板的控制层
 * @author Administrator
 *
 */
@Controller
public class FlowTemplateController {

	//流程类型业务接口
	private FlowTypeService flowTypeService;

	//步骤业务接口
	private StepTemplateService stepTemplateService;

	//流程链路业务接口
	private FlowLinkService flowLinkService;

	//流程定义模型业务接口
	private FlowTemplateService flowTemplateService;

	//流程实例业务接口
	private FlowInstanceService flowInstanceService;

	//用户业务接口
	private UserService userService;

	//权限业务接口
	@Resource
	private PrivilegeFilter privilegeFilter;

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Resource
	public void setFlowInstanceService(FlowInstanceService flowInstanceService) {
		this.flowInstanceService = flowInstanceService;
	}


	@Resource
	public void setFlowTemplateService(FlowTemplateService flowTemplateService) {
		this.flowTemplateService = flowTemplateService;
	}


	@Resource
	public void setFlowTypeService(FlowTypeService flowTypeService) {
		this.flowTypeService = flowTypeService;
	}


	@Resource
	public void setStepTemplateService(StepTemplateService stepTemplateService) {
		this.stepTemplateService = stepTemplateService;
	}

	@Resource
	public void setFlowLinkService(FlowLinkService flowLinkService) {
		this.flowLinkService = flowLinkService;
	}

	public void setPrivilegeFilterUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}


	/**
	 * 流程添加视图
	 * @param model
	 * @return
	 */
	@RequestMapping(value="flowTemplate_addView.action")
	public String addView(Model model,HttpServletRequest request){

		//获取所有流程类型
		List<FlowType> flowTypes = flowTypeService.findAll();
		
		//获取所有步骤
		List<StepTemplate> steps = stepTemplateService.findAll();
		
		//将流程类型和步骤放入request作用域
		model.addAttribute("flowTypes", flowTypes);
		model.addAttribute("steps", steps);

		//转发至流程添加页面
		return "forward:/page/workflow/workflow_add.jsp";
	}

	/**
	 * 添加流程
	 * @param steps
	 * @return
	 */
	@RequestMapping(value="flowTemplate_add.action")
	public String add(HttpServletRequest request,FlowLinkModel flowLinks,FlowTemplate flow,FlowType flowType){
		setPrivilegeFilterUser(request);
		
		//获取已登录用户 
		User user = (User) request.getSession().getAttribute("user");

		flow.setCreateDate(new Date());
		flow.setVersion(1);
		flow.setUser(user);
		flow.setModifyUser(new User());
		flow.setFlowType(flowType);

		//将流程添加至数据库并返回主键
		int flowId = flowTemplateService.insert(flow);
		
		if(flowId==-1){
			request.setAttribute("result", "权限不足");

			return "forward:flowTemplate_show.action";
		}
		
		//获取流程步骤
		List<FlowLink> FlowLinksList = flowLinks.getFlowLinks();

		List<FlowLink> FlowLinksList2 = new ArrayList<FlowLink>();
		Iterator<FlowLink> it = FlowLinksList.iterator();
		while(it.hasNext()){
			FlowLink flowLink = it.next();
			//去除空的步骤
			if(flowLink.getFromStep().getStepId()!=-1){
				//将流程与链路绑定
				flowLink.setFlow(flow);
				FlowLinksList2.add(flowLink);
			}

		}

		//将流程步骤保持至流程链路
		int num = flowLinkService.insertBatch(FlowLinksList2);
		
		if(num==-1){
			request.setAttribute("result", "权限不足");

			return "forward:flowTemplate_show.action";
		}

		return "redirect:flowTemplate_show.action";
	}

	/**
	 * 查看工作流程
	 */
	@RequestMapping(value="flowTemplate_show.action")
	public String flowShow(Model model,HttpServletRequest request){
		
		
		List<FlowTemplate> flows = flowTemplateService.findAll();

		model.addAttribute("flows", flows);

		return "forward:page/workflow/workflow_list.jsp";
	}

	/**
	 * 删除工作流程
	 */
	@RequestMapping(value="flowTemplate_delete.action")
	public String delete(FlowTemplate flow,HttpServletRequest request){

		setPrivilegeFilterUser(request);
		
		//flowTemplateService.delete();
		//根据流程查找流程实例
		List<FlowInstance> flowInstances = flowInstanceService.findByFlow(flow);

		if(flowInstances==null){
			request.setAttribute("result", "权限不足");

			return "forward:flowTemplate_show.action";
		}
		
		if(flowInstances.size()>0){
			//流程实例不能删除

		}else{

			Integer num = flowTemplateService.delete(flow);
			
			if(num==-1){
				request.setAttribute("result", "权限不足");

				return "forward:flowTemplate_show.action";
			}

			num = flowLinkService.deleteByFlowTemplate(flow);
		}

		return "flowTemplate_show.action";
	}
}
