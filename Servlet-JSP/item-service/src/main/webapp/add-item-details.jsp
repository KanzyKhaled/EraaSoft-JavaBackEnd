<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page session="true" %>
<%
    String user = (String) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp"); // Redirect if not logged in
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Add Item Details</title>
    <link rel="stylesheet" href="css/general.css">
</head>
<body>


    <div class="container">
        <h1>Add Item Details</h1>

        <%
            String itemIdStr = request.getParameter("item_id");
            int itemId = (itemIdStr != null && !itemIdStr.isEmpty()) ? Integer.parseInt(itemIdStr) : 0;
        %>

        <form action="ItemDetailsController?action=add-item-details&id=<%= itemId %>">
        	<input type="hidden" required name="action" value="add-item-details">

            <label>Description:</label>
            <input type="text" name="description" required>

            <label>Item ID:</label>
            <input type="text" name="item_id" value="<%= itemId %>" readonly>

		    <input type="submit" value="Add" class="button">
        </form>
		      <button><a href="ItemController?action=load-items">Back To Items</a></button>
        
    </div>

</body>
</html>