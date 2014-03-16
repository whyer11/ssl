
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="categories">
	<li><s:a action="product_execute" namespace="/product">
			<s:param name="procategoryId" value="categoryId"></s:param>
			<s:property value="name" />
		</s:a> <!--SUbmenu Starts-->
		<ul class="sub_menu">
			<s:action name="productCategory_getCatByFirst" executeResult="true"
				namespace="/product">
			</s:action>
		</ul> <!--SUbmenu Ends--></li>
</s:iterator>


