<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="_pro">
<div class="section_container">
	<!--Mid Section Starts-->
	<section>
		<ul class="breadcrumb">
			
		</ul>
		<!--PRODUCT DETAIL STARTS-->
		<div id="product_detail">
			<!--Product Left Starts-->
			<div class="product_leftcol" >
				<img style="width:360px;  height:360px;" src="<s:property value="imageLinkArray[1]"/>" />
			</div>
			<!--Product Left Ends-->
			<!--Product Right Starts-->
			<div class="product_rightcol" >
				<small class="pr_type">Formal Dress</small>
				<h1>Notch-collar shirt</h1>
				<p class="short_dc" />
			<s:property value="description"/>
				<div class="pr_price">
					<big><s:property value="price"/></big> <small>$72.00</small>
				</div>
				<div class="qty_info">
					<div class="quantity">
						<label>Quantity :</label> <select>
							<option />1
							<option />2
						</select>
					</div>
				</div>
				<div class="add_to_buttons">
					<button class="add_cart">立即购买</button>
					<span>or</span>
					<button class="add_cart">加入购物车</button>
				</div>
			</div>
			<!--Product Right Ends-->
		</div>
		<!--  -->
		<script>
			$(function() {

				// Calling the plugin
				$("#product_detailpic").organicTabs();

			});
		</script>
		<!--  -->
		<div class="product_detailpic" id="product_detailpic">
			<ul class="nav">
				<li class="nav-one"><a href="#baobei_detail" class="current">宝贝详情</a></li>
				<li class="nav-two"><a href="#comment">各种评价</a></li>
				<li class="nav-three last"><a href="#store_detail">商家详情</a></li>
			</ul>
			<div class="list-wrap">
				<ul id="baobei_detail">
				 <s:iterator value="imageLinkArray" var="link">
				 <s:if test="#link != null">
				    <img style="width:660px;  height:660px;" src="<s:property value="link"/>" />
				 </s:if>
				
				 </s:iterator>
				
					
				</ul>

				<ul id="comment" class="hide">
					<a>asdasdasfd</a>
				</ul>

				<ul id="store_detail" class="hide">
					<a>asfsadfasdg</a>
				</ul>
			</div>
		</div>
		<!--PRODUCT DETAIL ENDS-->
		<!--Product List Starts-->
		<div class="products_list products_slider">
			<h2 class="sub_title">You might also like</h2>
			<ul id="first-carousel"
				class="first-and-second-carousel jcarousel-skin-tango">
				<li><a class="product_image"><img
						src="/images/pr_l_1.jpg" /></a>
					<div class="product_info">
						<h3>
							<a href="leisure_detail.html">CN Clogs Beach/Garden Clog</a>
						</h3>
						<small>Comfortable and fun to wear these clogs are the
							latest trend in fash</small>
					</div>
					<div class="price_info">
						<a href="#">+ Add to wishlist</a>
						<button class="price_add" title="" type="button">
							<span class="pr_price">$76.00</span><span class="pr_add">加入购物车</span>
						</button>
					</div></li>
				<li><a class="product_image"><img
						src="/images/pr_l_2.jpg" /></a>
					<div class="product_info">
						<h3>
							<a href="leisure_detail.html">CN Clogs Beach/Garden Clog</a>
						</h3>
						<small>Comfortable and fun to wear these clogs are the
							latest trend in fash</small>
					</div>
					<div class="price_info">
						<a href="#">+ Add to wishlist</a>
						<button class="price_add" title="" type="button">
							<span class="pr_price">$76.00</span><span class="pr_add">加入购物车</span>
						</button>
					</div></li>
				<li><a class="product_image"><img
						src="/images/pr_l_3.jpg" /></a>
					<div class="product_info">
						<h3>
							<a href="leisure_detail.html">CN Clogs Beach/Garden Clog</a>
						</h3>
						<small>Comfortable and fun to wear these clogs are the
							latest trend in fash</small>
					</div>
					<div class="price_info">
						<a href="#">+ Add to wishlist</a>
						<button class="price_add" title="" type="button">
							<span class="pr_price">$76.00</span><span class="pr_add">加入购物车</span>
						</button>
					</div></li>
				<li><a class="product_image"><img
						src="/images/pr_l_5.jpg" /></a>
					<div class="product_info">
						<h3>
							<a href="leisure_detail.html">CN Clogs Beach/Garden Clog</a>
						</h3>
						<small>Comfortable and fun to wear these clogs are the
							latest trend in fash</small>
					</div>
					<div class="price_info">
						<a href="#">+ Add to wishlist</a>
						<button class="price_add" title="" type="button">
							<span class="pr_price">$76.00</span><span class="pr_add">加入购物车</span>
						</button>
					</div></li>
				<li><a class="product_image"><img
						src="/images/pr_l_1.jpg" /></a>
					<div class="product_info">
						<h3>
							<a href="leisure_detail.html">CN Clogs Beach/Garden Clog</a>
						</h3>
						<small>Comfortable and fun to wear these clogs are the
							latest trend in fash</small>
					</div>
					<div class="price_info">
						<a href="#">+ Add to wishlist</a>
						<button class="price_add" title="" type="button">
							<span class="pr_price">$76.00</span><span class="pr_add">加入购物车</span>
						</button>
					</div></li>
				<li><a class="product_image"><img
						src="/images/pr_l_2.jpg" /></a>
					<div class="product_info">
						<h3>
							<a href="leisure_detail.html">CN Clogs Beach/Garden Clog</a>
						</h3>
						<small>Comfortable and fun to wear these clogs are the
							latest trend in fash</small>
					</div>
					<div class="price_info">
						<a href="#">+ Add to wishlist</a>
						<button class="price_add" title="" type="button">
							<span class="pr_price">$76.00</span><span class="pr_add">加入购物车</span>
						</button>
					</div></li>
			</ul>
		</div>
		<!--Product List Ends-->

	</section>
	<!--Mid Section Ends-->
</div>

</s:iterator>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>