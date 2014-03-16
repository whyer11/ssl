<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>我的网站-织梦内容管理系统 V57_GBK_SP1</title>
<link href="/css/admin/frame.css" rel="stylesheet" type="text/css">
<script src="/js/admin/jquery.js" language="javascript"
	type="text/javascript"></script>
<script src="/js/admin/frame.js" language="javascript"
	type="text/javascript"></script>
<link href="/css/admin/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Expires" CONTENT="0">
<meta http-equiv="Cache-Control" CONTENT="no-cache">
<meta http-equiv="Pragma" CONTENT="no-cache">

<script language="JavaScript">
<!--
	javascript: window.history.forward(1);
//-->
</script>



<style type="text/css">
#skinlist {
	display: block;
	height: 11px;
	margin-top: 10px;
	overflow: hidden;
	width: 86px;
}

#skin div {
	float: left;
}

#skin li {
	cursor: pointer;
	float: left;
	height: 11px;
	width: 14px;
}

#def div,#s1 div,#s2 div,#s3 div,#s4 div {
	background-image: url("/images/admin/skinbutton.png");
	background-repeat: no-repeat;
}

#s1 div {
	background-position: 0 0px;
}

#s2 div {
	background-position: 0 -11px;
}

#s3 div {
	background-position: 0 -22px;
}

#s4 div {
	background-position: 0 -33px;
}

#s1 div.sel {
	background: url("/images/admin/skinbutton.png") no-repeat scroll -14px
		top transparent;
}

#s2 div.sel {
	background: url("/images/admin/skinbutton.png") no-repeat scroll -14px
		-11px transparent;
}

#s3 div.sel {
	background: url("/images/admin/skinbutton.png") no-repeat scroll -14px
		-22px transparent;
}

#s4 div.sel {
	background: url("/images/admin/skinbutton.png") no-repeat scroll -14px
		-33px transparent;
}
</style>
</head>
<body class="showmenu" >

	<div class="left">
		<div class="menu" id="menu">
			<iframe src="admin/login_loadMenu.html" id="menufra" name="menu"
				frameborder="0" scrolling="auto"></iframe>
		</div>
	</div>
	<div class="right">
		<div class="main">

			<iframe src="admin/login_loadBody.html" id="main" name="main"
				frameborder="0" scrolling="auto"></iframe>

		</div>
		<!--<div id="help"><span id="content"><a href="#">栏目管理操作使用说明</a></span></div>-->
	</div>
	<!-- 
<script language="javascript">
function JumpFrame(url1, url2){
    jQuery('#menufra').get(0).src = url1;
    jQuery('#main').get(0).src = url2;
}
(function($)
{
 	$("#skinlist>li").click(function()
	 {
		 var adminskin = $(this).index() + 1;
		 var csshref = "images/style"+adminskin+"/style.css";
		 $("#skinlist>li").each(function(){$(this).children('div').attr('class', '')});
		 $("#topdedelogo").attr('src', 'images/style'+adminskin+'/admin_top_logo.gif')
		 $('link').each(function()
		 {
			 if($(this).attr('href').match(/style.css$/))
			 {
				 $(this).attr('href',csshref);
			 }
		 });
		 $(this).children('div').attr('class', 'sel');
		 $(window.frames["menu"].document).find("link").each(function()
		 {
			 if($(this).attr('href').match(/style.css$/))
			 {
				 $(this).attr('href',csshref);
			 }
		 });
		 $(window.frames["main"].document).find("link").each(function()
		 {
			 if($(this).attr('href').match(/style.css$/))
			 {
				 $(this).attr('href',csshref);
			 }
		 });
		 $.get('index_body.php?dopost=setskin&cskin='+adminskin);
	 });
})(jQuery);
</script>
 -->


</body>
</html>