package com.ssm.OaManager.web.system.accessory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.accessory.AflType;
import com.ssm.OaManager.entity.accessory.AskForLeave;
import com.ssm.OaManager.entity.accessory.ProjectAsk;
import com.ssm.OaManager.entity.accessory.ReimType;
import com.ssm.OaManager.entity.accessory.Reimburse;
import com.ssm.OaManager.service.system.accessory.AflTypeService;
import com.ssm.OaManager.service.system.accessory.AskForLeaveService;
import com.ssm.OaManager.service.system.accessory.ProjectAskService;
import com.ssm.OaManager.service.system.accessory.ReimTypeService;
import com.ssm.OaManager.service.system.accessory.ReimburseService;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.web.BaseController;

/**
 * 我的工作控制层
 * @author Administrator
 *
 */
@Controller
public class AccessoryController extends BaseController{

	//报销业务接口
	private ReimburseService reimburseService;

	//报销类型业务接口
	private ReimTypeService reimTypeService;

	//请假业务接口
	private AskForLeaveService askForLeaveService;

	private ProjectAskService projectAskService;

	//权限业务接口
	private PrivilegeFilter privilegeFilter;

	//请假类型业务接口
	private AflTypeService aflTypeService;

	@Resource
	public void setProjectAskService(ProjectAskService projectAskService) {
		this.projectAskService = projectAskService;
	}

	@Resource
	public void setPrivilegeFilter(PrivilegeFilter privilegeFilter) {
		this.privilegeFilter = privilegeFilter;
	}

	@Resource
	public void setAflTypeService(AflTypeService aflTypeService) {
		this.aflTypeService = aflTypeService;
	}

	@Resource
	public void setAskForLeaveService(AskForLeaveService askForLeaveService) {
		this.askForLeaveService = askForLeaveService;
	}

	@Resource
	public void setReimTypeService(ReimTypeService reimTypeService) {
		this.reimTypeService = reimTypeService;
	}

	@Resource
	public void setReimburseService(ReimburseService reimburseService) {
		this.reimburseService = reimburseService;
	}

