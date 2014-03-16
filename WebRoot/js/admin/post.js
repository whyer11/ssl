$(function() {
		var m_url='admin/fa1_show.json';
		var s_url='admin/fa2_show.json';
		var memberlistTpl = null;
		var storelistTpl = null;
		var memberlist = null;
		var storelist = null;
		var totalpage_num = 1;
		var currentpage_num = 1;
		var sex=null;
		var areaId=0;
		
		seajs.use([ '$', 'validator','handlebars' ], function($, Validator,Handlebars) {
			var validator = new Validator({
				element : '[name = example]'
			});
			validator.addItem({
				element : '#addr',
				required : true,
				rule : 'text'
			}).addItem({
				element : '#title',
				required : true,
				rule : 'text'
			});
			
		$('.gender').click(function(){
			if($(this).checked) $(this).attr("checked",false);
			else  $(this).attr("checked",true);
			sex=$(this).val();
			
		});
		
		$('#s3').change(function(){
			areaId=$(this).children('option:selected').val();
			
		} );
			
			$(window).load(function(){
				ajaxPOST(m_url,{pageSize:8,pageNumber:1,sex:null,areaId:0}).success(function(data){
					if(!memberlistTpl){
						totalpage_num = data.totalPage;
						currentpage_num = data.pageNumber;
						var cuslist = data.customerList;
						for(var i=0;i<cuslist.length; i++)
							{
							memberlistTpl = Handlebars.compile($('#TPL-memberlist').html());
							memberlist += memberlistTpl(cuslist[i]);
							}
						$('#memeberinfo_list').html(''+memberlist+'');
						memberlist = null;
						$('.ui-paging-bold').text(currentpage_num+"/"+totalpage_num);
					}
				});
			});
		$('.ui-paging-prev').click(function(){
			if(currentpage_num == 1)
				{
					alert('没有上一页了');
				}
			else{
				if($(this).data('cid')=='member'){
			ajaxPOST(m_url,{pageNumber : (currentpage_num-1)}).success(function(data){
				
					totalpage_num = data.totalPage;
					currentpage_num = data.pageNumber;
					var cuslist = data.customerList;
					for(var i=0;i<cuslist.length; i++)
						{
						memberlistTpl=Handlebars.compile($('#TPL-memberlist').html());
						memberlist += memberlistTpl(cuslist[i]);
						}
					$('#memeberinfo_list').html(''+memberlist+'');
					memberlist = null;
					$('.ui-paging-bold').text(currentpage_num+"/"+totalpage_num);
				
			});
			}else{
				if($(this).data('cid')=='store'){
					ajaxPOST(s_url,{pageNumber : (currentpage_num-1),pageSize:8,sex:null,areaId:0}).success(function(data){
						totalpage_num = data.totalPage;
						currentpage_num = data.pageNumber;
						var cuslist = data.storeList;
						for ( var i = 0; i < cuslist.length; i++) {
							storelistTpl=Handlebars.compile($('#TPL-storelist').html());
							storelist+=storelistTpl(cuslist[i]);
						}
						$('#storeinfo_list').html(''+storelist+'');
						storelist = null;
						$('.ui-paging-bold').text(currentpage_num+"/"+totalpage_num);
					});
				}
			}
			}
		});
		$('.ui-paging-next').click(function(){
			if(currentpage_num==totalpage_num)
				{
				alert('没有下一页了');
				}
			else {if($(this).data('cid')=='member'){
			ajaxPOST(m_url,{pageNumber : (currentpage_num+1),pageSize:8,sex:null,areaId:0}).success(function(data){
					type="customer";
					totalpage_num = data.totalPage;
					currentpage_num = data.pageNumber;
					var cuslist = data.customerList;
					for(var i=0;i<cuslist.length; i++)
						{
						memberlistTpl=Handlebars.compile($('#TPL-memberlist').html());
						memberlist += memberlistTpl(cuslist[i]);
						}
					$('#memeberinfo_list').html(''+memberlist+'');
					memberlist = null;
					$('.ui-paging-bold').text(currentpage_num+"/"+totalpage_num);
				
			});
			}else{
				if($(this).data('cid')=='store'){
					ajaxPOST(s_url,{pageNumber : (currentpage_num+1)}).success(function(data){
						totalpage_num = data.totalPage;
						currentpage_num = data.pageNumber;
						var cuslist = data.storeList;
						for ( var i = 0; i < cuslist.length; i++) {
							storelistTpl=Handlebars.compile($('#TPL-storelist').html());
							storelist+=storelistTpl(cuslist[i]);
						}
						$('#storeinfo_list').html(''+storelist+'');
						storelist = null;
						$('.ui-paging-bold').text(currentpage_num+"/"+totalpage_num);
					});
				}
			}
			}
		});
		$('.nav').find('li a').bind('click',function(){
			if($(this).data('cid')=='member'){
				ajaxPOST(m_url,{}).success(function(data){
						type="customer";
						totalpage_num = data.totalPage;
						currentpage_num = data.pageNumber;
						var cuslist = data.customerList;
						for(var i=0;i<cuslist.length; i++)
							{
							memberlistTpl = Handlebars.compile($('#TPL-memberlist').html());
							memberlist += memberlistTpl(cuslist[i]);
							}
						$('#memeberinfo_list').html(''+memberlist+'');
						memberlist = null;
						$('.ui-paging-bold').text(currentpage_num+"/"+totalpage_num);
				});
			}
			else if($(this).data('cid')=='store'){
				ajaxPOST(s_url,{}).success(function(data){
					totalpage_num = data.totalPage;
					currentpage_num = data.pageNumber;
					var cuslist = data.storeList;
					for ( var i = 0; i < cuslist.length; i++) {
						storelistTpl=Handlebars.compile($('#TPL-storelist').html());
						storelist+=storelistTpl(cuslist[i]);
					}
					$('#storeinfo_list').html(''+storelist+'');
					storelist = null;
					$('.ui-paging-bold').text(currentpage_num+"/"+totalpage_num);
				});
			}
		});
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content"]', {
				cssPath : '/css/admin/prettify.css',
				uploadJson : '/js/admin/jsp/upload_json.jsp',
				fileManagerJson : '/js/admin/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
		
		});
		// Calling the plugin
		$("#data").organicTabs();
	});
