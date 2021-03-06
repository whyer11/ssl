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
<link rel="stylesheet" href="/css/admin/adproduct.css"
	type="text/css" media="screen">
<link
	href="http://assets.spmjs.org/alice/??box/1.0.0/box.css,button/1.1.1/button.css,button-dropdown/1.1.0/button-dropdown.css,form/1.0.1/form.css,list/1.0.0/list.css,nav/1.0.0/nav.css,paging/1.0.1/paging.css,poptip/1.1.1/poptip.css,tab/1.0.0/tab.css,table/1.0.1/table.css,tipbox/1.1.0/tipbox.css,tiptext/1.1.0/tiptext.css,select/1.0.0/select.css,loading/1.0.0/loading.css,step/1.0.3/step.css"
	rel="stylesheet">
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
			'autocomplete' : 'arale/autocomplete/1.2.2/autocomplete',
			'select' : 'arale/select/0.9.5/select'
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
									dataSource : '/adminjson/jsondeal_productInfo.html?qproduct={{query}}'
								}).on('itemSelect', function(abcdList) {
							console.log('%o', abcdList);
							$('#storename').text(abcdList);
						}).on('indexChange', function(currentIndex, lastIndex) {
							console.log(this.items[currentIndex]);

						}).render();

					});
</script>

<script type="text/javascript">
	seajs.use([ '$' ], function($) {

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
					$(this).attr("checked", "checked");
				} else {
					$(this).removeAttr("checked");
				}
			});

			$('#selector').click(function() {
				$('.ui-select-content', this).toggleClass('hide');
			});
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

			<div class="content-box-content" style="clear:both;">

				<div class="ui-select" id="selector"
					style="width: 90px; position: relative; float: left; margin: 10px 0 0 0;">
					<a href="#" class="ui-select-trigger"> 默认id<i class="iconfont"
						title="下三角形">&#xF03C;</i>
					</a>
					<ul class="ui-select-content hide ui-ul-li" id="whyer"
						style="position: absolute;">
						<li class="ui-select-item"><a
							href="admin/productA_list.html?storeId=${storeId}&selectValue=createTime&unDeleted=${unDeleted}&hasDeleted=${hasDeleted}&searchClause=${searchClause}">按时间</a></li>
						<li class="ui-select-item"><a
							href="admin/productA_list.html?storeId=${storeId}&selectValue=store&unDeleted=${unDeleted}&hasDeleted=${hasDeleted}&searchClause=${searchClause}">按店铺</a></li>
						<li class="ui-select-item"><a
							href="admin/productA_list.html?storeId=${storeId}&selectValue=category&unDeleted=${unDeleted}&hasDeleted=${hasDeleted}&searchClause=${searchClause}">按分类</a></li>
						<li class="ui-select-item"><a
							href="admin/productA_list.html?storeId=${storeId}&selectValue=price&unDeleted=${unDeleted}&hasDeleted=${hasDeleted}&searchClause=${searchClause}">按价格</a></li>

					</ul>
				</div>

				<div class="fa-btn-up" style="float: left;">
					<a
						href="admin/productA_list.html?storeId=${storeId}&unDeleted=true&selectValue=${selectValue}&searchClause=${searchClause}">
						<input type="button" class="ui-button ui-button-mwhite" value="未删">
					</a> <a
						href="admin/productA_list.html?storeId=${storeId}&hasDeleted=true&selectValue=${selectValue}&searchClause=${searchClause}">
						<input type="button" class="ui-button ui-button-mwhite" value="已删">
					</a> <a href="admin/productA_list.html?storeId=${storeId}"> <input
						type="button" class="ui-button ui-button-mwhite" value="全部"></a>
				</div>
				<div class="ui-form-item ui-form-item-error" style="float: right;">
					<s:form action="productA_list" method="get" theme="simple">

						<input id="acTrigger2" class="ui-input" type="text"
							name="searchClause" placeholder="商品查询" />
						<input type="submit" class="ui-button ui-button-morange"
							value="确定">

					</s:form>
				</div>
				<div class="ui-table-container">
					<table class="ui-table">
						<!-- 可以在class中加入ui-table-inbox或ui-table-noborder分别适应不同的情况 -->
						<thead>
							<tr>

								<th>商品ID</th>
								<th>商品名称</th>
								<th>店铺名称</th>
								<th>商品分类</th>
								<th>商品价格</th>
								<th>删除状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<!-- 表头可选 -->

						<tbody>

							<s:iterator value="lists">
								<tr>

									<td><s:property value="productId" /></td>
									<td><a
										href="admin/productA_shows.html?showsId=<s:property value="productId"/>&pageIndex=${pageIndex}&selectValue=${selectValue}"><s:property
												value="name" /></a></td>
									<td><a
										href="admin/storeDeal_shows.html?storeId=<s:property value="store.storeId"/>&pageIndex=${pageIndex}&selectValue=${selectValue}"><s:property
												value="store.name" /></a></td>
									<td><s:property value="category.name" /></td>
									<td><s:property value="price" /></td>
									<td>${deleted=="true"?"已删":"未删"}</td>
									<td><a
										href="admin/productA_deleted.html?deleteId=<s:property value="productId" />&pageIndex=${pageIndex}&selectValue=${selectValue}&unDeleted=${unDeleted}&hasDeleted=${hasDeleted}&searchClause=${searchClause}">删除</a>
										<a
										href="admin/productA_restore.html?restoreId=<s:property value="productId"/>&pageIndex=${pageIndex}&selectValue=${selectValue}&unDeleted=${unDeleted}&hasDeleted=${hasDeleted}&searchClause=${searchClause}">恢复</a>
										<a
										href="admin/productA_modified.html?storeId=<s:property value="store.storeId" />&modifiedId=<s:property value="productId"/>&pageIndex=${pageIndex}&selectValue=${selectValue}">修改</a>
										<a
										href="admin/productA_setTuan.html?productId=<s:property value="productId"/>&pageIndex=${pageIndex}&selectValue=${selectValue}">设为团购</a>
									</td>
								</tr>
							</s:iterator>

						</tbody>
					</table>

				</div>

			</div>



			<div class="ui-paging">

				<a style="float: left;"
					href="admin/productA_list.html?storeId=${storeId}&pageIndex=${pageIndex==1?1:pageIndex-1}&unDeleted=${unDeleted}&hasDeleted=${hasDeleted}&selectValue=${selectValue}&searchClause=${searchClause}"
					class="ui-paging-prev"> <i class="iconfont" title="左三角形">&#xF039;</i>
					上一页
				</a> <a style="float: left;" href="#"
					class="ui-paging-item ui-paging-current">${pageIndex}</a> <a
					style="float: left;"
					href="admin/productA_list.html?storeId=${storeId}&pageIndex=${pageIndex<pageCount?pageIndex+1:pageCount}&unDeleted=${unDeleted}&hasDeleted=${hasDeleted}&selectValue=${selectValue}&searchClause=${searchClause}"
					class="ui-paging-next"> 下一页 <i class="iconfont" title="右三角形">&#xF03A;</i>
				</a> <span style="float: left;" class="ui-paging-info"><span
					class="ui-paging-bold">${pageIndex}/${pageCount}</span>页</span>

				<form style="float: left;" action="productA_list.html">
					<input type="hidden" name="unDeleted" value="${unDeleted}">
					<input type="hidden" name="hasDeleted" value="${hasDeleted}">
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