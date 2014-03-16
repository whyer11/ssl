<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="categories">
<a class="categoryclick"
	data-cid="<s:property value="categoryId" />"><s:property
			value="name" /></a>
			</s:iterator>