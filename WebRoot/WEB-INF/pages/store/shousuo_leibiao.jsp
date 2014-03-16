<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<link rel="stylesheet" href="/css/daohang.css" />
</head>
<div id="bg" class="main">
	<div class="w950">
		<div class="company_left">
			<dl class="choose">
				<dt>
					<span>以下是可送至 <b></b> 的商家
					</span>商家筛选条件：
				</dt>
				<dd>
					<span>二级地区选择</span>
					<s:iterator value="listAreas">
						<a class="secondareaClick clickable "
							data-cid="<s:property value="areaId" />" href="#"><s:property
								value="name" /></a>
					</s:iterator>
				</dd>
				<dd class="no">
					<span>商家主营类型</span>
					<s:action name="productCategory_getAllCategory"
						executeResult="true" namespace="/product">
					</s:action>
				</dd>
				<dd class="no" id="secondCategory">
					<span>二级类型分类</span>
					<s:action name="productCategory_getAllCategorydisplay"
						executeResult="true" namespace="/product">
					</s:action>
				</dd>
			</dl>
			<div id="storeListLeibiao">
				<s:iterator value="storelist">
					<div class="company_list t15">
						<div class="company_list_l"></div>
						<dl>
							<dt>
								<img src="<s:property value="imageLinkArray[1]" />" />
							</dt>
							<dd>
								<h3>
									<s:property value="name" />
								</h3>
								<ul>
									<li><div class="price"><s:property value="shipPrice"/>元起送</div>
										<div class="values">外送费<s:property value="shipFee"/>元</div>
										<div class="times">
											<s:property value="reachTime" />
											小时左右到达
										</div></li>
									<li><div class="address">地址：<s:property value="address"/></div></li>
									<li class="list_comment"><h5>口味 <s:property value="environmentScore"/>颗星：</h5>
										<h5 class="mr15 star-5"></h5>
										<h5>服务<s:property value="serviceScore"/>颗星：</h5>
										<h5 class="mr15 star-5"></h5>
										<h5>速度<s:property value="speedScore"/>颗星：</h5>
										<h5 class="mr15 star-5"></h5></li>
								</ul>
								<span> <s:a action="store_storeDetail" namespace="/store">
								<s:param name="storedetailId" value="storeId"></s:param>
								<img src="/images/order_big.jpg" /></s:a>
								</span>
							</dd>
						</dl>

						<div class="company_list_r"></div>
					</div>
				</s:iterator>
			</div>
			<div id="pages">
				<div class="pages">
					<a class="clickable " id="firstPage" href="#" data-cid="0">第一页</a>
					<a class="clickable" id="prePage" href="#" data-cid="">上一页</a>
					<!--   <h3 id="currentPage"></h3> -->
					<a class="clickable" id="nextPage" href="#" data-cid="">下一页</a>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>
<script type="js/TPL" id="TPL-secondCatItem">
<a class="categoryclick1 clickable"  
	data-cid="{{categoryId}}" >{{name}}</a>
</script>
<script type="js/TPL" id="TPL-storelistItem">
<div class="company_list t15">
	<dl>	

                        <dt>
                          <img class="storelistImg" src=""/>
                              
						</dt>
						<dd>
							<h3>
								{{store.name}}
							</h3>
							<ul>
								<li><div class="price">10元起送</div>
									<div class="values">外送费1元</div>
									<div class="times">
										{{reachTime}}
										小时左右到达
									</div></li>
								<li><div class="address">地址：南京体育学院</div></li>
								<li class="list_comment"><h5>口味：</h5>
									<h5 class="mr15 star-5"></h5>
									<h5>服务：</h5>
									<h5 class="mr15 star-5"></h5>
									<h5>速度：</h5>
									<h5 class="mr15 star-5"></h5></li>
							</ul>
							<span> <a href="company/show/26.html" target="_blank"><img
									src="/images/order_big.jpg" /></a>
							</span>
						</dd>
					</dl>
</div>
</script>
<script type="text/javascript">
	seajs.use([ '$', 'handlebars' ], function($, Handlebars) {
		var defaultArea = 0;
		var defaultCat = 0;
		var defaultPage = 0;
		var currentPage=null;
		var currentPagehtml = $('#currentPage');
		var currentCategory=null;
		var currentArea=null;
		var $storeListLeibiao = $('#storeListLeibiao');
		currentPagehtml.text('第' + currentPage + '页');
		var productItemTpl = null;
		var storelistItemTpl = null;

		$(".categoryclick").click(
				function() {
					var selected = $(this);
					var cid = selected.data('cid');
					currentCategory = cid;
					//	alert(cid);
					var proList = '';
					proList = $('#ulwrapper');

					var secondCategory = $('#secondCategory');
					secondCategory.html('<span>二级分类</span>');
					proList.html("");
					$.ajax({
						type : "GET",
						url : 'store/category_getCatByFirst.json',
						data : {
							categoryId : cid
						},
						dataType : "json",
						success : function(p_result) {
							if (!productItemTpl) {
								productItemTpl = Handlebars.compile($(
										'#TPL-secondCatItem').html());
							}
							$.each(p_result, function(i, val) {
								secondCategory.append(productItemTpl(val));

							});
						}
					});
				});
		$('body').delegate(
				'.clickable',
				'click',
			
				function() {
					if ($(this).attr("class") == "categoryclick1  clickable") {
						currentCategory = $(this).data('cid');
						
					}
					if ($(this).attr("class") == "secondareaClick clickable ") {

						currentArea = $(this).data('cid');
					
					}

					if ($(this).attr('id') == "prePage") {
						
						currentPage--;
					
					}

					if ($(this).attr('id') == "nextPage") {
						currentPage++;
					
					}
					if ($(this).attr('id') == "firstPage") {
						currentPage = 0;
			
					}
					if (!currentArea) {
						currentArea = defaultArea;
					}
					if (!currentCategory) {
						currentCategory = defaultCat;
					}
					if (!currentPage) {
						currentPage = defaultPage;
					}
					
					alert(currentArea);
					alert(currentCategory);
					alert(currentPage);
					
					$.ajax({
						type : "GET",
						url : 'store/storeAreaCat_getStoreByAreaAndCat.json',
						data : {
							currentCategory : currentCategory,
							currentPage : currentPage,
							currentArea : currentArea,
						},
						dataType : "json",
						success : function(p_result) {
							$storeListLeibiao.html('');
							if (!storelistItemTpl) {
								storelistItemTpl = Handlebars.compile($(
										'#TPL-storelistItem').html());
							}
							$.each(p_result, function(i, val) {
								
								var $storeListLeibiao1 = $('<div></div>');
								$storeListLeibiao1
										.append(storelistItemTpl(val));
								$storeListLeibiao1.find('.storelistImg').attr(
										'src', val.store.imageLinkArray[1]);

								$storeListLeibiao.append($storeListLeibiao1);
							});
						}
					});

				});

	});
	
</script>
