<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String requestPath= pageContext.getServletContext().getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=requestPath %>/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=requestPath %>/css/layer-animate.css" />
<script type="text/javascript" src="<%=requestPath %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=requestPath %>/js/method.js"></script>
<script type="text/javascript" src="<%=requestPath %>/js/bootstrap.min.js"></script>
<title>Login page with box</title>
<script type="text/javascript">
	$(function(){
		var obj={
            type:"layer-fadeInUpBig",
            close:"false",
            title:"Login",
            url:"<%=requestPath %>/login_box2.jsp",
            btn:["登陆","注册"],
            area:["500px","400px"],
            callBack1:function(){
            	
            },
            callBack2:function(){
            	
            }
		};
		method.msg_layer(obj);
	})
</script>
</head>
<body>

</body>
</html>