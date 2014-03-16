<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<div class="member_management_content">
	<%@include file="/WEB-INF/pages/member/buyers/left_menu.jsp"%>
	<div class="member_management_content_right">
		<div class="member_index_main_content">
			<h1>我的积分</h1>
			<div class="user_score">
				<div class="ui-form-item">
					<label for="user_score" class="ui-label"><span
						class="ui-form-required"></span>您当前的积分为：</label>
					<div class="ui-form-explain">
						<a>${score}</a>
					</div>
				</div>			
				<s:a action="recharge_chargeScore" namespace="/member/buyers" class="btn btn-primary">充值</s:a>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>