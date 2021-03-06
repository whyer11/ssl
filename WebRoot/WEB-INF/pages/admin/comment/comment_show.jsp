<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/Shop/css/admin/adproduct.css" />
<link rel="stylesheet" type="text/css" href="/Shop/css/admin/alice.css " />
<link rel="stylesheet" href="/Shop/css/admin/style.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/Shop/css/admin/iconfont.css"
	type="text/css" media="screen">
</head>
<body>
	<div id="main-content">
		<div class="content-box">
			<!-- Start Content Box -->
			<div class="content-box-header">

				<h3>店铺查看</h3>
				<div class="clear"></div>

			</div>
			<!-- End .content-box-header -->

			<div class="content-box-content ">
				<s:form class="ui-form">

					<legend></legend>
					<!-- 修改数据默认填入对话框 -->
					<s:iterator value="store">

						<input type="hidden" name="pageIndex" value="${pageIndex }">
						<div class="ui-form-item">
							<label for="" class="ui-label"> <span
								class="ui-form-required ui-form-item-success"></span>店铺名称
							</label> <label class="ui-input"><s:property value="name" /></label>

						</div>
						<div class="ui-form-item ui-form-item-success">
							<label for="" class="ui-label">所在区域</label> <label
								class="ui-input"><s:property value="area.name" /></label>
						</div>

						<div class="ui-form-item ui-form-item-success ui-form-item-focus">
							<label for="" class="ui-label">会员ID</label> <label
								class="ui-input"><s:property value="customerId" /></label>
						</div>
						<div class="ui-form-item ui-form-item-success ui-form-item-focus">
							<label for="" class="ui-label">电话:</label> <label
								class="ui-input" style="height: 18px;"><s:property
									value="tel" /></label>
						</div>
						<div class="ui-form-item ui-form-item-success ui-form-item-focus">
							<label for="" class="ui-label">手机:</label> <label
								class="ui-input" style="height: 18px;"><s:property
									value="mobile" /></label>
						</div>
						<div class="ui-form-item ui-form-item-success ui-form-item-focus">
							<label for="" class="ui-label">图片logo</label> <img alt="店铺logo"
								src="${logo}" style="width: 190px;height:150px;border:0;"/>

						</div>
						<div class="ui-form-item ui-form-item-success">
							<label for="" class="ui-label">店铺简介</label>
							<textarea class="ui-textarea" name="pdescription"
								style="width: 427px; height: 122px;" disabled="disabled"><s:property
									value="description" /></textarea>

						</div>

						<div class="ui-form-item ui-form-item-success">
							<label for="" class="ui-label">地址</label> <label class="ui-input"
								style="height: 18px;"><s:property value="address" /></label>

						</div>
						<div class="ui-form-item ui-form-item-success">
							<label for="" class="ui-label">创建时间</label> <label
								class="ui-input" style="height: 18px;"><s:property
									value="crateTime" /></label>

						</div>
						<div class="ui-form-item ui-form-item-success">
							<label for="" class="ui-label">营业时间</label> <label
								class="ui-input">&nbsp;&nbsp;${ startTime==null?8:startTime}点
								到 &nbsp;${endTime==null?24:endTime}点 </label>
						</div>
						<div class="ui-form-item ui-form-item-success">
							<label for="" class="ui-label">起送价:</label> <label
								class="ui-input" style="height: 18px;">${shipPrice} </label>
						</div>
						<div class="ui-form-item ui-form-item-success">
							<label for="" class="ui-label">邮费:</label> <label
								class="ui-input" style="height: 18px;">${shipFee} </label>
						</div>
						<a
							href="admin/${saudit==false?'storeDeal_auditsStoreList.html':'storeDeal_list.html'}?pageIndex=${pageIndex }
							"
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