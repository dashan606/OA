package com.ssm.OaManager.web.system.official;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.accessory.Reimburse;
import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.hrm.Position;
import com.ssm.OaManager.entity.official.Approve;
import com.ssm.OaManager.entity.official.Official;
import com.ssm.OaManager.entity.workflow.FlowInstance;
import com.ssm.OaManager.entity.workflow.FlowLink;
import com.ssm.OaManager.entity.workflow.FlowTemplate;
import com.ssm.OaManager.entity.workflow.StepInstance;
import com.ssm.OaManager.entity.workflow.StepInstanceModel;
import com.ssm.OaManager.entity.workflow.StepTemplate;
import com.ssm.OaManager.service.hrm.DeptService;
import com.ssm.OaManager.service.hrm.EmployeeService;
import com.ssm.OaManager.service.system.UserService;
import com.ssm.OaManager.service.system.accessory.ReimburseService;
import com.ssm.OaManager.service.system.official.ApproveService;
import com.ssm.OaManager.service.system.official.OfficialService;
import com.ssm.OaManager.service.system.official.TestService;
import com.ssm.OaManager.service.system.workflow.FlowInstanceService;
import com.ssm.OaManager.service.system.workflow.FlowLinkService;
import com.ssm.OaManager.service.system.workflow.FlowTemplateService;
import com.ssm.OaManager.service.system.workflow.StepInstanceService;
import com.ssm.OaManager.service.system.workflow.StepTemplateService;
import com.ssm.OaManager.utils.PageBean;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.web.BaseController;
import org.apache.commons.beanutils.BeanUtils;

/**
 * 公文控制层
 * @author Administrator
 *
 */
@Controller
public class OfficialController extends BaseController{

	//流程定义模型业务接口
	private FlowTemplateService flowTemplateService;

	//报销业务接口
	private ReimburseService reimburseService;

	//公文业务接口
	private OfficialService officialService;

	//流程实例业务接口
	private FlowInstanceService flowInstanceService;

	//流程链路业务接口
	private FlowLinkService flowLinkService;

	//步骤实例业务接口
	private StepInstanceService stepInstanceService;

	//步骤定义模型业务接口
	private StepTemplateService stepTemplateService;

	//员工业务接口
	private EmployeeService employeeService;

	//部门业务接口
	private DeptService deptService;

	//用户业务接口
	private UserService userService;

	//审批业务接口
	private ApproveService approveService;

	private TestService testService;

	//权限业务接口
	@Resource
	private PrivilegeFilter privilegeFilter;

	@Resource
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	@Resource
	public void setApproveService(ApproveService approveService) {
		this.approveService = approveService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Resource
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	@Resource
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Resource
	public void setStepTemplateService(StepTemplateService stepTemplateService) {
		this.stepTemplateService = stepTemplateService;
	}

	@Resource
	public void setStepInstanceService(StepInstanceService stepInstanceService) {
		this.stepInstanceService = stepInstanceService;
	}

	@Resource
	public void setFlowLinkService(FlowLinkService flowLinkService) {
		this.flowLinkService = flowLinkService;
	}

	@Resource
	public void setFlowInstanceService(FlowInstanceService flowInstanceService) {
		this.flowInstanceService = flowInstanceService;
	}

	@Resource
	public void setOfficialService(OfficialService officialService) {
		this.officialService = officialService;
	}

	@Resource
	public void setReimburseService(ReimburseService reimburseService) {
		this.reimburseService = reimburseService;
	}

	@Resource
	public void setFlowTemplateService(FlowTemplateService flowTemplateService) {
		this.flowTemplateService = flowTemplateService;
	}
	
	public void setPrivilegeFilterUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}


	/**
	 * 查询所有流程
	 * @param model
	 * @return
	 */
	@RequestMapping(value="official_findAll.action")
	public String findAll(Model model,HttpServletRequest request){
		
		//查询所有流程
		List<FlowTemplate> flows = flowTemplateService.findAll();

		model.addAttribute("flows", flows);

		//转发至选择流程的页面
		return "forward:page/official/official_select_flow.jsp";
	}

