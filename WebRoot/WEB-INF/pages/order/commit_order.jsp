<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<script>
$(function(){
	select_address('#addrForm');
}
		);

</script>
<div class="main">
	<div class="order_step">
	
	</div>
	<div class="order_address">
		<form id="addrForm" name="addrform">
			<h3>确认收货地址
				<span class="manage_address">
					<a>管理收货地点</a>
				</span>
			</h3>
			<ul class="address_list">
				<li class="address_tag">
					<div class="address_info">
						<input type="radio" name="address">
						<a>江苏省 南京市 栖霞区 南京市栖霞区仙林大学城听泉山庄碧樱苑8幢807 (王焕宇 收) 15651917885</a>
					</div>
				</li>
				<li class="address_tag">
					<div class="address_info">
						<input type="radio" name="address">
						<a>江苏省 南京市 栖霞区 南京市栖霞区仙林大学城听泉山庄碧樱苑8幢807 (王焕宇 收) 15651917885</a>
					</div>
				</li>
			</ul>
			<div class=""></div>
		</form>
	</div>
	<div class="order_content">
	
	</div>
</div>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>