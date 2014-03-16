<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="categories1">
<a class="categoryclick1  clickable"
	data-cid="<s:property value="categoryId" />" href="#"><s:property
			value="name" /></a>
			</s:iterator>