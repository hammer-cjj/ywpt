<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/sign.css"/>
<script type="text/javascript" src="<%=basePath%>js/calendar.js"></script>
<script type="text/javascript" src="<%=basePath%>js/rili.js"></script>
<title>签到签退</title>
<script type="text/javascript">
	$(function(){
	  //ajax获取日历json数据
	  //var signList=[{"signDay":"10"},{"signDay":"11"},{"signDay":"12"},{"signDay":"13"}];
	  $.getJSON('/ywpt/currentMonth', function(data){
		  if (data.success) {
			var signList = data.signList;
			 calUtil.init(signList);
		  } else {
			 calUtil.init([]);
		  }
	  });
	});
</script>
</head>
<body>
	<div style="width:600px;height:400px;" id="calendar"></div>
</body>
</html>