	/**
	 * 添加公文的视图
	 * @param flow
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="official_addView.action")
	public String addView(FlowTemplate flow,
			Model model,HttpServletRequest request) throws Exception{

		//get请求转码
//		String str = new String(flow.getFlowName().getBytes("iso8859-1"), "UTF-8");
//		flow.setFlowName(str);

		//获取当前时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date());

		//将时间放入作用域
		model.addAttribute("date", date);

		model.addAttribute("s",Reimburse.WILL);

		//将流程放入作用域
		model.addAttribute("flow", flow);

		//转发至添加公文页面
		return "forward:page/official/official_addView.jsp";
	}

	/**
	 * 添加公文
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="official_add.action")
	public String add(HttpServletRequest request,
			Model model
			) throws Exception{

		setPrivilegeFilterUser(request);
		
		//获取已登录用户 
		User user = (User) request.getSession().getAttribute("user");

		Official official = new Official();
		FlowTemplate flow = new FlowTemplate();

		//拖过字节码文件后去official和flow的属性
		Field[] officialFields = official.getClass().getDeclaredFields();
		Field[] flowFields = flow.getClass().getDeclaredFields();

		// 图片上传
		// 1.创建工厂对象
		FileItemFactory factory = new DiskFileItemFactory();
		// 2.文件上传核心工具类
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 3.设置上传 大小限制参数
		upload.setFileSizeMax(100000 * 1024 * 1024); // 单个文件大小限制
		upload.setSizeMax(50000000 * 1024 * 1024); // 总文件大小限制
		upload.setHeaderEncoding("UTF-8"); // 对中文文件编码处理

		// 判断是否是上传的表单
		// <form 是否添加了此 enctype="multipart/form-data"
		if (upload.isMultipartContent(request)) {
			// 把请求数据转换为list集合
			List<FileItem> list = upload.parseRequest(request);

			// FileItem 代表请求的 内容（数据） 员工姓名、员工性别....
			for (FileItem item : list) {
				// jsp name属性值
				String name = item.getFieldName();
				// jsp 属性对应的value值
				String value = new String(item.getString().getBytes(
						"iso8859-1"), "utf-8");
				// 判断 是否上传 tiem
				if (!item.isFormField()) {

					if (item.getName() != null
							&& !"".equals(item.getName())) {

						byte[] bytes = value.getBytes();
						//将字节数组放入公文对象
						official.setAccessory(bytes);

					}
				} else { // 普通的item

					for(Field field : officialFields){
						if(field.getName().equals(name)){

							BeanUtils.setProperty(official, name, value);
						}
					}

					for(Field field : flowFields){
						if(field.getName().equals(name)){

							BeanUtils.setProperty(flow, name, value);
						}
					}
				}
			}
		}

		//给公文绑定用户
		official.setUser(user);
		//给公文绑定流程
		official.setFlow(flow);
		//公文新建处于创建状态
		official.setOffiState(official.NEW);
		//给公文绑定时间
		official.setOffiDate(new Date());

		//调用添加流程的业务方法
		Integer i = officialService.insertAndGetId(official);

		if(i==-1){
			request.setAttribute("result", "权限不足");

			return "forward:my_official.action";
		}
		
		//创建流程实例
		FlowInstance flowInstance = new FlowInstance();
		//创建用户
		flowInstance.setCreateUser(user);
		//创建时间
		flowInstance.setCreateDate(official.getOffiDate());
		//绑定流程
		flowInstance.setFlow(flow);
		//流程实例名称
		flowInstance.setFlowInstanceName(flow.getFlowName()+"实例");
		//处于初始状态
		flowInstance.setStatus(FlowInstance.NEW);
		//绑定公文
		flowInstance.setOfficial(official);

		int num = flowInstanceService.add(flowInstance);
		
		if(num==-1){
			request.setAttribute("result", "权限不足");

			return "forward:my_official.action";
		}

		//转发至我的公文
		return "forward:my_official.action";
	}

	/**
	 * 我的公文
	 * @return
	 */
	@RequestMapping(value="my_official.action")
	public String myOfficial(Integer status,Integer app,
			Model model,HttpServletRequest request){

		//获取当前用户
		User user = (User) request.getSession().getAttribute("user");

		if(status==null){
			/**我的公文*/
			//查询所有公文
			List<Official> officials = officialService.findByUser(user);
			
			model.addAttribute("datas", officials);

			//禁用审批按钮
			model.addAttribute("one", 2);

			//开启提交按钮
			model.addAttribute("twe", 1);

			//转发至我的公文
			return "forward:page/official/my_official.jsp";
		}

		if(status==1){
			/**待审公文*/
			List<StepInstance> stepins = new ArrayList<StepInstance>(); 

			List<StepInstance> stepInstances = stepInstanceService.findAll(user.getEmp());
			
			for(StepInstance s : stepInstances){
				StepTemplate findStep = stepTemplateService.findStep(s.getStep());
								
				if(s.getStatus().equals(StepInstance.ING)&&
						!findStep.getStepName().equals("结束")){
					stepins.add(s);
				}
			}

			if(stepins.size()>0){		
				//根据步骤实例查询公文
				List<Official> offis = officialService.findByStepIntances(stepins);
				
				model.addAttribute("datas", offis);
			}

			//开启审批按钮
			model.addAttribute("one", 1);
			//开启提交按钮
			model.addAttribute("twe", 1);
		}

		if(status==2){
			/**已审公文*/
			List<StepInstance> stepins = new ArrayList<StepInstance>(); 

			List<StepInstance> stepInstances = stepInstanceService.findAll(user.getEmp());

			for(StepInstance s : stepInstances){
				StepTemplate findStep = stepTemplateService.findStep(s.getStep());
				
				if(findStep==null){
					request.setAttribute("result", "权限不足");

					return "forward:my_official.action";
				}
				
				if(s.getStatus().equals(StepInstance.STOP)&&
						!findStep.getStepName().equals("结束")){
					stepins.add(s);	
				}
			}

			if(stepins.size()>0){		
				//根据步骤实例查询公文
				List<Official> offis = officialService.findByStepIntances(stepins);
				
				model.addAttribute("stepInstances", stepInstances);
				model.addAttribute("datas", offis);
			}

			//禁用审批按钮
			model.addAttribute("one", 2);
			//开启提交按钮
			model.addAttribute("twe", 1);
			//辅助开启提交按钮
			model.addAttribute("three", 1);
		}


		//转发至我的公文
		return "forward:page/official/my_official.jsp";
	}