function addToAddress1(){
	var objectName=document.getElementById("customer1").getElementsByTagName("input");
	document.getElementById("flag").value="customer";
	for(var i=0;i<objectName.length;i++){
		var name=objectName[i];	
		if(name.type=="checkbox"&&name.checked&&name.value!="null"){
			document.getElementById("addr").value+=name.value+";";	
			
		}
	}
}
function addToAddress2(){	
	var objectName=document.getElementById("store1").getElementsByTagName("input");	
	document.getElementById("flag").value="store";
	for(var i=0;i<objectName.length;i++){
		var name=objectName[i];
		if(name.type=="checkbox"&&name.checked&&name.value!="null"){
			document.getElementById("addr").value+=name.value+";";	
			
		}
	}
}
/**
 * 
 * @param url
 * @param array
 * @param callbacksucc
 * @param callbackfail
 */

// function post_class (url,array,callbacksucc,callbackfail){
//	 ajaxPOST(url,array).success(callbacksucc).fail(callbackfail);
// 
// }
// 
 /**
  * 处理会员列表
  */
// var array = new Array();
// array["pageSize"]=8;
// array.pageNumber=currentpage_num;
// array.areaId=areaId;
// array.sex=sex;
// //页面初始化回调
// function callback1(data){ 
//		if(!memberlistTpl){
//			totalpage_num = data.totalPage;
//			currentpage_num = data.pageNumber;
//			var cuslist = data.customerList;
//			for(var i=0;i<cuslist.length; i++)
//				{
//				memberlistTpl = Handlebars.compile($('#TPL-memberlist').html());
//				memberlist += memberlistTpl(cuslist[i]);
//				}
//			$('#memeberinfo_list').html(''+memberlist+'');
//			memberlist = null;
//			$('.ui-paging-bold').text(currentpage_num+"/"+totalpage_num);
//		}
// }
// 
// //上一页
// function prePage(data){
//	 
//	    totalpage_num = data.totalPage;
//		currentpage_num = data.pageNumber;
//		var cuslist = data.customerList;
//		for(var i=0;i<cuslist.length; i++)
//			{
//			memberlistTpl=Handlebars.compile($('#TPL-memberlist').html());
//			memberlist += memberlistTpl(cuslist[i]);
//			}
//		$('#memeberinfo_list').html(''+memberlist+'');
//		memberlist = null;
//		$('.ui-paging-bold').text(currentpage_num+"/"+totalpage_num);
// }
// 
// 
// //下一页
// function nextPage(data){
//	 
// }
// 
// //性别选择
// function filterSex(data){
//	 
// }
// 
// //地区选择
// function filterArea(data){
//	 
// }
// function fail1(){ 
//	 alert("未知错误!");
// }
// 
// $(window).load(post_class(m_url,array,callback1,fail1));
// $('.ui-paging-prev').click(function (){
//		 if(currentpage_num == 1)
//			{
//				alert('没有上一页了');
//			}
//		else{
//			if($(this).data('cid')=='member')
//			{
//				post_class(m_url,array,prePage,fail1);
//			}
//		}
// }
//		 );
//			
//
//
//



