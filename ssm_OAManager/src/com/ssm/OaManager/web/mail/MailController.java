package com.ssm.OaManager.web.mail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.mail.Attachment;
import com.ssm.OaManager.entity.mail.Mail;
import com.ssm.OaManager.entity.mail.MailAddr;
import com.ssm.OaManager.entity.mail.UserAuthenticator;
import com.ssm.OaManager.mailfun.ReveiceMail;
import com.ssm.OaManager.mailfun.SendMail;
import com.ssm.OaManager.mailfun.mail.MailService;
import com.ssm.OaManager.service.system.UserService;
import com.ssm.OaManager.utils.MailUtil;
import com.ssm.OaManager.utils.PrivilegeFilter;

@Controller
public class MailController {

	@Resource
	private UserService userService;

	@Resource
	private MailService mailService;

	@Resource
	private PrivilegeFilter privilegeFilter;

	public void setPrivilegeFilterUser(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}
	
	// 邮箱授权登录
	@RequestMapping("/mailLogin.action")
	public String mailLogin(HttpServletRequest request) {

		String mailAddr = request.getParameter("mailAddr");
		String mailPass = request.getParameter("mailPass");

		UserAuthenticator userAuth = new UserAuthenticator();
		userAuth.setMailAddr(mailAddr);
		userAuth.setMailPass(mailPass);

		try {
			// 连接SMTP服务
			SendMail sendMail = new SendMail();
			Session session = null;
			session = sendMail.connectSMTP(userAuth, "SMTP");
			request.getSession().setAttribute("SMTPSession", session);

			// 连接POP3服务
			ReveiceMail reveiceMail = new ReveiceMail();
			Folder folder = null;
			folder = reveiceMail.connectPOP3(userAuth, "POP3");
			request.getSession().setAttribute("folder", folder);

		} catch (MessagingException e) {
			request.setAttribute("cuo", "认证失败：" + e.getMessage());
			return "/pages_mail/mail_login.jsp";
		}

		// 将认证用户放入session域中
		request.getSession().setAttribute("userAuth", userAuth);
		// 收件箱
		return "/ReveiceMails.action";

	}

	// 获取所有用户
	@RequestMapping("/queryUser.action")
	public void queryUser(HttpServletResponse response) throws IOException {

		List<User> list = userService.findAll();

		String listJson = JSON.toJSONString(list);

		// 发送
		response.getWriter().write(listJson);
	}

	// 发件
	@RequestMapping("/sendEmails.action")
	public String sendEmails(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		setPrivilegeFilterUser(request);
		// 参数
		String reveicer = "";
		String reveicerAddr = "";
		String sereveicer = "";
		String sereveicerAddr = "";
		String anreveicer = "";
		String anreveicerAddr = "";
		String subject = "";
		String content = "";
		String filePath = "";
		String fileName = "";

		// 1.创建工厂对象
		FileItemFactory factory = new DiskFileItemFactory();
		// 2.文件上传核心工具类
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 判断是否是上传的表单
		// 表单添加 enctype="multipart/form-data" 才能上传表单数据
		if (upload.isMultipartContent(request)) {
			// 把请求数据转换成list集合
			List<FileItem> list = upload.parseRequest(request);

			// 3.设置上传文件大小限制
			upload.setFileSizeMax(10 * 1024 * 1024);// 单个文件大小限制
			upload.setSizeMax(50 * 1024 * 1024);// 总文件大小限制
			upload.setHeaderEncoding("UTF-8");// 对中文文件编码处理

			// FileItem代表请求的内容
			for (FileItem item : list) {
				// jsp name属性值
				String name = item.getFieldName();
				// jsp 属性对应的value值
				String value = new String(item.getString()
						.getBytes("iso8859-1"), "utf-8");

				// 保存其他表单数据
				if ("reveicer".equals(name)) {
					reveicer = value;
				}

				if ("reveicerAddr".equals(name)) {
					reveicerAddr = value;
				}

				if ("sereveicer".equals(name)) {
					sereveicer = value;
					if (!MailUtil.isNotNull(sereveicer)) {
						sereveicer = "无";
					}
				}
				if ("sereveicerAddr".equals(name)) {
					sereveicerAddr = value;
				}
				if ("anreveicer".equals(name)) {
					anreveicer = value;
					if (!MailUtil.isNotNull(anreveicer)) {
						anreveicer = "无";
					}
				}
				if ("anreveicerAddr".equals(name)) {
					anreveicerAddr = value;
				}
				if ("subject".equals(name)) {
					subject = value;
					// 若主题为空
					if (!MailUtil.isNotNull(subject)) {
						subject = "无主题";
					}
				}
				if ("content".equals(name)) {
					content = value;
				}

				// 判断是否上传
				if (MailUtil.isNotNull(item.getName())) {
					if (!item.isFormField()) {

						// 获取tomcat所在工程的真实绝对路径
						String realPath = request.getSession()
								.getServletContext().getRealPath("/");

						// 获得文件名
						fileName = item.getName();

						// 上传文件在tomcat的路径
						filePath = realPath + "/upload/" + item.getName();
						// 把item的文件内容写入另一个文件
						// 创建文件
						File newFile = new File(filePath);
						item.write(newFile);
						item.delete();// 删除临时文件

					}
				}
			}
		}

		// 用户session中取出的名字
		User user = (User) request.getSession().getAttribute("user");
		String sender = user.getEmp().getEmpName();

		Mail mail = new Mail();
		mail.setSender(sender);
		mail.setReveicer(reveicer);
		mail.setSereveicer(sereveicer);
		mail.setAnreveicer(anreveicer);
		mail.setSubject(subject);
		mail.setContent(content);
		mail.setTime(getNowTime());
		mail.setAttachment(fileName);
		mail.setMtype(0);// 已发
		// filePath文件的名字设值到mail中

		UserAuthenticator userAuth = (UserAuthenticator) request.getSession()
				.getAttribute("userAuth");

		// 封装地址
		MailAddr mailAddr = new MailAddr();
		mailAddr.setReveiceAddr(reveicerAddr);
		mailAddr.setSereveicerAddr(sereveicerAddr);
		mailAddr.setAnreveicerAddr(anreveicerAddr);

		// 获取SMTPSession
		Session session = (Session) request.getSession().getAttribute(
				"SMTPSession");

		// 发邮件
		SendMail sendMail = new SendMail();
		boolean bo = sendMail.sendMails(session, userAuth, mail, mailAddr,
				filePath);
		if (bo) {
			// 保存到发件箱
			mailService.insert(mail);
			request.setAttribute("dui", "邮件发送成功！");
		} else {
			request.setAttribute("cuo", "邮件发送失败！");
		}
		return "/pages_mail/mail_add.jsp";
	}

