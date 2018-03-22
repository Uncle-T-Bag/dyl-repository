<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Blogs</title>
</head>
<body>
	<table >
		<tr>
			<td>id</td>
			<td>title</td>
			<td></td>
			<td>status</td>
		</tr>
		<tr>
			<c:forEach items="blogs" var="blog">
				<td>${blog.id}</td>
				<td>${blog.title}</td>
				<td>${blog.id}</td>
				<td>${blog.id}</td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>