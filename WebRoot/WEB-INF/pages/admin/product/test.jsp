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
<link rel="stylesheet" href="/Shop/css/admin/iconfont.css">
<!-- 
<	type="text/css" media="screen">
<link href="http://assets.spmjs.org/alice/select/1.0.0/select.css" rel="stylesheet">
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
	seajs.use(['$','autocomplete'], function($,AutoComplete) {
		new AutoComplete({
			trigger : '#acTrigger2',
			submitOnEnter : false,
			selectFirst : true,
			template: $('#template').html(),
			locator:'abcdList',
			classPrefix:'ui-select',
			dataSource: '/Shop/adminjson/jsondeal_autoCompArray.html?q={{query}}'
		}).on('itemSelect', function(abcdList){
	        console.log('%o', abcdList);
	        })
	      .on('indexChange', function(currentIndex, lastIndex){
	         console.log(this.items[currentIndex]);    
	        
	    }).render();	
		
	});
</script> -->

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

			<div class="content-box-content" >
				<s:form class="ui-form" name="" method="post"
					action="productA_Smodified" namespace="/admin">

					<legend></legend>
					<!-- 修改数据默认填入对话框 -->
					<s:iterator value="product">

						<s:hidden value="%{productId}" name="productId" />
						<div class="ui-form-item">
							<label for="" class="ui-label"> <span
								class="ui-form-required">*</span>商品名
							</label> <input class="ui-input" type="text" name="pname"
								value='<s:property value="name"/>'>

						</div>

						<div class="ui-form-item ui-form-item-error">
							<label for="acTrigger2" class="ui-label">所在商家</label> <input
								class="ui-input" id="acTrigger2" type="text" name="acTrigger2"
								>

						</div>

						<div class="ui-form-item ui-form-item-error ui-form-item-focus">
							<label for="" class="ui-label">商品分类</label> <input
								class="ui-input" type="text" name="pcategoryName"
								value='<s:property value="category.name"/>'>

						</div>
						<div class="ui-form-item ui-form-item-error ui-form-item-focus">
							<label for="" class="ui-label">图片上传</label> <input type="file">

						</div>
						<div class="ui-form-item ui-form-item-success">
							<label for="" class="ui-label">商品描述</label>
							<textarea class="ui-textarea" name="pdescription"
								style="width: 427px; height: 122px;"><s:property
									value="description" /></textarea>

						</div>
						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">商品价格</label> <input name="pprice"
								class="ui-input" type="text" value='<s:property value="price"/>'>

						</div>
						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">是否团购</label> 是<input type="radio"
								name="tuan">否<input type="radio" name="tuan"
								checked="checked">
						</div>
					</s:iterator>
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