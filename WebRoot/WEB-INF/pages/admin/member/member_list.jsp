<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>会员管理</title>
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
<script charset="utf-8" id="seajsnode"
	src="http://static.alipayobjects.com/seajs/1.3.1/??sea.js,plugin-combo.js"></script>
</head>
<script type="text/javascript">
	seajs.config({
		alias : {
			'$' : 'gallery/jquery/1.7.2/jquery',
			'autocomplete' : 'arale/autocomplete/1.2.2/autocomplete',
			'select' : 'arale/select/0.9.5/select'
		}
	});
	seajs.use([ '$' ], function($) {
		$('#selector').click(function() {
			$('.ui-select-content', this).toggleClass('hide');
		});
	});
</script>


<body>
	<div id="main-content">
		<div class="content-box">
			<!-- Start Content Box -->

			<div class="content-box-header">

				<h3>会员列表</h3>
				<div class="clear"></div>

			</div>
			<div class="content-box-content">




				<div class="fa-btn-up">
					<a href="admin/CusAdmAction_show.html?delete=true"> <input
						type="button" class="ui-button ui-button-swhite" value="已删除"></a>


					<a href="admin/CusAdmAction_show.html?work=true"> <input
						type="button" class="ui-button ui-button-swhite" value="已审核"></a>


					<a href="admin/CusAdmAction_show.html?unwork=true"> <input
						type="button" class="ui-button ui-button-swhite" value="未审核"></a>



					<a href="admin/CusAdmAction_show.html?total=true"> <input
						type="button" class="ui-button ui-button-swhite" value="全部"></a>
				</div>

				<div class="ui-table-container">
					<table class="ui-table">
						<!-- 可以在class中加入ui-table-inbox或ui-table-noborder分别适应不同的情况 -->
						<thead>
							<tr>
								<th>会员ID</th>
								<th>真实姓名</th>
								<th>用户名</th>
								<th>性别</th>
								<th>所属地区</th>
								<th>出生日期</th>
								<th>积分</th>
								<th>审核状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<!-- 表头可选 -->
						<tbody>
							<s:iterator value="customerList">
								<tr>
									<td><s:property value="customerId" /></td>
									<td><s:property value="realName" /></td>
									<td><s:property value="userName" /></td>
									<td><s:property value="sex" /></td>
									<td><s:property value="areaString" /></td>
									<td><s:property value="birthday" /></td>
									<td><s:property value="score" /></td>
									<td><s:property value="state" /></td>
									<td><a
										href="admin/CustomerStateAction_delete.html?delete=<s:property value="customerId" />">删除</a>
										<a
										href="admin/CustomerStateAction_work.html?work=<s:property value="customerId"/>">审核</a>
										<a
										href="admin/productA_shows.html?showsId=<s:property value="customerId"/>">查看</a>
										<a
										href="admin/storeDeal_add.html?customerIdAdd=<s:property value="customerId"/>">开店</a>

									</td>
								</tr>
							</s:iterator>

						</tbody>
						<tfoot>
							<tr>
								<td colspan="7">表尾数据</td>
							</tr>
						</tfoot>
						<!-- 表尾可选 -->
					</table>

				</div>

			</div>
			<div class="ui-paging">

				<a style="float: left;"
					href="admin/CusAdmAction_show.html?pageNumber=${pageNumber==1?1:pageNumber-1}&delete=${delete}&work=${work}&unwork=${unwork}&total=${total}"
					class="ui-paging-prev"> <i class="iconfont" title="左三角形">&#xF039;</i>
					上一页
				</a> <a style="float: left;" href="#"
					class="ui-paging-item ui-paging-current">${pageNumber}</a> <a
					style="float: left;"
					href="admin/CusAdmAction_show.html?pageNumber=${pageNumber<totalPage?pageNumber+1:totalPage}&delete=${delete}&work=${work}&unwork=${unwork}&total=${total}"
					class="ui-paging-next"> 下一页 <i class="iconfont" title="右三角形">&#xF03A;</i>
				</a> <span style="float: left;" class="ui-paging-info"><span
					class="ui-paging-bold">${pageNumber}/${totalPage}</span>页</span>

				<form style="float: left;">
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