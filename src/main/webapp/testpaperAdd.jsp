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
						<h4>添加试卷</h4>
					</div>
					<div class="card-body">

						<form id="submitFrom" class="form-horizontal" action="#!"
							method="post" enctype="multipart/form-data">
							<div class="form-group">
								<div class="col-xs-12" style="padding: 10px 300px;">
									<input class="form-control input-lg" type="text" style="border-color:white;text-align:center;font-weight:bold" id="qpname" name="qpname" placeholder="试卷名称.." value="${testPaper!=null?testPaper.qpname:''}" />
									<div style="float:right">考试时长：<input class="form-control" type="text" style="display:inline;border-color:white;font-weight:bold;width:60px" id="time" name="time" placeholder="时长.." value="${testPaper!=null?testPaper.time:''}" />分</div>
									<input type="hidden" name="qpid" id="qpid" value="${testPaper!=null?testPaper.qpid:''}" />
								</div>
							</div>

							<div class="form-group" id="choice">
								<div class="col-xs-12">
									<label class="" for="example-text-input">一.&nbsp;选择题</label>
									<a class="btn btn-link" onclick="showVarifyModal(1)"
										style="float: right">添加></a>
									<c:forEach items="${listc }" var="c" varStatus="stat">
									<div>
										<div>
											<strong style="float:left" class="col-xs-12">${stat.index+1}、${c.qcontent }</strong>
											<span style="float:right"><a onclick="delVarifyModal(${c.qid})">删除</a></span>
										</div>
										<div class="col-xs-12">
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
									<a class="btn btn-link" onclick="showVarifyModal(2)"
										style="float: right">添加></a>
									<c:forEach items="${listi }" var="c" varStatus="stat">
									<div>
										<div>
											<strong style="float:left" class="col-xs-12">${stat.index+1}、${c.qcontent }</strong>
											<span style="float:right"><a onclick="delVarifyModal(${c.qid})">删除</a></span>
										</div>
										<div class="col-xs-12">
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
									<a class="btn btn-link" onclick="showVarifyModal(3)"
										style="float: right">添加></a>
									<c:forEach items="${listp }" var="c">
									<div>
										<div>
											<strong style="float:left" class="col-xs-12">${stat.index+1}、${c.qcontent }</strong>
											<span style="float:right"><a onclick="delVarifyModal(${c.qid})">删除</a></span>
										</div>
										<div class="col-xs-12">
											<div class="radio">
												<label> <input type="text" name="" value="" placeholder="程序输出结果..">
												</label>
											</div>
										</div>
									</div>
									</c:forEach>
								</div>
							</div>

							<div class="form-group">
								<div class="col-xs-12">
									<button class="btn btn-primary" onclick="Btnclick()">完成</button>
								</div>
							</div>
						</form>

					</div>
					<!-- ------end---- -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">选择题</h4>
									</div>
									<div class="modal-body">
										<div class="row">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th><label class="lyear-checkbox checkbox-primary">
																<input type="checkbox" id="check-all"><span></span>
														</label></th>
														<th>ID</th>
														<th>试题</th>
														<th>考察范围</th>
														<th>难度</th>
													</tr>
												</thead>
												<tbody id="addtr">
													<c:forEach items="${list}" var="q">
														<tr>
															<td><label class="lyear-checkbox checkbox-primary">
																	<input type="checkbox" name="qids[]" value="${q.qid }"><span></span>
															</label></td>
															<td>${q.qid }</td>
															<td>${q.qcontent }</td>
															<td>${q.qscope }</td>
															<td>${q.qdifficulty }</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
										<div class="row">
											<nav>
											<ul class="pager" id="addpage">
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
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">关闭</button>
										<button type="button" onclick="batchAdd()"
											class="btn btn-primary">点击添加</button>
									</div>
							</div>
						</div>
					</div>
					<!-- end -->
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
			var verifyUrl='<%=request.getContextPath()%>'+ '/clazzAction/addCla.do';
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
		function Btnclick(){
			window.location.reload();
		}

		function showVarifyModal(queTyp) {
			var myModal = $('#myModal');
			myModal.modal({
				show : true,//显示弹出层
				backdrop : 'static',//禁止位置关闭
				keyboard : false
			//关闭键盘事件
			});
			ajaxData(queTyp,1);
		}
		function ajaxData(queTyp,page){
			var params={};
			params.page = page;
			params.queTyp=queTyp;
			var verifyUrl='<%=request.getContextPath()%>'+'/testpaperAction/findQueByQty.do';
			$.ajax({
				type:'post',
				url:verifyUrl,
				data:params,
				datatype:'json', 
				async:false,                       //同步调用，保证先执行result=true,后再执行return result;
				success:function(data){
					//alert(data);
					if(data.result=='SUCCESS'){
						page = data.page;
						var totalPage = data.totalPage;
						data = data.list;//注意点：关联查询
						var tr ='';
						
						for(var i=0;i<data.length;i++){
							tr+='<tr><td><label class="lyear-checkbox checkbox-primary">'
							+'<input type="checkbox" name="qids[]" value="'+ data[i].qid +'"><span></span>'
							+'</label></td>'
							+'<td>'+data[i].qid +'</td>'
							+'<td>'+data[i].qcontent +'</td>'
							+'<td>'+data[i].qscope +'</td>'
							+'<td>'+data[i].qdifficulty +'</td>'
							+'</tr>';
						}
						var li = '';
						var num = parseInt(page)+1;
						if(totalPage>=2){
							if(totalPage-1>=page){
								li+='<li><a href="javascript:ajaxData('+queTyp+','+num+')">下一页</a></li>';
							}
							if(totalPage==page){
								li+='<li><a>下一页</a></li>';
							}
							if(totalPage-1>=1){
								li+='<li><a href="javascript:ajaxData('+queTyp+','+(page-1)+')">上一页</a></li>';
							}
							if(totalPage==1){
								li+='<li><a>上一页</a></li>';
							}
						}
						document.getElementById("addpage").innerHTML=li;
						document.getElementById("addtr").innerHTML=tr;
					}else{
						alert("查询失败,请检查！");
					}
				},
				error : function(data){
			      alert("进入了error方法"+data);
			      return false;
			 	}
			});
		}
		function delVarifyModal(qid){
			if(confirm("确定要删除吗？")){
				var qpid = $('#qpid').val();	
				var qpname = $('#qpname').val();
				var time = $('#time').val();
				window.location.href='<%=request.getContextPath()%>'+'/testpaperAction/delOneQue.do?qid='+qid+'&qpid='+qpid+'&qpname='+qpname+'&time='+time;;
			}
		}
		function batchAdd(){
			var checked=[];
			$('input:checkbox:checked').each(function(){
				if($(this).val()!='on')
					checked.push($(this).val());

			});
			var qpid = $('#qpid').val();	
			var qpname = $('#qpname').val();
			var time = $('#time').val();
			window.location.href='<%=request.getContextPath()%>'+'/testpaperAction/batchAdd.do?qids='+checked+'&qpid='+qpid+'&qpname='+qpname+'&time='+time;
			
		}
	</script>
</body>
</html>