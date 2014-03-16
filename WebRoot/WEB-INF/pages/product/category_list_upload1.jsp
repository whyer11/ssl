
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="categories">

	<li data-cid="<s:property value="categoryId" />"><a href="#"><s:property value="name" /></a>
		<ul>
			<li><a data-cid="<s:property value="categoryId" />"><s:property value="name" /></a><li>
		</ul></li>
</s:iterator>




