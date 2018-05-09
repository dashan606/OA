package com.ssm.OaManager.web.hrm;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.hrm.Leave;
import com.ssm.OaManager.service.hrm.EmployeeService;
import com.ssm.OaManager.service.hrm.LeaveService;
import com.ssm.OaManager.utils.PageBean;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.web.BaseController;

@Controller
public class LeaveController extends BaseController {
	@Resource
	private LeaveService leaveService;
	
	@Resource
	private EmployeeService employeeService;
	
	@Resource
	private PrivilegeFilter privilegeFilter;
	
	public void setPrivilegeFilterUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}
	
	@RequestMapping("/hrm/findAllLeaves.action")
	public String findAll(HttpServletRequest request){
		List<Leave>leaves = leaveService.findAll();
		request.setAttribute("leaves",leaves);
		return "/pages_hr/public_hr_leave.jsp";
	}
	
	@RequestMapping("/hrm/findLeaveById.action")
	public String findLeaveById(Integer leaId,HttpServletRequest request){
		PageBean<Employee> pageBean = new PageBean<Employee>();
		List<Employee>emps = employeeService.findByPage(pageBean);
		Leave leave = leaveService.findById(leaId);
		request.setAttribute("emps", emps);
	    request.setAttribute("leave",leave);
		return "/pages_hr/public_hr_leave_edit.jsp";
	}
	
	@RequestMapping("/hrm/updateLeave.action")
	public String updateEvection(Leave leave,HttpServletRequest request){
		
		setPrivilegeFilterUser(request);
		
		int update = leaveService.update(leave);
		
		if(update==-1){
			request.setAttribute("result", "权限不足！");
			
			return "/hrm/findAllLeaves.action";
		}
		
		return "redirect:/hrm/findAllLeaves.action";
	}
	
	@RequestMapping("/hrm/deleteLeave.action")
	public String deleteEvection(Integer leaId,HttpServletRequest request){
		
		setPrivilegeFilterUser(request);
		
		int deleteById = leaveService.deleteById(leaId);
		
		if(deleteById==-1){
			request.setAttribute("result", "权限不足！");
			
			return "/hrm/findAllLeaves.action";
		}
		
		return "redirect:/hrm/findAllLeaves.action";
	}
	
	@RequestMapping("/hrm/findEmpToLea.action")
	public String findEmps(HttpServletRequest request){
		PageBean<Employee> pageBean = new PageBean<Employee>();
		List<Employee>emps = employeeService.findByPage(pageBean);
		request.setAttribute("emps", emps);
		return "/pages_hr/public_hr_leave_add.jsp";
	}
	
	@RequestMapping("/hrm/insertLeave.action")
	public String insertEvection(Leave leave,HttpServletRequest request){
		
		setPrivilegeFilterUser(request);
		
		int insert = leaveService.insert(leave);
		
		if(insert==-1){
			request.setAttribute("result", "权限不足！");
			
			return "/hrm/findAllLeaves.action";
		}
		return "redirect:/hrm/findAllLeaves.action";
	}
	
	
	
	
}
