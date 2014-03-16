
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("content") != null ? request
			.getParameter("content") : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="content"]', {
			cssPath : '/css/admin/prettify.css',
			uploadJson : '/js/admin/jsp/upload_json.jsp',
			fileManagerJson : '/js/admin/jsp/file_manager_json.jsp',
			allowFileManager : true,
			resizeType : 0,
			items : [ 'source', '|', 'undo', 'redo', '|', 'preview',
					'wordpaste', '|', 'justifyleft', 'justifycenter',
					'justifyright', 'justifyfull', 'insertorderedlist',
					'insertunorderedlist', 'selectall', '|', 'fullscreen',
					'formatblock', 'fontname', 'fontsize', '|', 'forecolor',
					'hilitecolor', 'bold', 'italic', 'lineheight',
					'removeformat', '|', 'table', 'hr' ],
			afterCreate : function() {
				this.sync();
			},
			afterBlur : function() {
				this.sync();
			}
		});
		var editor = K.create('textarea', editor1);
		editor.sync();
		
		prettyPrint();
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通告发送列表</title>
</head>
<body>
	发送编号:
	<s:property value="advertId" />
	<br> 发送类别:
	<s:property value="type" />
	<br> 发送地址:
	<s:property value="address" />
	<br> 发送主题:
	<s:property value="subject" />
	<br> 发送内容:<s:property value="content" escape="false"/><br>
	
</body>
</html>