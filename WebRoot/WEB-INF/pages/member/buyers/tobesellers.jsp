<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<script type="text/javascript">
<!--//-->
	$(function() {
		seajs.use([ '$', 'validator' ], function($, Validator) {
			var validator = new Validator({
				element : '#store_data'
			});
			validator.addItem({
				element : '#store_name',
				required : true,
				rule : 'text'
			}).addItem({
				element : '#store_tel',
				required : true,
				rule : 'number'
			}).addItem({
				element : '#store_mobile',
				required : true,
				rule : 'mobile'
			}).addItem({
				element : '#store_address',
				required : true,
				rule : 'text'
			}).addItem({
				element : '#store_startTime',
				required : true,
				rule : 'text'
			}).addItem({
				element : '#store_endTime',
				required : true,
				rule : 'text'
			}).addItem({
				element : '#store_shipPrice',
				required : true,
				rule : 'number'
			}).addItem({
				element : '#store_shipFee',
				required : true,
				rule : 'number'
			}).addItem({
				element : '#store_maxpeople',
				required : true,
				rule : 'number'
			})
			.addItem({
				element : '#s1',
				required : true,
				rule : 'text',
				errormessageRequired: '请选择店铺区域'
			})
			.addItem({
				element : '#s2',
				required : true,
				rule : 'text',
				errormessageRequired: '请选择店铺区域'
			})
			.addItem({
				element : '#s3',
				required : true,
				rule : 'text',
				errormessageRequired: '请选择店铺区域'
			});
		});
		$("#store_startTime, #store_endTime").timePicker();

		// Store time used by duration.
		var oldTime = $.timePicker("#store_startTime").getTime();

		// Keep the duration between the two inputs.
		$("#store_startTime").change(
				function() {
					if ($("#store_endTime").val()) { // Only update when second input has a value.
						// Calculate duration.
						var duration = ($.timePicker("#store_endTime")
								.getTime() - oldTime);
						var time = $.timePicker("#store_startTime").getTime();
						// Calculate and update the time in the second input.
						$.timePicker("#store_endTime").setTime(
								new Date(new Date(time.getTime() + duration)));
						oldTime = time;
					}
				});
		// Validate.
		$("#store_endTime").change(
				function() {
					if ($.timePicker("#store_startTime").getTime() > $
							.timePicker(this).getTime()) {
						$(this).parent().addClass("ui-form-item-error");
					} else {
						$(this).parent().removeClass("ui-form-item-error");
					}
				});
		
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
			//----------
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
			//--------------------------------------------
			
			var array2=new Array();
		var lcount=0;
		
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
			var checkbox = $('<div style="max-width:100px;float:left;"><input type="checkbox" name="areaIds" checked="checked" value="'+pvalue+'"/><span>'+ptext+'</span></div> ');
			$('#checkboxAll').append(checkbox);
			}
			array2[lcount++]=pvalue;			
			
			//alert(p1);
			//alert(ptext);
			});
			//这是调用代码

		});
	});
