<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OA系统-登录页-主体部分</title>

<link href="../../css/login_main.css" rel="stylesheet" type="text/css">

<script type="application/x-javascript">
	 
	addEventListener("load", function() {
					setTimeout(hideURLbar, 0); }, false); 
	function hideURLbar(){ window.scrollTo(0,1); } 

</script>


</head>
<body>

	<!--start-main-->

	<div class="login-04">
		<div class="fourth-login">
			<form class="four" action="bfuser/user_login.action" method="post">
				<div class="green">
					<input type="text" name="user.u_name" class="text" value="USERNAME"
						onfocus="this.value = '' "
						onblur="if (this.value == '' ) {this.value = 'USERNAME'}">
				</div>
				<div class="block">
					<input type="password" name="user.u_pwd" value="PASSWORD"
						onfocus="this.value = '' "
						onblur="if (this.value == '' ) {this.value = 'PASSWORD'}">
				</div>
				<input type="submit" value="LOG IN">
			</form>
		</div>
	</div>


	<!--//End-login-form-->



</body>
</html>