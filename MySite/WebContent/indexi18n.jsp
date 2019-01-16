<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
<head>
<meta charset="utf-8">
<title>Hello World</title>
</head>
<body>
	<h1>Hello World from Struts 2</h1>
	
	<s:url namespace="/" action="locale" var="enentry">
      <s:param name="request_locale" >en_US</s:param>
   </s:url>
   <s:a href="%{enentry}">En Entry</s:a>   
   
   <s:url namespace="/" action="locale" var="esentry" >
      <s:param name="request_locale" >zh_CN</s:param>
   </s:url>
   <s:a href="%{esentry}">CN Entry</s:a>
</body>
</html>