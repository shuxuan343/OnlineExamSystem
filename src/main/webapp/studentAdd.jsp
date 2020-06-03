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
						<h4>添加学生</h4>
					</div>
					<div class="card-body">

						<form id="submitFrom" class="form-horizontal" action="#" method="post"
							enctype="multipart/form-data" >
							<div class="form-group">
								<label class="col-xs-12" for="example-text-input">学生编号</label>
								<div class="col-xs-12">
									<input class="form-control" type="text"
										id="sid" name="sid"
										placeholder="编号..">
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-12" for="example-text-input">学生姓名</label>
								<div class="col-xs-12">
									<input class="form-control" type="text"
										id="name" name="name"
										placeholder="姓名..">
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-12" for="example-text-input">学生班级</label>
								<div class="col-xs-12">
									<select name="bjid" class="form-control"
										id="qtid">
										<c:forEach items="${bjs }" var="bj">
											<option value="${bj.bjid }">${bj.bjname }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-12 abcdoption" for="example-email-input">电话</label>
								<div class="col-xs-12">
									<input class="form-control" type="text"
										id="phone" name="phone"
										placeholder="电话..">
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-12 abcdoption" for="example-email-input">邮箱</label>
								<div class="col-xs-12">
									<input class="form-control" type="text"
										id="email" name="email"
										placeholder="邮箱..">
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-xs-12">
									<button class="btn btn-primary" onclick="Btnclick()">提交</button>
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
		function Btnclick(){
			var params = $("#submitFrom").serialize();
			var verifyUrl='<%=request.getContextPath()%>'+'/studentAction/addStu.do';
					$.ajax({
						type : 'post',
						url : verifyUrl,
						data : params,
						datatype : 'json',
						async : false, //同步调用，保证先执行result=true,后再执行return result;
						success : function(data) {
							//alert(data);
							if (data.result == 'SUCCESS') {
								//alert(data);
								window.location.reload();

								alert("保存成功！");
							} else {
								alert("保存失败,请检查！");
							}
						},
						error : function(data) {
							alert("进入了error方法" + data);
						}
					});
					//console.log("我是验证结果："+result);

		}
	</script>
</body>
</html>