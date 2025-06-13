<%@ page session="true" %>
<%
    String user = (String) session.getAttribute("user");
    if (user != null) {
    	response.sendRedirect("ItemController?action=load-items");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign up</title>
    <link rel="stylesheet" href="css/loginSignup.css">
</head>
<body>
    <div class="container">
        <h1>Sign up</h1>
        <% if (request.getAttribute("errorMessage") != null) { %>
            <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
        <% } %>
        <form action="UserController" method="post">
        <input type="hidden" name="action" value="signup"> 
            <label>Username:</label>
            <input type="text" name="username" required>
            
            <label>Password:</label>
            <input type="password" name="password" required>

            <button type="submit">Create Account</button>
        </form>
        <p><a href="login.jsp">Already have an account? Login</a></p>
    </div>
</body>
</html>
