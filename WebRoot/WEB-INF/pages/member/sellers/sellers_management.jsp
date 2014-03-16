<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div class="member_management_content">
	<%@include file="/WEB-INF/pages/member/sellers/left_menu.jsp"%>
	<div class="member_management_content_right">
		<div class="member_index_main_content">
			<h1>商家资料</h1>
			<div class="sellers_basedata">
				<h2>基本资料</h2>
				<form id="sellers_basedata_form">
					<div class="ui-form-item">
						<label for="useravatar" class="ui-label"><span
							class="ui-form-required"></span>头像：</label> <input id="useravatar"
							name="useravatar" class="ui-input" type="text" />
						<div class="ui-form-explain">上传自己的头像</div>
					</div>
					<div class="ui-form-item">
						<label for="nickname" class="ui-label"><span
							class="ui-form-required"></span>昵称：</label> <input id="nickname"
							name="nickname" class="ui-input" type="text" />
						<div class="ui-form-explain">请输入你的昵称</div>
					</div>
					<div class="ui-form-item">
						<label for="realname" class="ui-label"><span
							class="ui-form-required"></span>真实姓名：</label> <input id="realname"
							name="realname" class="ui-input" type="text" />
						<div class="ui-form-explain">请输入你的真实姓名</div>
					</div>
					<div class="ui-form-item">
						<label for="mobilenumber" class="ui-label"><span
							class="ui-form-required"></span>手机号码：</label> <input id="mobilenumber"
							name="mobilenumer" class="ui-input" type="text" />
						<div class="ui-form-explain">修改你的手机号码</div>
					</div>
					<div class="ui-form-item" id="gender">
						<label class="ui-label"><span class="ui-form-required"></span>性别：</label>
						<input id="male" value="male" name="sex" type="radio"> <label
							for="male">Male</label> <input id="female" value="female"
							name="sex" type="radio"> <label for="female">Female</label>
						<div class="ui-form-explain" style="display: none;"></div>
					</div>
					<div class="ui-form-item">
						<label for="useremail" class="ui-label"><span
							class="ui-form-required"></span>安全邮箱：</label> <input id="useremail"
							name="useremail" class="ui-input" type="text" />
						<div class="ui-form-explain">请填写你的安全邮箱，可用于找回密码</div>
					</div>
				</form>
			</div>
			<div class="stores_data">
			<h2>店铺资料</h2>
				<form class="sellers_storesdata_form">
					<div class="ui-form-item">
						<label for="useravatar" class="ui-label"><span
							class="ui-form-required"></span>头像：</label> <input id="useravatar"
							name="useravatar" class="ui-input" type="text" />
						<div class="ui-form-explain">上传自己的头像</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>