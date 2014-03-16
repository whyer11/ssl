<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("content1") != null ? request
			.getParameter("content1") : "";
	String type = "";
%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="/css/admin/default.css" />
<link rel="stylesheet" href="/css/admin/prettify.css" />
<link rel="stylesheet" href="/css/arale_form.css" />
<link rel="stylesheet" href="/css/admin/alice.css"/>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<script charset="utf-8" src="/js/admin/kindeditor-all.js"></script>
<script charset="utf-8" src="/js/admin/zh_CN.js"></script>
<script charset="utf-8" src="/js/admin/prettify.js"></script>
<script src="/js/jquery-1.7.2.min.js"></script>
<script src="/js/organictabs.jquery.js"></script>
<script charset="utf-8" id="seajsnode"
	src="http://static.alipayobjects.com/seajs/1.3.1/??sea.js,plugin-combo.js"></script>
<script src="/js/admin/sanji.js"></script>
<script>
	seajs.config({
		alias : {
			'$' : 'gallery/jquery/1.7.2/jquery',
			'validator' : 'arale/validator/0.9.4/validator',
		}
	});
	$(function() {
		var totalpage_num = 1;
		var currentpage_num = 1;
		seajs.use([ '$', 'validator' ], function($, Validator) {
			var validator = new Validator({
				element : '[name = example]'
			});
			validator.addItem({
				element : '#addr',
				required : true,
				rule : 'text'
			}).addItem({
				element : '#title',
				required : true,
				rule : 'text'
			});
		});
		$(window).load(function() {
							$.ajax({
										type : 'POST',
										url : 'admin/fa3_show.json',
										data : {
											
										},
										success : function(data, status) {
											type="customer";
											totalpage_num = data.totalPage;
											currentpage_num = data.pageNumber;
											var cuslist = data.customerList;
											for ( var i = 0; i < cuslist.length; i++) {
												var tr = $("<tr><td>"
														+ (i + 1)
														+ "</td>"
														+ "<td>"
														+ cuslist[i].realName
														+ "</td>"
														+ "<td>"
														+ cuslist[i].userName
														+ "</td>"
														+ "<td>"
														+ cuslist[i].sex
														+ "</td>"
														+ "<td>"
														+ cuslist[i].areaString
														+ "</td>"
														+ "<td>"
														+ cuslist[i].birthday
														+ "</td>"
														+ "<td>"
														+ cuslist[i].score
														+ "</td>"
														+ "<td>"
														+ cuslist[i].mobile
														+ "</td>"
														+ "<td>"
														+ "<input type='checkbox' value="+cuslist[i].mobile+">"
														+ "</td></tr>");
												$('#memeberinfo_list').append(tr);
											}
											$('.ui-paging-bold').text(currentpage_num+"/"+totalpage_num);
										}
									});
						});
		$('.ui-paging-prev').click(function(){
			if(currentpage_num == 1)
				{
					alert('没有上一页了');
				}
			else{
			$('#memeberinfo_list').html('');
			$.ajax({
				type:'POST',
				url:'admin/fa3_show.json',
				data:{
					pageNumber : (currentpage_num-1)
				},
				success : function(data){
					totalpage_num = data.totalPage;
					currentpage_num = data.pageNumber;
					var cuslist = data.customerList;
					for ( var i = 0; i < cuslist.length; i++) {
						var tr = $("<tr><td>"
								+ (i + 1)
								+ "</td>"
								+ "<td>"
								+ cuslist[i].realName
								+ "</td>"
								+ "<td>"
								+ cuslist[i].userName
								+ "</td>"
								+ "<td>"
								+ cuslist[i].sex
								+ "</td>"
								+ "<td>"
								+ cuslist[i].areaString
								+ "</td>"
								+ "<td>"
								+ cuslist[i].birthday
								+ "</td>"
								+ "<td>"
								+ cuslist[i].score
								+ "</td>"
								+ "<td>"
								+ cuslist[i].mobile
								+ "</td>"
								+ "<td>"
								+ "<input type='checkbox' value="+cuslist[i].mobile+">"
								+ "</td></tr>");
						$('#memeberinfo_list').append(tr);
				}
					$('.ui-paging-bold').text(currentpage_num+"/"+totalpage_num);
				}
			});
			}
		});

		$('.ui-paging-next').click(function(){
			if(currentpage_num==totalpage_num)
				{
				alert('没有下一页了');
				}
			else{
			$('#memeberinfo_list').html('');
			$.ajax({
				type:'POST',
				url:'admin/fa3_show.json',
				data:{
					pageNumber : (currentpage_num+1)
				},
				success : function(data){
					totalpage_num = data.totalPage;
					currentpage_num = data.pageNumber;
					var cuslist = data.customerList;
					for ( var i = 0; i < cuslist.length; i++) {
						var tr = $("<tr><td>"
								+ (i + 1)
								+ "</td>"
								+ "<td>"
								+ cuslist[i].realName
								+ "</td>"
								+ "<td>"
								+ cuslist[i].userName
								+ "</td>"
								+ "<td>"
								+ cuslist[i].sex
								+ "</td>"
								+ "<td>"
								+ cuslist[i].areaString
								+ "</td>"
								+ "<td>"
								+ cuslist[i].birthday
								+ "</td>"
								+ "<td>"
								+ cuslist[i].score
								+ "</td>"
								+ "<td>"
								+ cuslist[i].mobile
								+ "</td>"
								+ "<td>"
								+ "<input type='checkbox' value="+cuslist[i].mobile+">"
								+ "</td></tr>");
						$('#memeberinfo_list').append(tr);
				}
					$('.ui-paging-bold').text(currentpage_num+"/"+totalpage_num);
				}
			});
			}
		});
		$('.nav').find('li a').bind('click',function(){
			if($(this).data('cid')=='member'){
				$('#memeberinfo_list').html('');
				$.ajax({
					type : 'POST',
					url : 'admin/fa3_show.json',
					data : {
						
					},
					success : function(data, status) {
						type="customer";
						totalpage_num = data.totalPage;
						currentpage_num = data.pageNumber;
						var cuslist = data.customerList;
						for ( var i = 0; i < cuslist.length; i++) {
							var tr = $("<tr><td>"
									+ (i + 1)
									+ "</td>"
									+ "<td>"
									+ cuslist[i].realName
									+ "</td>"
									+ "<td>"
									+ cuslist[i].userName
									+ "</td>"
									+ "<td>"
									+ cuslist[i].sex
									+ "</td>"
									+ "<td>"
									+ cuslist[i].areaString
									+ "</td>"
									+ "<td>"
									+ cuslist[i].birthday
									+ "</td>"
									+ "<td>"
									+ cuslist[i].score
									+ "</td>"
									+ "<td>"
									+ cuslist[i].mobile
									+ "</td>"
									+ "<td>"
									+ "<input type='checkbox' value="+cuslist[i].mobile+">"
									+ "</td></tr>");
							$('#memeberinfo_list').append(tr);
						}
						$('.ui-paging-bold').text(currentpage_num+"/"+totalpage_num);
					}
				});
			}
			else if($(this).data('cid')=='store'){
				$('#storeinfo_list').html('');
				$.ajax({
					type : 'POST',
					url : 'admin/fa4_show.json',
					data : {
						
					},
					success : function(data, status) {
						type="store";
						totalpage_num = data.totalPage;
						currentpage_num = data.pageNumber;
						var cuslist = data.storeList;
						for ( var i = 0; i < cuslist.length; i++) {
							var tr = $("<tr><td>"
									+ (i + 1)
									+ "</td>"
									+ "<td>"
									+ cuslist[i].name
									+ "</td>"
									+ "<td>"
									+ cuslist[i].realName
									+ "</td>"
									+ "<td>"
									+ cuslist[i].maxpeople
									+ "</td>"
									+ "<td>"
									+ cuslist[i].audit
									+ "</td>"
									+ "<td>"
									+ cuslist[i].mobile
									+ "</td>"
									+ "<td>"
									+ "<input type='checkbox' value="+cuslist[i].mobile+">"
									+ "</td></tr>");
							$('#storeinfo_list').append(tr);
						}
						$('.ui-paging-bold').text(currentpage_num+"/"+totalpage_num);
					}
				});
			}
		});
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : '/css/admin/prettify.css',
				uploadJson : '/js/admin/jsp/upload_json.jsp',
				fileManagerJson : '/js/admin/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
		// Calling the plugin
		$("#data").organicTabs();
		
	});
