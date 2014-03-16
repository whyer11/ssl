<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="js/tpl" id="TPL-accountinfo">
	<form class="account_basedata">
				<ul>
					<li><label>用户名：</label><span><a>{{userName}}</a></span> </li>
					<li><label>绑定手机：</label><span><a>{{mobile}}</a></span> </li>
					<li><label>密码：</label><span><a>********</a></span> </li>
					<li><label>邮箱：</label><span><a>{{email}}</a></span></li>
				</ul>
	</form>
</script>
<script type="text/javascript">
$(function(){
	var customer_mobile = null;
	var customer_email = null;
	var checkUserName_url = 'CustomerAccountUpdateAction_checkUserName.json';
	var checkCurrentMobile_url = 'CustomerAccountUpdateAction_checkCurrentMobile.json';
	var checkCurrentEmail_url = 'CustomerAccountUpdateAction_checkCurrentEmail.json';
	var checkNewMobile_url =  'CustomerAccountUpdateAction_checkNewMobile.json';
	var checkNewEmail_url = 'CustomerAccountUpdateAction_checkNewEmail.json';
	var checkCurrentPassword_url = 'CustomerAccountUpdateAction_checkCurrentPassword.json';
		seajs.use([ '$', 'dialog', 'validator','handlebars' ],function($, Dialog, Validator,Handlebars){
							new Dialog({
								trigger : '#update_username',
								content : $('#update_username_form'),
								effect : 'fade'
							});
							new Dialog({
								trigger : '#update_mobilenumber',
								content : $('#update_mobilenumber_form'),
								effect : 'fade'
							});
							new Dialog({
								trigger : '#update_password',
								content : $('#update_password_form'),
								effect : 'fade'
							});
							new Dialog({
								trigger : '#update_email',
								content : $('#update_email_form'),
								effect : 'fade'
							});
							Validator.addRule('check_username_available',function(options, commit) {
								console.log(options.element[0].value+"+"+options.element[0].name);
								valitate_happy(checkUserName_url,options,commit,options.element[0].name);
								/*$.post('CustomerAccountUpdateAction_checkUserName.json',
										{
											newUserName : $('#new_username').val()
										},function(data) {
															if (data.success == true) {
																		options.element
																				.parent()
																				.addClass(
																						'ui-form-item-success');
																	} else {
																		options.element
																				.parent()
																				.removeClass(
																						'ui-form-item-success');
																		options.element
																				.parent()
																				.addClass(
																						'ui-form-item-error');
																	}
																	commit(
																			data.success == true ? 'aaaaaa'
																					: null,
																			data.message);
																});*/
											});
							Validator.addRule(
											'check_currentmobile',
											function(options, commit) {
												$
														.post(
																'CustomerAccountUpdateAction_checkCurrentMobile.json',
																{
																	currentMobile : $(
																			'#used_mobilenumber')
																			.val()
																},
																function(data) {
																	if (data.success == true) {
																		options.element
																				.parent()
																				.addClass(
																						'ui-form-item-success');
																	} else {
																		options.element
																				.parent()
																				.removeClass(
																						'ui-form-item-success');
																		options.element
																				.parent()
																				.addClass(
																						'ui-form-item-error');
																	}
																	commit(
																			data.success == true ? data.message
																					: null,
																			data.message);
																});
											})
											.addRule(
											'check_currentemail',
											function(options, commit) {
												$
														.post(
																'CustomerAccountUpdateAction_checkCurrentEmail.json',
																{
																	currentEmail : $(
																			'#used_email')
																			.val()
																},
																function(data) {
																	if (data.success == true) {
																		options.element
																				.parent()
																				.addClass(
																						'ui-form-item-success');
																	} else {
																		options.element
																				.parent()
																				.removeClass(
																						'ui-form-item-success');
																		options.element
																				.parent()
																				.addClass(
																						'ui-form-item-error');
																	}
																	commit(
																			data.success == true ? data.message
																					: null,
																			data.message);
																});
											})
									.addRule(
											'check_mobilenum_available',
											function(options, commit) {
												$
														.post(
																'CustomerAccountUpdateAction_checkNewMobile.json',
																{
																	newMobile : $(
																			'#new_mobilenumber')
																			.val()
																},
																function(data) {
																	if (data.success == true) {
																		options.element
																				.parent()
																				.addClass(
																						'ui-form-item-success');
																	} else {
																		options.element
																				.parent()
																				.removeClass(
																						'ui-form-item-success');
																		options.element
																				.parent()
																				.addClass(
																						'ui-form-item-error');
																	}

																	commit(
																			data.success == true ? data.message
																					: null,
																			data.message);
																});
											})
											.addRule(
											'check_email_available',
											function(options, commit) {
												$
														.post(
																'CustomerAccountUpdateAction_checkNewEmail.json',
																{
																	newEmail : $(
																			'#new_email')
																			.val()
																},
																function(data) {
																	if (data.success == true) {
																		options.element
																				.parent()
																				.addClass(
																						'ui-form-item-success');
																	} else {
																		options.element
																				.parent()
																				.removeClass(
																						'ui-form-item-success');
																		options.element
																				.parent()
																				.addClass(
																						'ui-form-item-error');
																	}

																	commit(
																			data.success == true ? data.message
																					: null,
																			data.message);
																});
											})
									.addRule(
											'check_usedpassword',
											function(options, commit) {
												$
														.post(
																'CustomerAccountUpdateAction_checkCurrentPassword.json',
																{
																	currentPassword : $(
																			'#used_password')
																			.val()
																},
																function(data) {
																	if (data.success == true) {
																		options.element
																				.parent()
																				.addClass(
																						'ui-form-item-success');
																	} else {
																		options.element
																				.parent()
																				.removeClass(
																						'ui-form-item-success');
																		options.element
																				.parent()
																				.addClass(
																						'ui-form-item-error');
																	}

																	commit(
																			data.success == true ? data.message
																					: null,
																			data.message);
																});
											});
							var validator_username = new Validator({
								element : '#update_username_form',
							});
							var validator_mobilenumber = new Validator({
								element : '#update_mobilenumber_form',
							});
							var validator_password = new Validator({
								element : '#update_password_form'
							});
							var validator_email= new Validator({
								element :'#update_email_form'
							});
							validator_username.addItem({
								element : '#new_username',
								required : true,
								rule : 'check_username_available minlength{"min":6} maxlength{"max":10}',
							});
							validator_email.addItem({
								element:'#used_email',
								required : true,
								rule : 'check_currentemail email'	
							}).addItem({
								element : '#new_email',
								required : true,
								rule : 'check_email_available email'
							});
							validator_mobilenumber.addItem({
								element : '#used_mobilenumber',
								required : true,
								rule : 'check_currentmobile mobile'
							}).addItem({
								element : '#new_mobilenumber',
								required : true,
								rule : 'check_mobilenum_available mobile'
							});
							validator_password.addItem({
										element : '#used_password',
										required : true,
										rule : 'check_usedpassword'
									}).addItem(
											{
												element : '#new_password',
												required : true,
												rule : 'minlength{"min":5} maxlength{"max":20}'
											})
									.addItem(
											{
												element : '#new_passwordconfirm',
												required : true,
												rule : 'confirmation{target: "#new_password", name: "第一遍"}',
											});
							$(window).load(function(){
								var accountinfo = null;
								ajax('POST','buyers1_account.json',{}).success(function(data){
									console.log(data.mobile);
									console.log(data.email);
									customer_mobile = data.mobile;
									customer_email = data.email;
									if(!customer_mobile)
									{
										//validator_mobilenumber.removeItem('#used_mobilenumber');
										$('#update_mobilenumber').text('绑定手机');
										$('#used_mobilenumber').attr('disabled','true');
										$('#used_mobilenumber').val('当前未绑定手机');
									}
								else 
									{
										$('#update_mobilenumber').text('更改');
									}
								if(!customer_email)
									{
										$('#update_email').text('绑定邮箱');
										$('#used_email').attr('disabled','true');
										$('#used_email').val('当前未绑定邮箱');
									}
								else
									{
										$('#update_email').text('更改');
									}
									if(!accountinfo){
										accountinfo = Handlebars
										.compile($('#TPL-accountinfo').html());
										$('#user_baseinfo').html(''+accountinfo(data)+'');
									}
								});
							});

						});
		$('#new_username,#new_mobilenumber,#used_mobilenumber').blur(
				function() {
					if ($(this).val().length == 0) {
						$(this).parent().removeClass('ui-form-item-success');
					}
				});
		
		$('#check_mobilephone_code').click(function() {
			ajax('POST','CustomerAccountUpdateAction_sendUpdateCheckCode.json',{
				newMobile : $('#new_mobilenumber').val()
			}).success(function(data){
				
			});
		});
		
	});