</script>
<div class="member_management_content">
	<%@include file="/WEB-INF/pages/member/buyers/left_menu.jsp"%>
	<div class="member_management_content_right">
		<div class="member_index_main_content">
			<h1>商家加盟</h1>
			<div class="join_data">
				<s:form  action="AuditSeller_auditSeller" method="post" namespace="/user" class="ui-form" id="store_data">
					<div class="ui-form-item">
						<label for="store_name" class="ui-label"><span
							class="ui-form-required">*</span>店铺名称：</label> <input id="store_name"
							name="name" class="ui-input" type="text" data-explain="输入店铺名称" />
						<div class="ui-form-explain">请输入店铺名称</div>
					</div>
					<div class="ui-form-item">
						<label for="store_tel" class="ui-label"><span
							class="ui-form-required">*</span>店铺固话：</label> <input id="store_tel"
							name="tel" class="ui-input" type="text" data-explain="输入店铺固定电话" />
						<div class="ui-form-explain">请输入店铺固定电话</div>
					</div>
					<div class="ui-form-item">
						<label for="store_mobile" class="ui-label"><span
							class="ui-form-required">*</span>手机号：</label> <input id="store_mobile"
							name="mobile" class="ui-input" type="text" data-explain="输入手机号" />
						<div class="ui-form-explain">请输入手机号</div>
					</div>
					<div class="ui-form-item">
						<label for="store_address" class="ui-label"><span
							class="ui-form-required">*</span>店铺详细地址：</label> <input
							id="store_address" name="address" class="ui-input" type="text"
							data-explain="输入店铺详细地址" />
						<div class="ui-form-explain">请输入店铺详细地址</div>
					</div>
					<div class="ui-form-item">
						<label for="store_startTime" class="ui-label"><span
							class="ui-form-required">*</span>开始营业时间：</label> <input type="text"
							id="store_startTime" size="10" value="08:00" name="startTime"
							class="ui-input" type="text" data-explain="选择店铺营业开始时间" />
						<div class="ui-form-explain">请选择店铺营业开始时间</div>
					</div>
					<div class="ui-form-item">
						<label for="store_endTime" class="ui-label"><span
							class="ui-form-required">*</span>结束营业时间：</label> <input type="text"
							id="store_endTime" name="endTime" class="ui-input"
							data-explain="选择店铺营业结束时间" size="10" value="" />
						<div class="ui-form-explain">请选择店铺营业结束时间</div>
					</div>
					<div class="ui-form-item">
						<label for="store_shipPrice" class="ui-label"><span
							class="ui-form-required">*</span>每单起送价格：</label> <input
							id="store_shipPrice" name="shipPrice" class="ui-input"
							type="text" data-explain="输入每单起送价格" />
						<div class="ui-form-explain">请输入每单起送价格</div>
					</div>
					<div class="ui-form-item">
						<label for="store_shipFee" class="ui-label"><span
							class="ui-form-required">*</span>每单配送费用：</label> <input
							id="store_shipFee" name="shipFee" class="ui-input" type="text"
							data-explain="输入每单配送费用" />
						<div class="ui-form-explain">请输入每单配送费用</div>
					</div>
					<div class="ui-form-item">
						<label for="store_maxpeople" class="ui-label"><span
							class="ui-form-required">*</span>店家规模：</label> <input
							id="store_maxpeople" name="maxpeople" class="ui-input"
							type="text" data-explain="输入店家规模" />
						<div class="ui-form-explain">请输入店家规模</div>
					</div>
					<input type="hidden" id="categoryId" name="categoryId" value="${categoryId}"/>
						<div class="ui-form-item  ui-form-item-error">
							<label for="" class="ui-label"><span
								class="ui-form-required">*</span>经营分类</label> 
							
							<SELECT ID='category1' NAME='category1'
								style='max-width: 125px;'>
								<OPTION selected id='ocategory1'></OPTION>
							</SELECT> <SELECT ID='category2' NAME='category2' style='max-width: 125px;' >
								<OPTION selected id='ocategory2'></OPTION>
							</SELECT> 
							
						</div>	
					<div class="ui-form-item ui-form-item-error">
							<label for="s1" class="ui-label"><span
								class="ui-form-required">*</span>所在区域：</label> 
								
							<SELECT ID="s1" name="s1" style="max-width: 125px;">
								<OPTION selected></OPTION>
							</SELECT> 
							<SELECT ID="s2" name="s2" style="max-width: 125px;">
								<OPTION selected></OPTION>
							</SELECT> 
							<SELECT	ID="s3" name="areaId" style="max-width: 125px;" >
								<OPTION selected value="${s3}"></OPTION>
							</SELECT>
							<div class="ui-form-explain">请选择店家区域</div>
						</div>
						
						
					<div class="ui-form-item ui-form-item-error" style="max-width: 500px;" id="checkboxAll">
							
	
					</div>
					
					<s:token></s:token>
					<div class="submit_reg_btn">
						<span class="ui-button-morange ui-button"> <input
							id="submit_reg" class="ui-button-text" value="确定" type="submit"></span>
					</div>
				</s:form>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>