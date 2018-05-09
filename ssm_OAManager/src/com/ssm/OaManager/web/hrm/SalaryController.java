package com.ssm.OaManager.web.hrm;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.hrm.Salary;
import com.ssm.OaManager.entity.hrm.SalaryInfo;
import com.ssm.OaManager.service.hrm.SalaryService;
import com.ssm.OaManager.utils.PrivilegeFilter;

@Controller
public class SalaryController {

	@Resource
	private SalaryService salaryService;

	@Resource
	private PrivilegeFilter privilegeFilter;

	public void setPrivilegeFilterUser(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}

	@RequestMapping("/hrm/findToSal.action")
	public String findToSal(HttpServletRequest request) {
		List<SalaryInfo> list = salaryService.findToSal();
		request.setAttribute("list", list);
		return "/pages_hr/public_hr_salaryInfo.jsp";
	}

	@RequestMapping("/hrm/insertSal.action")
	public void insertSal(Salary salary, HttpServletResponse response,
			HttpServletRequest request) throws IOException {

		setPrivilegeFilterUser(request);

		Integer i = salaryService.insert(salary);

		if (i == -1) {
			response.getWriter().write("权限不足");
		}

		response.getWriter().write(i.toString());
	}

	@RequestMapping("/hrm/findSal.action")
	public String findSal(HttpServletRequest request) {
		List<Salary> list = salaryService.findAll();
		request.setAttribute("list", list);
		return "/pages_hr/public_hr_salary.jsp";
	}
}