	public void setPrivilegeFilterUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}

	/**
	 * 报销保存并导出word文档
	 * @param reimburse
	 * @param model
	 * @param reimType
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="accessory_reimburse_add.action")
	public String reimburseSave(Reimburse reimburse,Model model,
			ReimType reimType,User user,HttpServletRequest request,
			HttpServletResponse response,String money2) throws Exception{

		setPrivilegeFilterUser(request);

		user = (User) request.getSession().getAttribute("user");

		reimburse.setReimType(reimType);

		reimburse.setReApplicateionDate(new Date());
		reimburse.setUser(user);

		//添加报销并返回主键
		Integer i = reimburseService.add(reimburse);

		if(i==-1){
			request.setAttribute("result", "权限不足");

			return "forward:page/accessory/accessory_add.jsp";
		}

		reimburse = reimburseService.findByReimburse(reimburse);


		if(reimburse==null){
			request.setAttribute("result", "权限不足");

			return "forward:page/accessory/accessory_add.jsp";
		}

		//获取当前时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();

		String dateStr = format.format(date);

		String fileName = "reimburse_"+reimburse.getReMoney()+"_"+user.getUserName()+"_"+dateStr;
		request.setAttribute("fileName", fileName);

		request.setAttribute("reimburse", reimburse);
		request.setAttribute("user", user);
		request.setAttribute("money2", money2);


		return "forward:page/accessory/word/accessory_reimburse_word.jsp";

	}

	/**
	 * 请假保存并导出word文档
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="accessory_askforleave_add.action")
	public String askLeaveSave(Reimburse reimburse,Model model,
			User user,HttpServletRequest request,
			HttpServletResponse response,AskForLeave askLeave,AflType aflType) throws Exception{

		setPrivilegeFilterUser(request);

		user = (User) request.getSession().getAttribute("user");

		askLeave.setAflApplicationDate(new Date());
		askLeave.setAflType(aflType);
		askLeave.setUser(user);

		Integer i = askForLeaveService.insertAndGetId(askLeave);

		if(i==-1){
			request.setAttribute("result", "权限不足");

			return "forward:page/accessory/accessory_add.jsp";
		}

		askLeave = askForLeaveService.findByAskForLeave(askLeave);

		if(askLeave==null){
			request.setAttribute("result", "权限不足");

			return "forward:page/accessory/accessory_add.jsp";
		}

		//获取当前时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date aflStartDate = askLeave.getAflStartDate();
		Date aflEndDate = askLeave.getAflEndDate();

		String date = format.format(aflStartDate);
		String date2 = format.format(aflEndDate);


		//获取当前时间

		Date date3 = new Date();

		String dateStr = format.format(date3);

		String fileName = "askLeave_"+user.getUserName()+"_"+dateStr;
		request.setAttribute("fileName2", fileName);

		//计算日期相差天数
		int differentDays = differentDays(aflStartDate,aflEndDate);

		request.setAttribute("askLeave", askLeave);
		request.setAttribute("user", user);
		request.setAttribute("date", date);
		request.setAttribute("date2", date2);
		request.setAttribute("differentDays", differentDays);

		return "forward:page/accessory/word/accessory_askleave_word.jsp";

	}

	/**
	 * 项目资金申请保存并导出word文档
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="accessory_project_add.action")
	public String projectAskSave(Model model,
			HttpServletRequest request,ProjectAsk projectAsk,
			HttpServletResponse response,String money) throws Exception{

		setPrivilegeFilterUser(request);


		User user = (User) request.getSession().getAttribute("user");

		projectAsk.setProjectDate(new Date());
		projectAsk.setUser(user);


		Integer i = projectAskService.insertAndGetId(projectAsk);

		if(i==-1){
			request.setAttribute("result", "权限不足");

			return "forward:page/accessory/accessory_add.jsp";
		}

		projectAsk = projectAskService.findByProject(projectAsk);

		if(projectAsk==null){
			request.setAttribute("result", "权限不足");

			return "forward:page/accessory/accessory_add.jsp";
		}

		//获取当前时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();

		String dateStr = format.format(date);

		String fileName = "projectMoneyAsk_"+user.getUserName()+"_"+dateStr;
		request.setAttribute("fileName3", fileName);

		request.setAttribute("projectAsk", projectAsk);
		request.setAttribute("money", money);
		request.setAttribute("user", user);

		return "forward:page/accessory/word/accessory_projectask_word.jsp";

	}
	/**
	 * 返回请假类型
	 * @throws Exception 
	 */
	@RequestMapping(value="accessory_returnAskLeaveType.action")
	public void returnAskLeaveType(HttpServletResponse response) throws Exception{

		List<AflType> aflTypes = aflTypeService.findAll();

		JSONArray fromObject = JSONArray.fromObject(aflTypes);

		response.getWriter().write(fromObject.toString());
	}

	/**
	 * 返回请假类型
	 * @throws Exception 
	 */
	@RequestMapping(value="accessory_returnReimburseType.action")
	public void returnReimburseController(HttpServletResponse response) throws Exception{

		List<ReimType> reimTypes = reimTypeService.findAll();

		JSONArray fromObject = JSONArray.fromObject(reimTypes);

		response.getWriter().write(fromObject.toString());
	}

	public  int differentDays(Date date1,Date date2)
	{
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int day1= cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);

		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if(year1 != year2)   //同一年
		{
			int timeDistance = 0 ;
			for(int i = year1 ; i < year2 ; i ++)
			{
				if(i%4==0 && i%100!=0 || i%400==0)    //闰年            
				{
					timeDistance += 366;
				}
				else    //不是闰年
				{
					timeDistance += 365;
				}
			}

			return timeDistance + (day2-day1) ;
		}
		else    //不同年
		{
			System.out.println("判断day2 - day1 : " + (day2-day1));
			return day2-day1;
		}
	}
}
