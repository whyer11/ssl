<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<script type="text/javascript">
<!--
	//-->
	$(function() {
		seajs.use([ '$', 'validator' ], function($, Validator) {
			var validator = new Validator({
				element : '#r_p',
			});
			validator.addItem({
				element : '#check_code',
				required : true,
				rule : 'number',
			})
			.addItem({
				element : '#password_reset',
				required : true,
				rule : 'minlength{"min":5} maxlength{"max":20}',
				display : '密码'
			})
			.addItem({
				element : '#passwordconfirmation',
				required : true ,
				rule : 'confirmation{target: "#password_reset", name: "第一遍"}',
				errormessageRequired : '请再输入一遍.',
				display : '密码'
			});
		});
	});
</script>
<div class="reg_content">
	<div class="password_content">
		<div class="mainbox">
			<h3 class="mainbox_title">重设密码</h3>
			<s:form id="r_p" class="ui-form" action="ChangePasswordA_resetPassword" namespace="/customer" method="post" autocomplete="off">
				<div class="ui-form-item">
					<label for="check_code" class="ui-label"> <span
						class="ui-form-required">*</span>验证码：
					</label> <input id="check_code" name="randomCode" class="ui-input" type="text"
						data-explain="请输入验证码" />
					<div class="ui-form-explain">请输入验证码</div>
				</div>
				<div class="ui-form-item">
					<label for="password" class="ui-label"> <span
						class="ui-form-required">*</span>新密码：
					</label> <input id="password_reset" name="password" type="password"
						class="ui-input" data-explain="请输入5-20位的密码。" />
					<div class="ui-form-explain">密码的长度必须大于或等于5。</div>
				</div>

				<div class="ui-form-item">
					<label for="passwordconfirmation" class="ui-label"> <span
						class="ui-form-required">*</span>重复输入密码：
					</label> <input id="passwordconfirmation" name="repassword"
						type="password" class="ui-input" data-explain="请重复输入密码" />
					<div class="ui-form-explain">请再输入一遍。</div>
				</div>
				<s:token></s:token>
				<div class="submit_reg_btn">
							<span class="ui-button-morange ui-button"> <input
								id="submit_reg" class="ui-button-text" value="确定" type="submit"></span>
						</div>
			</s:form>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>