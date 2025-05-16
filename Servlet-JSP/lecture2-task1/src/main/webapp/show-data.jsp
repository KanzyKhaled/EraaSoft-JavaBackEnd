<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Person Data</title> 
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>Welcome, Your Data</h1>

    <div class="data-container">
        <%
        String fullName = request.getParameter("fullName"); 
        int age = Integer.parseInt(request.getParameter("age"));
        
        out.print("<p><span>Your Full Name : </span>" + fullName + "</p>");
        out.print("<p><span>Your Age : </span>" + age + "</p>");
        
        %>
    </div>

</body>
</html>