	/**
	 * 提交视图
	 * @return
	 */
	@RequestMapping(value="official_commitView.action")
	public String commitView(Official official,Model model,
			HttpServletRequest request){

		setPrivilegeFilterUser(request);
		
		//获取当前用户
		User user = (User) request.getSession().getAttribute("user");

		//根据公文获取流程实例
		FlowInstance flowinstance = flowInstanceService.findFlowInstance(official);

		//根据流程获取流程链路
		List<FlowLink> flowLinks = flowLinkService.findByFlow(flowinstance.getFlow());

		//根据公文获取步骤实例
		List<StepInstance> stepInstances = stepInstanceService.findStepInstancesByOfficial(flowinstance.getOfficial());

		//当前步骤
		List<StepTemplate> nowSteps = new ArrayList<StepTemplate>();

		StepTemplate nowStep = new StepTemplate();

		//下一步骤
		List<StepTemplate> toSteps = new ArrayList<StepTemplate>();


		//迭代遍历
		Iterator<FlowLink> it = flowLinks.iterator();

		ok:
			while(it.hasNext()){
				FlowLink flowLink = it.next();

				//开启审核
				if(stepInstances.size()==0){
					if(flowLink.getFromStep().getStepId()==FlowLink.STARTSTEP){
						StepTemplate step = null;
						//当前步骤
						step = stepTemplateService.findStep(flowLink.getFromStep());
						
						nowSteps.add(step);

						//下一步骤
						if(flowLink.getToStep1().getStepId()!=-1){
							step = stepTemplateService.findStep(flowLink.getToStep1());
							
							toSteps.add(step);
						}
						if(flowLink.getToStep2().getStepId()!=-1){
							step = stepTemplateService.findStep(flowLink.getToStep2());
							toSteps.add(step);
						}
						if(flowLink.getToStep3().getStepId()!=-1){
							step = stepTemplateService.findStep(flowLink.getToStep3());
							toSteps.add(step);
						}
						if(flowLink.getToStep4().getStepId()!=-1){
							step = stepTemplateService.findStep(flowLink.getToStep4());
							toSteps.add(step);
						}
						if(step==null){
							request.setAttribute("result", "权限不足");

							return "forward:my_official.action";
						}
						//跳出外循环
						break ok;
					}
				}else{
					//遍历流程实例
					for(StepInstance s : stepInstances){
						if(s.getEmp().getEmpId()==user.getEmp().getEmpId()){
							StepTemplate step = new StepTemplate();

							//当前步骤
							step = stepTemplateService.findStep(flowLink.getFromStep());
							nowStep = step;

							if(flowLink.getFromStep().getStepId()==s.getStep().getStepId()){
								//下一步骤
								if(flowLink.getToStep1().getStepId()!=-1){
									step = stepTemplateService.findStep(flowLink.getToStep1());
									
									toSteps.add(step);
								}
								if(flowLink.getToStep2().getStepId()!=-1){
									step = stepTemplateService.findStep(flowLink.getToStep2());
									
									toSteps.add(step);
								}
								if(flowLink.getToStep3().getStepId()!=-1){
									step = stepTemplateService.findStep(flowLink.getToStep3());
									
									toSteps.add(step);
								}
								if(flowLink.getToStep4().getStepId()!=-1){
									step = stepTemplateService.findStep(flowLink.getToStep4());
									toSteps.add(step);
								}
								//跳出外循环
								break ok;

							}
						}
					}
				}

			}


		//审批未同意,通知申请人
		List<Approve> approves = approveService.findByOffical(official);
		
		for(Approve approve : approves){
			if(approve.getUser().getUserId().equals(user.getUserId())){
				if(approve.getAgreeOrNot().equals(Approve.NO)){
					StepTemplate stepTemplate = new StepTemplate();
					stepTemplate.setStepName("结束");
					stepTemplate = stepTemplateService.findStep(stepTemplate);

					List<StepTemplate> steps = new ArrayList<StepTemplate>();
					steps.add(stepTemplate);

					toSteps = steps;
				}
			}
		}

		//将当前步骤放入作用域
		model.addAttribute("nowSteps", nowSteps);
		model.addAttribute("nowStep", nowStep);
		//将下一步骤放入作用域
		model.addAttribute("toSteps", toSteps);
		//将流程放入作用域
		model.addAttribute("flowinstance", flowinstance);
		//将公文放入作用域
		model.addAttribute("official", official);

		//妆发至公文提交页面
		return "forward:page/official/official_commitView.jsp";
	}

