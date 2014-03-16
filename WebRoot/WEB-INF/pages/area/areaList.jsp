<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="arealist">
	<li><s:a action="store_getStoreByAreaId" namespace="/store">
			<s:param name="touareaId" value="areaId"></s:param>
			<s:property value="name" />
		</s:a></li>
</s:iterator>