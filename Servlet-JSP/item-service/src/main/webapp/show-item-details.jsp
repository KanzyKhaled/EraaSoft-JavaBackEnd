<%@ page import="com.itemDetails.model.ItemDetails" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    String user = (String) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp"); // Redirect if not logged in
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Item Details</title>
    <link rel="stylesheet" href=css/general.css>
</head>
<body>


    <div class="container">
        <h1>Item Details</h1>

        <%
            ItemDetails details = (ItemDetails) request.getAttribute("itemDetails");
            if (details != null) {
        %>
            <table >
               
                <tr><th>Description</th><td><%= details.getDescription() %></td></tr>
                 </table>
        <%
            } else {
        %>
            <p>No details available for this item.</p>
        <%
            }
        %>

        <button><a href="ItemController?action=load-items">Back To Items</a></button>
    </div>
</body>
</html>