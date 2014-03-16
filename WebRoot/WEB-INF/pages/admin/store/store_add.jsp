<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/admin/adproduct.css" />
<link rel="stylesheet" type="text/css" href="/css/admin/alice.css " />
<link rel="stylesheet" href="/css/admin/style.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/iconfont.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/adproduct.css" type="text/css"
	media="screen">
<script type="text/javascript" src="/js/admin/jquery.min.js"></script>
<script language="javascript" src="/js/admin/sanji.js"></script>

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
	seajs.use([ '$', 'validator' ], function($, Validator) {
		$(function() {
			Validator.addRule('oneTimes', /^[0-9](\d)*$/, '{{display}}必须为整数');
			var validator = new Validator({
				element : '#test-form'
			});
			validator.addItem({
				element : '#sname',
				required : true,
				display : '用户名',
			}).addItem({
				element : '#scustomerId',
				required : true,
				rule : 'number',
				display : '会员ID',
				errormessageRequired : '会员ID不能为空',
			}).addItem({
				element : '#category2',
				required : true,
				errormessageRequired : '请选择经营范围。',
				display : '经营范围'
			}).addItem({
				element : '#s3',
				required : true,
				errormessageRequired : '请选择分类。',
				display : '分类'
			}).addItem({
				element : '#stel',
				//required : true,
				errormessageRequired : '电话号码格式不正确',

			}).addItem({
				element : '#smobile',
				display : '手机号码',
				errormessageRequired : '手机号码格式不正确',
				required : true,
				rule : 'mobile'

			}).addItem({
				element : '#saddress',
				display : '地址',			
				required : true,
			}).addItem({
				element : '#sstartTime',
				display : '开店时间',
				rule : 'number',
				required : true,
			}).addItem({
				element : '#sendTime',
				required : true,
				rule : 'number',
				display : '打烊时间',
			}).addItem({
				element : '#sshipPrice',
				required : true,
				display : '起送费',
				rule : 'oneTimes',
			}).addItem({
				element : '#sshipFee',
				required : true,
				rule : 'oneTimes',
				display : '外卖费',

			}).addItem({
				element : '#smaxpeople',
				display : '最大容纳人数',
				required : true,
				rule : 'number'

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
							</label> <input class="ui-input footer-goto" type="text" name="sname"
								id="sname" value='<s:property value="name"/>'>

						</div>

						<input type="hidden" name="selectId" id="selectId"	value="10">
						
						<input type="hidden" id="categoryId" name="categoryId" value="${categoryId}"/>
						<div class="ui-form-item  ">
							<label for="" class="ui-label"><span
								class="ui-form-required">*</span>经营分类</label> 
							
							<SELECT ID='category1' NAME='category1'
								style='max-width: 75px;'>
								<OPTION selected id='ocategory1'></OPTION>
							</SELECT> <SELECT ID='category2' NAME='category2' style='max-width: 75px;' >
								<OPTION selected id='ocategory2'></OPTION>
							</SELECT> 
							
						</div>	
							
						
						<div class="ui-form-item  ">
							<label for="" class="ui-label"><span
								class="ui-form-required">*</span>覆盖范围</label> 
							
							<SELECT ID='s1' NAME='s1'
								style='max-width: 75px;'>
								<OPTION selected id='ss1'></OPTION>
							</SELECT> <SELECT ID='s2' NAME='s2' style='max-width: 75px;' >
								<OPTION selected id='ss2'></OPTION>
							</SELECT> 
							<SELECT ID='s3' name='s3' style='max-width: 75px;' >
								<OPTION selected id='ss3'></OPTION>
							</SELECT>
						</div>
							
	
												
						
						<div class="ui-form-item ui-form-item-error" style="max-width: 500px;" id="checkboxAll">
							
							<s:iterator value="areaStores"> 
								<input type="checkbox" name="areaScope" checked="checked" value="${area.areaId}"><span>${area.name}</span>
							</s:iterator>
						</div>
						
						

						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label "><span
								class="ui-form-required">*</span>会员ID</label> <input id="scustomerId"
								class="ui-input footer-goto" type="text" name="scustomerId"
								value='<s:property value="customer.customerId"/>'>
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
							<label for="" class="ui-label">地址</label> <input id="saddress"
								class="ui-input footer-goto" type="text" name="saddress"
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
								id="sstartTime" class="ui-input footer-goto" type="text"
								placeholder="例如:8" name="sstartTime"
								value='<s:property value="startTime"/>'>

						</div>
						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">打烊时间(24点):</label> <input
								id="sendTime" class="ui-input footer-goto" type="text"
								placeholder="例如:23" name="sendTime"
								value='<s:property value="endTime"/>'>

						</div>
						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">最大容纳(人)</label> <input
								id="smaxpeople" class="ui-input footer-goto" type="text"
								name="smaxpeople" value='<s:property value="maxpeople"/>'>

						</div>
						<div class="ui-form-item ui-form-item-error">
							<label for="" class="ui-label">是否送货:</label> 
							<input type="radio" name="sendorno" value="1" checked="checked" id="sendorno1"/>是	
							<input type="radio" name="sendorno" value="0" id="sendorno2"/>否

						</div>
						
						
						<div class="ui-form-item ui-form-item-error" id="shipPriceItem">
							<label for="" class="ui-label">起送价(元)</label> <input
								id="sshipPrice" class="ui-input footer-goto" type="text"
								name="sshipPrice" value='${shipPrice>0?shipPrice:"0"}'>

						</div>
						<div class="ui-form-item ui-form-item-error" id="shipFeeItem">
							<label for="" class="ui-label">外卖费(元)</label> <input
								id="sshipFee" class="ui-input footer-goto" type="text"
								name="sshipFee" value='${shipFee>0?shipFee:"0"}'>

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
			url : '/adminjson/jsondeal_areaInfo.json',
			data : "",
			dataType : "json",
			success : function(result) {
				var rjson = result.jsonArray;
				var cjson =result.categoryJsonArray;
				var categoryArray=new Array();
				//alert(result);
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
				
				
				for ( var i = 0; i < cjson.length; i++) {
					categoryArray[i] = new Array(cjson[i].cid, cjson[i].pid,
							cjson[i].name);
				}
				//array[2]=new Array("2","1","22");
				var liandong = new CLASS_LIANDONG_YAO(categoryArray); //设置数据源
				liandong.firstSelectChange("根目录", "category1"); //设置第一个选择框
				liandong.subSelectChange("category1", "category2"); //设置子级选择框
				//liandong.subSelectChange("c2", "c3");	
				
				
			}
		});
		//--------------------------------------------
		
		var array2=new Array();
		//var oldvalue;
		var lcount=0;
		/*$(function(){
			oldvalue=$('[name="areaScope"][checked="checked"]').val();
			for (var i=0; i<oldvalue.length;i++)
			{
				console.log(oldvalue[i]);
			}
			console.log(oldvalue.length);
		});*/
		$('#s3').change(function(){ 
			//alert($(this).children('option:selected').val()); 
			var pvalue=$(this).children('option:selected').val();//这就是selected的值 
			var ptext=$(this).children('option:selected').text();
			var i=0;
			for( i=0;i<array2.length;i++)
			{
				if(array2[i]==pvalue) break;				
				
			}
			if(i==array2.length){
			var checkbox = $('<div style="max-width:100px;float:left;"><input type="checkbox" name="areaScope" checked="checked" value="'+pvalue+'" /><span>'+ptext+'</span></div> ');
			$('#checkboxAll').append(checkbox);
			}
			array2[lcount++]=pvalue;			
			
			//alert(p1);
			//alert(ptext);
			});
		
		
		
		$('#category1').change(function(){ 
			//alert($(this).children('option:selected').val()); 
			var pvalue=$(this).children('option:selected').val();//这就是selected的值
			$('#categoryId').val(pvalue);
			});
		$('#category2').change(function(){ 
			//alert($(this).children('option:selected').val()); 
			var pvalue=$(this).children('option:selected').val();//这就是selected的值
			$('#categoryId').val(pvalue);
			});
		
		
		//这是调用代码
		var params = {
			categoryId : $("#categoryId").val(),
			sanjiId :$("#selectId").val()
		};
	//	alert($("#selectId").val());
		//alert(params);
		
		$.ajax({
			type : "post",
			url : '/adminjson/jsondeal_sanlianCategory.json',
			data : params,
			dataType : 'json',
			success : function(result) {
				var j = 0;	
				var k = 0;
				$.each(result.sanMap, function(i, item) {
					j++;					
					if (j == 1) {
						$("#ocategory1").val(i);
						$("#ocategory1").text(item);
						$("#categoryId").val(i);
					} else if (j == 2) {

						$("#ocategory2").val(i);
						$("#ocategory2").text(item);
						$("#categoryId").val(i);
					} 
				});
				
				
			}
		});
		$('#sendorno1').click(function(){
			if(this.checked==true){
				$('#shipFeeItem').show();
				$('#shipPriceItem').show();
			}		
				
		});
		$('#sendorno2').click(function(){
			if(this.checked==true){
				$('#shipFeeItem').hide();
				$('#shipPriceItem').hide();
			}		
				
		});

	});
</script>


</html>