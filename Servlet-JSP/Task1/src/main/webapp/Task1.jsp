<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Example</title>
</head>
<body>

<%
   
    int id = 101;
    String name = "Kanzy";
    String result =  id + " - " + name;
%>

<h2>Function Output:</h2>
<p><%= result %></p>

</body>
</html>