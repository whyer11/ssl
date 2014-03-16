<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>我的网站-织梦内容管理系统 V57_GBK_SP1</title>
<link rel="stylesheet" href="/css/admin/reset.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/style(1).css"
	type="text/css" media="screen">
<link rel="stylesheet" href="/css/admin/invalid.css"
	type="text/css" media="screen">
<link rel="stylesheet" href="/css/admin/alice.css" type="text/css"
	media="screen">
<script language="javascript" src="/js/admin/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="/js/admin/admin.jquery.configuration.js"></script>
<script src="/js/admin/frame.js" language="javascript"
	type="text/javascript"></script>
<script src="/js/admin/tools.js" language="javascript"
	type="text/javascript"></script>
<!-- <script language="javascript" type="text/javascript">
window.onload=function (){	setInterval("document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
}
</script> -->

</head>
<body>
	<div id="main-content">

		<h2>欢迎访问网站管理后台</h2>
		<p id="page-intro">快捷方式</p>

		<ul class="shortcut-buttons-set">

			<li><s:a action="storeDeal_add" cssClass="shortcut-button"
					>
					<span> <img src="/images/admin/pencil.png" alt="添加店铺"><br>
						添加店铺
					</span>
				</s:a></li>
			<li><s:a action="productA_list" cssClass="shortcut-button"
					namespace="/admin">
					<span> <img src="/images/admin/document.png" alt="管理商品"><br>
						管理商品
					</span>
				</s:a> <!-- <a class="shortcut-button"
				href="./product_list.jsp"><span>
						<img src="./images/document.png" alt="管理文章"><br> 管理商品
				</span></a> --></li>

			<li><a class="shortcut-button"
				href="http://demo.dedemao.com/houtai2/dede/feedback_main.php"><span>
						<img src="/images/admin/comment.png" alt="评论管理"><br>
						评论管理
				</span></a></li>

			<li><a class="shortcut-button"
				href="http://demo.dedemao.com/houtai2/dede/index_body.php#"
				onclick="JumpFrame(catalog_menu.php,public_guide.php);"><span>
						<img src="/images/admin/post.png" alt="会员管理"><br>
						会员管理
				</span></a></li>

			<li><a class="shortcut-button"
				href="http://demo.dedemao.com/houtai2/dede/makehtml_homepage.php"><span>
						<img src="/images/admin/HTML.png" alt="待删除"><br>
						待删除
				</span></a></li>

			<li><a class="shortcut-button"
				href="http://demo.dedemao.com/houtai2/dede/sys_info.php"><span>
						<img src="/images/admin/hammer.png" alt="基本设置"><br>
						基本设置
				</span></a></li>

		</ul>
		<!-- End .shortcut-buttons-set -->
		<script>
			$(".shortcut-button").click(
					function() {
						curhref = $(this).attr('href');

						$("#main-nav li ul", window.parent.menu.document)
								.hide(); // Slide up all sub menus except the one clicked

						$(".nav-bottom-item[href='" + curhref + "']",
								window.parent.menu.document).parent().parent()
								.show(); // Slide down the clicked sub menu
						$(".nav-bottom-item", window.parent.menu.document)
								.removeClass('current');
						$(".nav-top-item", window.parent.menu.document)
								.removeClass('current');
						$(".nav-bottom-item[href='" + curhref + "']",
								window.parent.menu.document)
								.addClass("current");
						$(".nav-bottom-item[href='" + curhref + "']",
								window.parent.menu.document).parents("li")
								.children(".nav-top-item").addClass("current");
					});
		</script>

		<div class="clear"></div>
		<!-- End .clear -->

		<div class="content-box">
			<!-- Start Content Box -->

			<div class="content-box-header">

				<h3 style="cursor: s-resize;">系统信息</h3>

				<div class="clear"></div>

			</div>
			<!-- End .content-box-header -->

			<div class="content-box-content">

				<div class="tab-content default-tab" id="tab1"
					style="display: block;">
					<!-- This is the target div. id must match the href of this div's tab -->



					<table>

						<tbody>
							<tr class="alt-row">
								<td>程序版本</td>
								<td>织梦内容管理系统 V57_GBK_SP1</td>
							</tr>
							<tr>
								<td>操作系统</td>
								<td>WINNT</td>
							</tr>
							<tr class="alt-row">
								<td>网站域名/IP</td>
								<td>http://192.168.2.105:8080/admin.jsp</td>
							</tr>
							<tr>
								<td>服务器解译引擎</td>
								<td>Microsoft-IIS/6.0</td>
							</tr>
							<tr class="alt-row">
								<td>PHP</td>
								<td>php 5.2.17</td>
							</tr>
							<tr>
								<td>MySQL 版本</td>
								<td>mysql 5.0.81-community-nt</td>
							</tr>
							<tr class="alt-row">
								<td>服务器时间</td>
								<td><div class="fRight mR10" id="time">2013年7月19日
										下午5:17:31 星期五</div></td>
							</tr>
							<tr>
								<td>当前附件尺寸</td>
								<td>20M</td>
							</tr>
							<tr class="alt-row">
								<td>服务器语言</td>
								<td></td>
							</tr>

						</tbody>

					</table>

				</div>
				<!-- End #tab1 -->

			</div>
			<!-- End .content-box-content -->

		</div>
		<!-- End .content-box -->

		<div class="clear"></div>

		<div id="footer">
			<small> <!-- footer --> Powered by <a
				href="http://www.dedecms.com/">DEDECMS</a> 主题由<a href="#">fallow5</a>提供
				推荐使用chrome 1440*900分辨率浏览
			</small>
			<script src="stat.php" language="JavaScript"></script>
			<script src="cnzz_core.php" charset="utf-8" type="text/javascript"></script>
			<a href="http://www.cnzz.com/stat/website.php?web_id=5201073"
				target="_blank" title="站长统计">站长统计</a>
		</div>
		<!-- End #footer -->
	</div>
	<!-- End #main-content -->

	<script language="javascript">
		function JumpFrame(url1, url2) {
			jQuery('#menufra', window.parent.document).get(0).src = url1;
			jQuery('#main', window.parent.document).get(0).src = url2;
		}
	</script>

</body>
</html>