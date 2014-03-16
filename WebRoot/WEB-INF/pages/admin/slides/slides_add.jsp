<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/admin/style.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/alice.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/adproduct.css" type="text/css"
	media="screen">
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
<script charset="utf-8" id="seajsnode"
	src="http://static.alipayobjects.com/seajs/1.3.1/??sea.js,plugin-combo.js"></script>
<script src="/js/AjaxUpload.js"></script>
<script src="/js/imageupload.js"></script>
<script type="text/javascript">
	seajs.config({
		alias : {
			'$' : 'gallery/jquery/1.7.2/jquery',
			'autocomplete' : 'arale/autocomplete/1.2.2/autocomplete',
			'validator' : 'arale/validator/0.9.4/validator.js'
		}
	});
	seajs.use(['$','validator'],function($,Validator){
		$(function() {
			var validator = new Validator({
				element : '#test-form'
				
			});
			validator.addItem({
				element : '#spicname',
				required : true,
				display: '幻灯片名称',				
				
			}).addItem({
				element : '#spicUrl',
				required : true,
				rule :'url',
				display:'外部链接',
				
			}).addItem({
				element : '#imgInput',
				required : true,
				display:'幻灯片地址'
				
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

				<h3>商品编辑</h3>
				<div class="clear"></div>

			</div>
			<!-- End .content-box-header -->

			<div class="content-box-content">
				<s:form class="ui-form" id="test-form"  method="post"
					action="updateDeal_slidesModified" namespace="/admin">
					<legend></legend>
					<input type="hidden" value="${slideId}" name="slideId">
					<!-- 修改数据默认填入对话框 -->
					<s:iterator value="slides">
						<div class="ui-form-item">
							<label for="" class="ui-label">slides名称
							</label> <input class="ui-input" type="text" name="spicname"
								value='<s:property value="picname"/>' id="spicname">
								<div class="ui-form-explain">幻灯片名称。</div>
						</div>	
						<div class="ui-form-item ">
							<label for="" class="ui-label">点击链接</label> <input name="spicUrl"
								class="ui-input" type="text" value='<s:property value="picUrl"/>' id="spicUrl">
							<div class="ui-form-explain">幻灯片外部链接。</div>
						</div>					
						
						<div class="ui-form-item ">
							<label for="" class="ui-label">图片上传</label> <input name="surl"
								class="ui-input" id="imgInput" type="text" value='<s:property value="url"/>' >
								
							<input	class="ui-button ui-button-mwhite" id="btnUploadImg" value="上传"
								type="button" name="userfile">
								<input id="btnDeleteImg"type="hidden">
							<div class="ui-form-explain">幻灯片右派地址</div>
						</div>																						
					</s:iterator>
					<div class="ui-form-item"  >
						<input type="submit" class="ui-button ui-button-morange"
							value="确定">
					</div>
				</s:form>

				<!-- End .clear -->
			</div>
			<!-- End #tab1 -->


			<!-- End #main-content -->
		</div>
	</div>

</body>
</html>