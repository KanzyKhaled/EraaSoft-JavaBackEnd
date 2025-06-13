<%@ page session="true" %>
<%
    // Redirect logged-in users to the main page
    String user = (String) session.getAttribute("user");
    if (user != null) {
        response.sendRedirect("ItemController?action=load-items");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/loginSignup.css">
</head>
<body>
    <div class="container">
        <h1>Login</h1>

        <%-- Display error message if login fails --%>
        <% if (request.getAttribute("errorMessage") != null) { %>
            <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
        <% } %>

        <form action="UserController" method="post">
         <input type="hidden" name="action" value="login">
            <label>Username:</label>
            <input type="text" name="username" required>

            <label>Password:</label>
            <input type="password" name="password" required>

            <button type="submit">Login</button>
        </form>

        <p><a href="signup.jsp">Don't have an account? Sign up</a></p>
    </div>
</body>
</html>
