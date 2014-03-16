window.onload = function() {
	init(); // 初始化
}

// 初始化
function init() {

	// 初始化图片上传
	var btnImg = document.getElementById("btnUploadImg");
	var img = document.getElementById("imgShow1");

	var hidImgName = document.getElementById("hidImgName");
	document.getElementById("btnDeleteImg").onclick = function() {
		DelImg(img, hidImgName);
	};
	g_AjxUploadImg(btnImg, img, hidImgName);
}
var count = 0;
// 图片上传
function g_AjxUploadImg(btn, img, hidPut) {
	var button = btn, interval;

	new AjaxUpload(button, {
		action : 'product/product1_savaPicToyoupai.html',
		data : {},
		name : 'myfile',
		responseType : 'json',
		
		onSubmit : function(file, ext) {
			if (!(ext && /^(jpg|png|jpeg|gif)$/.test(ext))) {
				// 扩展名不允许
				alert('错误：无效的文件扩展名！');
				// 取消上传
				return false;
			}

		},
		onComplete : function(file, response) {
			alert(response.fileName);
			
			
		  count=++count % 4;
			alert(count);
			if (count == 1) {
				$("#imgShow1").attr('src', response.fileName);
				$("#imgInput").val(response.fileName);
			} else if (count == 2) {
				$("#imgShow2").attr('src', response.fileName);
				$("#imgInput").val(response.fileName);
			} else if (count == 3) {
				$("#imgShow3").attr('src', response.fileName);
				$("#imgInput").val(response.fileName);
			} else {
				$("#imgShow4").attr('src', response.fileName);
				$("#imgInput").val(response.fileName);
			}

		}

	});

}

// 删除文档
function DelFile(doc, hidPut) {
	hidPut.value = "";
	doc.innerHTML = "<input type=\"text\" disabled=\"disabled\" />";
}

// 删除图片
function DelImg(img, hidPut) {
	hidPut.value = "";
	img.src = "/images/nophoto.gif";
}