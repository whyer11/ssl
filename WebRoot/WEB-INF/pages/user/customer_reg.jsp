<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<script>
	$(function() {
		// Calling the plugin
		$("#product_detailpic").organicTabs();
	});
	seajs.use([ 'validator','autocomplete', '$' ], function(Validator,AutoComplete, $) {
		$(function() {
			var validator = new Validator({
				element : '#reg_form_mobile',
				onFormValidated : function(err, results, form) {
					window.console && console.log
							&& console.log(err, results, form);
				},
				failSilently : true
			});
			var validator_1 = new Validator({
				element : '#reg_form_email',
				onFormValidated : function(err, results, form) {
					window.console && console.log
							&& console.log(err, results, form);
				},
				failSilently : true
			});
			Validator.addRule('check_username_available', function(options,
					commit) {
				$.post('CustomerAction_checkUserName.json', {
					userName : options.element.val()
				},
						function(data) {
							if (data.success == true) {
								options.element.parent().addClass(
										'ui-form-item-success');
							} else {
								options.element.parent().addClass(
										'ui-form-item-error');
							}
							commit(data.success == true ? data.message : null,
									data.message);
						});
			});
			Validator.addRule('check_email_available',function(options,commit){
				$.post('user/emailAction_checkEmail.json',{
					email : options.element.val()
				},
				function(data){
					if(data.success==true ){
						options.element.parent().addClass('ui-form-item-success');
					}
					else
						{
						options.element.parent().addClass('ui-form-item-error');
						}
					commit(data.success == true ? data.message:null, data.message);
				});
			});
			Validator.addRule('check_mobilenum_available', function(options,
					commit) {
				$.post('CustomerAction_checkMobileNO.json', {
					mobileNO : options.element.val()
				},
						function(data) {
							if (data.success == true) {
								options.element.parent().addClass(
										'ui-form-item-success');
							} else {
								options.element.parent().removeClass(
										'ui-form-item-success');
								options.element.parent().addClass(
										'ui-form-item-error');
							}

							commit(
									data.success ==true  ? data.message
											: null, '无法使用该手机号码');
						});
			});
			validator.addItem({
				element : '#mobilenum',
				required : true,
				rule : 'check_mobilenum_available mobile',
				errormessageRequired : '请输入手机号码'
			}).addItem({
				element : '#password_mobile',
				required : true,
				rule : 'minlength{"min":5} maxlength{"max":20}',
				display : '密码'
			}).addItem({
				element : '#nicknam',
				required : true,
				rule : 'check_username_available minlength{"min":6} maxlength{"max":10}',
				errormessageRequired : '请输入用户名',
				display : '用户名'
			}).addItem({
				element : '#passwordconfirmation',
				required : true,
				rule : 'confirmation{target: "#password_mobile", name: "第一遍"}',
				errormessageRequired : '请再重复输入一遍.',
				display : '密码'
			})
			.addItem({
				element : '#address_mobile',
				required : true,
				rule : 'text',
				errormessageRequired : '请输入您的地址',
				display : '地址'
			})
			.addItem({
				element : '#s1',
				required : true,
				rule : 'text',
				errormessageRequired: '请选择店铺区域'
			})
			.addItem({
				element : '#s2',
				required : true,
				rule : 'text',
				errormessageRequired: '请选择店铺区域'
			})
			.addItem({
				element : '#s3',
				required : true,
				rule : 'text',
				errormessageRequired: '请选择店铺区域'
			});
			$('#check_mobilephone_code').click(function() {
					validator.execute(function(hasError,results,element){
						console.log('aa');
					});
					ajax('POST','getCheckCode_sendMessage.json',{mobileNO : $('#mobilenum').val()}).success(function(data){
						
					});
			});
			//邮件注册
			validator_1.addItem({
				element : '#email',
				required : true,
				rule : 'email check_email_available'
			})
			.addItem({
				element : '#username_email',
				required : true,
				rule : 'check_username_available minlength{"min":6} maxlength{"max":10}'
			})
			.addItem({
				element : "#password_email",
				required : true,
				rule : 'minlength{"min":5} maxlength{"max":20}',
				display : '密码'
			})
			.addItem({
				element : '#passwordconfirmation_eamil',
				required : true,
				rule : 'confirmation{target: "#password_email", name: "第一遍"}',
				errormessageRequired : '请再重复输入一遍.',
				display : '密码'
			})
			.addItem({
				element : '#address_email',
				required : true,
				rule:'text',
				display:'地址'
			})
			.addItem({
				element : '#a1',
				required : true,
				rule : 'text',
				errormessageRequired: '请选择店铺区域'
			})
			.addItem({
				element : '#a2',
				required : true,
				rule : 'text',
				errormessageRequired: '请选择店铺区域'
			})
			.addItem({
				element : '#a3',
				required : true,
				rule : 'text',
				errormessageRequired: '请选择店铺区域'
			});
			 var data = [
			             '163.com',
			             '126.com',
			             'gmail.com',
			             'qq.com',
			             'sina.com',
			             'hotmail.com',
			             '139.com',
			         ];
			         new AutoComplete({
			             trigger: '#email',
			             dataSource: function(query) {
			                 var a = $.map(data, function(v, i) {
			                     return query + '@' + v;
			                 });
			                 return a;
			             },
			             filter: '',
			             inputFilter: function(v){
			                 return v.replace(/^(.*)@.*$/,'$1');
			             }
			         }).render();
		});
	});
