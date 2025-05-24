<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
<title>Insert title here</title>
</head>
<body>
<%		
		String favPlace = "Not Set";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
		    for (Cookie cookie : cookies) {
		        if (cookie.getName().equals("favouritePlace")) {
		            favPlace = cookie.getValue();
		            break;
		        }
		    }
		}
		
		out.println("<h3>Your Favorite Place: " + favPlace + "</h3>");

%>
		<br>
	    <a href="start.html">Change Favorite Place</a>
</body>
</html>