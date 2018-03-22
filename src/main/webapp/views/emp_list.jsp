<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String requestPath = pageContext.getServletContext().getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=requestPath %>/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=requestPath %>/css/layer-animate.css" />
<script type="text/javascript" src="<%=requestPath %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=requestPath %>/js/method.js"></script>
<script type="text/javascript" src="<%=requestPath %>/js/bootstrap.min.js"></script>
<script type="text/javascript">
	
	function pageable(pageNo){
		window.location.href="?pageNo="+pageNo;
	}
	function edit(id){
		window.location.href="${pageContext.servletContext.contextPath}/emp/edit/"+id;
	}
	function del(id){
		 var obj={
            type:"layer-shake",
            close:"true",
            title:"提示",
            content:"确定删除吗？",
            btn:["删除","取消"],
            callBack1:function(){
            	//将请求变成Delete请求，需要在页面添加一个表单，通过表单去提交
            	$("form").attr("action","${pageContext.servletContext.contextPath}/emp/del/"+id);
        		$("#_method").attr("value","DELETE");
        		$("form").submit();
                //method.msg_layer({title:"系统信息",content:"删除成功"})
            },
            callBack2:function(){
            	
            }
		 };
		method.msg_layer(obj);
	}
</script>
<title>List employees</title>
</head>
<body>
	<form action="" method="POST">
		<input type="hidden" name="_method" id="_method" value=""/>
	</form>
	<div class="container">
		<c:if test="${page==null || page.numberOfElements == 0}">
			<h1>当前没有记录</h1>
		</c:if>
		<c:if test="${page!=null && page.numberOfElements > 0}">
			<table class="table table-bordered">
				<tr class="success">
					<td>id</td>
					<td>realName</td>
					<td>loginName</td>
					<td>Email</td>
					<td>birthDay</td>
					<td>createTime</td>
					<td>updateTime</td>
					<td>department</td>
					<td>operation</td>
				</tr>
			<c:forEach items="${page.content }" var="emp">
				<tr>
					<td class="active">${emp.id }</td>
					<td class="info">${emp.rName }</td>
					<td class="active">${emp.lName }</td>
					<td class="success">${emp.email }</td>
					<td class="info">
						<fmt:formatDate value="${emp.birthDay }" pattern="yyyy-MM-dd"/>
					</td>
					<td class="active">
						<fmt:formatDate value="${emp.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/>
					</td>
					<td class="info">
						<fmt:formatDate value="${emp.updateTime }" pattern="yyyy-MM-dd hh:mm:ss"/>
					</td>
					<td class="active">${emp.department.name }</td>
					<td class="warning">
						<button type="button" class="btn btn-success btn-xs" onclick="edit(${emp.id});">
  							<span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Edit
						</button>

						<button type="button" class="btn btn-danger btn-xs" onclick="del(${emp.id});">
  							<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete
						</button>
					</td>
				</tr>
			</c:forEach>
				<tr>
					<td colspan="9" align="right">
						共${page.totalElements } 条记录
						共${page.totalPages } 页
						当前第${page.number+1 } 页
						<button type="button" class="btn btn-link btn-xs" onclick="pageable(${page.number+1-1});">
  							<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> 上一页
						</button>
						<button type="button" class="btn btn-link btn-xs" onclick="pageable(${page.number+1+1});">
  							下一页 <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> 
						</button>
					</td>
				</tr>	
			</table>
		</c:if>
	</div>
</body>
</html>