	// 调用连接POP3服务
	@RequestMapping("/ReveiceMails.action")
	public String ReveiceMails(HttpServletRequest request) throws Exception {
		List<Mail> objs = getMails(request);

		request.setAttribute("objs", objs);

		return "/pages_mail/mail_flow.jsp";
	}

	// 解析邮件头消息，包括判断是否有附件
	@RequestMapping("/ParseMail.action")
	public String ParseMail(HttpServletRequest request)
			throws MessagingException, IOException {

		Integer mailId = Integer.parseInt(request.getParameter("mailId"));
		Folder folder = (Folder) request.getSession().getAttribute("folder");

		if (!folder.isOpen()) {
			folder.open(Folder.READ_WRITE);
		}

		Message message = folder.getMessage(mailId);

		// 封装到对象
		Mail mail = new Mail();

		String from = getFroms(message);
		String subject = message.getSubject();
		String sentDate = getSentDate(message, null);
		mail.setSender(from);
		mail.setSubject(subject);
		mail.setTime(sentDate);

		// 邮件正文
		StringBuffer content = new StringBuffer(30);
		getMailTextContent(message, content);
		mail.setContent(content.toString());

		// 邮件中包含附件，解析
		// 如果该邮件是组合型"multipart/*"则可能包含附件等
		List<Attachment> list = null;

		if (message.isMimeType("multipart/*")) {
			Multipart multipart = (Multipart) message.getContent();
			int bodyCounts = multipart.getCount();

			list = new ArrayList<Attachment>();

			for (int i = 0; i < bodyCounts; i++) {
				BodyPart bodypart = multipart.getBodyPart(i);
				// 如果该BodyPart对象包含附件，则应该解析出来
				if (bodypart.getDisposition() != null) {
					String filename = bodypart.getFileName();
					if (filename.startsWith("=?")) {
						// 把文件名编码成符合RFC822规范
						filename = MimeUtility.decodeText(filename);
					}
					// 生成打开附件的超链接
					Attachment attach = new Attachment();
					attach.setMsgNum(mailId);
					attach.setBodyNum(i);// bodynum
					attach.setFileName(filename);
					list.add(attach);
				}
			}
		}

		if (folder.isOpen()) {
			folder.close(false);
		}

		request.setAttribute("mail", mail);
		request.setAttribute("list", list);

		return "/pages_mail/mail_detail.jsp";
	}

	// 处理附件
	@RequestMapping("/HandleAttachments.action")
	public String HandleAttachments(HttpServletRequest request,
			HttpServletResponse response) throws MessagingException,
			IOException {

		Integer mailId = Integer.parseInt(request.getParameter("mailId"));
		int bodynum = Integer.parseInt(request.getParameter("bodynum"));
		String filename = request.getParameter("filename");

		Folder folder = (Folder) request.getSession().getAttribute("folder");

		if (!folder.isOpen()) {
			folder.open(Folder.READ_WRITE);
		}

		Message message = folder.getMessage(mailId);

		// 通过文件名获得文件的格式
		String contentType = request.getSession().getServletContext()
				.getMimeType(filename);
		// 设置回传文件的格式
		response.setContentType(contentType);
		// 将消息头类型设置为附件类型
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename);

		Multipart multipart = (Multipart) message.getContent();
		BodyPart bodypart = multipart.getBodyPart(bodynum);

		InputStream input = bodypart.getInputStream();

