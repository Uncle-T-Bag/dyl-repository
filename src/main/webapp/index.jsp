<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String requestPath= pageContext.getServletContext().getContextPath();
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<script type="text/javascript" src="<%=requestPath %>/js/jquery.min.js"></script>
	<title>Index Page</title>
	<script type="text/javascript">
		$(function(){
			$('#testJSON').click(function(){
				var url = $(this).href;
				var args = {};
				$.post(url,args,function(data){
					alert(data);
				});
			});
		})
	</script>
</head>
<body >
	<a href="${pageContext.request.contextPath}/emp/list">list employees</a>
		<br>
	<a href="${pageContext.request.contextPath}/dept/add">Add an employee</a>
		<br>
	<a href="${pageContext.request.contextPath}/test/i18n">Test i18n</a>
		<br>
	<a href="${pageContext.request.contextPath}/test/i18n?locale=zh_CN">i18n Chinese</a>
		<br>
	<a href="${pageContext.request.contextPath}/test/i18n?locale=en_US">i18n English</a>
	    <br>
	<a href="${pageContext.request.contextPath}/test/beanNameViewResolver">Test BeanNameViewResolver</a>
		<br>
	<form action="${pageContext.request.contextPath}/test/testDateConverter" method="POST">
		<input type="text" name="dateStr" value=""/>
		<input type="submit" value="submit"/>
	</form>
	<br><br>
	<a href="${pageContext.request.contextPath}/test/testJSON" id="testJSON">Test JSON</a>
	<br><br>
	<form action="${pageContext.request.contextPath}/test/testFileUpload" method="POST" enctype="multipart/form-data">
		<input type="file" name="file"/>
		<input type="text" name="text"/>
		<input type="submit" value="submit"/>
	</form>
	<br><br>
	上传文件到服务器：
	<br>
	<form action="${pageContext.request.contextPath}/file/upload" method="POST" enctype="multipart/form-data">
		<input type="file" name="file"/>
		<input type="file" name="file"/>
		<input type="submit" value="submit"/>
	</form>
	<br>
	从服务器下载文件：
	<a href="${pageContext.request.contextPath}/file/download?fileName=test.txt">DownLoad File</a>
</body>
</html>
