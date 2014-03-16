<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<!--  -->
<script type="text/javascript" src="/js/fg.menu.js"></script>
<link type="text/css" href="/css/fg.menu/fg.menu.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/css/fg.menu/ui.core.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/css/fg.menu/ui.accordion.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/css/fg.menu/ui.datepicker.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/css/fg.menu/ui.dialog.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/css/fg.menu/ui.progressbar.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/css/fg.menu/ui.resizable.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/css/fg.menu/ui.slider.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/css/fg.menu/ui.tabs.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/css/fg.menu/ui.theme.css"
	media="screen" rel="stylesheet" />
<script type="text/javascript">
	$(function() {
		// BUTTONS
		$('.fg-button').hover(function() {
			$(this).removeClass('ui-state-default').addClass('ui-state-focus');
		}, function() {
			$(this).removeClass('ui-state-focus').addClass('ui-state-default');
		});

		// MENUS    	
		$('#flat').menu({
			content : $('#flat').next().html(), // grab content from this page
			showSpeed : 400
		});

		$('#hierarchy').menu({
			content : $('#hierarchy').next().html(),
			crumbDefaultText : ' '
		});

		$('#hierarchybreadcrumb').menu({
			content : $('#hierarchybreadcrumb').next().html(),
			backLink : false
		});

		// or from an external source
		$.get('menuContent.html', function(data) { // grab content from another page
			$('#flyout').menu({
				content : data,
				flyOut : true
			});
		});
	});
	
	
</script>
<script type="text/javascript">
<!--
	//-->
	$(function() {
		seajs.use([ 'validator', '$' ], function(Validator, $) {
			var validator = new Validator({
				element : '#add_goods',
				autoSubmit : false
			});
			validator.addItem({
				element : '#good_name',
				required : true,
				rule : 'text',
				errormessageRequired : '请输入商品名称.'
			})
			.addItem({
				element:'#description',
				required :true,
				rule:'text'
			})
			.addItem({
				element:'#price',
				require: true,
				rule :'text',
				errormessageRequired : '请输入商品价格.'
			})
		});
		$('#submit_addProduct').click(function(){
			$.ajax({
				type:"POST",
				url:'product/product_SaveProductInfo.json',
				data:{name:$('#good_name').val(),categoryName:$('#menuSelection').text(),price:$('#price').val(),description:$('#description').val(),categoryId:$('input[name=categoryId]').val(),},
				dataType:"json"
			});
		});
	});
</script>
<div class="member_management_content">
	<%@include file="/WEB-INF/pages/member/sellers/left_menu.jsp"%>
	<div class="member_management_content_right">
		<div class="member_index_main_content">
			<h1>菜单管理</h1>
			<div class="cell">
				<form id="add_goods" class="ui-form">
					<div class="ui-form-item">
						<label for="good_name" class="ui-label"><span
							class="ui-form-required">*</span>商品名称：</label> <input id="good_name"
							name="good_name" class="ui-input" type="text" data-explain="填写正确的商品名称"/>
						<div class="ui-form-explain">请填写商品名称。</div>
					</div>
					<!-- 下拉选择商品分类开始 -->
					<div class="category_choose">
					<p id="menuLog">
						商品分类： <span id="menuSelection"></span>
						<input type="hidden" name=categoryId /> 
					</p>
					<a tabindex="0" href="#news-items-2"
						class="fg-button fg-button-icon-right ui-widget ui-state-default ui-corner-all"
						id="hierarchybreadcrumb"><span
						class="ui-icon ui-icon-triangle-1-s"></span> 请选择商品分类</a>
					<div id="news-items-2" class="hidden">
						<ul>
					<s:action name="productCategory1_getAllCategory" executeResult="true"
					namespace="/product">
			    	</s:action>
			    	</ul>
					</div>
					</div>
					<!-- 下拉选择商品分类结束 -->
					<!-- 上传商品图片开始 -->
					<div class="uploadImg">
						<div>
							<img id="imgShow1" />
							<img id="imgShow2" />
						 	<img id="imgShow3" />
							<img id="imgShow4" />
						</div>
						<input type="hidden" id="hidImgName" /> 
						<span class="ui-button-morange ui-button" style="margin:40px"><input
							class="ui-button-text" id="btnUploadImg" value="上传" type="button" name="userfile"></span> 
						<span class="ui-button-morange ui-button"><input
							class="ui-button-text" id="btnDeleteImg" value="删除" type="button"></span>
					</div>
					<!-- 上传商品图片结束 -->
					<div class="ui-form-item">
							<label for="description" class="ui-label">
								<span class="ui-form-required">*</span>商品描述：
							</label>
							<textarea class="ui-textarea"  id="description" name="description" style="width: 427px; height: 122px;"></textarea>
					</div>
					<div class="ui-form-item">
							<label for="price" class="ui-label">
								<span class="ui-form-required">*</span>商品价格：
							</label> 
							<input id="price" name="price"	class="ui-input" type="text" data-explain="请输入正确的商品价格">
							<div class="ui-form-explain">请填写商品价格。</div>
					</div>
						<div class="ui-form-item">
							<label for="" class="ui-label">
								<span class="ui-form-required">*</span>是否团购：
							</label> 
							是
							<input type="radio" name="tuan">
							否
							<input type="radio" name="tuan"checked="checked">
						</div>
						<s:token></s:token>
					<div class="submit_reg_btn">
						<span class="ui-button-morange ui-button"><input
							class="ui-button-text" id="submit_addProduct" value="确定" type="submit"></span>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>