<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>文档列表 - 光年(Light Year Admin)后台管理系统模板</title>
<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico"
	type="image/ico">
<meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
<meta name="description"
	content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
<meta name="author" content="yinqi">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/materialdesignicons.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container-fluid p-t-15">

		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-header">
						<h4>查看试卷</h4>
					</div>
					<div class="card-body">

						<form id="submitFrom" class="form-horizontal" action="#!"
							method="post" enctype="multipart/form-data">
							<div class="form-group">
								<div class="col-xs-12" style="padding: 10px 300px;">
									<h3 style="border-color:white;text-align:center;font-weight:bold" >${testPaper!=null?testPaper.qpname:''}</h3>
									<div style="float:right">考试时长：${testPaper!=null?testPaper.time:''}分</div>
									<input type="hidden" name="qpid" id="qpid" value="${testPaper!=null?testPaper.qpid:''}" />
								</div>
							</div>

							<div class="form-group" id="choice">
								<div class="col-xs-12">
									<label class="" for="example-text-input">一.&nbsp;选择题</label>
									<c:forEach items="${listc }" var="c" varStatus="stat">
									<div>
										<div>
											<strong>${stat.index+1}、${c.qcontent }</strong>
										</div>
										<div class="col-xs-12" style="display:block">
											<div class="radio">
												<label> <input type="radio" name="" value="A">A.${c.aoption }
												</label>
											</div>
											<div class="radio">
												<label> <input type="radio" name="" value="B">B.${c.boption }
												</label>
											</div>
											<div class="radio">
												<label> <input type="radio" name="" value="C">C.${c.coption }
												</label>
											</div>
											<div class="radio">
												<label> <input type="radio" name="" value="D">D.${c.doption }
												</label>
											</div>
										</div>
									</div>
									</c:forEach>
								</div>
							</div>
							<div class="form-group" id="isornot">
								<div class="col-xs-12">
									<label class="" for="example-text-input">二.&nbsp;判断题</label>
									<c:forEach items="${listi }" var="c" varStatus="stat">
									<div>
										<div>
											<strong>${stat.index+1}、${c.qcontent }</strong>
										</div>
										<div class="col-xs-12" style="display:block">
											<div class="radio">
												<label> <input type="radio" name="" value="1">1.正确
												</label>
											</div>
											<div class="radio">
												<label> <input type="radio" name="" value="0">2.错误
												</label>
											</div>
										</div>
									</div>
									</c:forEach>
								</div>
							</div>
							<div class="form-group" id="program">
								<div class="col-xs-12">
									<label class="" for="example-text-input">三.&nbsp;读程序题</label>
									<c:forEach items="${listp }" var="c">
									<div>
										<div>
											<strong>${stat.index+1}、${c.qcontent }</strong>
										</div>
										<div class="col-xs-12" style="display:block">
											<div>
												<label>请输入： <input type="text" name="" value="" placeholder="程序输出结果..">
												</label>
											</div>
										</div>
									</div>
									</c:forEach>
								</div>
							</div>

						</form>

					</div>
					
				</div>
			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/main.min.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>