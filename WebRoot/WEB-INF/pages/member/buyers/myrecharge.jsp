<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<head>
<link rel="stylesheet" href="/css/admin/adproduct.css" type="text/css"
	media="screen">
<script type="text/javascript">
	$(function() {
		seajs.use([ '$', 'validator' ], function($, Validator) {	
			Validator.addRule('oneTimes', /^[1-9](\d)*$/, '{{display}}必须为正整数');
			var validator = new Validator({
				element : '#test-form'
			});
			validator.addItem({
				element : '#scoreRmb',
				rule : 'oneTimes',
				required : true,
				display : '金额',
			}).addItem({
				element : '[name=paytype]',
				required : true,
				display : '充值方式',
			});
			$('#scoreul li').bind('click', function() {
				$(this).find('input').attr("checked", "checked");
			});			
			$('#scoreRmb').blur(function(){
				var ab=$('#scoreRmb').val()*50;
				console.log('%o',ab);
				$('#adscore').val( ab);
				
			}) ;	
		});
	});
</script>
</head>
<div class="member_management_content">
	<%@include file="/WEB-INF/pages/member/buyers/left_menu.jsp"%>
	<div class="member_management_content_right">
		<div class="member_index_main_content">
			<h1>我的积分</h1>
			<div class="user_score">
				<div class="content-box-content" style="padding-top: 100px;">
					<s:form class="ui-form" id="test-form" method="post"
						action="recharge_payForScore" namespace="/member/buyers">
						<legend></legend>
						<input type="hidden" value="${slideId}" name="slideId">
						<!-- 修改数据默认填入对话框 -->

						<div class="ui-form-item">
							<label for="" class="ui-label">充值金额:(元) </label> <input
								class="ui-input score-input " type="text" name="WIDtotal_fee"
								id="scoreRmb">
							<div class=" ui-form-explain ">需要为正整数:如1,2...</div>
						</div>
						<div class="ui-form-item ">
							<label for="" class="ui-label">可换成积分</label> <input
								name="adscore" class="ui-input score-input " type="text"
								id="adscore" disabled="disabled">
							<div class="ui-form-explain">兑换比例为1:50</div>
						</div>
						<input type="hidden" name="WIDout_trade_no" value="${WIDout_trade_no }">
						<input type="hidden" name="WIDsubject" value="${WIDsubject }">
						<input type="hidden" name="WIDbody" value="${WIDbody }">
						<div class="ui-form-item ">
							<label class="ui-label">支付方式</label>
							<ul class="score-ul-li" id="scoreul">
								<li><input type="radio" name="paytype" id="paytype" value="1"><img
									alt="" src="/images/ALIPAY.jpg"></li>
								<li><input type="radio" name="paytype" id="paytype" value="2"><img
									alt="" src="/images/02.gif"></li>
								<li><input type="radio" name="paytype" id="paytype" value="3"><img
									alt="" src="/images/02.gif"></li>
								<li><input type="radio" name="paytype" id="paytype" value="4"><img
									alt="" src="/images/02.gif"></li>
								<li><input type="radio" name="paytype" id="paytype" value="5"><img
									alt="" src="/images/02.gif"></li>
								<li><input type="radio" name="paytype" id="paytype" value="6"><img
									alt="" src="/images/02.gif"></li>
								<li><input type="radio" name="paytype" id="paytype" value="7"><img
									alt="" src="/images/02.gif"></li>
							</ul>
							<div class="ui-form-explain" style="clear: both;">请选择充值方式</div>
						</div>
						<s:token></s:token>
						<div class="submit_reg_btn">
							<span class="ui-button-morange ui-button"> <input
								id="submit_reg" class="ui-button-text" value="确定" type="submit"></span>
						</div>
					</s:form>
					<!-- End .clear -->
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>