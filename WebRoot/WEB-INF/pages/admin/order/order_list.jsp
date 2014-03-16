<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<title>文档管理</title>
<link rel="stylesheet" type="text/css"
	href="/css/admin/adproduct.css" />
<link rel="stylesheet" type="text/css" href="/css/admin/alice.css " />
<link rel="stylesheet" href="/css/admin/reset.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/style(1).css"
	type="text/css" media="screen">
<link rel="stylesheet" href="/css/admin/invalid.css"
	type="text/css" media="screen">
<link rel="stylesheet" href="/css/admin/alice.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/iconfont.css"
	type="text/css" media="screen">
<link href="http://assets.spmjs.org/alice/select/1.0.0/select.css"
	rel="stylesheet">
<link rel="stylesheet" href="/css/admin/adproduct.css"
	type="text/css" media="screen">
<script charset="utf-8" id="seajsnode"
	src="http://static.alipayobjects.com/seajs/1.3.1/??sea.js,plugin-combo.js"></script>
<script id="template" type="text/x-handlebars-template">
<div class="ui-select">
  <ul class="ui-select-content" data-role="items">
    {{#if items}}
    {{#each items}}
    <li data-role="item" class="ui-select-item" style="width:190px;" data-value="{{matchKey}}">
        <a href="#">{{matchKey}}</a>
    </li>
    {{/each}}
    {{/if}}
  </ul>
</div>
</script>
<script>
	seajs.config({
		alias : {
			'$' : 'gallery/jquery/1.7.2/jquery',
			'autocomplete' : 'arale/autocomplete/1.2.2/autocomplete'
		}
	});
	seajs
			.use(
					[ '$', 'autocomplete' ],
					function($, AutoComplete) {
						new AutoComplete(
								{
									trigger : '#acTrigger2',
									submitOnEnter : false,
									selectFirst : true,
									template : $('#template').html(),
									locator : 'productNameList',
									classPrefix : 'ui-select',
									dataSource : '/adminjson/jsondeal_tuanInfo.html?qproduct={{query}}'
								}).on('itemSelect', function(abcdList) {
							console.log('%o', abcdList);
							$('#storename').text(abcdList);
						}).on('indexChange', function(currentIndex, lastIndex) {
							console.log(this.items[currentIndex]);

						}).render();

					});
</script>
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#checkall").click(function() {
			if (this.checked == true) {// 全选     
				$("input[type=checkbox][name=checkone]").each(function() {
					$(this).attr("checked", "checked");
				});
			} else {// 取消全选     
				$("input[type=checkbox][name=checkone]").each(function() {
					$(this).removeAttr("checked");
				});
			}
		});
		$("#checkall").click(function() {
			if (this.checked == true) {
				$(this).attr("checked","checked");
			}
			else{
				$(this).removeAttr("checked");
			}
		});	
		
		$('#selector').click(function(){
			$('.ui-select-content', this).toggleClass('hide');
		});
	});

</script>

