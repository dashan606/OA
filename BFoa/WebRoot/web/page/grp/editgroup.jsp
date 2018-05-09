<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>OA系统-编辑组</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="web/css/reset.css" />
	<link rel="stylesheet" type="text/css" href="web/css/mainstyle.css" />
	<script type="text/javascript" src="web/js/mainjs.js"></script>
	<script type="text/javascript">
	  function t_sub() {
		  document.getElementById("form01").submit();
	  }
	</script>
  </head>
  
  <body>
    <div align="center">
    <form action="bfgrp/grp_updateGroup.action" method="post" id="form01">
	<table width="300" height="120">
		<tr>
			<td height="60" align="left" 
				style="background-image:url(web/imgs/editgroupbar.jpg);height:60px; line-height:60px">
				<div style="width:70px; height:60px; float:left"></div>
				<p  style="color:#0066ff; font-size:18px" class="textShadow">用户改组</p>
			</td>
		</tr>
		<tr>
			<td class="inputline" align="left">
				&nbsp;&nbsp;&nbsp;组名：
				<select name="gid" class="textbox"> 
					<s:iterator value="#request.groups">
					   <option value="<s:property value="g_id"/>"><s:property value="g_name"/></option>
					</s:iterator>
				</select>
			</td>
			<tr>
			   <td class="inputline" align="left">
			   &nbsp;账号名：
			      <input type="hidden" name="uid" value="<s:property value="#request.user.u_id"/>">
			      <input type="text" name="u_name" class="textbox" disabled="disabled" value="<s:property value="#request.user.u_name"/>">
			   </td>
			</tr>
		</tr>
		<tr>
			<td class="inputline" align="center">
			<div class="button" onmouseover="buttonHover(this,'web/')" onmouseout="buttonNormal(this,'web/')" onclick="t_sub()">
					提交
			</div>
			</td>
		</tr>
	</table>
	</form>
	</div>
  </body>
</html>