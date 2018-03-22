<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String requestPath= pageContext.getServletContext().getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=requestPath %>/css/bootstrap.min.css" />
<script type="text/javascript" src="<%=requestPath %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=requestPath %>/js/bootstrap.min.js"></script>
<title>Login page with box</title>
</head>
<body>
	
	<form class="form-horizontal" >
	  <div class="form-group">
	    <label for="rName" class="col-sm-3 control-label">RealName:</label>
	    <div class="col-sm-6">
	      <input  id="rName" class="form-control" placeholder="RealName">
	    </div>
	    <div class="col-sm-3">
	       <strong style="display: none;" id="tip1"></strong>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lName" class="col-sm-3 control-label">LoginName:</label>
	    <div class="col-sm-6">
	      <input  id="lName" class="form-control" placeholder="LoginName">
	    </div>
	    <div class="col-sm-3">
	       <strong style="display: none;" id="tip2"></strong>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="email" class="col-sm-3 control-label">Email :</label>
	    <div class="col-sm-6">
	      <input  id="email" class="form-control" placeholder="Email">
  	  	</div>
  	  	<div class="col-sm-3">
	       <strong style="display: none;" id="tip3"></strong>
	    </div>
  	  </div>
	  <div class="form-group">
	  	<label for="birthDay" class="col-sm-3 control-label">BirthDay:</label>
	  	<div class="col-sm-6">
	      <input id="birthDay" class="form-control" placeholder="BirthDay">
	    </div>
	    <div class="col-sm-3">
	       <strong style="display: none;" id="tip4"></strong>
	    </div>
	  </div>
	  <div class="form-group">
	  	<label for="dept" class="col-sm-3 control-label">Department:</label>
	  	<div class="col-sm-6">
			<select class="form-control">
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
			</select>
		</div>
	  </div>
	</form>
	
</body>
</html>