
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="categories">
	<li data-cid="<s:property value="categoryId" />"><s:a
			action="product_execute" namespace="/product">
			<s:property value="name" />
		</s:a> <!--SUbmenu Starts-->
		<ul>
			<s:action name="productCategory1_getCatByFirst" executeResult="true"
				namespace="/product">
			</s:action>
			<a data-cid="<s:property value="categoryId" />"><s:property
					value="name" /></a>

		</ul> <!--SUbmenu Ends--></li>
</s:iterator>