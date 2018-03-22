<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String requestPath = pageContext.getServletContext().getContextPath();
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Login Page</title>
	<link rel="stylesheet" type="text/css" href="<%=requestPath %>/css/reset.css" />
	<link rel="stylesheet" type="text/css" href="<%=requestPath %>/css/supersized.css" />
	<link rel="stylesheet" type="text/css" href="<%=requestPath %>/css/style.css" />
	<script type="text/javascript" src="<%=requestPath %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=requestPath %>/js/supersized.3.2.7.min.js"></script>
	<script type="text/javascript" src="<%=requestPath %>/js/supersized-init.js"></script>
	<script>
		$(".btn").click(function(){
			is_hide();
		})
		var u = $("input[name=username]");
		var p = $("input[name=password]");
		$("#submit").live('click',function(){
			if(u.val() == '' || p.val() =='')
			{
				$("#ts").html("用户名或密码不能为空~");
				is_show();
				return false;
			}
			else{
				var reg = /^[0-9A-Za-z]+$/;
				if(!reg.exec(u.val()))
				{
					$("#ts").html("用户名错误");
					is_show();
					return false;
				}
			}
		});
		window.onload = function()
		{
			$(".connect p").eq(0).animate({"left":"0%"}, 600);
			$(".connect p").eq(1).animate({"left":"0%"}, 400);
		}
		function is_hide(){ $(".alert").animate({"top":"-40%"}, 300) }
		function is_show(){ $(".alert").show().animate({"top":"45%"}, 300) }
	</script>
</head>
<body oncontextmenu="return false">
	<div class="page-container">
          <h1>Login</h1>
          <form action="" method="post">
			<div>
				<input type="text" name="username" class="username" placeholder="Username" autocomplete="off"/>
			</div>
            <div>
				<input type="password" name="password" class="password" placeholder="Password" oncontextmenu="return false" onpaste="return false" />
            </div>
            <button id="submit" type="button">Sign in</button>
          </form>
          <div class="connect">
              <p>If we can only encounter each other rather than stay with each other,then I wish we had never encountered.</p>
			  <p style="margin-top:20px;">如果只是遇见，不能停留，不如不遇见。</p>
          </div>
    </div>
	<div class="alert" style="display:none">
		  <h2>消息</h2>
		  <div class="alert_con">
			  <p id="ts"></p>
			  <p style="line-height:70px"><a class="btn">确定</a></p>
		  </div>
	</div>
</body>
</html>