<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="/css/admin/default.css" />
<link rel="stylesheet" href="/css/admin/prettify.css" />
<link rel="stylesheet" href="/css/arale_form.css" />
<link rel="stylesheet" href="/css/admin/alice.css" />
<link rel="stylesheet" href="/css/bootstrap.min.css">
<script charset="utf-8" src="/js/admin/kindeditor-all.js"></script>
<script charset="utf-8" src="/js/admin/zh_CN.js"></script>
<script charset="utf-8" src="/js/admin/prettify.js"></script>
<script src="/js/jquery-1.7.2.min.js"></script>
<script src="/js/organictabs.jquery.js"></script>
<script charset="utf-8" id="seajsnode"
	src="http://static.alipayobjects.com/seajs/1.3.1/??sea.js,plugin-combo.js"></script>
<script src="/js/as.js"></script>
<script src="/js/admin/sanji.js"></script>
<script src="/js/admin/post.js"></script>
<script type="js/TPL" id="TPL-memberlist">
	<tr>
		<td></td>
		<td>{{realName}}</td>
		<td>{{userName}}</td>
		<td>{{sex}}</td>
		<td>{{areaString}}</td>
		<td>{{birthday}}</td>
		<td>{{score}}</td>
		<td>{{email}}</td>
		<td><input type="checkbox" value="{{email}}"/></td>
	</tr>
</script>
<script type="js/TPL" id="TPL-storelist">
	<tr>
		<td></td>
		<td>{{name}}</td>
		<td>{{realName}}</td>
		<td>{{maxpeople}}</td>
		<td>{{audit}}</td>
		<td>{{email}}</td>
		<td><input type="checkbox" value="{{email}}"/></td>	
	</tr>
</script>
<script>
	seajs.config({
		alias : {
			'$' : 'gallery/jquery/1.7.2/jquery',
			'validator' : 'arale/validator/0.9.4/validator',
			'handlebars' : 'gallery/handlebars/1.0.2/handlebars',
		}
	});
