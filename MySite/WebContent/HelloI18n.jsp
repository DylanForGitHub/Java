<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
<head>
<meta charset="utf-8">
<title>Hello World</title>
</head>
<body>
	<h1>Hello World from Struts 2 for i18n</h1>
   
	<s:form action="Hello" methon="post">
		<label for="name">Please enter your name</label><br />
		<s:textfield type="text" id="name" key="global.name" />
		<s:submit type="submit" key="global.submit"/>
	</s:form>
</body>
</html>