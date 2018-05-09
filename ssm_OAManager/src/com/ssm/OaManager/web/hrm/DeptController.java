package com.ssm.OaManager.web.hrm;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.hrm.Department;
import com.ssm.OaManager.service.hrm.DeptService;
import com.ssm.OaManager.utils.PrivilegeFilter;

@Controller
public class DeptController {
	@Resource
	private DeptService service;

	public void setService(DeptService service) {
		this.service = service;
	}
	
	@Resource
	private PrivilegeFilter privilegeFilter;
	
	public void setPrivilegeFilterUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}

	/**
	 * 查看所有数据
	 * @param model
	 * @return
	 */
	@RequestMapping("/pages_hr/findDeptAll.action")
	public String PagingAll(Model model) {
		List<Department> pageBean = this.service.findAll();
		
		model.addAttribute("pageBean",pageBean);
		
		return "/pages_hr/public_hr_department.jsp";
	}
	
	/**
	 * 添加数据
	 * @param department
	 * @param request
	 * @return
	 */
	@RequestMapping("/pages_hr/insertDept.action")
	public String insert(Department department,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		
		int num = this.service.insert(department);
		
		if(num==-1){
			request.setAttribute("result", "权限不足！");
		}
		
		return "/pages_hr/findDeptAll.action";
		
	}
	
	@RequestMapping("/pages_hr/findByDeptId.action")
	public String findById(Integer id,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		
		Department dept = this.service.findById(id);
		
		request.setAttribute("dept", dept);
		
		return "/pages_hr/public_hr_department_edit.jsp";
		
	}
	
	/**
	 * 修改功能
	 * @param function
	 * @param request
	 * @return
	 */
	@RequestMapping("/pages_hr/updateDept.action")
	public String update(Department dept,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		
		int num = this.service.update(dept);
		if(num==-1){
			request.setAttribute("result", "权限不足！");
		}
		return "/pages_hr/findDeptAll.action";
	}
	
	/**
	 * 根据id删除
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/pages_hr/deleteByDeptId.action")
	public String deleteById(Integer id,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		
		int num = this.service.deleteById(id);
		if(num==-1){
			request.setAttribute("result", "权限不足！");
		}else if(num==-2){
			request.setAttribute("message", "删除失败，该部门被引用");
		}
		
		return "/pages_hr/findDeptAll.action";
	}
	
	
}
