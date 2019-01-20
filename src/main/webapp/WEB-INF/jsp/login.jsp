<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/login.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.select.js"></script>
<title>运维管理平台_用户登录</title>
</head>
<body>
<div id="container">
    <div id="bd">
    	<div id="main">
    		<form action="login" method="post" id="submitForm">
        	<div class="login-box">
                <div id="logo"></div>
                <h1></h1>
                <div class="input username" id="username">
                    <label for="username">用户名</label>
                    <span></span>
                    <input type="text" id="username" name="username" />
                </div>
                <div class="input psw" id="psw">
                    <label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                    <span></span>
                    <input type="password" id="password" name="password"/>
                </div>
                <div class="input validate" id="validate">
                    <label for="valiDate">验证码</label>
                    <input type="text" id="valiDate" name="verifyCodeActual" />
                    <div class="value" id="verifyCode" onclick="changeVerifyCode()">
	                     
                    </div>
                    <input type="hidden" value="" name="verifyCodeExpected" id="verifyCodeExpected" />
                </div>
                <div id="btn" class="loginButton">
                    <input type="button" class="button" value="登录"  />
                </div>
                <div style="position: absolute;top:367px;left:78px;color:red;line-hieght:37px;height:37px;font-size:14px;">
                	${msg }
                </div>
            </div>
            </form> 
        </div>
        <div id="ft">CopyRight&nbsp;2019&nbsp;&nbsp;版权所有&nbsp;&nbsp;舟山市公安局科技信息化 &nbsp;&nbsp;</div>
    </div>
   
</div>
</body>
<script type="text/javascript">
	var height = $(window).height() > 445 ? $(window).height() : 445;
	$("#container").height(height);
	var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
	$('#bd').css('padding-top', bdheight);
	$(window).resize(function(e) {
	    var height = $(window).height() > 445 ? $(window).height() : 445;
		$("#container").height(height);
		var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
		$('#bd').css('padding-top', bdheight);
	});
	//$('select').select();
	
	$('.loginButton').click(function(e) {
		var username = $("input[name='username']").val();
		var password = $("input[name='password']").val();
		var verifyCodeActual = $("input[name='verifyCodeActual']").val();
		if (username.length == 0) {
			alert("请输入用户名");
			return false;
		}
		if (password.length == 0) {
			alert("请输入密码");
			return false;
		}
		if (verifyCodeActual.length == 0) {
			alert("请输入验证码");
			return false;
		}
	    $('#submitForm').submit();
	}); 
	
	
	/**
	* 改变验证码
	*/
	function changeVerifyCode() {
		$.getJSON("/ywpt/verifyCode", function(data){
			if (data.success) {
				$('#verifyCode').html(data.verifyCodeExpected);
				$('#verifyCodeExpected').val(data.verifyCodeExpected);
			}
		});	
	}
	
	$(function(){
		changeVerifyCode();
	})
</script>
</html>