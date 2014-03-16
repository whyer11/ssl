<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- head file Starts -->
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/main.css" />
<link rel="stylesheet" href="/css/arale_form.css" />
<link rel="stylesheet" href="/css/base.css" />
<link rel="stylesheet" href="/css/flexslider.css" />
<link rel="stylesheet" href="/css/jcarousel_tango.css" />
<link rel="stylesheet" href="/css/responsive.css">
<link rel="stylesheet" href="http://assets.spmjs.org/alice/select/1.0.0/select.css">
<link rel="stylesheet" href="/css/calendar.css">

<script src="/js/jquery-1.7.2.min.js"></script>
<script src="/js/Jquery.Plugins.js"></script>
<!--
	<script src="/js/jquery.carouFredSel-6.1.0-packed.js"></script>
	<script src="/js/jquery.timePicker.js"></script>
	<script src="/js/pikaday.js"></script>
<script src="/js/jquery.easing.js"></script>
<script src="/js/organictabs.jquery.js"></script>
<script src="/js/jquery.flexslider.js"></script>
<script src="/js/jquery.jcarousel.js"></script>
 -->
<script src="/js/admin/sanji.js"></script>
<script src="/js/custom.js"></script>
<script src="/js/form_elements.js"></script>
<script charset="utf-8" id="seajsnode"
	src="http://static.alipayobjects.com/seajs/1.3.1/??sea.js,plugin-combo.js"></script>
<script src="/js/default.js"></script>
<script src="/js/AjaxUpload.js"></script>
<script src="/js/imageupload.js"></script>
<script src="/js/customerSupport.js"></script>
<meta name="author" content="">
<meta name="" content="">
<meta name="" content="">

<!-- arale config start -->
<script type="text/javascript">
	seajs.config({
		alias : {
			'$' : 'gallery/jquery/1.7.2/jquery',
			'sticky' : 'arale/sticky/1.2.1/sticky',
			'slide' : 'arale/switchable/1.0.0/slide',
			'tab' : 'arale/switchable/0.9.15/tabs',
			'dialog' : 'arale/dialog/1.1.3/dialog',
			'validator' : 'arale/validator/0.9.4/validator',
			'calendar' : 'arale/calendar/0.8.4/calendar',
			'select' : 'arale/select/0.9.5/select',
			'handlebars' : 'gallery/handlebars/1.0.2/handlebars',
			'autocomplete' : 'arale/autocomplete/1.2.2/autocomplete'
		}
	});
