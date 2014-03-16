<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="arealist">
	<div class="f_head">
			<h2>
				<a>最快送达</a>
			</h2>
			<div class="f_head_brands">
				<div class="clip_machine">
					<ul>
						<li><a><s:property value="name"/></a></li>
						<li><a>看谁送的最快</a></li>
						<li><a>点击logo进入商店看看</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="main_content">
			<ul class="s_c_l">
				<s:action name="store_fastStore" executeResult="true"
					namespace="/store">
					<s:param name="shouyeareaId" value="areaId"></s:param>
				</s:action>
			</ul>
		</div>
		
</s:iterator>