	/**
	 * 提交公文
	 * @return
	 */
	@RequestMapping(value="official_commit.action")
	public String commit(StepInstanceModel stepInstances,
			FlowInstance flowInstance ,Official official,StepTemplate stepTemplate,
			HttpServletRequest request){

		setPrivilegeFilterUser(request);
		
		User user = (User) request.getSession().getAttribute("user");

		/**同意的情况*/
		List<StepInstance> stepInstancesList = stepInstances.getStepInstances();

		//根据公文获取步骤实例
		List<StepInstance> stepInstances2 = stepInstanceService.findStepInstancesByOfficial(official);
		
		List<StepInstance> stepINstances3 = new ArrayList<StepInstance>();

		//获取流程
		FlowInstance f = flowInstanceService.findByFlowInstance(flowInstance);
		
		//获取流程链路
		List<FlowLink> links = flowLinkService.findByFlow(f.getFlow());
		
		//将当前步骤修改为已提交
		List<StepInstance> stepInstance4 = stepInstanceService.findStepInstancesByOfficial(official);		
		
		if(stepInstance4.size()>0){		
			for(StepInstance s : stepInstance4){
				if(s.getStep().getStepId().equals(stepTemplate.getStepId())){
					StepTemplate findStep = stepTemplateService.findStep(s.getStep());
					
					if(!findStep.getStepName().equals("开始")){
						s.setCommit(1);
						Integer num = stepInstanceService.update(s);
						
						if(num==-1){
							request.setAttribute("result", "权限不足");

							return "forward:my_official.action";
						}
					}
				}
			}
		}

		/**不同意的情况*/
		List<Approve> approves = approveService.findByOffical(official);
		
		if(approves.size()>0){
			for(Approve a : approves){
				if(a.getAgreeOrNot().equals(Approve.NO)&&
						a.getUser().getUserId()==user.getUserId()){
					for(FlowLink link : links){
						if(link.getFromStep().getStepId().equals(stepTemplate.getStepId())){
							StepInstance stepInstance = new StepInstance();
							//给步骤实例绑定流程实例
							stepInstance.setFlowInstance(flowInstance);
							//给步骤绑定公文
							stepInstance.setOfficial(official);
							//设置开始时间
							stepInstance.setStartDate(new Date());
							//设置结束时间
							stepInstance.setFinishDate(null);
							//设置状态
							stepInstance.setStatus(StepInstance.ING);


							StepTemplate st = new StepTemplate();
							st.setStepName("结束");
							StepTemplate findStep = stepTemplateService.findStep(st);

							stepInstance.setStep(findStep);

							stepINstances3.add(stepInstance);

							@SuppressWarnings("unused")
							Integer insertBatch = stepInstanceService.insertBatch(stepINstances3);
							
							if(insertBatch==-1){
								request.setAttribute("result", "权限不足");

								return "forward:my_official.action";
							}
							
							//结束公文
							List<StepInstance> byOfficial = stepInstanceService.findStepInstancesByOfficial(official);
							
							for(StepInstance s : byOfficial){
								s.setStatus(StepInstance.STOP);
							}

							List<StepInstance> ss = stepInstanceService.findStepInstancesByOfficial(official);

							List<StepInstance> ss2 = new ArrayList<StepInstance>();
							for(StepInstance s : ss){
								if(s.getStatus().equals(StepInstance.ING)){
									ss2.add(s);
								}
							}


							Integer num = stepInstanceService.update(byOfficial);
							if(num==-1){
								request.setAttribute("result", "权限不足");

								return "forward:my_official.action";
							}

							if(ss2.size()>0){
								num = stepInstanceService.deleteBatch(ss2);
								
								if(num==-1){
									request.setAttribute("result", "权限不足");

									return "forward:my_official.action";
								}
							}

							//修改公文状态
							official.setOffiState(Official.END);

							num = officialService.update(official);
							if(num==-1){
								request.setAttribute("result", "权限不足");

								return "forward:my_official.action";
							}

							//转发至我的公文
							return "forward:my_official.action";
						}
					}
				}
			}
		}



		List<StepTemplate> steps = new ArrayList<StepTemplate>();

		//迭代遍历
		Iterator<StepInstance> it = stepInstancesList.iterator();
		while(it.hasNext()){
			StepInstance stepInstance = it.next();
			//给步骤实例绑定流程实例
			stepInstance.setFlowInstance(flowInstance);
			//给步骤绑定公文
			stepInstance.setOfficial(official);
			//设置开始时间
			stepInstance.setStartDate(new Date());
			//设置结束时间
			stepInstance.setFinishDate(null);
			//设置状态
			stepInstance.setStatus(StepInstance.ING);


			//避免重复插入
			int i = 0;
			for(StepInstance s : stepInstances2){
				if(stepInstance.getStep().getStepId()!=
						s.getStep().getStepId()){
					i++;
				}
			}
			if(i==stepInstances2.size()){
				StepTemplate findStep = stepTemplateService.findStep(stepInstance.getStep());
				
				if(findStep.getStepName().equals("结束")){
					stepInstance.setStatus(StepInstance.STOP);
				}
				stepINstances3.add(stepInstance);
			}
			for(FlowLink link: links){
				Integer stepId = link.getFromStep().getStepId();
				Integer stepId2 = stepTemplate.getStepId();
				if(stepId.equals(stepId2)){
					for(FlowLink l: links){
						if(link.getToStep1().getStepId()==l.getToStep1().getStepId()){
							steps.add(l.getFromStep());
						}
					}		
				}
			}
		}





		//批量创建步骤实例
		//上一步骤全部审批过后才能提交
		if(steps.size()>0){
			List<StepInstance> stepstances = stepInstanceService.findByStepTemplates(steps);
			
			List<StepInstance> stepstances2 = new ArrayList<StepInstance>();

			for(StepInstance st : stepstances){
				if(st.getOfficial().getOffiId().equals(official.getOffiId())){
					stepstances2.add(st);
				}
			}
			int sum = 0;
			for(StepInstance st : stepstances2){
				if(st.getStatus()==2){
					sum++;
				}
			}

			if(sum==stepstances2.size()){
				if(stepINstances3.size()>0){			
					Integer insertBatch = stepInstanceService.insertBatch(stepINstances3);
				
					if(insertBatch==-1){
						request.setAttribute("result", "权限不足");

						return "forward:my_official.action";
					}
				}
			}
		}else{
			if(stepINstances3.size()>0){			
				Integer insertBatch = stepInstanceService.insertBatch(stepINstances3);
				if(insertBatch==-1){
					request.setAttribute("result", "权限不足");

					return "forward:my_official.action";
				}
			}
		}
		boolean b = false;
		for(StepInstance s : stepINstances3){
			StepTemplate findStep = stepTemplateService.findStep(s.getStep());

			if(findStep.getStepName().equals("结束")){
				b = true;
			}
		}

		//修改公文状态
		official.setOffiState(Official.ING);
		if(b){
			official.setOffiState(official.END);
		}
		Integer num = officialService.update(official);

		if(num==-1){
			request.setAttribute("result", "权限不足");

			return "forward:my_official.action";
		}
		
		//转发至我的公文
		return "forward:my_official.action";
	}