</script>
<script id="template" type="text/x-handlebars-template">
<div class="ui-select" style="width:477px">
  <ul class="ui-select-content" data-role="items">
    {{#if items}}
    {{#each items}}
    <li data-role="item" class="ui-select-item" style="cursor:default;" data-value="{{matchKey}}">
        <a>{{matchKey}}</a>
    </li>
    {{/each}}
    {{/if}}
  </ul>
</div>
</script>
<!-- arale config end -->
<script>
	$(function() {
		seajs
				.use(
						[ '$', 'sticky', 'tab', 'dialog', 'validator',
								'autocomplete' ],
						function($, sticky, Tabs, Dialog, Validator,
								AutoComplete) {
							sticky(".header_container", 0, function(status) {
								if (status) {
									seajs.log("stick");
								} else {
									seajs.log("unstick");
								}
							});
							tab_3 = new Tabs(
									{
										element : '#searcher_children',
										triggers : '#searcher_children .ui-switchable-nav li',
										panels : '#searcher_children .ui-switchable-content div',
										activeIndex : 0,
										effect : 'fade'
									}).render();
							new AutoComplete(
									{
										trigger : '#query_store',
										submitOnEnter : false,
										selectFirst : true,
										template : $('#template').html(),
										locator : 'storeArray',
										filter : {
											name : 'startsWith',
											options : {
												key : 'name'
											}
										},
										classPrefix : 'ui-select',
										dataSource : '/adminjson/jsondeal_storeInfo.html?qstore={{query}}'
									}).on('itemSelect', function(data, item) {
								console.log(data.label);
								alert(data.label);
							}).render();
							new AutoComplete(
									{
										trigger : '#query_baobei',
										submitOnEnter : false,
										selectFirst : true,
										template : $('#template').html(),
										locator : 'storeArray',
										filter : {
											name : 'startsWith',
											options : {
												key : 'name'
											}
										},
										classPrefix : 'ui-select',
										dataSource : '/adminjson/jsondeal_productInfo.html?qproduct={{query}}'
									}).on('itemSelect', function(data, item) {
								console.log(data.label);
								alert(data.label);
							}).render();

							new Dialog({
								trigger : '#login_top',
								content : $('#login_form'),
								effect : 'fade'
							});
							new Dialog({
								trigger : '#tobeaseller_nologin',
								content : $('#login_form_tobeseller'),
								effect : 'fade'
							});
							var validator_1 = new Validator({
								element : '#login_form_tobeseller',
								autoSubmit : false
							});
							validator_1.addItem({
								element : '#username',
								required : true,
								rule : 'text'
							}).addItem({
								element : '#password',
								required : true,
								rule : 'text'
							});
							var validator = new Validator({
								element : '#login_form',
								autoSubmit : false
							});

							validator.addItem({
								element : '#login_username',
								required : true,
								rule : 'text'
							})

							.addItem({
								element : '#login_password',
								required : true,
								rule : 'minlength{min:5}'
							});
						});
	});
	document.createElement("header");
	document.createElement("nav");
	$(function() {
		$(window).scroll(function() {
			if ($(window).scrollTop() > 100) {

				$('#backtotop').fadeIn(100);
			} else {
				$('#backtotop').fadeOut(100);
			}
		});
		$('#backtotop').click(function() {
			$('body,html').animate({
				scrollTop : 0
			}, 500);
		});
	});
	$(function() {
		$('#login_form').submit(function() {
			ajax('POST', 'LoginAction.json', {
				login_username : $('#login_username').val(),
				login_password : $('#login_password').val()
			}).success(function(data) {
				if (data.success == true) {
					window.location.reload();
				} else {
					$('#login_error').text('用户名或密码输入不正确，请重新输入');
				}
			});
		});
		$('#login_form_tobeseller')
				.submit(
						function() {
							ajax('POST', 'LoginAction.json', {
								login_username : $('#username').val(),
								login_password : $('#password').val()
							})
									.success(
											function(data) {
												if (data.success == true) {
													window.location.href = '/member/buyers/buyers_tobesellers.html';
												} else {
													$('#login_t_error')
															.text(
																	'用户名或密码输入不正确，请重新输入')
												}
											});
						});
		$('#login_out').click(function() {
			ajax('POST', 'Join2_logout.json', {}).success(function(data) {
				if (data.success == true) {
					window.location.href = '/index.html';
				}
			});
		});
	});
</script>
<title>送送乐</title>
</head>
<body>
	<div class="header_container">
		<!--Header Starts-->
		<header>
			<div class="top_bar clear">
				<!-- Back To Top Starts -->
				<a class="back_to_top" id="backtotop">点我返回顶部</a>
				<!-- Back To Top Ends -->
				<!--Top Links Starts-->
				<ul class="top_links">
					<%
						if (session.getAttribute("login_username") != null) {
					%>
					<li><s:a action="CustomerIndexAction_index"
							namespace="/member/buyers" class="welcome_username"
							id="welcome_username"><%=session.getAttribute("login_username")%></s:a></li>
					<li><a action="user/Join2_logout" id="login_out">退出登录</a></li>
					<li><s:a action="Join1_join" id="tobeaseller_login">商家加盟</s:a></li>

					<%
						} else {
					%>
					<li><a id="login_top" href="#" class="login_and_logout">登录</a></li>
					<li><a id="tobeaseller_nologin">商家加盟</a></li>
					<%
						}
					%>
					<li class="highlight"><s:a action="userreg" namespace="/user">注册</s:a></li>
				</ul>
				<!--Top Links Ends-->
			</div>
		</header>
		<!--Header Ends-->
	</div>
	<div class="logo_and_searcher">
		<!--Logo Starts-->
		<div class="logo"></div>
		<!--Logo Ends-->
		<!--Search Starts-->
		<div class="searcher">
			<div id="searcher_children" class="section">
				<ul class="ui-switchable-nav">
					<li>店铺</li>
					<li>宝贝</li>
				</ul>
				<s:form action="search_searchStore" namespace="/store">
					<div class="ui-switchable-content">
						<div style="display: none">
							<input id="query_store" name="storesearch"
								placeholder="嗯？你要找哪个店家呢，记得给好评哦~">
						</div>
						<div>
							<input id="query_baobei" name="baobeisearch"
								placeholder="来找找你的宝贝吧">
						</div>

						<input id="search_btn" type="submit" value="搜索">
					</div>
				</s:form>
			</div>
		</div>
	</div>
	<!--Search Ends-->
	<div id="nothing" class="main"></div>
	<!--Navigation Starts-->
	<div class="navigation_container">
		<nav>
			<ul class="primary_nav">
				<li class="active"><s:a action="index" namespace="/">首页</s:a></li>
				<s:action name="productArea_getAllArea" executeResult="true"
					namespace="/area">
				</s:action>
			</ul>
			<div class="minicart">
				<a href="#" class="minicart_link"> <span class="item"><b>2</b>
						ITEM /</span> <span class="price"><b>$69.20</b></span>
				</a>
				<div class="cart_drop">
					<span class="darw"></span>
					<ul>
						<li><img src="/images/mini_c_item1.png" /><a href="#">Clogs
								Beach/Garden Clog</a> <span class="price">$49.90</span></li>
						<li><img src="/images/mini_c_item2.png" /><a href="#">Faded
								chambray shorts</a> <span class="price">$12.90</span></li>
						<div class="cart_bottom">
							<div class="subtotal_menu">
								<small>Subtotal:</small><big>$69.20</big>
							</div>
							<a>Checkout</a>
						</div>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<!--Navigation Ends-->
	<!-- Log In Window Starts -->
	<div class="cell" style="display: none;">
		<form id="login_form" class="ui-form">
			<div class="login_form_content">
				<h3 class="login_form_title">登录送送乐</h3>
				<p id="login_error" class="login_error"></p>
				<div class="ui-form-item">
					<label for="login_username" class="ui-label"><span
						class="ui-form-required">*</span>用户名：</label> <input id="login_username"
						name="login_username" class="ui-input" type="text" />
					<div class="ui-form-explain">用户名为电子邮箱。</div>
				</div>
				<div class="ui-form-item">
					<label for="login_password" class="ui-label"><span
						class="ui-form-required">*</span>密码：</label> <input id="login_password"
						name="login_password" type="password" class="ui-input"
						data-explain="请输入5-20位的密码。" /> <a
						href="/customer/customer_getbackpassword.html"
						class="getbackpassword">忘记密码？</a>
					<div class="ui-form-explain">请输入密码</div>
				</div>
				<s:token></s:token>
				<div class="submit_reg_btn">
					<span class="ui-button-morange ui-button"><input
						class="ui-button-text" id="submit_login" value="确定" type="submit"></span>
				</div>
			</div>
		</form>
	</div>
	<div class="cell" style="display: none;">
		<form id="login_form_tobeseller" class="ui-form">
			<div class="login_form_content">
				<h3 class="login_form_title">登录送送乐</h3>
				<p id="login_t_error" class="login_error"></p>
				<div class="ui-form-item">
					<label for="username" class="ui-label"><span
						class="ui-form-required">*</span>用户名：</label> <input id="username"
						name="username" class="ui-input" type="text" />
					<div class="ui-form-explain">用户名为电子邮箱。</div>
				</div>
				<div class="ui-form-item">
					<label for="password" class="ui-label"><span
						class="ui-form-required">*</span>密码：</label> <input id="password"
						name="password" type="password" class="ui-input"
						data-explain="请输入5-20位的密码。" value="" />
					<div class="ui-form-explain">密码的长度必须大于或等于5。</div>
				</div>
				<s:token></s:token>
				<div class="submit_reg_btn">
					<span class="ui-button-morange ui-button"><input
						class="ui-button-text" id="submit_login" value="确定" type="submit"></span>
				</div>
			</div>
		</form>
	</div>
	<!-- Log In Window Ends -->
	<!--customer support online Starts-->
	<div id="floatTools" class="rides-cs">
		<div class="floatL">
			<a style="display: block" id="aFloatTools_Show" class="btnOpen"
				title="查看在线客服"
				onClick="javascript:$('#divFloatToolsView').animate({width: 'show', opacity: 'show'}, 'normal',function(){ $('#divFloatToolsView').show();kf_setCookie('RightFloatShown', 0, '', '/','www.songsongle.com'); });$('#aFloatTools_Show').attr('style','display:none');$('#aFloatTools_Hide').attr('style','display:block');"
				href="javascript:void(0);"> 展开</a> <a style="display: none"
				id="aFloatTools_Hide" class="btnCtn" title="关闭在线客服"
				onClick="javascript:$('#divFloatToolsView').animate({width: 'hide', opacity: 'hide'}, 'normal',function(){ $('#divFloatToolsView').hide();kf_setCookie('RightFloatShown', 1, '', '/', 'www.songsongle.com'); });$('#aFloatTools_Show').attr('style','display:block');$('#aFloatTools_Hide').attr('style','display:none');"
				href="javascript:void(0);"> 收缩</a>
		</div>
		<div id="divFloatToolsView" class="floatR" style="display: none">
			<div class="cn">
				<h3 class="titZx">产品销售</h3>
				<ul>
					<li><span>客服1</span> <a target="_blank"
						href="http://wpa.qq.com/msgrd?v=3&uin=490078184&site=qq&menu=yes">
							<img border="0" src="http://wpa.qq.com/pa?p=2:123456:51"
							alt="ShopNC客服1" title="ShopNC客服1" />
					</a></li>
					<li><span>客服2</span> <a target="_blank"
						href="http://wpa.qq.com/msgrd?v=3&uin=123456&site=qq&menu=yes">
							<img border="0" src="http://wpa.qq.com/pa?p=2:123456:51"
							alt="ShopNC客服2" title="ShopNC客服2" />
					</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!--customer support online Ends-->
	<!-- head file Ends -->