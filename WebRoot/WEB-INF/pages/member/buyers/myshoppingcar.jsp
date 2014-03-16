<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div class="member_management_content">
	<%@include file="/WEB-INF/pages/member/buyers/left_menu.jsp"%>
	<div class="member_management_content_right">
		<div class="member_index_main_content">
			<h1>我的购物车</h1>
			<div id="shopping_cart" class="full_page">
				<div class="action_buttonbar">
					<button type="button" title="" class="continue">继续购物</button>
					<button type="button"
						onclick=" parent.location='leisure_checkout.html' " title=""
						class="checkout">结算</button>
				</div>
				<div class="cart_table">
					<table class="data-table cart-table" id="shopping-cart-table"
						cellpadding="0" cellspacing="0">
						<tr>
							<th colspan="2">Products</th>
							<th class="align_center" width="6%"></th>
							<th class="align_center" width="12%">单价</th>
							<th class="align_center" width="10%">数量</th>
							<th class="align_center" width="12%">结算总价</th>
							<th class="align_center" width="6%"></th>
						</tr>
						<tr>
							<td width="10%"><img src="/images/cart1.jpg" /></td>
							<td class="align_left" width="44%"><a class="pr_name"
								href="#">Notch-collar shirt</a><span class="pr_info">Proin
									gravida </span></td>
							<td class="align_center"><a href="#" class="edit">Edit</a></td>
							<td class="align_center vline"><span class="price">$49.90</span></td>
							<td class="align_center vline"><input class="qty_box"
								type="text" /></td>
							<td class="align_center vline"><span class="price">$49.90</span></td>
							<td class="align_center vline"><a href="#" class="remove"></a></td>
						</tr>
						<tr>
							<td><img src="/images/cart2.jpg" /></td>
							<td class="align_left" width="44%"><a class="pr_name"
								href="#">Notch-collar shirt</a><span class="pr_info">Proin
									gravida </span></td>
							<td class="align_center"><a href="#" class="edit">Edit</a></td>
							<td class="align_center vline"><span class="price">$49.90</span></td>
							<td class="align_center vline"><input class="qty_box"
								type="text" /></td>
							<td class="align_center vline"><span class="price">$49.90</span></td>
							<td class="align_center vline"><a href="#" class="remove"></a></td>
						</tr>
					</table>
					<div class="totals">
						<table id="totals-table">
							<tr>
								<td width="60%" colspan="1" class="align_left"><strong>Subtotal</strong></td>
								<td class="align_right" style=""><strong><span
										class="price">$109.00</span></strong></td>
							</tr>
							<tr>
								<td width="60%" colspan="1" class="align_left">Shipping
									cost</td>
								<td class="align_right" style=""><span class="price">$0.00</span></td>
							</tr>
							<tr>
								<td width="60%" colspan="1" class="align_left total">Grand
									Total</td>
								<td class="align_right" style=""><span class="total">$109.00</span></td>
							</tr>
						</table>
					</div>
				</div>
				<div class="action_buttonbar">
					<button type="button" title="" class="continue">继续购物</button>
					<button type="button"
						onclick="parent.location='leisure_checkout.html'" title=""
						class="checkout">结算</button>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>