</script>
<div class="reg_content">
	<div class="mainbox">
		<h3 class="mainbox_title">用户注册</h3>
		<div class="product_detailpic" id="product_detailpic">
		<!-- Tab pages Starts -->
		<!-- Tab pages navigation Starts -->
		<ul class="nav">
			<li class="nav-one"><a href="#reg_mobile" class="current">手机注册</a></li>
			<li class="nav-two last"><a href="#reg_email">邮箱注册</a></li>
		</ul>
		<!-- Tab pages navigation Ends -->
		<div class="list-wrap">
		<!-- sign up by mobile Starts -->
			<ul id="reg_mobile">
				<div class="cell">
					<s:form id="reg_form_mobile" class="ui-form"
						action="getCheckCode_regSuccess" namespace="/user" autocomplete="off">
						<div class="ui-form-item">
							<label for="mobilenum" class="ui-label"> <span
								class="ui-form-required">*</span>手机号码：
							</label> <input id="mobilenum" name="mobilenum" class="ui-input"
								type="text" data-explain="请输入手机号码" />
							<div class="ui-form-explain" id="mobilenumexplian">请输入手机号码</div>
						</div>
						<div class="ui-form-item">
							<label for="nicknam" class="ui-label"> <span
								class="ui-form-required">*</span>用户名：
							</label> <input id="nicknam" name="nicknam" class="ui-input" type="text"
								data-explain="请输入6-10字符的用户名" />
							<div class="ui-form-explain" id="nicknamexplain">请输入你的用户名</div>
						</div>

						<div class="ui-form-item">
							<label for="password" class="ui-label"> <span
								class="ui-form-required">*</span>密码：
							</label> <input id="password_mobile" name="password" type="password"
								class="ui-input" data-explain="请输入5-20位的密码。" />
							<div class="ui-form-explain">密码的长度必须大于或等于5。</div>
						</div>
						<div class="ui-form-item">
							<label for="passwordconfirmation" class="ui-label"> <span
								class="ui-form-required">*</span>重复输入密码：
							</label> <input id="passwordconfirmation" name="passwordconfirmation"
								type="password" class="ui-input" data-explain="请重复输入密码" />
							<div class="ui-form-explain">请再输入一遍。</div>
						</div>
						<div class="ui-form-item">
							<label for="s1" class="ui-label"><span
								class="ui-form-required">*</span>所在区域：</label> 
								
							<SELECT ID="s1" name="s1" style="max-width: 125px;">
								<OPTION selected></OPTION>
							</SELECT> 
							<SELECT ID="s2" name="s2" style="max-width: 125px;">
								<OPTION selected></OPTION>
							</SELECT> 
							<SELECT	ID="s3" name="areaId" style="max-width: 125px;" >
								<OPTION selected value="${s3}"></OPTION>
							</SELECT>
							<div class="ui-form-explain">请选择店家区域</div>
						</div>
						<div class="ui-form-item">
							<label for="address" class="ui-label"> <span
								class="ui-form-required">*</span>地址：
							</label> <input id="address_mobile" name="address" type="text"
								class="ui-input" data-explain="请输入您的地址。" />
							<div class="ui-form-explain">请输入您的地址。</div>
						</div>
						<div class="ui-form-item">
							<label for="mobilephone_code" class="ui-label"> <span
								class="ui-form-required">*</span>请输入手机验证码：
							</label> <input id="mobilephone_code" name="mobilephone_code" type="text"
								class="ui-input" style="width: 85px;" />
							<div class="ui-form-explain">
								<span class="ui-button-sorange ui-button">
								<input id="check_mobilephone_code" value="点击获取验证码" class="ui-button-text" type="button"></span>
							</div>
						</div>
						<s:token></s:token>
						<div class="submit_reg_btn">
						<span class="ui-button-morange ui-button">
						<input id="submit_reg" class="ui-button-text" value="确定" type="submit">
						</span>
						</div>
					</s:form>
				</div>
			</ul>
			<!-- sign up by mobile Ends -->
			<!-- sign up by email Starts -->
			<ul id="reg_email" class="hide">
				<div class="cell">
					<s:form id="reg_form_email" class="ui-form"
						action="reg_sendToMailBox" namespace="/user" autocomplete="off">
						<div class="ui-form-item">
							<label for="email" class="ui-label"> <span
								class="ui-form-required">*</span>电子邮箱：
							</label> <input id="email" name="email" class="ui-input"
								type="text" data-explain="请输入电子邮箱" />
							<div class="ui-form-explain">请输入电子邮箱</div>
						</div>
						<div class="ui-form-item">
							<label for="username_email" class="ui-label"> <span
								class="ui-form-required">*</span>用户名：
							</label> <input id="username_email" name="username" class="ui-input" type="text"
								data-explain="请输入6-10字符的用户名" />
							<div class="ui-form-explain">请输入你的用户名</div>
						</div>
						<div class="ui-form-item">
							<label for="password_email" class="ui-label"> <span
								class="ui-form-required">*</span>密码：
							</label> <input id="password_email" name="password" type="password"
								class="ui-input" data-explain="请输入5-20位的密码。" />
							<div class="ui-form-explain">密码的长度必须大于或等于5。</div>
						</div>

						<div class="ui-form-item">
							<label for="passwordconfirmation_email" class="ui-label"> <span
								class="ui-form-required">*</span>重复输入密码：
							</label> <input id="passwordconfirmation_eamil" name="repassword"
								type="password" class="ui-input" data-explain="请重复输入密码" />
							<div class="ui-form-explain">请再输入一遍。</div>
						</div>
						<div class="ui-form-item">
							<label for="a1" class="ui-label"><span
								class="ui-form-required">*</span>所在区域：</label> 
								
							<SELECT ID="a1" name="a1" style="max-width: 125px;">
								<OPTION selected></OPTION>
							</SELECT> 
							<SELECT ID="a2" name="a2" style="max-width: 125px;">
								<OPTION selected></OPTION>
							</SELECT> 
							<SELECT	ID="a3" name="areaId" style="max-width: 125px;" >
								<OPTION selected value="${s3}"></OPTION>
							</SELECT>
							<div class="ui-form-explain">请选择店家区域</div>
						</div>
						<div class="ui-form-item">
							<label for="address" class="ui-label"> <span
								class="ui-form-required">*</span>地址：
							</label> <input id="address_email" name="address" type="text"
								class="ui-input" data-explain="请输入您的地址。" />
							<div class="ui-form-explain">请输入您的地址。</div>
						</div>
						<s:token></s:token>
						<div class="submit_reg_btn">
							<span class="ui-button-morange ui-button"> <input
								id="submit_reg" class="ui-button-text" value="确定" type="submit"></span>
						</div>
					</s:form>
				</div>
			</ul>
			<!-- sign up by email Ends -->
		</div>
	</div>
	<!-- Tab pages Ends -->
	</div>
