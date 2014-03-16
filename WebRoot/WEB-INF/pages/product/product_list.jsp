<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:iterator value="products">
   <li> <a href="product3_getProDetailInfo.json?productId=<s:property value="productId"/>" >  <img alt="" src="<s:property value="imageLinkArray[1]" />"> </a>
					<div class="detail">
					  <a href="product3_getProDetailInfo.json?productId=<s:property value="productId"/>" ><p class="floorgoods_proname"><s:property value="name" /></p> </a>
			 			<p class="floorgoods_proprice">
							<strong>$</strong> <span><s:property value="price"/></span> /
							<del>19.8</del>
						</p>
					</div></li>
     </s:iterator>

	
</body>
</html>

