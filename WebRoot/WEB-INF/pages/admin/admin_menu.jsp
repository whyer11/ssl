<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>我的网站-送送乐管理系统 </title>
<link rel="stylesheet" href="/css/admin/reset.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/menu.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/css/admin/invalid.css"
	type="text/css" media="screen">
<script language="javascript" src="/js/admin/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="/js/admin/admin.jquery.configuration.js"></script>
<script src="/js/admin/frame.js" language="javascript"
	type="text/javascript"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px;
	color: #000000;
}

.STYLE5 {
	font-size: 12
}

.STYLE7 {
	font-size: 12px;
	color: #FFFFFF;
}
-->
</style>


</head>
<body>
	<div id="body-wrapper">
		<!-- Wrapper for the radial gradient background -->
		<div id="sidebar">
			<div id="sidebar-wrapper">
				<!-- Sidebar with logo and menu -->


				<h1 id="sidebar-title">
					<a href="http://demo.dedemao.com/houtai2/dede/index_menu.php#">信息管理系统</a>
				</h1>

				<!-- Logo (221px wide) -->
				<a href="#"><img id="logo" src="/images/admin/logo.png"
					alt="zcncms logo"></a>
				<!-- Sidebar Profile links -->
				<div id="profile-links">
					Hello,${session.get("fallow.session.user").getRealName()} <br> 
					<!--<a href="./" title="前台首页">后台首页</a> |  -->
					<a href="/" title="前台首页" target="_blank">前台首页</a> | 
					<a href="admin_logout.html" title="退出" target="_parent">退出</a>
				</div>
				<ul id="main-nav">
					<!-- Accordion Menu -->
					<li><a id="index_body" href="admin/login_loadBody.html"
						class="nav-top-item no-submenu current" target="main"
						style="padding-right: 15px;"> <!-- Add the class "no-submenu" to menu items with no sub menu -->
							管理首页
					</a></li>
					<li><a id="articles" href="javascript:void(0);"
						class="nav-top-item" style="padding-right: 15px;"> 常用操作 </a>
						<ul style="display: none;">
							<li><s:a action="storeDeal_add" cssClass="nav-bottom-item"
									id="article_add" target="main" namespace="/admin">添加店铺
									</s:a></li>
							
							<li><s:a action="productA_list" cssClass="nav-bottom-item"
									namespace="/admin" id="content_list" target="main">
					管理商品
				</s:a></li>
							<li><a class="nav-bottom-item" id="feedback_main"
								href="http://demo.dedemao.com/houtai2/dede/feedback_main.php"
								target="main">评论管理</a></li>
							<li><a class="nav-bottom-item" id="recycling" href=""
								target="main">会员管理</a></li>
						</ul></li>
					<li><a id="articles" href="javascript:void(0);"
						class="nav-top-item" style="padding-right: 15px;"> 团购管理 </a>
						<ul style="display: none;">
							<li><a class="nav-bottom-item"
								href="admin/tuanDeal_list.html" target="main">团购列表</a></li>
							<li><a class="nav-bottom-item" href="admin/loginout.html"
								target="main">图片集</a></li>
							<li><a class="nav-bottom-item"
								href="http://demo.dedemao.com/houtai2/dede/content_i_list.php?channelid=3"
								target="main">软件</a></li>
						</ul></li>
					<li><a id="media" href="javascript:void(0);"
						class="nav-top-item" style="padding-right: 15px;"> 订单管理 </a>
						<ul style="display: none;">
							<li><a class="nav-bottom-item" id="media_add"
								href="admin/orderDeal_list.html" target="main">订单列表</a></li>
							<li><a class="nav-bottom-item" id="media_main"
								href="http://demo.dedemao.com/houtai2/dede/media_main.php"
								target="main">附件数据管理</a></li>
							<li><a class="nav-bottom-item" id="filemanager"
								href="http://demo.dedemao.com/houtai2/dede/media_main.php?dopost=filemanager"
								target="main">文件式管理器</a></li>
						</ul></li>
					<li><a id="articles" href="javascript:void(0);"
						class="nav-top-item" style="padding-right: 15px;"> 商品管理 </a>
						<ul style="display: none;">
							<li><a class="nav-bottom-item" href="productA_add.html"
								target="main">添加商品</a></li>
							<li><a class="nav-bottom-item" href="productA_list.html"
								target="main">管理商品</a></li>

						</ul></li>
					<li><a id="channel" href="javascript:void(0);"
						class="nav-top-item" style="padding-right: 15px;"> 商家店铺</a>
						<ul style="display: none;">
							<li><a class="nav-bottom-item" id="templets_one"
								href="storeDeal_add.html" target="main">添加店铺</a></li>
							<li><a class="nav-bottom-item" id="mychannel_main"
								href="storeDeal_list.html" target="main">店铺列表</a></li>
							<li><a class="nav-bottom-item" id="mychannel_main"
								href="storeDeal_auditsStoreList.html" target="main">店铺审核</a></li>

						</ul></li>

					<li><a id="member" href="javascript:void(0);"
						class="nav-top-item" style="padding-right: 15px;"> 会员管理</a>
						<ul style="display: none;">
							<li><a class="nav-bottom-item" id="member_main"
								href="admin/CusAdmAction_show.html" target="main">注册会员列表</a></li>
							<li><a class="nav-bottom-item" id="member_rank"
								href="AuditStoreAction_execute.html" target="main">开店审核设置</a></li>
							<li><a class="nav-bottom-item" id="member_scores"
								href="http://demo.dedemao.com/houtai2/dede/member_scores.php"
								target="main">积分头衔设置</a></li>
							<li><a class="nav-bottom-item" id="member_model_main"
								href="http://demo.dedemao.com/houtai2/dede/member_model_main.php"
								target="main">会员模型管理</a></li>
							<li><a class="nav-bottom-item" id="member_pm"
								href="http://demo.dedemao.com/houtai2/dede/member_pm.php"
								target="main">会员短信管理</a></li>
							<li><a class="nav-bottom-item" id="member_guestbook"
								href="http://demo.dedemao.com/houtai2/dede/member_guestbook.php"
								target="main">会员留言管理</a></li>
							<li><a class="nav-bottom-item" id="member_feed"
								href="http://demo.dedemao.com/houtai2/dede/member_info_main.php?type=feed"
								target="main">会员动态管理</a></li>
							<li><a class="nav-bottom-item" id="member_mood"
								href="http://demo.dedemao.com/houtai2/dede/member_info_main.php?type=mood"
								target="main">会员心情管理</a></li>
						</ul></li>
					<!--  <li><a id="module" href="javascript:void(0);"
						class="nav-top-item" style="padding-right: 15px;"> 会员管理 </a>
						<ul style="display: block;">
							<li><a class="nav-bottom-item" id="module_main"
								href="http://demo.dedemao.com/houtai2/dede/module_main.php"
								target="main">模块管理</a></li>
							<li><a class="nav-bottom-item" id="module_upload"
								href="http://demo.dedemao.com/houtai2/dede/module_upload.php"
								target="main">上传新模块</a></li>
							<li><a class="nav-bottom-item" id="module_make"
								href="http://demo.dedemao.com/houtai2/dede/module_make.php"
								target="main">模块生成向导</a></li>
						</ul></li>
						-->

					<li><a id="makehtml" href="javascript:void(0);"
						class="nav-top-item" style="padding-right: 15px;"> 评论管理 </a>
						<ul style="display: none;">
							<li><a class="nav-bottom-item" id="makehtml_all"
								href="http://demo.dedemao.com/houtai2/dede/makehtml_all.php"
								target="main">一键更新网站</a></li>
							<li><a class="nav-bottom-item" id="sys_cache_up"
								href="http://demo.dedemao.com/houtai2/dede/sys_cache_up.php"
								target="main">更新系统缓存</a></li>
							<li><a class="nav-bottom-item" id="makehtml_homepage"
								href="http://demo.dedemao.com/houtai2/dede/makehtml_homepage.php"
								target="main">更新主页HTML</a></li>
							<li><a class="nav-bottom-item" id="makehtml_list"
								href="http://demo.dedemao.com/houtai2/dede/makehtml_list.php"
								target="main">更新栏目HTML</a></li>
							<li><a class="nav-bottom-item" id="makehtml_archives"
								href="http://demo.dedemao.com/houtai2/dede/makehtml_archives.php"
								target="main">更新文档HTML</a></li>
							<li><a class="nav-bottom-item" id="makehtml_map_guide"
								href="http://demo.dedemao.com/houtai2/dede/makehtml_map_guide.php"
								target="main">更新网站地图</a></li>
							<li><a class="nav-bottom-item" id="makehtml_rss"
								href="http://demo.dedemao.com/houtai2/dede/makehtml_rss.php"
								target="main">更新RSS文件</a></li>
							<li><a class="nav-bottom-item" id="makehtml_js"
								href="http://demo.dedemao.com/houtai2/dede/makehtml_js.php"
								target="main">获取JS文件</a></li>
							<li><a class="nav-bottom-item" id="makehtml_spec"
								href="http://demo.dedemao.com/houtai2/dede/makehtml_spec.php"
								target="main">更新专题HTML</a></li>
						</ul></li>
					<li><a id="plus" href="javascript:void(0);"
						class="nav-top-item" style="padding-right: 15px;"> slides管理</a>
						<ul style="display: none;">
							<li><a class="nav-bottom-item" id="plus_main"
								href="admin/updateDeal_slidesAdd.html" target="main">添加幻灯片</a></li>
							<li><a class="nav-bottom-item" id="ad_main"
								href="admin/updateDeal_slidesList.html" target="main">幻灯片列表</a></li>
							<li><a class="nav-bottom-item" id="friendlink_main"
								href="http://demo.dedemao.com/houtai2/dede/friendlink_main.php"
								target="main">友情链接</a></li>
							<li><a class="nav-bottom-item" id="vote_main"
								href="http://demo.dedemao.com/houtai2/dede/vote_main.php"
								target="main">投票模块</a></li>
						</ul></li>



					<li><a id="member" href="javascript:void(0);"
						class="nav-top-item" style="padding-right: 15px;">公告管理</a>
						<ul style="display: none;">
							<li><a class="nav-bottom-item" id="member_main"
								href="editor1_execute.html"
								target="main">已发信息列表</a></li>
							<li><a class="nav-bottom-item" id="member_rank"
								href="editor2_execute.html"
								target="main">邮件群发</a></li>
							<li><a class="nav-bottom-item" id="member_scores"
								href="editor3_execute.html"
								target="main">短信群发</a></li>							
						</ul></li>

					<li><a id="templets" href="javascript:void(0);"
						class="nav-top-item" style="padding-right: 15px;"> 模块管理 </a>
						<ul style="display: none;">
							<li><a class="nav-bottom-item" id="templets_main"
								href="http://demo.dedemao.com/houtai2/dede/templets_main.php"
								target="main">默认模板管理</a></li>
							<li><a class="nav-bottom-item" id="templets_tagsource"
								href="http://demo.dedemao.com/houtai2/dede/templets_tagsource.php"
								target="main">标签源码管理</a></li>
							<li><a class="nav-bottom-item" id="mytag_main"
								href="http://demo.dedemao.com/houtai2/dede/mytag_main.php"
								target="main">自定义宏标记</a></li>
							<li><a class="nav-bottom-item" id="mytag_tag_guide"
								href="http://demo.dedemao.com/houtai2/dede/mytag_tag_guide.php"
								target="main">智能标记向导</a></li>
							<li><a class="nav-bottom-item" id="tag_test"
								href="http://demo.dedemao.com/houtai2/dede/tag_test.php"
								target="main">全局标记测试</a></li>
						</ul></li>

					<li><a id="sys" href="javascript:void(0);"
						class="nav-top-item" style="padding-right: 15px;"> 系统设置 </a>
						<ul style="display: none;">
							<li><a class="nav-bottom-item" id="sys_update"
								href="updateDeal_pwd.html"
								target="main">修改密码</a></li>
							<li><a class="nav-bottom-item" id="sys_info"
								href="http://demo.dedemao.com/houtai2/dede/sys_info.php"
								target="main">系统基本参数</a></li>
							<li><a class="nav-bottom-item" id="sys_admin_user"
								href="http://demo.dedemao.com/houtai2/dede/sys_admin_user.php"
								target="main">系统用户管理</a></li>
							<!--可考虑增加类型管理 -->
							<li><a class="nav-bottom-item" id="sys_group"
								href="http://demo.dedemao.com/houtai2/dede/sys_group.php"
								target="main">用户组设定</a></li>
							<li><a class="nav-bottom-item" id="sys_multiserv"
								href="http://demo.dedemao.com/houtai2/dede/sys_multiserv.php"
								target="main">服务器分布/远程</a></li>
							<li><a class="nav-bottom-item" id="log_list"
								href="http://demo.dedemao.com/houtai2/dede/log_list.php"
								target="main">系统日志管理</a></li>
							<li><a class="nav-bottom-item" id="sys_safe"
								href="http://demo.dedemao.com/houtai2/dede/sys_safe.php"
								target="main">验证安全设置</a></li>
							<li><a class="nav-bottom-item" id="sys_info_mark"
								href="http://demo.dedemao.com/houtai2/dede/sys_info_mark.php"
								target="main">图片水印设置</a></li>
							<li><a class="nav-bottom-item" id="content_att"
								href="http://demo.dedemao.com/houtai2/dede/content_att.php"
								target="main">自定义文档属性</a></li>
							<li><a class="nav-bottom-item" id="soft_config"
								href="http://demo.dedemao.com/houtai2/dede/soft_config.php"
								target="main">软件频道设置</a></li>

							<li><a class="nav-bottom-item" id="sys_task"
								href="http://demo.dedemao.com/houtai2/dede/sys_task.php"
								target="main">计划任务管理</a></li>
							<li><a class="nav-bottom-item" id="sys_data"
								href="http://demo.dedemao.com/houtai2/dede/sys_data.php"
								target="main">数据库备份/还原</a></li>
							<li><a class="nav-bottom-item" id="sys_sql_query"
								href="http://demo.dedemao.com/houtai2/dede/sys_sql_query.php"
								target="main">SQL命令行工具</a></li>

						</ul></li>





				</ul>
				<!-- End #main-nav -->

				<script>
					$(".nav-bottom-item").click(
							function() {
								$(".nav-bottom-item").removeClass('current');
								$(".nav-top-item").removeClass('current');
								$(this).addClass("current");
								$(this).parents("li").children(".nav-top-item")
										.addClass("current");
							});
				</script>


			</div>
			<!-- End #messages -->

			<!-- End #messages -->

		</div>
	</div>



</body>
</html>