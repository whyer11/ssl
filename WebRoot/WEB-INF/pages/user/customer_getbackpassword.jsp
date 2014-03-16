<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<script type="text/javascript">
<!--

//-->
$(function(){
	seajs.use(['$','validator'],function($,Validator){
		var validator = new Validator({
			element : '#g_b_p',
		});
		Validator.addRule('check_emo_avaliable',function(options,commit){
			$.post('ChangePassword_checkEmo.json',{
				emo : options.element.val()
			},function(data){
				if(data.success==true)
					{
					options.element.parent().addClass('ui-form-item-success');
					}
				else
					{
					options.element.parent().addClass('ui-form-item-error');
					}
				commit(data.success == true ? data.message : null , data.message);
			});
		});
		validator.addItem({
			element : '#email_or_mobile',
			required : true,
			rule : 'check_emo_avaliable '
		});
	});
	$('#email_or_mobile').blur(function(){
		if($(this).val().length == 0)
			{
			$(this).parent().removeClass('ui-form-item-success');
			$(this).parent().addClass('ui-form-item-error');
			}
	});
});
</script>
<div class="reg_content">
	<div class="password_content">
		<div class="mainbox">
			<h3 class="mainbox_title">找回密码</h3>
			<s:form id="g_b_p" class="ui-form" action="ChangePasswordAction_sendRandomCode" namespace="/customer" method="post">
				<div class="ui-form-item">
					<label for="email_or_mobile" class="ui-label"> <span
						class="ui-form-required">*</span>邮箱/手机号：
					</label> <input id="email_or_mobile" name="emo" class="ui-input"
						type="text" data-explain="请输入邮箱/手机号" />
					<div class="ui-form-explain">请输入邮箱/手机号</div>
				</div>
				<s:token></s:token>
				<div class="submit_reg_btn">
					<span class="ui-button-morange ui-button"> <input
						id="submit_reg" class="ui-button-text" value="找回密码" type="submit"></span>
				</div>
			</s:form>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>