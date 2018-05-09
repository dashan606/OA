package com.ssm.OaManager.web.system;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.privilege.Function;
import com.ssm.OaManager.service.system.FunctionService;
import com.ssm.OaManager.utils.PrivilegeFilter;

@Controller
public class FunctionController {
	@Resource
	private FunctionService functionService;

	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}
	
	@Resource
	private PrivilegeFilter privilegeFilter;
	
	public void setPrivilegeFilterUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}
	
	/**
	 * 分页查询所有
	 * @param currentPage
	 * @param model
	 * @return
	 */
	@RequestMapping("/sys_privilege/findByFunPage.action")
	public String findByPage(String currentPage, Model model){
		
		List<Function> pageBean = this.functionService.findAll();
		
		model.addAttribute("pageBean", pageBean);
		
		return "/sys_privilege/oa_function_list.jsp";
	}
	
	/**
	 * 添加功能
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/sys_privilege/saveFun.action")
	public String insert(Function function,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		function.setFunForbidden(0);
		int num = this.functionService.insert(function);
		if(num==-1){
			request.setAttribute("result", "权限不足！");
		}
		return "/sys_privilege/findByFunPage.action";
	}
	
	/**
	 * 根据ID删除
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/sys_privilege/deleteById.action")
	public String deleteById(Integer id,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		int num = this.functionService.deleteById(id);
		if(num==-1){
			request.setAttribute("result", "权限不足！");
		}
		return "/sys_privilege/findByFunPage.action";
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/sys_privilege/findByFunId.action")
	public String findByFunId(Integer id,HttpServletRequest request){

		Function function = this.functionService.findById(id);
		request.setAttribute("function", function);
		
		return "/sys_privilege/oa_function_add.jsp";
	}
	
	/**
	 * 修改功能
	 * @param function
	 * @param request
	 * @return
	 */
	@RequestMapping("/sys_privilege/updateFun.action")
	public String updateFun(Function function,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		function.setFunForbidden(0);
		
		int num = this.functionService.update(function);
		if(num==-1){
			request.setAttribute("result", "权限不足！");
		}
		return "/sys_privilege/findByFunPage.action";
	}

	/**
	 * 修改功能
	 * @param function
	 * @param request
	 * @return
	 */
	@RequestMapping("/sys_privilege/updateFunction.action")
	public String updateFunction(Function function,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		int num = this.functionService.findFunction(function);
		if(num==-1){
			request.setAttribute("result", "权限不足！");
		}
		return "/view/user/findByNp.action?str=js";
	}

}
