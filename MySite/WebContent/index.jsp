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
   <a href="UserList">User List</a>   
	<form action="Hello">
		<label for="name">Please enter your name</label><br />
		<input type="text" id="name" name="name" />
		<input type="submit" value="Say Hello"/>
	</form>
</body>
</html>