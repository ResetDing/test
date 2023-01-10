<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>字母表</title>
</head>
<body>
<%
   for(char x='A';x<='Z';x++)
   {
   		out.println(""+x);
   }
%>
</body>
</html>