<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发送记录列表</title>
<link rel="stylesheet" type="text/css" href="/css/admin/adproduct.css" />
<link rel="stylesheet" type="text/css" href="/css/admin/alice.css " />
<link rel="stylesheet" href="/css/admin/reset.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/style(1).css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/invalid.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/alice.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/iconfont.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/adproduct.css" type="text/css"
	media="screen">
<link
	href="http://assets.spmjs.org/alice/??box/1.0.0/box.css,button/1.1.1/button.css,button-dropdown/1.1.0/button-dropdown.css,form/1.0.1/form.css,list/1.0.0/list.css,nav/1.0.0/nav.css,paging/1.0.1/paging.css,poptip/1.1.1/poptip.css,tab/1.0.0/tab.css,table/1.0.1/table.css,tipbox/1.1.0/tipbox.css,tiptext/1.1.0/tiptext.css,select/1.0.0/select.css,loading/1.0.0/loading.css,step/1.0.3/step.css"
	rel="stylesheet">
<script charset="utf-8" id="seajsnode"
	src="http://static.alipayobjects.com/seajs/1.3.1/??sea.js,plugin-combo.js"></script>
</head>
<body>
	<div id="main-content">
		<div class="content-box">
			<!-- Start Content Box -->

			<div class="content-box-header">

				<h3>发送记录列表</h3>
				<div class="clear"></div>

			</div>

			</div>
			<div class="ui-table-container" style="clear: both;">
				<table class="ui-table">
					<!-- 可以在class中加入ui-table-inbox或ui-table-noborder分别适应不同的情况 -->
					<thead>
						<tr>

							<th>发送ID</th>
							<th>类别</th>
							<th>地址</th>
							<th>主题</th>
							<th>发送时间</th>
							<th>点击详情</th>
						</tr>
					</thead>
					<!-- 表头可选 -->
					<tbody>
						<s:iterator value="advertlist">
							<tr>
								<td><s:property value="advertId" /></td>
								<td><s:property value="type" /></td>
								<td><s:property value="address" /></td>
								<td><s:property value="subject" /></td>
								<td><s:property value="createTime" /></td>
								<td><a
									href="admin/detail_execute.html?advertId=<s:property value="advertId" />">查看</a>
								</td>
							</tr>
						</s:iterator>

					</tbody>
				</table>

			</div>

		</div>

		<div class="ui-paging">

			<a style="float: left;"
				href="admin/editor1_execute.html?pageNumber=${pageNumber==1?1:pageNumber-1}"
				class="ui-paging-prev"> <i class="iconfont" title="左三角形">&#xF039;</i>
				上一页
			</a> <a style="float: left;" href="#"
				class="ui-paging-item ui-paging-current">${pageNumber}</a> <a
				style="float: left;"
				href="admin/editor1_execute.html?pageNumber=${pageNumber<totalPage?pageNumber+1:totalPage}"
				class="ui-paging-next"> 下一页 <i class="iconfont" title="右三角形">&#xF03A;</i>
			</a> <span style="float: left;" class="ui-paging-info"><span
				class="ui-paging-bold">${pageNumber}/${totalPage}</span>页</span>

			<form style="float: left;" action="editor1_execute.html"
				namespace="/admin">
				<span class="ui-paging-which "> <input name="pageNumber"
					type="text">
				</span> <input class="ui-paging-info ui-paging-goto" type="submit"
					value="跳转">
			</form>
		</div>
	</div>
	</div>

</body>



</html>