</script>
</head>
<body>
	<div class="wrp">
		<div class="data" id="data">
			<ul class="nav">
				<li class="nav-one"><a data-cid="member" href="#member_list"
					class="current btn btn-primary">选择会员地址 </a></li>
				<li class="nav-two last"><a data-cid="store" href="#store_list"
					class="btn btn-primary">选择店铺地址</a></li>
			</ul>
			<div class="list-wrap">
				<ul id="member_list">
					<h5>选择会员邮箱地址</h5>
					<form id="customer1" name="" namespace="">
						<div class="ui-form-item">
							<label class="ui-label"><span class="ui-form-required"></span>选择性别：</label>
							<label for="male"><input class="ui-hidden gender"
								name="gender" id="male" type="radio" value="男" >男 </label> <label
								for="female"><input class="ui-hidden gender" name="gender"
								id="female" type="radio" value="女">女</label>
								<input class="ui-hidden gender" name="gender"
								id="female" type="radio" value="all">全部</label>
						</div>
						<div class="ui-form-item">
							<SELECT ID='s1' NAME='s1' style='max-width: 75px;'>
								<OPTION selected id='ss1'></OPTION>
							</SELECT> <SELECT ID='s2' NAME='s2' style='max-width: 75px;'>
								<OPTION selected id='ss2'></OPTION>
							</SELECT> <SELECT ID='s3' name='s3' style='max-width: 125px;'>
								<OPTION selected id='ss3'></OPTION>
							</SELECT>
						</div>
						<div class="main_table">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>真实姓名</th>
										<th>用户名</th>
										<th>性别</th>
										<th>所属地区</th>
										<th>生日</th>
										<th>积分</th>
										<th>邮箱</th>
										<th>选择</th>
									</tr>
								</thead>
								<tbody id="memeberinfo_list">
								</tbody>
							</table>
							<div class="ui-paging">
								<span class="ui-paging-info">第<span
									class="ui-paging-bold"></span>页
								</span> <a class="ui-paging-prev" data-cid="member">上一页 </a> <a
									class="ui-paging-next" data-cid="member"> 下一页 </a>
							</div>
						</div>
						<input class="btn btn-primary" value="添加地址"
							onclick="addToAddress1();" />
					</form>
				</ul>
				<ul id="store_list" class="hide">
					<h5>选择店铺邮箱地址</h5>
					<form id="store1">
						<div class="ui-form-item">
							<SELECT ID='a1' NAME='a1' style='max-width: 75px;'>
								<OPTION selected id='ss1'></OPTION>
							</SELECT> <SELECT ID='a2' NAME='a2' style='max-width: 75px;'>
								<OPTION selected id='ss2'></OPTION>
							</SELECT> <SELECT ID='a3' name='a3' style='max-width: 125px;'>
								<OPTION selected id='ss3'></OPTION>
							</SELECT>
						</div>
						<div class="main_table">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>店铺名称</th>
										<th>负责人</th>
										<th>规模</th>
										<th>审核状态</th>
										<th>邮箱</th>
										<th>选择</th>
									</tr>
								</thead>
								<tbody id="storeinfo_list">
								</tbody>
							</table>
							<div class="ui-paging">
								<span class="ui-paging-info">第<span
									class="ui-paging-bold"></span>页
								</span> <a class="ui-paging-prev" data-cid="store">上一页 </a> <a
									class="ui-paging-next" data-cid="store"> 下一页 </a>
							</div>
						</div>
						<input class="btn btn-primary" value="添加地址"
							onclick="addToAddress2()" />
					</form>
				</ul>
			</div>

		</div>
		<s:form name="example" method="post" action="fa5_sendToEmail">
			<div class="ui-form-item">
				<label for="addr" class="ui-label"><span
					class="ui-form-required">*</span>地址：</label> <input id="addr"
					name="address" class="ui-input" type="text" value="" />
				<div class="ui-form-explain">请填写地址</div>
			</div>
			<div class="ui-form-item">
				<label for="title" class="ui-label"><span
					class="ui-form-required">*</span>主题：</label> <input id="title"
					name="subject" type="text" class="ui-input"
					data-explain="请输入主题" />
				<div class="ui-form-explain">请输入主题</div>
			</div>
			<input id ="flag" type="hidden" name="flag" value=""/>
			<textarea name="content" cols="100" rows="8"
				style="width: 700px; height: 200px; visibility: hidden;"></textarea>
			<br />
			<s:token></s:token>
			<input type="submit" class="btn btn-primary" value="提交内容" />
		</s:form>
	</div>
	<script type="text/javascript">
		$(function() {
			$.ajax({
				type : "post",
				url : '/adminjson/jsondeal_areaInfo.json',
				data : "",
				dataType : "json",
				success : function(result) {
					var rjson = result.jsonArray;

					var array = new Array();
					for ( var i = 0; i < rjson.length; i++) {
						array[i] = new Array(rjson[i].cid, rjson

						[i].pid, rjson[i].name);
					}
					//array[2]=new Array("2","1","22");
					var liandong = new CLASS_LIANDONG_YAO(array); //设置数据源
					liandong.firstSelectChange("根目录", "s1"); //设置第一个选择框
					liandong.subSelectChange("s1", "s2"); //设置子级选择框
					liandong.subSelectChange("s2", "s3");
				}
			});
		});
		$(function() {
			$.ajax({
				type : "post",
				url : '/adminjson/jsondeal_areaInfo.json',
				data : "",
				dataType : "json",
				success : function(result) {
					var rjson = result.jsonArray;

					var array = new Array();
					for ( var i = 0; i < rjson.length; i++) {
						array[i] = new Array(rjson[i].cid, rjson

						[i].pid, rjson[i].name);
					}
					//array[2]=new Array("2","1","22");
					var liandong = new CLASS_LIANDONG_YAO(array); //设置数据源
					liandong.firstSelectChange("根目录", "a1"); //设置第一个选择框
					liandong.subSelectChange("a1", "a2"); //设置子级选择框
					liandong.subSelectChange("a2", "a3");
				}
			});
		});
	</script>
</body>
</html>
