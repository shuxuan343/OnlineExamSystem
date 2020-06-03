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
          <form method="post" action="${pageContext.request.contextPath}/loginAction/editpwd.do" class="site-form">
          	<c:if test="${TEA!=null }">
	          <input type="hidden" name="edittype" value="tea">
	        </c:if>
	        <c:if test="${STU!=null }">
	          <input type="hidden" name="edittype" value="stu">
	        </c:if>
	        <div class="form-group">
              <label for="old-password">旧密码</label>
              <input type="password" class="form-control" name="oldpwd" id="old-password" placeholder="输入账号的原登录密码">
            </div>
            <div class="form-group">
              <label for="new-password">新密码</label>
              <input type="password" class="form-control" name="newpwd" id="new-password" placeholder="输入新的密码">
            </div>
            <div class="form-group">
              <label for="confirm-password">确认新密码</label>
              <input type="password" class="form-control" name="confirmpwd" id="confirm-password" placeholder="请输入正确的邮箱地址">
            </div>
            <div class="form-group">
              <label for="confirm-password"><font color="red">${errinfo }</font></label>
            </div>
            <button type="submit" class="btn btn-primary">修改密码</button>
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