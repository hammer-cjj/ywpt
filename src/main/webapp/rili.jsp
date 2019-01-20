<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 	<head>
	    <base href="<%=basePath%>">
	    
	    <title>My JSP 'index.jsp' starting page</title>
		<script type="text/javascript" src="js/jquery.js"></script>
		<link rel="stylesheet" type="text/css" href="css/sign.css"/>
		<script type="text/javascript" src="js/calendar.js"></script>
		<script type="text/javascript" src="js/rili.js"></script>
		<script type="text/javascript">
		$(function(){
		  //ajax获取日历json数据
		  var signList=[{"signDay":"10"},{"signDay":"11"},{"signDay":"12"},{"signDay":"13"}];
		   calUtil.init(signList);
		});
		</script>
	</head>
	<body>
		<div style="width:300px;height:300px;" id="calendar"></div>
	</body>
</html>
