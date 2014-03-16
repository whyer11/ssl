<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/admin/adproduct.css" />
<link rel="stylesheet" type="text/css" href="/css/admin/alice.css " />
<link rel="stylesheet" href="/css/admin/style.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/iconfont.css" type="text/css"
	media="screen">
<script charset="utf-8" id="seajsnode"
	src="http://static.alipayobjects.com/seajs/1.3.1/??sea.js,plugin-combo.js"></script>

<script type="text/javascript">
	seajs.config({
		alias : {
			'$' : 'gallery/jquery/1.7.2/jquery',
			'autocomplete' : 'arale/autocomplete/1.2.2/autocomplete',
			'validator' : 'arale/validator/0.9.4/validator.js'
		}
	});
	seajs.use([ '$', 'validator' ], function($, Validator) {
		$(function() {
			var validator = new Validator({
				element : '#test-form'
			});
			validator.addItem({
				element : '#oldpasswd',
				required : true,
				display : '旧密码',
			}).addItem({
				element : '#newpasswd',
				required : true,
				display : '新密码',

			}).addItem({
				element : '#renewpasswd',
				required : true,
				display : '重复密码'
			});
		});
		$(function() {
			val
			newpasswd = $('#newpasswd').val;
			val
			renewpasswd = $('#renewpasswd').val;
			if (newpasswd == renewpasswd) {
				return true;
			} else {
				return false;
			}
		});
	});
</script>




</head>
<body>
	<div id="main-content">
		<div class="content-box">
			<!-- Start Content Box -->
			<div class="content-box-header">

				<h3>修改密码</h3>
				<div class="clear"></div>

			</div>


			<div class="content-box-content">
				<s:form class="ui-form" name="" method="post"
					action="updateDeal_repwd" namespace="/admin" id="test-form">

					<legend></legend>
					<!-- 修改数据默认填入对话框 -->

					<div class="ui-form-item">
						<label for="" class="ui-label"> <span
							class="ui-form-required">*</span>原密码:
						</label> <input class="ui-input" type="password" name="oldpasswd"
							id="oldpasswd">
					</div>
					<div class="ui-form-item">
						<label for="" class="ui-label"> <span
							class="ui-form-required">*</span>新密码:
						</label> <input class="ui-input" type="password" name="newpasswd"
							id="newpasswd">
					</div>
					<div class="ui-form-item">
						<label for="" class="ui-label"> <span
							class="ui-form-required">*</span>重复密码:
						</label> <input class="ui-input" type="password" name="renewpasswd"
							id="renewpasswd">
					</div>
					<div class="ui-form-item">
						<input type="submit" class="ui-button ui-button-morange"
							value="确定">
					</div>



				</s:form>

				<!-- End .clear -->
			</div>

		</div>
	</div>

</body>
</html>