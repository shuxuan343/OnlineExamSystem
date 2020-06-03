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
						<h4>开考试卷</h4>
					</div>
					<div class="card-body">

						<form id="submitFrom" class="form-horizontal" action="${pageContext.request.contextPath}/testpaperAction/subOneTsc.do"
							method="post" enctype="multipart/form-data" onsubmit="beforeSubmit()">
							<div class="form-group">
								<div class="col-xs-12" style="padding: 10px 300px;">
									<h3 style="border-color:white;text-align:center;font-weight:bold" >${testPaper!=null?testPaper.qpname:''}</h3>
									<div style="float:right;color:red">考试时长：${testPaper!=null?testPaper.time:''}分&nbsp;&nbsp;&nbsp;&nbsp;计时：<font id="useTime" style="font-weight: bold;"></font>&nbsp;&nbsp;&nbsp;&nbsp;剩余时间：<font id="remainTime" style="font-weight: bold;"></font></div>
									<input type="hidden" name="tcid" id="tcid" value="${tcid}" />
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
												<label> <input type="radio" name="id-c-${c.qid }" value="${c.aoption }">A.${c.aoption }
												</label>
											</div>
											<div class="radio">
												<label> <input type="radio" name="id-c-${c.qid }" value="${c.boption }">B.${c.boption }
												</label>
											</div>
											<div class="radio">
												<label> <input type="radio" name="id-c-${c.qid }" value="${c.coption }">C.${c.coption }
												</label>
											</div>
											<div class="radio">
												<label> <input type="radio" name="id-c-${c.qid }" value="${c.coption }">D.${c.doption }
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
												<label> <input type="radio" name="id-i-${c.qid }" value="对">1.对
												</label>
											</div>
											<div class="radio">
												<label> <input type="radio" name="id-i-${c.qid }" value="错">2.错
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
												<label>请输入： <input type="text" name="id-p-${c.qid }" value="" placeholder="程序输出结果..">
												</label>
											</div>
										</div>
									</div>
									</c:forEach>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-12">
									<button class="btn btn-primary" id="btsubmit" type="submit">提交</button>
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
	var examTime=("${testPaper!=null?testPaper.time:''}"==null||"${testPaper!=null?testPaper.time:''}"=="")?9999*60:"${testPaper!=null?testPaper.time:''}"*60; 
	var useTime=0,remainTime=examTime; 
	
	// 显示使用时间和剩余时间
	function showCount(){
		if(remainTime==0){
			document.getElementById("submitFrom").submit();
		}
		useTime+=1;
		remainTime-=1;
		var hourU=Math.floor(useTime/3600);
		var minuteU=Math.floor((useTime-hourU*3600)/60);
		var secondU=Math.floor(useTime-hourU*3600-minuteU*60);
		document.getElementById("useTime").innerHTML=format(hourU)+":"+format(minuteU)+":"+format(secondU);
		
		var hourR=Math.floor(remainTime/3600);
		var minuteR=Math.floor((remainTime-hourR*3600)/60);
		var secondR=Math.floor(remainTime-hourR*3600-minuteR*60);
		document.getElementById("remainTime").innerHTML=format(hourR)+":"+format(minuteR)+":"+format(secondR);
	}
	
	// 格式化日期数字
	function format(timeNumber){
		if(timeNumber==0){
			return "00";
		}else if(timeNumber<10){
			return "0"+timeNumber;
		}else{
			return timeNumber;
		}
	}
	
	window.setInterval("showCount()",1000);
	function beforeSubmit(){
		if(confirm("确定检查完毕每一道题，并要交卷吗？")){
			$('#btsubmit').attr('disabled','disabled');
			return true;
		}
		return false;
	}
	</script>
</body>
</html>