</script>
<div class="member_management_content">
	<%@include file="/WEB-INF/pages/member/buyers/left_menu.jsp"%>
	<div class="member_management_content_right">
		<div class="member_index_main_content">
			<h1>帐号设置</h1>
			<div id="user_baseinfo"></div>
			<ul class="edit_info">
			<li ><a id="update_username">更换</a></li>
			<li ><a id="update_mobilenumber">更换</a></li>
			<li ><a id="update_password">修改</a></li>
			<li ><a id="update_email">更换</a></li>
			</ul>	
		</div>
	</div>
</div>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>
<!-- update username Starts -->
<div class="cell" style="display: none;">
	<s:form id="update_username_form" class="ui-form"
		action="CustomerInforSubmit_updateUserName" method="post">
		<div class="login_form_content">
				<h3 class="login_form_title">修改用户名</h3>
		<div class="ui-form-item">
			<label for="new_username" class="ui-label"><span
				class="ui-form-required">*</span>新用户名：</label> <input id="new_username"
				name="newUserName" class="ui-input" type="text" />
			<div class="ui-form-explain">请输入新的用户名</div>
		</div>
		<s:token></s:token>
		<div class="submit_reg_btn">
			<span class="ui-button-morange ui-button"><input
				class="ui-button-text" value="确定" type="submit"></span>
		</div>
		</div>
	</s:form>
