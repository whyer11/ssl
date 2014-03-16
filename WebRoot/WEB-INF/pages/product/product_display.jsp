<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="wrapper">
	<div class="section_container">
		<!--Mid Section Starts-->
		<section>
			<!--SIDE NAV STARTS-->
			<div id="side_nav">
				<div class="sideNavCategories">
					<h1>商品分类</h1>
					<ul class="test">
						<li>
							<h3 id="firstCat">
								<s:property value="procategoryId" />
							</h3>
						</li>
					</ul>
					<ul class="category departments">
						<s:iterator value="categories">
							<li><a class="categoryclick"
								data-cid="<s:property value="categoryId" />" href="#"><s:property
										value="name" /></a></li>
						</s:iterator>
					</ul>
					

				</div>
			</div>
			<!--SIDE NAV ENDS-->
			<!--MAIN CONTENT STARTS-->
			<div id="main_content">
				<div class="category_banner">
					<img src="/images/promo_cat_banner.jpg" />
				</div>
				<ul class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Women</a></li>
					<li class="active"><a href="#">Shirts & Blouses</a></li>
				</ul>
				<!--Toolbar-->
				<div class="toolbar">
					<div class="sortby">
						<label>Sort by :</label> <select>
							<option>PRICE</option> NAME
							</o
						ption>
						</select>
					</div>
					<div class="viewby">
						<label>View as :</label> <a class="list" href="#"></a> <a
							class="grid" href="#"></a>
					</div>
					<div class="show_no">
						<label>Show :</label> <select>
							<option>12 ITEMS</option>
							<option>24 ITEMS</option>
						</select>
					</div>
				</div>
				<!--Toolbar-->
				<!--Product List Starts-->
				<div class="products_list products_slider">
					<ul id="ulwrapper">
						<s:action name="product_getAllByCategoryId" executeResult="true"
							namespace="/product">
						</s:action>
					</ul>
				</div>
				<!--Product List Ends-->
				<!--Toolbar-->
				<div class="toolbar">
					<div class="sortby">
						<label>Sort by :</label> <select>
							<option>PRICE</option>
							<option>NAME</option>
						</select>
					</div>
					<div class="viewby">
						<label>View as :</label> <a class="list" href="#"></a> <a
							class="grid" href="#"></a>
					</div>
					<div class="show_no">
						<label>Show :</label> <select>
							<option>12 ITEMS</option>
							<option>24 ITEMS</option>
						</select>
					</div>
				</div>
				<!--Toolbar-->
				<!-- next and pre -->
				<ul>
					<li><a class="pageMove" id="firstPage" href="#" data-cid="0">第一页</a></li>
					<li><a class="pageMove" id="prePage" href="#" data-cid="">上一页</a></li>
					<li><h3 id="currentPage"></h3></li>
					<li><a class="pageMove" id="nextPage" href="#" data-cid="">下一页</a></li>
				</ul>
				<!-- next and pre -->
			</div>
			<!--MAIN CONTENT ENDS-->
		</section>
		<!--Mid Section Ends-->
	</div>
</div>
<script type="js/TPL" id="TPL-productItem">
	<li ><a  href="product3_getProDetailInfo.json?productId={{productId}}" class="product_image"><img  
			src="{{imageLink}}" style="width:224px; height:246px;"/></a>
		<div class="product_info">
			<h3>
				<a  href="product3_getProDetailInfo.json?productId={{productId}}"   >{{name}}</a>
			</h3>
			<small>
			{{description}}
			</small>
		</div>
		<div class="price_info">
			<a href="#">+ Add to wishlist</a>
			<button class="price_add" title="" type="button">
				<span class="pr_price">{{price}}</span><span class="pr_add">加入购物车</span>
			</button>
		</div></li>
</script>
<script type="text/javascript">
	seajs.use([ '$', 'handlebars' ], function($, Handlebars) {
		var currentPage = 0;
		var currentPagehtml = $('#currentPage');
		var firstCat = $('#firstCat').text();
		var currentCategory = firstCat;
		currentPagehtml.text('第' + currentPage + '页');
		var productItemTpl = null;
		$(".categoryclick").click(
				function() {
					var selected = $(this);
					var cid = selected.data('cid');
					currentCategory = cid;
					alert(cid);
					var proList = '';
					proList = $('#ulwrapper');
					proList.html("");
					$.ajax({
						type : "GET",
						url : 'product/product2_getAllByCategoryId1.json',
						data : {
							procategoryId : cid
						},
						dataType : "json",
						success : function(p_result) {
							if (!productItemTpl) {
								productItemTpl = Handlebars.compile($(
										'#TPL-productItem').html());
							}
							$.each(p_result, function(i, val) {
								proList.append(productItemTpl(val));
							});
						}
					});
				});
		$(".pageMove").click(
				function() {
					var selected = $(this).parent();
					var selectedId = this.id;
					if (selectedId == "prePage") {
						currentPage--;
						alert(currentPage);
						currentPagehtml.text('第' + currentPage + '页');
						alert(currentCategory);
						$.ajax({
							type : "GET",
							url : 'product/product2_getAllByCategoryId1.json',
							data : {
								procategoryId : currentCategory,
								currentPage : currentPage
							},
							dataType : "json",
							success : function(p_result) {
								if (!productItemTpl) {
									productItemTpl = Handlebars.compile($(
											'#TPL-productItem').html());
								}
								$.each(p_result, function(i, val) {
									proList.append(productItemTpl(val));
								});
							}
						});
					} else if (selectedId == "nextPage") {
						currentPage++;
						alert(currentPage);
						currentPagehtml.text('第' + currentPage + '页');
						alert(currentCategory);
						$.ajax({
							type : "GET",
							url : 'product/product2_getAllByCategoryId1.json',
							data : {
								procategoryId : currentCategory,
								currentPage : currentPage
							},
							dataType : "json",
							success : function(p_result) {
								if (!productItemTpl) {
									productItemTpl = Handlebars.compile($(
											'#TPL-productItem').html());
								}
								$.each(p_result, function(i, val) {
									proList.append(productItemTpl(val));
								});
							}
						});
					} else {
						currentPage = 0;
						alert(currentPage);
						currentPagehtml.text('第' + currentPage + '页');
						alert(currentCategory);
						$.ajax({
							type : "GET",
							url : 'product/product2_getAllByCategoryId1.json',
							data : {
								procategoryId : currentCategory,
								currentPage : currentPage
							},
							dataType : "json",
							success : function(p_result) {
								if (!productItemTpl) {
									productItemTpl = Handlebars.compile($(
											'#TPL-productItem').html());
								}
								$.each(p_result, function(i, val) {
									proList.append(productItemTpl(val));
								});
							}
						});
					}
					var cid = selected.data('cid');
					var proList = '';
					proList = $('#ulwrapper');
					proList.html("");
					$.ajax({
						type : "GET",
						url : 'product/product2_getAllByCategoryId1.json',
						data : {
							procategoryId : cid
						},
						dataType : "json",
						success : function(p_result) {
							if (!productItemTpl) {
								productItemTpl = Handlebars.compile($(
										'#TPL-productItem').html());
							}
							$.each(p_result, function(i, val) {
								proList.append(productItemTpl(val));
							});
						}
					});
				});
	});
	$("body").delegate(".clickTodetail", "click", function() {
		var $selected = $(this);
		var productId = $selected.data('cid');
	});
</script>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>