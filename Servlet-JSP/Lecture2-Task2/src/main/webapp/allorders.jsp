<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Orders</title>
</head>
<body>

    <h2>All Ordered Items</h2>

    <% 
        HttpSession sessionObj = request.getSession();
        List<String> orders = (List<String>) sessionObj.getAttribute("orders");

        if (orders != null && !orders.isEmpty()) {
            out.println("<ul>");
            for (String order : orders) {
                out.println("<li>" + order + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>No orders placed yet.</p>");
        }
    %>

    <br>
    <a href="order.jsp">Go Back to Ordering</a>

</body>
</html>