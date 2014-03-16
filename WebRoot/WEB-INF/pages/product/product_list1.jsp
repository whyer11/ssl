<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="products"> 
<li ><a href="product3_getProDetailInfo.json?productId=<s:property value="productId"/>"  class="product_image"><img 
			src="<s:property value="imageLinkArray[1]" />" style="width:224px; height:246px;"/></a>
		<div class="product_info">
			<h3>
				<a  href="product3_getProDetailInfo.json?productId=<s:property value="productId"/>" class="clickTodetail" data-cid="<s:property value="productId"/>" ><s:property value="name" /></a>
			</h3>
			<small>
			<s:property value="description"/>
			</small>
		</div>
		<div class="price_info">
			<a href="#">+ Add to wishlist</a>
			<button class="price_add" title="" type="button">
				<span class="pr_price"><s:property value="price"/></span><span class="pr_add">加入购物车</span>
			</button>
		</div></li>
	
</s:iterator>