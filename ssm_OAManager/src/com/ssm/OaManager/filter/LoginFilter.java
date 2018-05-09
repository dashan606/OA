package com.ssm.OaManager.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssm.OaManager.entity.User;

public class LoginFilter implements Filter {

	public void doFilter(ServletRequest arg, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg;
		HttpServletResponse response = (HttpServletResponse) arg1;

		// 获得uri
		String uri = request.getRequestURI();
		// 获得最后一个/的下标
		Integer startLength = uri.lastIndexOf("/");
		// 截取/后的所有字符
		String clazzName = uri.substring(startLength + 1);
		// 获得session中的用户对象
		User user = (User) request.getSession().getAttribute("user");
		// 判断
		if ("login.jsp".equals(clazzName)
				|| "facelogin.action".equals(clazzName)
				|| "findByNp.action".equals(clazzName)
				|| "findByName.action".equals(clazzName)
				|| "regist.action".equals(clazzName)
				|| "active.action".equals(clazzName)
				|| "findEmail.action".equals(clazzName)
				|| "findUser.action".equals(clazzName)
				|| "checkCode.action".equals(clazzName)
				|| "findEmpIdByEmpName.action".equals(clazzName)
				|| "lockuser.action".equals(clazzName)
				|| "findUser.jsp".equals(clazzName)
				|| "success.jsp".equals(clazzName)
				|| "updateUser.action".equals(clazzName)) {
			// 放行
			chain.doFilter(request, response);
		} else {
			if (user == null) {
				// 重定向
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			} else {
				// 放行
				chain.doFilter(request, response);
			}
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void destroy() {

	}

}
