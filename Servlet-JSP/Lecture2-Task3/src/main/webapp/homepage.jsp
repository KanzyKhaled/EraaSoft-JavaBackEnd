<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
    <title>Homepage</title>
</head>
<body>

    <h2>Favourite Place Added Succsesfully</h2>

    <% 
    	String favPlace = request.getParameter("favPlace");
      
        Cookie cookie = new Cookie("favouritePlace", favPlace);
        cookie.setMaxAge(30 * 24 * 60 * 60);
        
        response.addCookie(cookie);
        
    %>

    <br>
    <a href="main.jsp">Go To Main Page</a> <br>



</body>
</html>