	/**
	 * 选择员工(提交公文)
	 * @throws Exception 
	 */
	@RequestMapping(value="official_commit_selectEmp.action")
	public void commitSelectEmp(HttpServletResponse response,
			Position pos,Official official,HttpServletRequest request) throws Exception{

		if(pos!=null&&pos.getPosName()!=null&&!pos.getPosName().equals("")){
			pos = deptService.findByPos(pos);
			
			//根据职位查询员工
			List<Employee> emps = employeeService.findAllByPos(pos);
			
			String string = JSON.toJSONString(emps);
			
			System.out.println("根据职位查询员工:\n"+string);
			
			response.getWriter().write(string);
		}else{
			//通知申请人
			official = officialService.findById(official.getOffiId());
			
			User user = userService.findById(official.getUser().getUserId());
			
			Employee employee = employeeService.findById(user.getEmp().getEmpId());
			
			List<Employee> emps = new ArrayList<Employee>();
			emps.add(employee);

			String string = JSON.toJSONString(emps);
			response.getWriter().write(string);
		}

	}

	/**
	 * 审批结果
	 * @throws Exception 
	 */
	@RequestMapping(value="official_approve_result.action")
	public void approveResult(HttpServletResponse response,
			Official official,Model model,HttpServletRequest request) throws Exception{

		//查询步骤实例
		List<StepInstance> stepInstances = stepInstanceService.findStepInstancesByOfficial(official);

		//查询审批历史
		List<Approve> approves = approveService.findByOffical(official);

		String result = "";

		int num = 0;
		if(stepInstances.size()>0){
			for(StepInstance stepInstance : stepInstances){
				StepTemplate findStep = stepTemplateService.findStep(stepInstance.getStep());

				if(findStep.getStepName().equals("结束")){
					num++;
				}
			}

			if(num==1){
				result="审批通过!";
			}else{
				result="审批中!";
			}
		}

		if(approves.size()>0){
			ok:
				for(Approve approve: approves){
					if(approve.getAgreeOrNot().equals(Approve.NO)){
						result="审批未通过!";

						break ok;
					}
				}

		}
		List<Object> list = new ArrayList<Object>();
		list.add(result);
		list.add(approves);

		String jsonString = JSON.toJSONString(list);
		response.getWriter().write(jsonString);
	}


