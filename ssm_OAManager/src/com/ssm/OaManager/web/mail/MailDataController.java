package com.ssm.OaManager.web.mail;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.mail.Mail;
import com.ssm.OaManager.mailfun.mail.MailService;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.utils.PrivilegeFilter;

/***
 * 以下为本地服务 数据库
 * 
 * @author TH
 * 
 */
@Controller
public class MailDataController {

	@Resource
	private MailService mailService;
	
	@Resource
	private PrivilegeFilter privilegeFilter;

	public void setPrivilegeFilterUser(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}

	//发件箱删除
	@RequestMapping("/deleteSendMail.action")
	public String deleteSendMail(HttpServletRequest request){
		setPrivilegeFilterUser(request);
		Integer mailId =Integer.parseInt(request.getParameter("mailId"));
		
		//从发件箱删除
	int num=	mailService.deleteById(mailId);
	if (num == -1) {
		request.setAttribute("result", "权限不足！");
	}	
	
		return "/querySendMails.action";
	}

	// 对象查
	@RequestMapping("/queryOneSend.action")
	public String queryOneSend(HttpServletRequest request) {

		Integer mailId = Integer.parseInt(request.getParameter("mailId"));

		Mail mail = mailService.findById(mailId);
		request.setAttribute("mail", mail);

		return "/pages_mail/mail_senddetail.jsp";
	}

	// 发件箱 查询所有
	@RequestMapping("/querySendMails.action")
	public String querySendMails(HttpServletRequest request) {

		Mail mail = new Mail();
		// 获取session 用户名封装到mail实例
		// 0 已发
		mail.setMtype(0);
		List<Mail> list = mailService.findPart(mail);
		request.setAttribute("list", list);

		return "/pages_mail/mail_send.jsp";
	}

}
