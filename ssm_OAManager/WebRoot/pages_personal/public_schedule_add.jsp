<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="cn">
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>日程添加</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<jsp:include page="/media/ui_css.jsp"></jsp:include>
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/media/css/select2_metro.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/media/css/DT_bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/media/css/datepicker.css" />
<link
	href="${pageContext.request.contextPath}/media/css/jquery.fancybox.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/media/css/search.css"
	rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/zdialog.css" />
<!-- END PAGE LEVEL STYLES -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<jsp:include page="/main_pages/top.jsp"></jsp:include>
	<!-- BEGIN 容器 -->
	<div class="page-container row-fluid">
		<jsp:include page="/main_pages/leftdel.jsp"></jsp:include>
		<!-- BEGIN 开始页面-->
		<div class="page-content">
			<!-- ---------------------------------------------- -->
			<!-- BEGIN 页面容器-->
			<div class="container-fluid">
				<!-- BEGIN 页面标题-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN 风格定制 -->
						<jsp:include page="/main_pages/styleset.jsp"></jsp:include>
						<!-- END 风格定制 -->
						<!-- BEGIN 网页的标题和面包屑-->
						<!-- BEGIN 网页的标题和面包屑-->
						<h3 class="page-title">
							日程<small>添加日程</small>
						</h3>
						<ul class="breadcrumb">
							<li><i class="icon-home"></i> <a
								href="${pageContext.request.contextPath}/sys_schedule/findBySchedulePage.action">My日程</a>
								<i class="icon-angle-right"></i> <a
								href="${pageContext.request.contextPath}/sys_schedule/findByScheduleAll.action">日程列表</a>
						</ul>
						<!-- END 网页的标题和面包屑-->
					</div>
				</div>
				<!-- END 页面标题-->
				<!-- BEGIN 智能搜索 -->
				<!-- BEGIN PAGE CONTENT-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN SAMPLE FORM PORTLET-->
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-reorder"></i>添加日程
								</div>
							</div>
							<div class="portlet-body form">
								<!-- BEGIN FORM-->
								<form
									action="${pageContext.request.contextPath}/sys_schedule/saveSchedule.action"
									method="post" class="form-horizontal">
									<h3 class="form-section">日程信息</h3>
									<div class="row-fluid">
										<div class="span12 ">
											<div class="control-group">
												<label class="control-label">日程标题：</label>
												<div class="controls">
													<input type="text" class="m-wrap span10" placeholder="必填"
														id="register_password" name="scheduleDesprict">
												</div>
											</div>
										</div>
										<!--/span-->
									</div>
									<div class="row-fluid">
										<div class="span12">
											<div class="row-fluid">
												<div class="span3 ">
													<div class="control-group">
														<label class="control-label">发布时间</label>
														<div class="controls">
															<div class="input-append date date-picker"
																data-date-format="yyyy-mm-dd" data-date-viewmode="years">
																<input name="scheduleDate" placeholder="请选择"
																	id="rest_password"
																	class="m-wrap m-ctrl-medium date-picker" size="16"
																	type="text" /><span class="add-on"><i
																	class="icon-calendar"></i> </span>
															</div>
														</div>
													</div>
												</div>
												<!--/span-->
											</div>
											<!--/row-->
											<br />
										</div>
										<!--end booking-search-->
									</div>
									<!--/span-->
									<div class="form-actions">
										<button type="submit" id="submit-button" class="btn green">
											<i class="icon-ok"></i>保存
										</button>
										<button type="reset" class="btn">重置</button>
										<button type="button" onclick="history.back()"
											class="btn blue">返回</button>
									</div>
								</form>
								<!-- END FORM-->
							</div>
						</div>
						<!-- END SAMPLE FORM PORTLET-->
					</div>
				</div>
				<!-- END PAGE CONTENT-->
				<!--end row-fluid-->
			</div>
		</div>
		<!-- END SAMPLE TABLE PORTLET-->
	</div>
	<!-- END 页面容器-->
	<!-- --------------------------------------------------------- -->
	<!-- END 页面 -->
	<!-- END 容器 -->
	<jsp:include page="/main_pages/foot.jsp"></jsp:include>
	<jsp:include page="/media/ui_js.jsp"></jsp:include>
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/media/js/select2.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/media/js/jquery.dataTables.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/media/js/DT_bootstrap.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/media/js/search.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/media/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/media/js/jquery.fancybox.pack.js"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<script src="${pageContext.request.contextPath}/media/js/app.js"></script>
	<script
		src="${pageContext.request.contextPath}/media/js/form-samples.js"></script>
	<script
		src="${pageContext.request.contextPath}/media/js/table-advanced.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/main_pages/selectparam.js"></script>
	<!--begin 弹出层js -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/zdialog.js"></script>
	<!-- end -->
	<script>
		jQuery(document).ready(function() {
			App.init();
			TableAdvanced.init();
			FormSamples.init();
			Search.init();
			$(".collapse").click();
		});
		$(function() {
			var custype = $("#select2_sample_custype");
			ajaxLoadParam(custype, 1);
			var type = $("#select2_sample_type");
			ajaxLoadParam(type, 2);
		});
	</script>

	<script type="text/javascript">
		//注册表单验证
		$('#submit-button').click(function() {
			var userpwd = $('#register_password');
			var userPassword = $('#register_password').val().trim();//日程标题
			var reuserPassword = $('#rest_password').val().trim();//发布时间

			if (userPassword == "") {
				$.DialogByZ.Alert({
					Title : "提示",
					Content : "日程标题不能为空！",
					BtnL : "确定",
					FunL : alerts
				});
				return false;
			}
			if (reuserPassword == "") {
				$.DialogByZ.Alert({
					Title : "提示",
					Content : "时间不能为空！",
					BtnL : "确定",
					FunL : alerts
				});
				return false;
			}
			return true;
		});

		function alerts() {

			$.DialogByZ.Close();
		}
	</script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/main_pages/selectcustomer.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/main_pages/selectdepsemps.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/main_pages/selectcitys.js"></script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
