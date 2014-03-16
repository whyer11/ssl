<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>

<script type="text/javascript">
	$(function() {
		seajs.use([ '$', 'sticky' ], function($, sticky) {
			sticky("#deal_nav_c", 0, function(status) {
				if (status) {
					seajs.log("stick");
				} else {
					seajs.log("unstick");
				}
			});
		});
	})
</script>

<div class="section_container">
	<section>
		<ul class="breadcrumb">
			<li><a href="#">Home</a></li>
			<li><a href="leisure_listing.html">Women</a></li>
			<li class="active"><a href="#">Shirts & Blouses</a></li>
		</ul>
		<div class="content">
			<div class="deal_intro">
			<div class="deal_intro_left">
				<div class="deal-brand">
					福建原家沙县小吃
				</div>
				<div class="s_status">
					<p>正在营业</p>	
				</div>
				<div class="s_time">
					<p>营业时间：9:00-23:00</p>
				</div>
			</div>
				<div class="deal-buy-cover-img">
					<img src="/images/lm_banner_2.jpg" />
				</div>
				<div class="deal-preference">
					<div class="preference-bar">

						<div class="deal-share">
							<ul>
								<li><a class="im" id="deal-share-im">QQ/MSN</a></li>
								<li><a class="sina" target="_blank">新浪微博</a></li>
								<li><a class="qq" target="_blank">腾讯微博</a></li>
								<li><a class="renren" target="_blank">人人</a></li>
								<li><a class="douban" target="_blank">豆瓣</a></li>
								<li><a class="qzone" target="_blank">QQ空间</a></li>
							</ul>
							<span class="share-tip">分享到</span>
						</div>
						<a href="javascript:void(0)" class="add-favorite"
							gaevent="content/main/addFavorite"><i></i>收藏本店</a>
					</div>
				</div>
			</div>
			<div class="deal_rating">
				<a href="#anchor-reviews" class="more inline-block">查看全部评价</a> 消费评分：<span
					class="score-info inline-block"><em>4.5</em> <span
					class="common-rating rating-16x16 stars"> <span
						class="rate-stars" style="width: 90%;"> </span>
				</span> </span>已有5800人评价
			</div>
			<div class="deal_other">
				<h3>该商家的推荐商品</h3>
				<ul class="item-list">
					<li><a class="first" target="_blank"> <span class="sale">39170人已购买</span>
							<span class="money"> <span class="price">¥277</span><span
								class="value-cn">门店价 </span><span class="value">¥579</span>
						</span> <span class="biz-title">【南京等】4-6人套餐，营养美味，欢乐聚餐</span>
					</a></li>
					<li><a target="_blank"> <span class="sale">6762人已购买</span>
							<span class="money"> <span class="price">¥577</span><span
								class="value-cn">门店价 </span><span class="value">¥1137</span>
						</span> <span class="biz-title">【南京等】7-8人精品火锅套餐，珍宝蟹领衔</span>
					</a></li>
					<li><a target="_blank"> <span class="sale">1089人已购买</span>
							<span class="money"> <span class="price">¥1277</span><span
								class="value-cn">门店价 </span><span class="value">¥2406</span>
						</span> <span class="biz-title">【南京等】10-12人精品火锅套餐，珍宝蟹领衔</span>
					</a></li>
					<li><a "
						target="_blank"> <span class="sale">1035人已购买</span>
							<span class="money"> <span class="price">¥977</span><span
								class="value-cn">门店价 </span><span class="value">¥1911</span>
						</span> <span class="biz-title">【南京等】10人精品火锅套餐，加拿大龙虾领衔</span>
					</a></li>
				</ul>
			</div>
			<div class="deal_nav">
				<ul id="deal_nav_c" style="z-index: 1000;">
					<li><a id="a1" href="#location">商家位置</a></li>
					<li><a id="a2" href="#deal_detail">店铺菜单</a></li>
					<li><a id="a3" href="#intro">商家介绍</a></li>
					<li><a id="a4" href="#comment">消费评价</a></li>
				</ul>
			</div>
			<div class="deal_stuff">
				<h3 id="location">商家位置</h3>
				<div class="location main_title">
					<a>asdas</a><br> <a>dasdasd</a><br> <a>sdasdas</a>
				</div>
				<h3 id="deal_detail">店铺菜单</h3>
				<div class="deal_detail main_title">
					<div class="s_goods">
						<div class="s_good_title">
							<h1>炒饭</h1>
						</div>
						<div class="s_good_content products_list products_slider">
							<ul>
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
							</ul>
						</div>
					</div>
				</div>
				<h3 id="intro">商家介绍</h3>
				<div class="intro main_title">
					<a>asdas</a>
				</div>
				<h3 id="comment">消费评价</h3>
				<div class="comment main_title">
					<a>asdas</a>
				</div>
			</div>
		</div>
		<div class="sidebar"></div>
	</section>
</div>
<script type="text/javascript">
	$(function() {

		$(window)
				.scroll(
						function() {
							if (($(window).scrollTop() > $('#location')
									.offset().top)
									&& ($(window).scrollTop() < $(
											'#deal_detail').offset().top)) {
								$('#a1').parent().parent().find('li a')
										.removeClass('nac_active');
								$('#a1').addClass('nac_active');
							} else if (($(window).scrollTop() > $(
									'#deal_detail').offset().top)
									&& ($(window).scrollTop() < $('#intro')
											.offset().top)) {
								$('#a2').parent().parent().find('li a')
										.removeClass('nac_active');
								$('#a2').addClass('nac_active');
							} else if (($(window).scrollTop() > $('#intro')
									.offset().top)
									&& ($(window).scrollTop() < $('#comment')
											.offset().top)) {
								$('#a3').parent().parent().find('li a')
										.removeClass('nac_active');
								$('#a3').addClass('nac_active');
							} else if (($(window).scrollTop() > $('#comment')
									.offset().top)
									&& ($(window).scrollTop())) {
								$('#a4').parent().parent().find('li a')
										.removeClass('nac_active');
								$('#a4').addClass('nac_active');
							}
							$('#deal_nav_c').delegate(
									'a',
									'click',
									function() {
										$(this).parent().parent().find('li a')
												.removeClass('nac_active');
										$(this).addClass('nac_active');

									});
						});

	});
</script>

<%@include file="/WEB-INF/pages/common/footer.jsp"%>