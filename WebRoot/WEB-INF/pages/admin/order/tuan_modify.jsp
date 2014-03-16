<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Shop/css/admin/style.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/Shop/css/admin/alice.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/Shop/css/admin/adproduct.css"
	type="text/css" media="screen">

<link href="http://assets.spmjs.org/alice/select/1.0.0/select.css"
	rel="stylesheet">


<script type="text/javascript" src="/Shop/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/Shop/js/fg.menu.js"></script>
<link type="text/css" href="/Shop/css/fg.menu/fg.menu.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/Shop/css/fg.menu/ui.core.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/Shop/css/fg.menu/ui.accordion.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/Shop/css/fg.menu/ui.datepicker.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/Shop/css/fg.menu/ui.dialog.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/Shop/css/fg.menu/ui.progressbar.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/Shop/css/fg.menu/ui.resizable.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/Shop/css/fg.menu/ui.slider.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/Shop/css/fg.menu/ui.tabs.css"
	media="screen" rel="stylesheet" />
<link type="text/css" href="/Shop/css/fg.menu/ui.theme.css"
	media="screen" rel="stylesheet" />

<link rel="stylesheet" href="/Shop/css/main.css" />
<link rel="stylesheet" href="/Shop/css/arale_btn.css" />
<link rel="stylesheet" href="/Shop/css/arale_form.css" />
<link rel="stylesheet" href="/Shop/css/base.css" />
<link rel="stylesheet" href="/Shop/css/flexslider.css" />
<link rel="stylesheet" href="/Shop/css/jcarousel_tango.css" />
<link rel="stylesheet" href="/Shop/css/responsive.css">
<link rel="stylesheet"
	href="http://assets.spmjs.org/alice/select/1.0.0/select.css">
<script src="/Shop/js/AjaxUpload.js"></script>
<script src="/Shop/js/imageupload.js"></script>

<!-- styles for this example page only -->
<style type="text/css">
body {
	font-size: 62.5%;
	margin: 0;
	padding: 0;
}

#menuLog {
	font-size: 1.4em;
	margin: 20px;
}

.hidden {
	position: absolute;
	top: 0;
	left: -9999px;
	width: 1px;
	height: 1px;
	overflow: hidden;
}

.fg-button {
	clear: left;
	margin: 0 4px 40px 20px;
	padding: .4em 1em;
	text-decoration: none !important;
	cursor: pointer;
	position: relative;
	text-align: center;
	zoom: 1;
}

.fg-button .ui-icon {
	position: absolute;
	top: 50%;
	margin-top: -8px;
	left: 50%;
	margin-left: -8px;
}

a.fg-button {
	float: left;
}

button.fg-button {
	width: auto;
	overflow: visible;
} /* removes extra button width in IE */
.fg-button-icon-left {
	padding-left: 2.1em;
}

.fg-button-icon-right {
	padding-right: 2.1em;
}

.fg-button-icon-left .ui-icon {
	right: auto;
	left: .2em;
	margin-left: 0;
}

.fg-button-icon-right .ui-icon {
	left: auto;
	right: .2em;
	margin-left: 0;
}

.fg-button-icon-solo {
	display: block;
	width: 8px;
	text-indent: -9999px;
}
/* solo icon buttons must have block properties for the text-indent to work */
.fg-button.ui-state-loading .ui-icon {
	background: url(spinner_bar.gif) no-repeat 0 0;
}
</style>

<!-- style exceptions for IE 6 -->
<!--[if IE 6]>
	<style type="text/css">
		.fg-menu-ipod .fg-menu li { width: 95%; }
		.fg-menu-ipod .ui-widget-content { border:0; }
	</style>
	<![endif]-->

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
		$('#tuanSele1').click(function() {
			if (this.checked == true) {
				$('#showTuan').show();
			}

		});
		$('#tuanSele2').click(function() {
			if (this.checked == true) {
				$('#showTuan').hide();
			}

		});
	});
</script>
<!-- theme switcher button -->
<!--<script type="text/javascript"
	src="http://ui.jquery.com/applications/themeroller/themeswitchertool/"></script>
	-->
