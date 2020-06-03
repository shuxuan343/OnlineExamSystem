<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>首页 - 光年(Light Year Admin)后台管理系统模板</title>
<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/ico">
<meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
<meta name="description"
	content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
<meta name="author" content="yinqi">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/materialdesignicons.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap-multitabs/multitabs.min.css">
<link href="${pageContext.request.contextPath}/css/style.min.css" rel="stylesheet">
</head>

<body>
	<div class="lyear-layout-web">
		<div class="lyear-layout-container">
			<!--左侧导航-->
			<aside class="lyear-layout-sidebar"> <!-- logo -->
			<div id="logo" class="sidebar-header">
				<a href="${pageContext.request.contextPath}/index.html"><h3 style="font-size:35px">在线考试系统</h3></a>
			</div>
			<div class="lyear-layout-sidebar-scroll">

				<nav class="sidebar-main">
				<ul class="nav nav-drawer">
					<li class="nav-item active"><a class="multitabs"
						href="${pageContext.request.contextPath}/welcome.jsp"><i class="mdi mdi-home"></i> <span>后台首页</span></a>
					</li>
					<c:if test="${TEA!=null }">
						<li class="nav-item nav-item-has-subnav"><a
							href="javascript:void(0)"><i class="mdi mdi-palette"></i> <span>题库管理</span></a>
							<ul class="nav nav-subnav">
								<li><a class="multitabs" href="${pageContext.request.contextPath}/questionAction/findList.do">试题列表</a></li>
								<li><a class="multitabs" href="${pageContext.request.contextPath}/questionAction/addQuePage.do">添加试题</a></li>
							</ul>
						</li>		
						<li class="nav-item nav-item-has-subnav"><a
							href="javascript:void(0)"><i
								class="mdi mdi-format-align-justify"></i> <span>考卷管理</span></a>
							<ul class="nav nav-subnav">
								<li><a class="multitabs" href="${pageContext.request.contextPath}/testpaperAction/findList.do">查询试卷</a></li>
								<li><a class="multitabs" href="${pageContext.request.contextPath}/testpaperAction/addTppPage.do">手动添加待考试卷</a></li>
								<li><a class="multitabs" href="${pageContext.request.contextPath}/testpaperAction/findListTsc.do?tsctime=aft">待考试卷列表</a></li>
	<%-- 							<li><a class="multitabs" href="${pageContext.request.contextPath}/lyear_forms_radio.html">自动生成待考试卷</a></li>
	 --%>						</ul>
						</li>
					</c:if>
					<c:if test="${ADM!=null }">
						<li class="nav-item nav-item-has-subnav"><a
							href="javascript:void(0)"><i
								class="mdi mdi-format-align-justify"></i> <span>班级管理</span></a>
							<ul class="nav nav-subnav">
								<li><a class="multitabs" href="${pageContext.request.contextPath}/clazzAction/findList.do">查看班级</a></li>
								<li><a class="multitabs" href="${pageContext.request.contextPath}/clazzAction/addClaPage.do">添加班级</a></li>
							</ul>
						</li>
					</c:if>
					<li class="nav-item nav-item-has-subnav"><a
						href="javascript:void(0)"><i
							class="mdi mdi-format-align-justify"></i> <span>课程考试</span></a>
						<ul class="nav nav-subnav">
							<c:if test="${TEA!=null }">
								<li><a class="multitabs" href="${pageContext.request.contextPath}/testpaperAction/findListTsc.do?tsctime=bef">以往试卷查询</a></li>
								<li><a class="multitabs" href="${pageContext.request.contextPath}/lyear_forms_radio.html">班级成绩统计</a></li>
							</c:if>
							<c:if test="${STU!=null }">	
								<li><a class="multitabs" href="${pageContext.request.contextPath}/testpaperAction/findListTsc.do?tsctime=aft">个人待考卷</a></li>
								<li><a class="multitabs" href="${pageContext.request.contextPath}/testnoteAction/queryTestonteStu.do">个人成绩统计</a></li>
							</c:if>
						</ul>
					</li>
					<c:if test="${ADM!=null }">
						<li class="nav-item nav-item-has-subnav"><a
							href="javascript:void(0)"><i
								class="mdi mdi-format-align-justify"></i> <span>教师管理</span></a>
							<ul class="nav nav-subnav">
								<li><a class="multitabs" href="${pageContext.request.contextPath}/teacherAction/findList.do">查看教师</a>
								</li>
								<li><a class="multitabs" href="${pageContext.request.contextPath}/teacherAction/addTeaPage.do">添加教师</a>
								</li>
							</ul>
						</li>
						<li class="nav-item nav-item-has-subnav"><a
							href="javascript:void(0)"><i class="mdi mdi-file-outline"></i>
								<span>学生管理</span></a>
							<ul class="nav nav-subnav">
								<li><a class="multitabs" href="${pageContext.request.contextPath}/studentAction/findList.do">查看学生</a>
								</li>
								<li><a class="multitabs" href="${pageContext.request.contextPath}/studentAction/addStuPage.do">添加学生</a>
								</li>
							</ul>
						</li>
					</c:if>
					<%-- <li class="nav-item nav-item-has-subnav"><a
						href="javascript:void(0)"><i
							class="mdi mdi-language-javascript"></i> <span>个人信息</span></a>
						<ul class="nav nav-subnav">
							<li><a class="multitabs" href="${pageContext.request.contextPath}/lyear_js_datepicker.html">查看信息</a>
							</li>
							<li><a class="multitabs" href="${pageContext.request.contextPath}/lyear_js_sliders.html">修改密码</a>
							</li>
						</ul>
					</li> --%>
					
				</ul>
				</nav>

				<div class="sidebar-footer">
					<p class="copyright">
						Copyright &copy; 2019. <a target="_blank"
							href="http://lyear.itshubao.com">IT书包</a> All rights reserved.
					</p>
				</div>
			</div>

			</aside>
			<!--End 左侧导航-->

			<!--头部信息-->
			<header class="lyear-layout-header"> <nav
				class="navbar navbar-default">
			<div class="topbar">

				<div class="topbar-left">
					<div class="lyear-aside-toggler">
						<span class="lyear-toggler-bar"></span> <span
							class="lyear-toggler-bar"></span> <span class="lyear-toggler-bar"></span>
					</div>
				</div>

				<ul class="topbar-right">
					<c:if test="${ADM!=null }">
						<li class="dropdown dropdown-profile">
							<a
								href="javascript:void(0)" data-toggle="dropdown"> <img
									class="img-avatar img-avatar-48 m-r-10"
									src="${pageContext.request.contextPath}/images/users/avatar.jpg" alt="笔下光年" /> <span>${ADM.username } <span
										class="caret"></span></span>
							</a>
							<ul class="dropdown-menu dropdown-menu-right">
								<li><a class="multitabs"
									data-url="${pageContext.request.contextPath}/loginAction/editpwdPage.do" href="javascript:void(0)"><i
										class="mdi mdi-lock-outline"></i> 修改密码</a></li>
								<li><a href="${pageContext.request.contextPath}/loginAction/logout.do?type=adm"><i
										class="mdi mdi-logout-variant"></i> 退出登录</a></li>
							</ul>
						</li>
					</c:if>
					<c:if test="${TEA!=null }">
						<li class="dropdown dropdown-profile">
							<a
								href="javascript:void(0)" data-toggle="dropdown"> <img
									class="img-avatar img-avatar-48 m-r-10"
									src="${pageContext.request.contextPath}/images/users/avatar.jpg" alt="笔下光年" /> <span>${TEA.tname } <span
										class="caret"></span></span>
							</a>
							<ul class="dropdown-menu dropdown-menu-right">
								<li><a class="multitabs" data-url="${pageContext.request.contextPath}/loginAction/profilePage.do"
									href="javascript:void(0)"><i class="mdi mdi-account"></i>
										个人信息</a></li>
								<li><a class="multitabs"
									data-url="${pageContext.request.contextPath}/loginAction/editpwdPage.do" href="javascript:void(0)"><i
										class="mdi mdi-lock-outline"></i> 修改密码</a></li>
								<li><a href="${pageContext.request.contextPath}/loginAction/logout.do?type=tea"><i
										class="mdi mdi-logout-variant"></i> 退出登录</a></li>
							</ul>
						</li>
					</c:if>
					<c:if test="${STU!=null }">
						<li class="dropdown dropdown-profile">
							<a
								href="javascript:void(0)" data-toggle="dropdown"> <img
									class="img-avatar img-avatar-48 m-r-10"
									src="${pageContext.request.contextPath}/images/users/avatar.jpg" alt="笔下光年" /> <span>${STU.name }<span
										class="caret"></span></span>
							</a>
							<ul class="dropdown-menu dropdown-menu-right">
								<li><a class="multitabs" data-url="${pageContext.request.contextPath}/loginAction/profilePage.do"
									href="javascript:void(0)"><i class="mdi mdi-account"></i>
										个人信息</a></li>
								<li><a class="multitabs"
									data-url="${pageContext.request.contextPath}/loginAction/editpwdPage.do" href="javascript:void(0)"><i
										class="mdi mdi-lock-outline"></i> 修改密码</a></li>
								<li><a href="${pageContext.request.contextPath}/loginAction/logout.do?type=stu"><i
										class="mdi mdi-logout-variant"></i> 退出登录</a></li>
							</ul>
						</li>
					</c:if>
					<!--切换主题配色-->
					<li class="dropdown dropdown-skin"><span
						data-toggle="dropdown" class="icon-palette"><i
							class="mdi mdi-palette"></i></span>
						<ul class="dropdown-menu dropdown-menu-right"
							data-stopPropagation="true">
							<li class="drop-title"><p>LOGO</p></li>
							<li class="drop-skin-li clearfix"><span class="inverse">
									<input type="radio" name="logo_bg" value="default"
									id="logo_bg_1" checked> <label for="logo_bg_1"></label>
							</span> <span> <input type="radio" name="logo_bg" value="color_2"
									id="logo_bg_2"> <label for="logo_bg_2"></label>
							</span> <span> <input type="radio" name="logo_bg" value="color_3"
									id="logo_bg_3"> <label for="logo_bg_3"></label>
							</span> <span> <input type="radio" name="logo_bg" value="color_4"
									id="logo_bg_4"> <label for="logo_bg_4"></label>
							</span> <span> <input type="radio" name="logo_bg" value="color_5"
									id="logo_bg_5"> <label for="logo_bg_5"></label>
							</span> <span> <input type="radio" name="logo_bg" value="color_6"
									id="logo_bg_6"> <label for="logo_bg_6"></label>
							</span> <span> <input type="radio" name="logo_bg" value="color_7"
									id="logo_bg_7"> <label for="logo_bg_7"></label>
							</span> <span> <input type="radio" name="logo_bg" value="color_8"
									id="logo_bg_8"> <label for="logo_bg_8"></label>
							</span></li>
							<li class="drop-title"><p>头部</p></li>
							<li class="drop-skin-li clearfix"><span class="inverse">
									<input type="radio" name="header_bg" value="default"
									id="header_bg_1" checked> <label for="header_bg_1"></label>
							</span> <span> <input type="radio" name="header_bg"
									value="color_2" id="header_bg_2"> <label
									for="header_bg_2"></label>
							</span> <span> <input type="radio" name="header_bg"
									value="color_3" id="header_bg_3"> <label
									for="header_bg_3"></label>
							</span> <span> <input type="radio" name="header_bg"
									value="color_4" id="header_bg_4"> <label
									for="header_bg_4"></label>
							</span> <span> <input type="radio" name="header_bg"
									value="color_5" id="header_bg_5"> <label
									for="header_bg_5"></label>
							</span> <span> <input type="radio" name="header_bg"
									value="color_6" id="header_bg_6"> <label
									for="header_bg_6"></label>
							</span> <span> <input type="radio" name="header_bg"
									value="color_7" id="header_bg_7"> <label
									for="header_bg_7"></label>
							</span> <span> <input type="radio" name="header_bg"
									value="color_8" id="header_bg_8"> <label
									for="header_bg_8"></label>
							</span></li>
							<li class="drop-title"><p>侧边栏</p></li>
							<li class="drop-skin-li clearfix"><span class="inverse">
									<input type="radio" name="sidebar_bg" value="default"
									id="sidebar_bg_1" checked> <label for="sidebar_bg_1"></label>
							</span> <span> <input type="radio" name="sidebar_bg"
									value="color_2" id="sidebar_bg_2"> <label
									for="sidebar_bg_2"></label>
							</span> <span> <input type="radio" name="sidebar_bg"
									value="color_3" id="sidebar_bg_3"> <label
									for="sidebar_bg_3"></label>
							</span> <span> <input type="radio" name="sidebar_bg"
									value="color_4" id="sidebar_bg_4"> <label
									for="sidebar_bg_4"></label>
							</span> <span> <input type="radio" name="sidebar_bg"
									value="color_5" id="sidebar_bg_5"> <label
									for="sidebar_bg_5"></label>
							</span> <span> <input type="radio" name="sidebar_bg"
									value="color_6" id="sidebar_bg_6"> <label
									for="sidebar_bg_6"></label>
							</span> <span> <input type="radio" name="sidebar_bg"
									value="color_7" id="sidebar_bg_7"> <label
									for="sidebar_bg_7"></label>
							</span> <span> <input type="radio" name="sidebar_bg"
									value="color_8" id="sidebar_bg_8"> <label
									for="sidebar_bg_8"></label>
							</span></li>
						</ul></li>
					<!--切换主题配色-->
				</ul>

			</div>
			</nav> </header>
			<!--End 头部信息-->

			<!--页面主要内容-->
			<main class="lyear-layout-content">

			<div id="iframe-content"></div>

			</main>
			<!--End 页面主要内容-->
		</div>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/perfect-scrollbar.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/bootstrap-multitabs/multitabs.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.min.js"></script>
</body>
</html>