</script>
</head>
	<body>
	<div class="wrp">
		<div class="data" id="data">
			<ul class="nav">
				<li class="nav-one"><a data-cid="member" href="#member_list"
					class="current btn btn-primary">选择会员地址</a></li>
				<li class="nav-two last"><a data-cid="store" href="#store_list"
					class="btn btn-primary">选择店铺地址</a></li>
			</ul>
			<div class="list-wrap">
				<ul id="member_list">
					<h5>选择会员邮箱地址</h5>
					<form>
						<div class="ui-form-item">
							<label class="ui-label"><span class="ui-form-required"></span>选择性别：</label>
							<label for="male"><input class="ui-hidden" name="gender"
								id="male" type="checkbox">男</label> <label for="female"><input
								class="ui-hidden" name="gender" id="female" type="checkbox">女</label>
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
										<th>手机</th>
										<th>选择</th>
									</tr>
								</thead>
								<tbody id="memeberinfo_list">
								</tbody>
							</table>
							<div class="ui-paging">
									<span class="ui-paging-info">第<span
										class="ui-paging-bold"></span>页
									</span> <a class="ui-paging-prev">上一页
									</a> <a class="ui-paging-next"> 下一页 
									</a>
								</div>
						</div>
						<input type="submit" class="btn btn-primary" value="添加地址" />
					</form>

				</ul>
				<ul id="store_list" class="hide">
					<h5>选择店铺邮箱地址</h5>
					<form>
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
										<th>手机</th>
										<th>选择</th>
									</tr>
								</thead>
								<tbody id="storeinfo_list">
								</tbody>
							</table>
							<div class="ui-paging">
									<span class="ui-paging-info">第<span
										class="ui-paging-bold"></span>页
									</span> <a class="ui-paging-prev">上一页
									</a> <a class="ui-paging-next"> 下一页 
									</a>
								</div>
						</div>
						<input type="submit" class="btn btn-primary" value="添加地址" />
					</form>
				</ul>
			</div>

		</div>
		<%=htmlData%>
		<form name="example" method="post" action="">
			<div class="ui-form-item">
				<label for="addr" class="ui-label"><span
					class="ui-form-required">*</span>地址：</label> <input id="addr" name="addr"
					class="ui-input" type="text" />
				<div class="ui-form-explain">请填写地址</div>
			</div>
			<div class="ui-form-item">
				<label for="title" class="ui-label"><span
					class="ui-form-required">*</span>主题：</label> <input id="title" name="title"
					type="text" class="ui-input" data-explain="请输入主题" />
				<div class="ui-form-explain">请输入主题</div>
			</div>
			<textarea name="content1" cols="100" rows="8"
				style="width: 700px; height: 200px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>
			<br /> <input type="submit" name="button" class="btn btn-primary"
				value="提交内容" />
		</form>
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
						array[i] = new Array(rjson[i].cid, rjson[i].pid,
								rjson[i].name);
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
						array[i] = new Array(rjson[i].cid, rjson[i].pid,
								rjson[i].name);
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
<%!private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}%>