	/**
	 * 删除公文
	 */
	@RequestMapping(value="official_delete.action")
	public String delete(Official official,HttpServletRequest request){

		//删除公文
		Integer i = officialService.delete(official);
		
		if(i==-1){
			request.setAttribute("result", "权限不足");

			return "forward:my_official.action";
		}

		List<Approve> approves = approveService.findByOffical(official);
		
		List<StepInstance> stepInstances = stepInstanceService.findStepInstancesByOfficial(official);
		
		FlowInstance flowInstance = flowInstanceService.findFlowInstance(official);
		
		//删除审批历史
		if(approves.size()>0){
			i = approveService.deleteBatch(approves);
			
			if(i==-1){
				request.setAttribute("result", "权限不足");

				return "forward:my_official.action";
			}
		}
		//删除步骤实例
		if(stepInstances.size()>0){
			//------------------------------------------------------
			i = stepInstanceService.deleteBatch(stepInstances);
			//------------------------------------------------------
			if(i==-1){
				request.setAttribute("result", "权限不足");

				return "forward:my_official.action";
			}
		}
		//删除流程实例
		if(flowInstance!=null){
			i = flowInstanceService.delete(flowInstance);
			if(i==-1){
				request.setAttribute("result", "权限不足");

				return "forward:my_official.action";
			}
		}

		//转发至我的公文
		return "forward:my_official.action";
	}

