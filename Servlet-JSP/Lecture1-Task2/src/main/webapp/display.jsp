<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f4f4f4;
            padding: 50px;
        }
        .data-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.1);
            display: inline-block;
            text-align: left;
            min-width: 300px;
        }
        p {
            font-size: 18px;
            padding: 8px;
            border-bottom: 1px solid #ddd;
        }
        p:last-child {
            border-bottom: none;
        }
    </style>
</head>
<body>
    <h2>Student Information Received</h2>
    <div class="data-container">
  	   <%
  		 String fullName = request.getParameter("fullName"); 
		 String password = request.getParameter("password"); 
   		 int age = Integer.parseInt(request.getParameter("age"));
  		 String addressRadio = request.getParameter("addressRadio"); 
  		 String addressSelect = request.getParameter("addressSelect"); 
     
  	   %> 
        <p><strong>Full Name: </strong><%= fullName %></p>
        <p><strong>Password: </strong><%= password %></p>
        <p><strong>Age: </strong><%= age %></p>
        <p><strong>Address (Radio): </strong><%= addressRadio %> </p>
        <p><strong>Address (Select): </strong><%= addressSelect %> </p>
    </div>
</body>
</html>