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
<link rel="stylesheet" href="/css/admin/iconfont.css"
	type="text/css" media="screen">
</head>
<body>
	<div id="main-content">
		<div class="content-box">
			<!-- Start Content Box -->
			<div class="content-box-header">

				<h3>幻灯片查看</h3>
				<div class="clear"></div>

			</div>
			<!-- End .content-box-header -->

			<div class="content-box-content">
				<s:form class="ui-form" name="" method="post"
					action="productA_Smodified" namespace="/admin">

					<legend></legend>
					<!-- 修改数据默认填入对话框 -->
					<s:iterator value="slides">

						<s:hidden value="%{productId}" name="slideId" />
						<div class="ui-form-item">
							<label for="" class="ui-label"> <span
								class="ui-form-required ui-form-item-success"></span>名称
							</label>
							<textarea class="ui-textarea" name="pdescription"
								style="width: 300px; height: 50px; max-height: 200px; max-width: 500px;"
								disabled="disabled"><s:property value="picname" /></textarea>
						</div>
						<div class="ui-form-item ui-form-item-success">
							<label for="" class="ui-label">点击链接</label>
							<textarea class="ui-textarea" name="pdescription"
								style="width: 300px; height: 50px; max-height: 200px; max-width: 500px;"
								disabled="disabled"><s:property value="picUrl" /></textarea>

						</div>
						<div class="ui-form-item ui-form-item-success">
							<label for="" class="ui-label">图片链接</label>
							<textarea class="ui-textarea" name="pdescription"
								style="width: 300px; height: 50px; max-height: 200px; max-width: 500px;"
								disabled="disabled"><s:property value="url" /></textarea>

						</div>
						<a href="admin/updateDeal_slidesList.html?pageIndex=${pageIndex}"
							class="ui-button ui-button-morange " style="margin-left: 140px;">返回</a>
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