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
<link rel="stylesheet" href="/Shop/css/admin/adproduct.css"
	type="text/css" media="screen">
<script type="text/javascript" src="/Shop/js/admin/jquery.min.js"></script>
<script language="javascript" src="/Shop/js/admin/sanji.js"></script>

<script charset="utf-8" id="seajsnode"
	src="http://static.alipayobjects.com/seajs/1.3.1/??sea.js,plugin-combo.js"></script>

<script src="/Shop/js/AjaxUpload.js"></script>
<script src="/Shop/js/imageupload.js"></script>
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
				element : '#sname',
				required : true,
				display: '用户名',				
				rule : 'email'
			}).addItem({
				element : '#scustomerId',
				required : true,
				rule :'number',
				display:'会员ID',
				errormessageRequired :'会员ID不能为空',
			}).addItem({
				element :'#s3',
				 required: true,
		         errormessageRequired: '请选择分类。',
		         display :'分类'
			}).addItem({
				element : '#stel',
				//required : true,
				errormessageRequired :'电话号码格式不正确',
				
			}).addItem({
				element : '#smobile',
				display:'手机号码',
				errormessageRequired :'手机号码格式不正确',
				required : true,
				rule :'number'
				
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

				<h3>店铺编辑</h3>
				<div class="clear"></div>

			</div>
			<!-- End .content-box-header -->

			<div class="content-box-content">
				<s:form class="ui-form" name="" method="post"
					action="storeDeal_Smodified" namespace="/admin" id="test-form">

					<legend></legend>
					<!-- 修改数据默认填入对话框 -->
					<s:iterator value="store">

						<s:hidden value="%{storeId}" name="storeId" />
						<div class="ui-form-item">
							<label for="" class="ui-label"> <span
								class="ui-form-required">*</span>店铺名称
							</label> <input class="ui-input footer-goto" type="text" name="sname" id="sname"
								value='<s:property value="name"/>'>
								
						</div>
						
						<input type="hidden" name="selectId" id="selectId"
							value="${area.areaId }">
						<div class="ui-form-item ui-form-item-error ">
							<label for="" class="ui-label"><span
								class="ui-form-required">*</span>所在区域</label> 
							<div class="footer-goto" style="min-width:190px;">
							<SELECT ID="s1" NAME="s1"
								style="max-width: 75px;">
								<OPTION selected id="ss1"></OPTION>
							</SELECT> <SELECT ID="s2" NAME="s2" style="max-width: 75px;" >
								<OPTION selected id="ss2"></OPTION>
							</SELECT> 
							<SELECT ID="s3" name="s3" style="max-width: 75px;" >
								<OPTION selected id="ss3"></OPTION>
							</SELECT>
							</div>
							
						</div>

						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label " ><span
								class="ui-form-required">*</span>会员ID</label> <input id="scustomerId"
								class="ui-input footer-goto" type="text" name="scustomerId"
								value='<s:property value="customerId"/>'>
						</div>
						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label"><span
								class="ui-form-required">*</span>电话:</label> <input id="stel"
								class="ui-input footer-goto" type="text" name="stel"
								value='<s:property value="tel"/>'>

						</div>
						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label"><span
								class="ui-form-required">*</span>手机:</label> <input id="smobile"
								class="ui-input footer-goto" type="text" name="smobile"
								value='<s:property value="mobile"/>'>

						</div>


						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">上传logo</label> <input name="slogo"
								class="ui-input" id="imgInput" type="text" id="slogo"
								value='<s:property value="logo"/>'> <input
								class="ui-button ui-button-mwhite" id="btnUploadImg" value="上传"
								type="button" name="userfile"> <input id="btnDeleteImg"
								type="hidden">
						</div>
						<!-- 
						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">上传logo</label> <input
								class="ui-input" type="file" name="slogo"
								value='<s:property value="logo"/>'>
						</div>
						 -->

						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">地址</label> <input id="acTrigger2"
								class="ui-input" type="text" name="saddress"
								value='<s:property value="address"/>'>
						</div>

						<div class="ui-form-item ui-form-item-success">
							<label for="" class="ui-label">店铺描述</label>
							<textarea class="ui-textarea" name="pdescription"
								style="width: 427px; height: 122px;"><s:property
									value="description" /></textarea>

						</div>

						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">开店时间(24点):</label> <input
								id="acTrigger2" class="ui-input" type="text" placeholder="例如:13"
								name="sstartTime" value='<s:property value="startTime"/>'>

						</div>
						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">打烊时间(24点):</label> <input
								id="acTrigger2" class="ui-input" type="text" placeholder="例如:23"
								name="sendTime" value='<s:property value="endTime"/>'>

						</div>
						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">起送价(元)</label> <input
								id="acTrigger2" class="ui-input" type="text" name="sshipPrice"
								value='<s:property value="shipPrice"/>'>

						</div>
						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">外卖费(元)</label> <input
								id="acTrigger2" class="ui-input" type="text" name="sshipFee"
								value='<s:property value="shipFee"/>'>

						</div>
						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">最大容纳(人)</label> <input
								id="acTrigger2" class="ui-input" type="text" name="smaxpeople"
								value='<s:property value="maxpeople"/>'>

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


<script language="javascript">
	$(function() {
		$.ajax({

			type : "post",
			url : '/Shop/adminjson/jsondeal_areaInfo.json',
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
		//--------------------------------------------
		//这是调用代码
		var params = {
			sanjiId : $("#selectId").val()
		};
		//alert($("#selectId").val());
		$.ajax({
			type : "post",
			url : '/Shop/adminjson/jsondeal_sanlianarea.json',
			data : params,
			dataType : 'json',
			success : function(result) {
				var j = 0;
				$.each(result.sanMap, function(i, item) {
					j++;

					if (j == 1) {
						$("#ss1").val(i);
						$("#ss1").text(item);
					} else if (j == 2) {

						$("#ss2").val(i);
						$("#ss2").text(item);
					} else if (j == 3) {
						$("#ss3").val(i);
						$("#ss3").text(item);
					}

				});
			}

		});
	});
</script>


</html>