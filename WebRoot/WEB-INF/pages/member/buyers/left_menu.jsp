<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>	
<%if(session.getAttribute("login_username")!=null)
	{
	
	}else
	{
		
	}%>
<div id="side_nav">
	<div class="sideNavCategories">
		<h1>会员中心</h1>

		<ul class="category departments">
			<div class="member_avatar">
				<img src="/images/avatar.png">
			</div>
			<li class="header">hello,周杰伦</li>
			<li><s:a action="buyers_index" namespace="/member/buyers">我的资料</s:a></li>
			<li><s:a action="buyers_shoppingcar" namespace="/member/buyers">我的购物车</s:a></li>
			<li><s:a action="buyers_goods" namespace="/member/buyers">已买到的宝贝</s:a></li>
			<li><s:a action="buyers_storeshavebought" namespace="/member/buyers">购买过的店铺</s:a></li>
			<li><s:a action="buyers_collection" namespace="/member/buyers">我的收藏</s:a></li>
			<li><s:a action="recharge_myscore" namespace="/member/buyers">我的积分</s:a></li>
			<li><s:a action="buyers_tobesellers" namespace="/member/buyers">商家加盟</s:a></li>
			<li><s:a action="buyers_account" namespace="/member/buyers">账户设置</s:a></li>
			<li><s:a action="" namespace="">评价管理</s:a></li>
			<li><s:a action="Join2_logout" namespace="/member/buyers">退出登录</s:a></li>
		</ul>
	</div>
</div>