</div>
<!-- update username Ends -->
<!-- update moblienumber Starts -->
<div class="cell" style="display: none;">
	<s:form id="update_mobilenumber_form" class="ui-form"
		action="CustomerInforSubmit_updateMobile" method="post">
		<div class="login_form_content">
				<h3 class="login_form_title">更改绑定手机</h3>
		<div class="ui-form-item">
			<label for="used_mobilenumber" class="ui-label"><span
				class="ui-form-required">*</span>当前手机号：</label> <input
				id="used_mobilenumber" name="currentMobile" class="ui-input"
				type="text" data-explain="输入当前绑定的手机号码" />
			<div class="ui-form-explain">请输入当前绑定的手机号码</div>
		</div>
		<div class="ui-form-item">
			<label for="new_mobilenumber" class="ui-label"><span
				class="ui-form-required">*</span>新手机号：</label> <input id="new_mobilenumber"
				name="newMobile" class="ui-input" type="text" data-explain="输入新的手机号" />
			<div class="ui-form-explain">请输入新的手机号</div>
		</div>
		<div class="ui-form-item">
			<label for="mobilephone_code" class="ui-label"> <span
				class="ui-form-required">*</span>请输入手机验证码：
			</label> <input id="mobilephone_code" name="randomCode" type="text"
				class="ui-input" style="width: 85px;" />
			<div class="ui-form-explain">
				<a id="check_mobilephone_code"
					style="text-decoration: underline;"> 点击获取验证码 </a>
			</div>
		</div>
		<s:token></s:token>
		<div class="submit_reg_btn">
			<span class="ui-button-morange ui-button"><input
				class="ui-button-text" id="submit_login" value="确定" type="submit"></span>
		</div>
		</div>
	</s:form>
</div>
<!-- update moblienumber Ends -->
<!-- update password Starts -->
<div class="cell" style="display: none;">
	<s:form id="update_password_form" class="ui-form"
		action="CustomerInforSubmit_updatePassword" method="post">
		<div class="login_form_content">
				<h3 class="login_form_title">更改密码</h3>
		<div class="ui-form-item">
			<label for="used_password" class="ui-label"><span
				class="ui-form-required">*</span>当前密码：</label> <input id="used_password"
				name="currentPassword" class="ui-input" type="password"
				data-explain="输入当前密码" />
			<div class="ui-form-explain">请输入当前密码</div>
		</div>
		<div class="ui-form-item">
			<label for="new_password" class="ui-label"><span
				class="ui-form-required">*</span>新密码：</label> <input id="new_password"
				name="newPassword" class="ui-input" type="password"
				data-explain="输入新的密码" />
			<div class="ui-form-explain">请输入新的密码</div>
		</div>
		<div class="ui-form-item">
			<label for="new_passwordconfirm" class="ui-label"> <span
				class="ui-form-required">*</span>再次输入密码：
			</label> <input id="new_passwordconfirm" name="reNewPassword" type="password"
				class="ui-input" data-explain="请重复输入密码" />
			<div class="ui-form-explain">请再输入一遍。</div>
		</div>
		<s:token></s:token>
		<div class="submit_reg_btn">
			<span class="ui-button-morange ui-button"><input
				class="ui-button-text" id="submit_login" value="确定" type="submit"></span>
		</div>
		</div>
	</s:form>
</div>
<!-- update password Ends -->
<!-- update email Starts -->
<div class="cell" style="display: none;">
	<s:form id="update_email_form" class="ui-form"
		action="CustomerInforSubmit_updateMobile" method="post">
		<div class="login_form_content">
				<h3 class="login_form_title">更改绑定邮箱</h3>
		<div class="ui-form-item">
			<label for="used_email" class="ui-label"><span
				class="ui-form-required">*</span>当前邮箱号：</label> <input
				id="used_email" name="currentEmail" class="ui-input"
				type="text" data-explain="输入当前绑定的邮箱号码" />
			<div class="ui-form-explain">请输入当前绑定的邮箱号码</div>
		</div>
		<div class="ui-form-item">
			<label for="new_email" class="ui-label"><span
				class="ui-form-required">*</span>新邮箱号：</label> <input id="new_email"
				name="newEmail" class="ui-input" type="text" data-explain="输入新的邮箱号" />
			<div class="ui-form-explain">请输入新的邮箱号</div>
		</div>
		<div class="ui-form-item">
			<label for="email_code" class="ui-label"> <span
				class="ui-form-required">*</span>请输入邮箱验证码：
			</label> <input id="email_code" name="randomCode" type="text"
				class="ui-input" style="width: 85px;" />
			<div class="ui-form-explain">
				<a id="check_email_code"
					style="text-decoration: underline;"> 点击获取验证码 </a>
			</div>
		</div>
		<s:token></s:token>
		<div class="submit_reg_btn">
			<span class="ui-button-morange ui-button"><input
				class="ui-button-text" id="submit_login" value="确定" type="submit"></span>
		</div>
		</div>
	</s:form>
</div>
<!-- update email Ends -->