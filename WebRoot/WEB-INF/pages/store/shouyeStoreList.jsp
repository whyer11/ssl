
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="setstore">
	<li>
		<div class="cover">
			<a name="trade-geo" class="trade-geo " id="trade-geo"> <span
				class="cover_area">商圈：<small> <s:action
							name="storeshangquan_getStoreCoverArea" executeResult="true"
							namespace="/store">
							<s:param name="storeId1" value="store.storeId"></s:param>
						</s:action> <s:property value="store.name" />

				</small></span><br> <span class="get_time">送达时间：<small><s:property
							value="reachTime" /></small></span>
			</a>
			<s:a action="store_storeDetail" namespace="/store" class="store_images">
				<s:param name="storedetailId" value="store.storeId"></s:param>
				<img src="<s:property value="store.imageLinkArray[1]" />"
					style="width: 182px; height: 182px;" />
			</s:a>
		</div>
	</li>
</s:iterator>

