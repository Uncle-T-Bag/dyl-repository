<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String requestPath = pageContext.getServletContext().getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=requestPath %>/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=requestPath %>/css/jquery.datetimepicker.css"/>
<link rel="stylesheet" type="text/css" href="<%=requestPath %>/css/formLayout.css"/>
<script type="text/javascript" src="<%=requestPath %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=requestPath %>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=requestPath %>/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=requestPath %>/js/jquery.datetimepicker.js"></script>
<script type="text/javascript">
	var $rName= $('#rName');
	var $lName= $('#lName');
	var $email= $('#email');
	var $birthDay=$('#birthDay');
	var $dept= $('#dept');
	$(function(){
		$("#birthDay").datetimepicker({
			lang:"ch",          //语言选择中文
			format:"Y-m-d",     //格式化日期Y-m-d H:i
			timepicker:false    //关闭时间选项
			//yearStart：2000     //设置最小年份
			//yearEnd:2050        //设置最大年份
			//todayButton:false   //关闭选择今天按钮
		});
		$('#lName').change(function(){
			var val = $(this).val();
			val = $.trim(val);
			$(this).val(val);
			
			var _oldLName= $('#_oldLName').val();
			_oldLName = $.trim(_oldLName);
			if(_oldLName==val){
				showMsg("#tip2","可以使用","#00CD00");
				return;
			}
			
			url = "${pageContext.servletContext.contextPath}/emp/validateLName";
			args = {"lName":val,"date":new Date()};
			$.post(url,args,function(data){
				if(data=="0"){
					showMsg("#tip2","可以使用","#00CD00");
				}else if(data=="1"){
					showMsg("#tip2","不可用","#FF0000");
				}
			});
		});
		$('#email').change(function(){
			var val = $(this).val();
			val = $.trim(val);
			$(this).val(val);
			//邮箱正则
			var emailReg =/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if(!emailReg.test(val)){
				showMsg("#tip3", "格式错误", "#FF0000");
				$(this).focus();
			}else{
				showMsg("#tip3", "格式正确", "#00CD00");
			}
		});
	});
	function formSubmit(){
		if(validateForm()){
			$("form").submit();
		}
	}
	function reset(){
		$rName.val("");
		$lName.val("");
		$email.val("");
		$birthDay.val("");
		$dept.val("");
	}
	function validateForm(){
		if($('#rName').val() == ""){
			showMsg("#tip1","不能为空","#FF0000");
		}else if ($('#lName').val()=="") {
			showMsg("#tip2","不能为空","#FF0000");
		}else if ($('#email').val()=="") {
			showMsg("#tip3","不能为空","#FF0000");
		}else if ($('#birthDay').val()=="") {
			showMsg("#tip4","不能为空","#FF0000");
		}else{
			return true;
		}
	}
	function showMsg(selectorName,msg,colorRgb){
		$(selectorName).text(msg).css({"display":"block","color":colorRgb});
	}
</script>
<title>Add a employees</title>
</head>
<body>
	<div class="boxDiv">
	<c:set value="${pageContext.servletContext.contextPath}/emp/add" var="url"></c:set>
	<c:if test="${employee.id !=null}">
		<c:set value="${pageContext.servletContext.contextPath}/emp/add/${employee.id }" var="url"></c:set>
	</c:if>
	<form:form cssClass="form-horizontal" action="${url}" 
	method="POST" modelAttribute="employee">
	  <c:if test="${employee.id !=null}">
		<input type="hidden" id="_oldLName" value="${employee.lName }"/>
		<form:hidden path="id"/>
		<input type="hidden" name="_method" value="PUT"/>
	  </c:if>
	  <div class="form-group">
	    <label for="rName" class="col-sm-2 control-label">RealName:</label>
	    <div class="col-sm-8">
	      <form:input path="rName" id="rName" cssClass="form-control" placeholder="RealName"/>
	    </div>
	    <div class="col-sm-2">
	       <strong style="display: none;" id="tip1"></strong>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lName" class="col-sm-2 control-label">LoginName:</label>
	    <div class="col-sm-8">
	      <form:input path="lName" id="lName" cssClass="form-control" placeholder="LoginName"/>
	    </div>
	    <div class="col-sm-2">
	       <strong style="display: none;" id="tip2"></strong>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="email" class="col-sm-2 control-label">Email :</label>
	    <div class="col-sm-8">
	      <form:input path="email" id="email" cssClass="form-control" placeholder="Email"/>
  	  	</div>
  	  	<div class="col-sm-2">
	       <strong style="display: none;" id="tip3"></strong>
	    </div>
  	  </div>
	  <div class="form-group">
	  	<label for="birthDay" class="col-sm-2 control-label">BirthDay:</label>
	  	<div class="col-sm-8">
	      <form:input path="birthDay" id="birthDay" cssClass="form-control" placeholder="BirthDay"/>
	    </div>
	    <div class="col-sm-2">
	       <strong style="display: none;" id="tip4"></strong>
	    </div>
	  </div>
	  <div class="form-group">
	  	<label for="dept" class="col-sm-2 control-label">Department:</label>
	  	<div class="col-sm-8">
			<form:select path="department.id" items="${depts }" cssClass="form-control"
				itemLabel="name" itemValue="id">
			</form:select>
		</div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-success" onclick="formSubmit();">Submit</button>
	      <button type="button" class="btn btn-primary" onclick="reset();">Reset</button>
	    </div>
	  </div>
	</form:form>
	</div>
</body>
</html>