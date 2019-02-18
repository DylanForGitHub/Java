<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.common.wechat.entry.AccessTokenInfo" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    WeChat Learn
    <hr/>
    access_token ：<%=AccessTokenInfo.accessToken.getAccessToken()%>
  </body>
</html>