<!--<script type="text/javascript">
	$(function() {
		$('<div style="position: absolute; top: 20px; right: 300px;" />')
				.appendTo('body').themeswitcher();
	});
</script>-->

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
									dataSource : '/Shop/adminjson/jsondeal_storeInfo.html?qstore={{query}}'
								}).on('itemSelect', function(abcdList) {
							console.log('%o', abcdList);
							$('#storename').text(abcdList);
						}).on('indexChange', function(currentIndex, lastIndex) {
							console.log(this.items[currentIndex]);

						}).render();

					});
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
									trigger : '#acTrigger3',
									submitOnEnter : false,
									selectFirst : true,
									template : $('#template').html(),
									locator : 'cateNameList',
									classPrefix : 'ui-select',
									dataSource : '/Shop/adminjson/jsondeal_categoryInfo.html?vcategory={{query}}'
								}).on('itemSelect', function(cateNameList) {
							console.log('%o', cateNameList);
						}).render();

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
				<s:form class="ui-form" name="" method="post"
					action="tuanDeal_Smodified" namespace="/admin">

					<legend></legend>
					<!-- 修改数据默认填入对话框 -->
					<s:iterator value="tuan">

						<s:hidden value="%{tuanId}" name="tuanId"/>
						<div class="ui-form-item">
							<label for="" class="ui-label"> <span
								class="ui-form-required"></span>商品名称
							</label> <input class="ui-input" type="text" name="pname"
								value='<s:property value="product.name"/>'>

						</div>

						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">所在商家</label> <input
								id="acTrigger2" class="ui-input" type="text" name="pstoreName"
								value='<s:property value="store.name"/>'>

						</div>
						<label value='<s:property value="category.name"/>'></label>
						<input type="hidden" name="categoryId" value="${product.category.categoryId}"/>
						<div class=" ui-form-item-success ui-form-item-focus"
							style="margin: 0 0 0 85px;">
							<a tabindex="0" href="#news-items-2"
								class="fg-button fg-button-icon-right ui-widget ui-state-default ui-corner-all ui-input"
								id="hierarchybreadcrumb" style="width: 210px; height: 34px;">
								<span class="ui-icon ui-icon-triangle-1-s"> </span> <label
								id="menuSelection">${product.category.name==null?"选择分类":product.category.name}</label>
							</a>
							<div id="news-items-2" class="hidden">
								<ul>
									<s:action name="productCategory1_getAllCategory"
										executeResult="true" namespace="/product">
									</s:action>
								</ul>
							</div>
						</div>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<!-- 上传商品图片开始 -->
						<div class=" ui-form-item-success ui-form-item-focus uploadImg"
							style="margin-left: 100px;">
							<div>
								<input type="hidden" id="hidImgName" /> <span
									class="ui-button-morange ui-button"> <input
									class="ui-button-text" id="btnUploadImg" value="上传"
									type="button" name="userfile"></span> <span
									class="ui-button-morange ui-button"><input
									class="ui-button-text" id="btnDeleteImg" value="删除"
									type="button"></span>
							</div>
							<br>
							<div>
								<img id="imgShow1" style="float: left;" border="0" /> <img
									id="imgShow2" style="float: left;" /> <img id="imgShow3"
									style="float: left;" /> <img id="imgShow4" style="float: left;" />
							</div>
						</div>
						<!-- 上传商品图片结束 -->

						<div class="ui-form-item ui-form-item-success">
							<label for="" class="ui-label">商品描述</label>
							<textarea class="ui-textarea" name="pdescription"
								style="width: 427px; height: 122px;">${product.description}</textarea>
						</div>
						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">商品价格</label> <input name="pprice"
								class="ui-input" type="text"
								value='<s:property value="product.price"/>'>

						</div>
						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">商品数目</label> <input
								class="ui-input" type="text" name="limitCount"
								value='<s:property value="limitCount"/>'>

						</div>
						<div class="ui-form-item ui-form-item-error " id="showTuan"
							>
							<label for="" class="ui-label">团购价格:</label><input
								class="ui-input" name="tuanPrice" type="text" value='<s:property value="currentPrice"/>'>
						</div>
					
					</s:iterator>
					<input type="hidden" value="${pageIndex}" name="pageIndex">
					<div class="ui-form-item">
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