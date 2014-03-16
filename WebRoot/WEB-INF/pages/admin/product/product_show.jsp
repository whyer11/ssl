<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/css/admin/adproduct.css" />
<link rel="stylesheet" type="text/css" href="/css/admin/alice.css " />
<link rel="stylesheet" href="/css/admin/style.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/iconfont.css" type="text/css"
	media="screen">
</head>
<body>
	<div id="main-content">
		<div class="content-box">
			<!-- Start Content Box -->
			<div class="content-box-header">

				<h3>商品查看</h3>
				<div class="clear"></div>

			</div>
			<!-- End .content-box-header -->

			<div class="content-box-content">
				<s:form class="ui-form" name="" method="post" action="productA_Smodified" namespace="/admin">
					
						<legend></legend>
						<!-- 修改数据默认填入对话框 -->
						<s:iterator value="product">
						
							<s:hidden value="%{productId}" name="productId"/>
							<div class="ui-form-item">
								<label for="" class="ui-label"> <span
									class="ui-form-required ui-form-item-success"></span>商品名称
								</label> <label class="ui-input"><s:property value="name"/></label>							

							</div>
							<div class="ui-form-item ui-form-item-success">
								<label for="" class="ui-label">所在商家</label> 
								<label class="ui-input"><s:property value="store.name"/></label>
							</div>

							<div class="ui-form-item ui-form-item-success ui-form-item-focus">
								<label for="" class="ui-label">商品分类</label> 
								<label class="ui-input"><s:property value="category.name"/></label>
							</div>
							<div class="ui-form-item ui-form-item-success ui-form-item-focus">
								<label for="" class="ui-label">图片上传</label>
								<label class="ui-input">图片</label>

							</div>
							<div class="ui-form-item ui-form-item-success">
								<label for="" class="ui-label">商品描述</label>
								<textarea class="ui-textarea" name="pdescription"
									style="width: 427px; height: 122px;" disabled="disabled"><s:property value="description"/></textarea>

							</div>
							<div class="ui-form-item ui-form-item-success">
								<label for="" class="ui-label">商品价格</label>
								<label class="ui-input"><s:property value="price"/></label>								 
							</div>
							<div class="ui-form-item ui-form-item-success">
								<label for="" class="ui-label">创建时间</label>
								<label class="ui-input"><s:property value="createTime"/></label>
								 
							</div>
							<!-- <div class="ui-form-item ui-form-item-error">
								<label for="" class="ui-label">是否团购</label> 是<input type="radio"
									name="tuan">否<input type="radio" name="tuan"
									checked="checked">
							</div> -->
							<a href="admin/productA_list.html?pageIndex=${pageIndex}&storeId=<s:property value="store.storeId"/>" class="ui-button ui-button-morange "  style="margin-left: 140px;">返回</a>
						</s:iterator>
						
				
				</s:form>

				<!-- End .clear -->
			</div>
			<!-- End #tab1 -->


			<!-- End #main-content -->
		</div>
	</div>

</body>
</html>