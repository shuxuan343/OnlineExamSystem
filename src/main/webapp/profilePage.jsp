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
        <div class="card-body">
          
          <div class="edit-avatar">
            <img src="${pageContext.request.contextPath}/images/users/avatar.jpg" alt="..." class="img-avatar">
            <div class="avatar-divider"></div>
            <div class="edit-avatar-content">
              <button class="btn btn-default">头像</button>
            </div>
          </div>
          <hr>
          <form method="post" action="#!" class="site-form">
          	<c:if test="${TEA!=null }">
	            <div class="form-group">
	              <label for="username">教师姓名</label>
	              <input type="text" class="form-control" name="username" id="username" value="${TEA.tname }" disabled="disabled" />
	            </div>
	            <div class="form-group">
	              <label for="nickname">电话</label>
	              <input type="text" class="form-control" name="nickname" id="nickname" disabled="disabled" value="${TEA.phone }">
	            </div>
	            <div class="form-group">
	              <label for="email">邮箱</label>
	              <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp" disabled="disabled" value="${TEA.email }">
	            </div>
	           </c:if>
	           <c:if test="${STU!=null }">
	            <div class="form-group">
	              <label for="username">学生姓名</label>
	              <input type="text" class="form-control" name="username" id="username" value="${STU.name }" disabled="disabled" />
	            </div>
	            <div class="form-group">
	              <label for="username">班级</label>
	              <input type="text" class="form-control" name="username" id="username" value="${STU.bj.bjname }" disabled="disabled" />
	            </div>
	            <div class="form-group">
	              <label for="nickname">电话</label>
	              <input type="text" class="form-control" name="nickname" id="nickname" disabled="disabled" value="${STU.phone }">
	            </div>
	            <div class="form-group">
	              <label for="email">邮箱</label>
	              <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp" disabled="disabled" value="${STU.email }">
	            </div>
	           </c:if>
            <!-- <button type="submit" class="btn btn-primary">保存</button> -->
          </form>
 
        </div>
      </div>
    </div>
    
  </div>
  
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
</body>
</html>