</div>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>
<script type="text/javascript">
	$(function() {
		$.ajax({
			type : "post",
			url : '/adminjson/jsondeal_areaInfo.json',
			data : "",
			dataType : "json",
			success : function(result) {
				var rjson = result.jsonArray;
				//alert(rjson.childId);
				var array = new Array();
				for ( var i = 0; i < rjson.length; i++) {
					array[i] = new Array(rjson[i].cid, rjson[i].pid,
							rjson[i].name);
					//alert(array[i]);
				}
				//array[2]=new Array("2","1","22");
				var liandong = new CLASS_LIANDONG_YAO(array); //设置数据源
				liandong.firstSelectChange("根目录", "s1"); //设置第一个选择框
				liandong.subSelectChange("s1", "s2"); //设置子级选择框
				liandong.subSelectChange("s2", "s3");
			}
		});
		$.ajax({
			type : "post",
			url : '/adminjson/jsondeal_areaInfo.json',
			data : "",
			dataType : "json",
			success : function(result) {
				var rjson = result.jsonArray;
				//alert(rjson.childId);
				var array = new Array();
				for ( var i = 0; i < rjson.length; i++) {
					array[i] = new Array(rjson[i].cid, rjson[i].pid,
							rjson[i].name);
					//alert(array[i]);
				}
				//array[2]=new Array("2","1","22");
				var liandong = new CLASS_LIANDONG_YAO(array); //设置数据源
				liandong.firstSelectChange("根目录", "a1"); //设置第一个选择框
				liandong.subSelectChange("a1", "a2"); //设置子级选择框
				liandong.subSelectChange("a2", "a3");
			}
		});
	});
</script>