		ServletOutputStream out = response.getOutputStream();
		byte[] bs = new byte[100];
		while ((input.read(bs)) != -1) {
			out.write(bs);
			out.flush();
		}
		out.close();
		if (folder.isOpen()) {
			folder.close(false);
		}

		return "/pages_mail/mail_detail.jsp";
	}

	// 收件箱列表 邮件头信息
	public List<Mail> getMails(HttpServletRequest request)
			throws MessagingException, UnsupportedEncodingException {

		List<Mail> msgs = null;

		Folder folder = (Folder) request.getSession().getAttribute("folder");
		if (!folder.isOpen()) {
			folder.open(Folder.READ_ONLY);
		}

		Message[] messages = folder.getMessages();
		for (int i = 0; i < messages.length; i++) {
			if (msgs == null) {
				msgs = new ArrayList<Mail>();
			}
			Mail mail = new Mail();
			if (messages[i].getFlags().equals(Flags.Flag.DELETED)) {
				continue;
			}

			mail.setMailId(i + 1);
			mail.setSender(getFroms(messages[i]));
			mail.setSubject(messages[i].getSubject());
			mail.setTime(getSentDate(messages[i], null));
			msgs.add(mail);
		}
		if (folder.isOpen()) {
			folder.close(false);// 关闭 false 不删除邮件
		}

		return msgs;
	}

	// 获得邮件文本内容
	public void getMailTextContent(Part part, StringBuffer content)
			throws MessagingException, IOException {

		boolean isContainTextAttach = part.getContentType().indexOf("name") > 0;

		if (part.isMimeType("text/*") && !isContainTextAttach) {

			content.append(part.getContent().toString());

		} else if (part.isMimeType("message/rfc822")) {

			getMailTextContent((Part) part.getContent(), content);

		} else if (part.isMimeType("multipart/*")) {

			Multipart multipart = (Multipart) part.getContent();
			int partCount = multipart.getCount();

			for (int i = 0; i < partCount; i++) {

				BodyPart bodyPart = multipart.getBodyPart(i);
				getMailTextContent(bodyPart, content);
			}

		}
	}

	/**
	 * 处理发送时间
	 * 
	 * @param messages
	 * @param pattern
	 * @return
	 * @throws MessagingException
	 */
	public String getSentDate(Message messages, String pattern)
			throws MessagingException {
		Date receivedDate = messages.getSentDate();
		if (receivedDate == null)
			return "";

		if (pattern == null || "".equals(pattern))
			pattern = "yyyy年MM月dd日 E HH:mm ";

		return new SimpleDateFormat(pattern).format(receivedDate);
	}

	/**
	 * 处理其他时间
	 * 
	 * @return
	 */
	public String getNowTime() {
		return new SimpleDateFormat("yyyy年MM月dd日 E HH:mm ").format(new Date());
	}

	/**
	 * 获取邮件发件人
	 * 
	 * @param messages
	 * @return
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public String getFroms(Message messages) throws MessagingException,
			UnsupportedEncodingException {
		String from = "";
		Address[] froms = messages.getFrom();
		if (froms.length < 1)
			throw new MessagingException("没有发件人!");

		InternetAddress address = (InternetAddress) froms[0];
		String person = address.getPersonal();
		if (person != null) {
			person = MimeUtility.decodeText(person) + " ";
		} else {
			person = "";
		}
		from = person + " < " + address.getAddress() + " > ";

		return from;
	}

	// 删除邮件
	@RequestMapping("/deleteMail.action")
	public String deleteMail(HttpServletRequest request)
			throws MessagingException {

		Integer mailId = Integer.parseInt(request.getParameter("mailId"));
		Folder folder = (Folder) request.getSession().getAttribute("folder");
		if (!folder.isOpen()) {
			folder.open(Folder.READ_WRITE);
		}

		Message message = folder.getMessage(mailId);
		message.setFlag(Flags.Flag.DELETED, true);// 把邮件标记为删除

		if (folder.isOpen()) {
			folder.close(true);
		}

		return "/ReveiceMails.action";
	}

	// 登出
	@RequestMapping("/loginOut.action")
	public String loginOut(HttpServletRequest request)
			throws MessagingException {

		// 处理POP3服务关闭
		// 获取folder
		Folder folder = (Folder) request.getSession().getAttribute("folder");

		if (folder.isOpen()) {
			folder.close(true);
		}

		ReveiceMail reveiceMail = new ReveiceMail();
		reveiceMail.closeStore();// 关闭收件箱连接

		request.getSession().removeAttribute("folder");

		// 处理SMTP服务关闭
		request.getSession().removeAttribute("session");
		// 移除认证用户
		request.getSession().removeAttribute("userAuth");

		return "/index.jsp";
	}

	// 判断邮箱是否登录
	@RequestMapping("/ResultSession.action")
	public String ResultSession(HttpServletRequest request) throws Exception {

		// 获得pop3服务 folder
		Folder folder = (Folder) request.getSession().getAttribute("folder");
		if (folder == null) {
			request.setAttribute("result", "没有登录");
			return "/pages_mail/mail_login.jsp";
		}
		return "/ReveiceMails.action";
	}

}
