package com.ssm.OaManager.web.hrm;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.hrm.Evection;
import com.ssm.OaManager.service.hrm.EmployeeService;
import com.ssm.OaManager.service.hrm.EvectionService;
import com.ssm.OaManager.utils.PageBean;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.web.BaseController;

@Controller
public class EvectionController extends BaseController{

	@Resource
	private EvectionService evectionService;

	@Resource
	private EmployeeService employeeService;

	@Resource
	private PrivilegeFilter privilegeFilter;

	public void setPrivilegeFilterUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}

	@RequestMapping("/hrm/findAllEvections.action")
	public String findAll(HttpServletRequest request){
		List<Evection>evections = evectionService.findAll();
		request.setAttribute("evections",evections);
		return "/pages_hr/public_hr_evection.jsp";
	}

	@RequestMapping("/hrm/findEvectionById.action")
	public String findEvectionById(Integer eveId,HttpServletRequest request){
		PageBean<Employee> pageBean = new PageBean<Employee>();
		List<Employee>emps = employeeService.findByPage(pageBean);
		Evection evection = evectionService.findById(eveId);
		request.setAttribute("emps", emps);
		request.setAttribute("eve",evection);
		return "/pages_hr/public_hr_evection_edit.jsp";
	}

	@RequestMapping("/hrm/updateEvection.action")
	public String updateEvection(Evection evection,HttpServletRequest request){

		setPrivilegeFilterUser(request);

		int update = evectionService.update(evection);

		if(update==-1){

			request.setAttribute("result", "权限不足!");

			return "/hrm/findAllEvections.action";
		}

		return "redirect:/hrm/findAllEvections.action";
	}

	@RequestMapping("/hrm/deleteEvection.action")
	public String deleteEvection(Integer eveId,HttpServletRequest request){

		setPrivilegeFilterUser(request);

		int deleteById = evectionService.deleteById(eveId);

		if(deleteById==-1){

			request.setAttribute("result", "权限不足!");

			return "/hrm/findAllEvections.action";
		}

		return "redirect:/hrm/findAllEvections.action";
	}

	@RequestMapping("/hrm/findEmpToEve.action")
	public String findEmps(HttpServletRequest request){
		PageBean<Employee> pageBean = new PageBean<Employee>();
		List<Employee>emps = employeeService.findByPage(pageBean);
		request.setAttribute("emps", emps);
		return "/pages_hr/public_hr_evection_add.jsp";
	}

	@RequestMapping("/hrm/insertEvection.action")
	public String insertEvection(Evection evection,HttpServletRequest request){

		setPrivilegeFilterUser(request);

		int insert = evectionService.insert(evection);

		if(insert==-1){

			request.setAttribute("result", "权限不足!");

			return "/hrm/findAllEvections.action";
		}

		return "redirect:/hrm/findAllEvections.action";
	}


}
