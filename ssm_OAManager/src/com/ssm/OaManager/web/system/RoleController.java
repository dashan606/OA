package com.ssm.OaManager.web.system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.privilege.Function;
import com.ssm.OaManager.entity.privilege.Role;
import com.ssm.OaManager.service.system.FunctionService;
import com.ssm.OaManager.service.system.RoleService;
import com.ssm.OaManager.utils.PrivilegeFilter;

@Controller
public class RoleController {
	@Resource
	private FunctionService functionService;
	
	@Resource
	private RoleService roleService;

	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@Resource
	private PrivilegeFilter privilegeFilter;
	
	public void setPrivilegeFilterUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}
	
	/**
	 * 分页查询全部
	 * @param currentPage
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/sys_privilege/findByRolePage.action")
	public String findByPage(String currentPage, Model model){
		
		List<Role> role = this.roleService.findAll();
		
		model.addAttribute("pageBean", role);
		
		return "/sys_privilege/oa_role_list.jsp";
		
	}
	
	/**
	 * 角色添加
	 * @param role
	 * @param request
	 * @return
	 */
	@RequestMapping("/sys_privilege/saveRole.action")
	public String insert(Role role,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		String[] funIds = request.getParameterValues("funId");
		
		int num = this.roleService.insert(role,funIds);
		if(num==-1){
			request.setAttribute("result", "权限不足！");
		}
		return "/sys_privilege/findByRolePage.action";
	}
	
	/**
	 * 根据ID删除
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/sys_privilege/deleteRole.action")
	public String deleteById(Integer id,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		int num = this.roleService.deleteById(id);
		if(num==-1){
			request.setAttribute("result", "权限不足！");
		}
		return "/sys_privilege/findByRolePage.action";
	}
	
	@RequestMapping("/sys_privilege/findFunctionAll.action")
	public String findFunctionAll(Model model,HttpServletResponse response,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		try {
			List<Function> functions1 = functionService.findAll();
			if(functions1==null){
				response.getWriter().write("1");
			}else{
				String functions = JSON.toJSONString(functions1);
				// 发送给客户端
				response.getWriter().write(functions);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/sys_privilege/findByRoleId.action")
	public String findById(Integer id,HttpServletResponse response,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		try {
			List<Object> obj = new ArrayList<Object>();
			Role role = this.roleService.findById(id);
			List<Function> functions1 = functionService.findAll();
			obj.add(role);
			if(role.getFunctions()!=null){
				for (Function fun : role.getFunctions()) {
					for (int i = 0; i < functions1.size(); i++) {
						Function fun2 = functions1.get(i);
						if (fun2.getFunId()==fun.getFunId()) {
							functions1.remove(i);
						}
					}
				}
			}
			obj.add(functions1);
			if(role==null){
				response.getWriter().write("1");
			}else{
				String functions = JSON.toJSONString(obj);
				// 发送给客户端
				response.getWriter().write(functions);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 角色修改
	 * @param role
	 * @param request
	 * @return
	 */
	@RequestMapping("/sys_privilege/updateRole.action")
	public String update(Role role,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		String[] funIds = request.getParameterValues("funId");
		
		int num = this.roleService.updateRole(role,funIds);
		if(num==-1){
			request.setAttribute("result", "权限不足！");
			return "/sys_privilege/findByRolePage.action";
		}
		return "/view/user/findByNp.action?str=ur";
	}

}
