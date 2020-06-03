<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>登录页面 - 光年(Light Year Admin)后台管理系统模板</title>
<link rel="icon" href="favicon.ico" type="image/ico">
<meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
<meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
<meta name="author" content="yinqi">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/materialdesignicons.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.min.css" rel="stylesheet">
<style>
.lyear-wrapper {
    position: relative;
}
.lyear-login {
    display: flex !important;
    min-height: 100vh;
    align-items: center !important;
    justify-content: center !important;
}
.lyear-login:after{
    content: '';
    min-height: inherit;
    font-size: 0;
}
.login-center {
    background: #fff;
    min-width: 29.25rem;
    padding: 2.14286em 3.57143em;
    border-radius: 3px;
    margin: 2.85714em;
}
.login-header {
    margin-bottom: 1.5rem !important;
}
.login-center .has-feedback.feedback-left .form-control {
    padding-left: 38px;
    padding-right: 12px;
}
.login-center .has-feedback.feedback-left .form-control-feedback {
    left: 0;
    right: auto;
    width: 38px;
    height: 38px;
    line-height: 38px;
    z-index: 4;
    color: #dcdcdc;
}
.login-center .has-feedback.feedback-left.row .form-control-feedback {
    left: 15px;
}
</style>
</head>
  
<body>
<div class="row lyear-wrapper" style="background-image: url(${pageContext.request.contextPath}/images/login-bg.jpg); background-size: cover;">
  <div class="lyear-login">
    <div class="login-center">
      <div class="login-header text-center">
        <a href="${pageContext.request.contextPath}/loginAction/toLogin.do"><h3 style="font-size:35px">在线考试系统</h3></a>
      </div>
      <form action="${pageContext.request.contextPath}/loginAction/login.do" method="post" onsubmit="return:loginAndCheck();">
        <div class="form-group has-feedback feedback-left">
          <input type="text" placeholder="请输入您的用户名" class="form-control" name="username" id="username" />
          <span class="mdi mdi-account form-control-feedback s1" aria-hidden="true"></span>
        </div>
        <div class="form-group has-feedback feedback-left">
          <input type="password" placeholder="请输入密码" class="form-control" id="password" name="password" />
          <span class="mdi mdi-lock form-control-feedback s2" aria-hidden="true"></span>
        </div>
        <div class="form-group has-feedback feedback-left">
          
          	<select name="logintype" class="form-control" >
          		<option>--请选择--</option>
          		<option value="stu">学生</option>
          		<option value="tea">教师</option>
          		<option value="adm">管理员</option>
          	</select>
            <span class="mdi form-control-feedback s3" aria-hidden="true"></span>
        </div>
        <div class="form-group">
          <label>
            <span><font color="red">${errinfo }</font></span>
          </label>
        </div>
        <div class="form-group">
          <input class="btn btn-block btn-primary" type="submit"  value="立即登录">
        </div>
      </form>
      <hr>
      <footer class="col-sm-12 text-center">
        <p class="m-b-0">Copyright © 2019 <a href="http://lyear.itshubao.com">IT书包</a>. All right reserved</p>
      </footer>
    </div>
  </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript">
if(self != top){
	top.location.href = location.href;
}
function loginAndCheck(){
	//用户名校验
	var userid=document.getElementById("username").value;
	if(userid==null||userid==""){
		var s1=document.getElementById("s1");
		//alert("用户名不能为空！");
		s1.style.color='red';
		s1.innerHTML="用户名不能为空！";
		return false;
	}
	//密码校验
	var passWord=document.getElementById("password").value;
	if(passWord==null||passWord==""){
		var s2=document.getElementById("s2");
		
		s2.style.color='red';
		s2.innerHTML="密码不能为空！";
		return false;
	}
	//登陆类型
	var logintype=document.getElementById("logintype").value;
	if(logintype==null||logintype==""){
		var s2=document.getElementById("s3");
		
		s2.style.color='red';
		s2.innerHTML="请选择！";
		return false;
	}
	
}

</script>
</body>
</html>