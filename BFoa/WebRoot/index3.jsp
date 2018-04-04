<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>OA系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="web/css/reset.css" />
</head>

<body>
	<form action="bfuser/user_login.action" method="post">
		<div
			style="background-image: url(web/imgs/loginimage.jpg); width: 1000px; height: 610px;">
			<input type="password" name="user.u_pwd"
				style="width: 90px; border: none; height: 13px; background-color: #ddeffd; position: absolute; left: 675px; top: 300px;" />
			<input name="image" type="image"
				style="position: absolute; left: 775px; top: 265px;"
				src="web/imgs/gobutton.jpg" /> 
			<input type="text" name="user.u_name"
				style="width: 90px; border: none; height: 13px; background-color: #ddeffd; position: absolute; left: 675px; top: 268px" />

			<div
				style="position: absolute; width: 400px; height: 145px; left: 460px; top: 428px; color: #FF3333; font-weight: bolder; line-height: 30px; font-size: 14px"
				align="center">
				推荐您使用firefox(火狐)浏览器，并使用1024 X 768<br /> 及其以上分辨率，以达到最佳显示效果。<br />
				Copy right 2018 张俊霞 黄河科技学院
			</div>
		</div>
		<form>
</body>
</html>
