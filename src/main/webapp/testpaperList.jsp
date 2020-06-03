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
<!--时间选择插件-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css">
<link href="${pageContext.request.contextPath}/css/style.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container-fluid p-t-15">

		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-toolbar clearfix">
						<!-- <form class="pull-right search-bar" method="get" action="#!"
							role="form">
							<div class="input-group">
								<div class="input-group-btn">
									<input type="hidden" name="search_field" id="search-field"
										value="title">
									<button class="btn btn-default dropdown-toggle" id="search-btn"
										data-toggle="dropdown" type="button" aria-haspopup="true"
										aria-expanded="false">
										学生 <span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a tabindex="-1" href="javascript:void(0)"
											data-field="title">标题</a></li>
										<li><a tabindex="-1" href="javascript:void(0)"
											data-field="cat_name">栏目</a></li>
									</ul>
								</div>
								<input type="text" class="form-control" value="" name="keyword"
									placeholder="请输入名称">
							</div>
						</form> -->
						<div class="toolbar-btn-action">
							<a class="btn btn-danger" href="#!"
								onclick="sureAndDelete(${page})"><i
								class="mdi mdi-window-close"></i> 删除</a>
						</div>
					</div>
					<div class="card-body">

						<div class="table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th><label class="lyear-checkbox checkbox-primary">
												<input type="checkbox" id="check-all"><span></span>
										</label></th>
										<th>编号</th>
										<th>试卷名称</th>
										<th>添加老师</th>
										<th>创建时间</th>
										<th>时长</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="t">
										<tr>
											<td><label class="lyear-checkbox checkbox-primary">
													<input type="checkbox" name="qpids[]" value="${t.qpid }"><span></span>
											</label></td>
											<td>${t.qpid }</td>
											<td>${t.qpname }</td>
											<td>${t.teacherUser.tname }</td>
											<td>${t.qpdate }</td>
											<td>${(t.time)}分</td>
											<td>
												<div class="btn-group">
													<a class="btn btn-xs btn-default"
														target="_blank" href="${pageContext.request.contextPath}/testpaperAction/findOneTpp.do?qpid=${t.qpid }" title="查看试卷"
														data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
												</div>
												<div class="btn-group">
													<a class="btn btn-xs btn-default"
														onclick="showVarifyModal(${t.qpid })" href="#!" title="添加待考"
														data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
												</div>
											</td>
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- 分页 -->
						<div class="row">
							<div class="col-lg-12">

								<div class="card">
									<div class="card-body">
										<nav>
										<ul class="pager">
											<c:if test="${totalPage>=2 }">
												<c:if test="${totalPage-1>=page}">
													<li><a
														href="${pageContext.request.contextPath}/testpaperAction/findList.do?page=${page+1 }&operType=bookType">下一页</a></li>
												</c:if>
												<c:if test="${totalPage==page}">
													<li><a>下一页</a></li>
												</c:if>
												<c:forEach begin="${page-2<0?1:page-2}"
													end="${page+2>totalPage?totalPage:page+2}" var="v">
													<c:if test="${v>0 and v<totalPage+1 }">
														<li><a
															href="${pageContext.request.contextPath}/testpaperAction/findList.do?page=${v }&operType=bookType">${v }</a></li>
													</c:if>
												</c:forEach>
												<c:if test="${page-1>=1}">
													<li><a
														href="${pageContext.request.contextPath}/testpaperAction/findList.do?page=${page-1 }&operType=bookType">上一页</a></li>
												</c:if>
												<c:if test="${1==page}">
													<li><a>上一页</a></li>
												</c:if>
											</c:if>
										</ul>
										</nav>

									</div>
								</div>

							</div>
						</div>
						<!-- 分页end -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<form action="" id="modifyForm">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">待考信息</h4>
										</div>
										<div class="modal-body">
											<div class="row">
												<div class="col-xs-8 col-xs-offset-2">
													<input type="hidden" id="qpid" >
													<input
														type="text" name="tdate" id="tdate" placeholder="考试日期(2020-05-20 00:00)..."
														class="form-control js-datetimepicker" data-side-by-side="true" data-locale="zh-cn" data-format="YYYY-MM-DD HH:mm" />
												</div>

											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">关闭</button>
											<button type="button" onclick="Btnclick()"
												class="btn btn-primary">点击保存</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>
	<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker/moment.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker/locale/zh-cn.js"></script>
	<!--日期选择插件-->
	<script src="${pageContext.request.contextPath}/js/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/main.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$('.search-bar .dropdown-menu a')
					.click(
							function() {
								var field = $(this).data('field') || '';
								$('#search-field').val(field);
								$('#search-btn')
										.html(
												$(this).text()
														+ ' <span class="caret"></span>');
							});
		});

		function showVarifyModal(qpid) {
			var myModal = $('#myModal');
			myModal.modal({
				show : true,//显示弹出层
				backdrop : 'static',//禁止位置关闭
				keyboard : false
			//关闭键盘事件
			});
			$('#qpid').val(qpid);
		}
		function Btnclick(){
			var params={};
			params.qpid=$('#qpid').val();
			params.tdate=$('#tdate').val();
			var verifyUrl='<%=request.getContextPath()%>'+'/testpaperAction/addTsc.do';
			$.ajax({
				type:'post',
				url:verifyUrl,
				data:params,
				datatype:'json', 
				async:false,                       //同步调用，保证先执行result=true,后再执行return result;
				success:function(data){
					//alert(data);
					if(data.result=='SUCCESS'){
						//alert(data);
						//window.location.reload();
						
						alert("保存成功！");
					}else{
						alert("保存失败,请检查！");
					}
				},
				error : function(data){
			      alert("进入了error方法"+data);
			 	}
			});
		}
		function sureAndDelete(page){
			if(confirm("确定要删除吗？")){
				var checked=[];
				$('input:checkbox:checked').each(function(){

					checked.push($(this).val());

					});
				
				window.location.href='<%=request.getContextPath()%>'+'/testpaperAction/delTpp.do?page='+page+'&qpids='+checked;
			}
		}
	</script>
</body>
</html>