<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<script type="js/TPL" id="TPL-userinfoItem" onload="load()">
				<div class="user_baseinfo">
					<form id="buyers_baseinfo_form">
						<div class="ui-form-item">
							<label for="realname" class="ui-label"><span
								class="ui-form-required"></span>真实姓名：</label>
							<div class="ui-form-explain"><a>{{realName}}</a></div>
						</div>
						<div class="ui-form-item" id="gender">
							<label class="ui-label"><span class="ui-form-required"></span>性别：</label>
								<div class="ui-form-explain"><a>{{sex}}</a></div>
						</div>
						<div class="ui-form-item">
							<label for="user_score" class="ui-label"><span
								class="ui-form-required"></span>积分：</label>
							<div class="ui-form-explain"><a>{{score}}</a></div>
						</div>
						<div class="ui-form-item">
							<label for="user_lasttime" class="ui-label"><span
								class="ui-form-required"></span>上一次登录：</label>
								<div class="ui-form-explain"><a>{{lastVisit}}</a></div>
						</div>
						<div class="ui-form-item">
							<label for="user_regtime" class="ui-label"><span
								class="ui-form-required"></span>帐号注册时间：</label>
								<div class="ui-form-explain"><a>{{registerTime}}</a></div>
						</div>
						<div class="ui-form-item" style="position: relative">
							<label for="user_birth" class="ui-label"><span
								class="ui-form-required"></span>生日：</label>
							<div class="ui-form-explain"><a>{{birthday}}</a></div>
						</div>
						<div class="ui-form-item">
							<label for="s1" class="ui-label"><span
								class="ui-form-required"></span>所在区域：</label>
							<div class="ui-form-explain"><a>{{areaString}}</a></div>
						</div>
					</form>
				</div>
				</script>
<div class="member_management_content">
	<%@include file="/WEB-INF/pages/member/buyers/left_menu.jsp"%>
	<div class="member_management_content_right">
		<div class="member_index_main_content">
			<h1>我的资料</h1>
			<div class="member_index_user_data">
				<h2>头像上传</h2>
				<div class="user_uploadavatar">
					<div class="uploadImg">
						<div>
							<img id="imgShow1" />
						</div>
						<input type="hidden" id="hidImgName" /> <span
							class="ui-button-morange ui-button" style="margin: 40px"><input
							class="ui-button-text" id="btnUploadImg" value="上传" type="button"
							name="avatar"></span> <span class="ui-button-morange ui-button"><input
							class="ui-button-text" id="btnDeleteImg" value="删除" type="button"
							name="delAvatar"></span>
					</div>
				</div>
				<h2>基本资料</h2>
			</div>
			<s:token></s:token>
			<div class="submit_reg_btn">
							<span class="ui-button-morange ui-button"><input
								class="ui-button-text" id="login" value="修改" type="button"></span>
						</div>
		</div>
	</div>
</div>
<div class="cell" style="display: none;">
	<s:form action="base_updateBaseInfor" namespace="/member/buyers" id="alert_userinfo" class="ui-form">
		<div class="login_form_content">
			<h3 class="login_form_title">修改个人信息</h3>
			<div class="ui-form-item">
				<label for="realname" class="ui-label"><span
					class="ui-form-required"></span>真实姓名：</label> <input id="realname"
					name="realName" class="ui-input" type="text" />
				<div class="ui-form-explain">请输入你的真实姓名</div>
			</div>
			<div class="ui-form-item" id="gender">
				<label class="ui-label"><span class="ui-form-required"></span>性别：</label>
				<input id="male" value="male" name="sex" type="radio"> <label
					for="male">Male</label> <input id="female" value="female"
					name="sex" type="radio"> <label for="female">Female</label>
				<input id="unknow" value="unknow" name="sex" type="radio"> <label
					for="unknow">Unknow</label>
				<div class="ui-form-explain" style="display: none;"></div>
			</div>
			<div class="ui-form-item" style="position: relative">
				<label for="user_birth" class="ui-label"><span
					class="ui-form-required"></span>生日：</label> <input type="text"
					id="user_birth" name="birthday" class="ui-input">
				<div class="ui-form-explain">请点击输入框选择日期</div>

			</div>
			<div class="ui-form-item">
				<label for="s1" class="ui-label"><span
					class="ui-form-required"></span>所在区域：</label> <SELECT ID="s1" name="s1"
					style="max-width: 125px;">
					<OPTION selected></OPTION>
				</SELECT> <SELECT ID="s2" name="s2" style="max-width: 125px;">
					<OPTION selected></OPTION>
				</SELECT> <SELECT ID="s3" name="areaId" style="max-width: 125px;">
					<OPTION selected value="${s3}"></OPTION>
				</SELECT>
				<div class="ui-form-explain">请选择您的区域</div>
			</div>
			<s:token></s:token>
			<div class="submit_reg_btn">
				<span class="ui-button-morange ui-button"><input
					class="ui-button-text" id="submit_login" value="确定" type="submit"></span>
			</div>
		</div>
	</s:form>
</div>
<script type="text/javascript">
	$(function() {
		seajs.use([ '$', 'validator', 'select', 'dialog', 'handlebars' ],
						function($, Validator, Select, Dialog, Handlebars) {
							var userinfoItemTpl = null;
								function load(){
									ajax('POST','CustomerBaseInfor_showBaseInfor.json',null,null).success(function(data){
										if (!userinfoItemTpl) {
											userinfoItemTpl = Handlebars.compile($('#TPL-userinfoItem').html());
											$('.member_index_user_data').append(userinfoItemTpl(data));
										}
									});
								}
								load();
							var validator = new Validator({
								element : '#alert_userinfo',
							});
							validator.addItem({
								element : '#realname',
							}).addItem({
								element : '[name=sex]',
							}).addItem({
								element : '#s1',
								rule : 'text',
								errormessageRequired : '请选择您的区域'
							}).addItem({
								element : '#s2',
								rule : 'text',
								errormessageRequired : '请选择您的区域'
							}).addItem({
								element : '#s3',
								rule : 'text',
								errormessageRequired : '请选择您的区域'
							});
							new Dialog({
								trigger : '#login',
								content : $('#alert_userinfo'),
								effect : 'fade'
							});
						});

		new Pikaday({
			field : document.getElementById('user_birth'),
			minDate : new Date('1953-01-01'),
			maxDate : new Date('2013-12-31'),
			yearRange : [ 1953, 2013 ],
		});
		$.ajax({
			type : "post",
			url : '/adminjson/jsondeal_areaInfo.json',
			cache:false,
			data : "",
			dataType : "json",
			success : function(result) {
				var rjson = result.jsonArray;
				var array = new Array();
				for ( var i = 0; i < rjson.length; i++) {
					array[i] = new Array(rjson[i].cid, rjson[i].pid,
							rjson[i].name);
				}
				var liandong = new CLASS_LIANDONG_YAO(array); //设置数据源
				liandong.firstSelectChange("根目录", "s1"); //设置第一个选择框
				liandong.subSelectChange("s1", "s2"); //设置子级选择框
				liandong.subSelectChange("s2", "s3");
			}
		});
	});
</script>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>