	/**
	 * 下载附件
	 * @throws Exception 
	 */
	@RequestMapping(value="official_down.action")
	public String down(Official official,
			HttpServletResponse response,HttpServletRequest request) throws Exception{

		official = officialService.findById(official.getOffiId());

		String mimeType = request.getSession().getServletContext().getMimeType("word.doc");

		response.setCharacterEncoding(mimeType);

		response.reset();
		//application/x-download
		response.setContentType("application/msword;charset=utf-8");
		response.setHeader("content-Disposition", "attachment;filename=official_"+official.getOffiId());
		response.getOutputStream().write(official.getAccessory());
		response.getOutputStream().flush();
		response.getOutputStream().close();

		//转发至我的公文
		return "forward:my_official.action";
	}

	/**
	 * 文件转换为字节数组
	 * @param file
	 * @return
	 */
	@SuppressWarnings("unused")
	private byte[] getBytesFromFile(File file) {
		byte[] bte = null;
		try {
			if(file==null) {
				return null;
			}
			FileInputStream in = new FileInputStream(file);
			ByteArrayOutputStream out = new ByteArrayOutputStream(4000);
			byte[] b = new byte[4000];
			int n;
			while((n=in.read(b))!=-1) {
				out.write(b, 0, n);
			}
			in.close();
			out.close();
			bte = out.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bte;
	}

}
