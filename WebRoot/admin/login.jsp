<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fi" lang="fi">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>后台登陆</title>
<link href="/css/admin/login.css" rel="stylesheet" type="text/css">

<meta http-equiv="Expires" CONTENT="0">
<meta http-equiv="Cache-Control" CONTENT="no-cache">
<meta http-equiv="Pragma" CONTENT="no-cache">

<script language="JavaScript">
<!--
	javascript: window.history.forward(1);
//-->
</script>
<title>无标题页</title>
<link href="/css/admin/login.css" rel="stylesheet" type="text/css">
<link charset="utf-8" rel="stylesheet"
	href="http://assets.alipay.com/al/alice.components.ui-form-1.0-src.css">
<link charset="utf-8" rel="stylesheet"
	href="http://assets.alipay.com/al/alice.components.ui-button-orange-1.3-full.css">
<script charset="utf-8" id="seajsnode"
	src="http://static.alipayobjects.com/seajs/1.3.1/??sea.js,plugin-combo.js"></script>
<script language="javascript" type="text/javascript">
	var code; //在全局 定义验证码  
	function createCode() {
		code = "";
		var codeLength = 4;//验证码的长度  
		var checkCode = document.getElementById("checkCode");
		var selectChar = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C',
				'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
				'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');//所有候选组成验证码的字符，当然也可以用中文的  
		for ( var i = 0; i < codeLength; i++) {
			var charIndex = Math.floor(Math.random() * 36);
			code += selectChar[charIndex];

		}

		if (checkCode) {
			checkCode.className = "code";
			checkCode.value = code;
		}

	}
	function validate() {
		var inputCode = document.getElementById("vdcode").value;

		if (inputCode.length <= 0) {
			return false;
		} else if (inputCode.toLowerCase() != code.toLowerCase()) {
			//alert("验证码输入错误！");
			//console.log("%o",'avc');
			createCode();//刷新验证码
			return false;

		} else {

			return true;
		}

	}
</script>
<script type="text/javascript">
	seajs.config({
		alias : {
			'$' : 'gallery/jquery/1.7.2/jquery',
			'validator' : 'arale/validator/0.9.4/validator.js',
		}
	});
	seajs.use([ 'validator', '$' ], function(Validator, $) {
		$(function() {
			var validator = new Validator({
				element : '#test-form'
			});
			validator.addItem({
				element : '#username',
				required : true,
			//rule : 'email'
			}).addItem({
				element : '#password',
				required : true,
			}).addItem({
				element : '#vdcode',
				required : true,
			});
		});
	});
</script>
</head>

<%
	session.invalidate();
%>

</head>

<body onload="createCode()">
	<div id="container">
		<h1>送送乐后台管理系统</h1>
		<div id="box">
			<s:form method="post" action="admin_login" id="test-form"
				onsubmit="return validate()">
				<p class="main">
					<label>用户: </label> <input name="username" value="" id="username" />
					<label>密码: </label> <input type="password" name="password"
						id="password" value=""> <label>验证码: </label> <input
						id="vdcode" type="text"
						style="text-transform: uppercase; width: 100px;"> <input
						type="text" onclick="createCode()" readonly="readonly"
						style="width: 60px; margin-left: 20px; text-align: center; color: white;"
						id="checkCode" />
				</p>
				<!-- "  -->
				<p class="space">
					<input type="submit" onclick="return validate()" value="确定"
						class="login" />
				</p>
			</s:form>
			<!-- 
			
			<input	type="hidden" name="gotopage"
					value="<?php if(!empty($gotopage)) echo RemoveXSS($gotopage);?>" />
				<input type="hidden" name="dopost" value="login" /> <input
					name='adminstyle' type='hidden' value='newdedecms' />
				<p class="main">
					<label>用户: </label> <input name="userid" value="" /> <label>密码:
					</label> <input type="password" name="pwd" value=""> <label>验证码:
					</label> <input id="vdcode" type="text" name="validate"
						style="text-transform: uppercase; width: 100px;"> <img
						id="vdimgck" align="absmiddle" onClick="this.src=this.src+'?'"
						style="cursor: pointer;" alt="看不清？点击更换"
						src="../include/vdimgck.php" />
				</p>
				<p class="space">
					<input type="submit" value="登陆" class="login" />
				</p>
			 -->



		</div>
	</div>
</body>
</html>