</head>
<body>
	<div id="main-content">
		<div class="content-box">
			<!-- Start Content Box -->

			<div class="content-box-header">

				<h3>商品列表</h3>
				<div class="clear"></div>

			</div>
			
			
			<div class="content-box-content">
			
				<div class="ui-select" id="selector"  style="width: 90px;position:relative; float:left;margin:10px 0 0 0;">
			  <a href="#" class="ui-select-trigger" >
			    	默认ID
			    <i class="iconfont" title="下三角形" >&#xF03C;</i>
			  </a>
			  <ul class="ui-select-content hide ui-ul-li"  id ="whyer" style="position:absolute;">
				<li class="ui-select-item"><a href="admin/tuanDeal_list.html?selectValue=createTime&unDeleted=${unDeleted}&hasDeleted=${hasDeleted}">按时间</a></li>
			    <li class="ui-select-item"><a href="admin/tuanDeal_list.html?selectValue=store">按店铺</a></li>
			    <li class="ui-select-item"><a href="admin/tuanDeal_list.html?selectValue=category">按分类</a></li>
			    <li class="ui-select-item"><a href="admin/tuanDeal_list.html?selectValue=currentPrice">团购价</a></li>			    
			  </ul>
			</div>		
				
				<div class="fa-btn-up" style="float: left;">
					<a href="admin/tuanDeal_list.html?unDeleted=true">	<input type="button" class="ui-button ui-button-mwhite" value="未支付"></a>
					<a href="admin/tuanDeal_list.html?hasDeleted=true">	<input type="button" class="ui-button ui-button-mwhite" value="未发货"></a>
					<a href="admin/tuanDeal_list.html?hasDeleted=true">	<input type="button" class="ui-button ui-button-mwhite" value="未收货"></a>
					<a href="admin/tuanDeal_list.html">	<input type="button" class="ui-button ui-button-mwhite" value="全部"></a>
				</div>
				<div class="ui-form-item ui-form-item-error" style="float: right;">
					<s:form action="tuanDeal_list" method="post" >
						<input id="acTrigger2" class="ui-input" type="text"
							name="searchClause" placeholder="快速查询"/> <input type="submit"
							class="ui-button ui-button-morange" value="确定">

					</s:form>
				</div>
				<div class="ui-table-container" style="clear:both;">
					<table class="ui-table">
						<!-- 可以在class中加入ui-table-inbox或ui-table-noborder分别适应不同的情况 -->
						<thead>
							<tr>
								<th>订单ID</th>
								<th>订单编号</th>
								<th>买家</th>
								<th>店铺ID</th>
								<th>总价</th>
								<th>下单时间</th>						
								<th>交易状态</th>
								<th>订单状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<!-- 表头可选 -->
						<tbody>
							<s:iterator value="orderlists">
								<tr>
								
								
								
									<td><a href="www.baidu.com"><s:property value="orderId" /></a></td>
									<td>12345678890</td>
								<td><s:property value="customer.mobile" /></td>
									<td><s:property value="store.storeId" /></td>								
									<td><s:property value="totalPrice" /></td>								
									<td><s:property value="createTime" /></td>									
									<td>${state==0?"待支付":((state==1?"待发货":(state==2?"待收货":(state==3?"交易成功":""))))}</td> 	
									<td>已删除</td>
									<td><a
										href="admin/tuanDeal_deleted.html?deleteId=<s:property value="tuanId" />&pageIndex=${pageIndex}">删除</a>
										<a
										href="admin/tuanDeal_restore.html?restoreId=<s:property value="tuanId"/>&pageIndex=${pageIndex}">恢复</a>
										<a
										href="admin/tuanDeal_shows.html?showsId=<s:property value="tuanId"/>&pageIndex=${pageIndex}">查看</a>
										<a
										href="admin/tuanDeal_modified.html?modifiedId=<s:property value="tuanId"/>&pageIndex=${pageIndex}">修改</a>
									</td>
								</tr>
							</s:iterator>

						</tbody>
					</table>

				</div>

			</div>



			<div class="ui-paging">

				<a style="float: left;"
					href="admin/tuanDeal_list.html?pageIndex=${pageIndex==1?1:pageIndex-1}&unDeleted=${unDeleted}&hasDeleted=${hasDeleted}&selectValue=${selectValue}"
					class="ui-paging-prev"> <i class="iconfont" title="左三角形">&#xF039;</i>
					上一页
				</a> <a style="float: left;" href="#"
					class="ui-paging-item ui-paging-current">${pageIndex}</a>
					
					 <a
					style="float: left;"
					href="admin/tuanDeal_list.html?pageIndex=${pageIndex<pageCount?pageIndex+1:pageCount}&unDeleted=${unDeleted}&hasDeleted=${hasDeleted}&selectValue=${selectValue}"
					class="ui-paging-next"> 下一页 <i class="iconfont" title="右三角形">&#xF03A;</i>
				</a> 
				<span style="float: left;" class="ui-paging-info"><span
					class="ui-paging-bold">${pageIndex}/${pageCount}</span>页</span>
				
				<form style="float: left;">
					<span class="ui-paging-which "> <input name="pageIndex"
						type="text">
					</span> <input class="ui-paging-info ui-paging-goto" type="submit"
						value="跳转">
				</form>
			</div>
		</div>
	</div>

</body>



</html>