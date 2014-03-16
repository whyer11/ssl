<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div class="member_management_content">
	<%@include file="/WEB-INF/pages/member/buyers/left_menu.jsp"%>
	<div class="member_management_content_right">
		<div class="member_index_main_content">
			<h1>购买过的店铺</h1>
			<div class="stores_categories">
				<ul>
					<li><a>店铺分类：</a></li>
					<li><a>全部</a></li>
					<li><a>KTV</a></li>
					<li><a>酒店</a></li>
					<li><a>健康</a></li>
					<li><a>美食</a></li>
					<li><a>电影</a></li>
					<li><a>服装</a></li>
				</ul>
			</div>
			<table class="bought_table">
				<thead>
					<tr class="col_name">
						<th class="bought_stores">店铺</th>
						<th class="bought_info">购买信息</th>
						<th class="bought_hot">收藏人气</th>
						<th class="bought_operate">操作</th>
					
					</tr>
				</thead>
				<tbody>
					<tr class="sep_row">
						<td class="middle_nothing"></td>
					</tr>
					<tr class="order_bd">
						<td class="bought_stores" colspan="1">
							<a class="pic_s50">
								<img alt="商品图片" src="/images/avatar.png" style="width:50px">
							</a>
							<div class="desc">
								<a class="baobei_name">野生周杰伦一只</a>
								<div class="spec">
									<span>颜色分类：紫色</span>
									<span>数量：100</span>
								</div>
							</div>
						</td>
						<td class="bought_info">80.00</td>
				
						<td class="bought_hot" rowspan="1">
						<a>收藏热度：</a>
						<span><a>12930</a></span><br>
						<a>查看物流</a>
						</td>
						<td class="bought_operate"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>