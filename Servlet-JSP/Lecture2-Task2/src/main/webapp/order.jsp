<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Food</title>
</head>
<body>

    <h2>Order Food</h2>
    <form action="order.jsp" method="post">
        <input type="text" name="food" placeholder="Enter food item" required>
        <input type="submit" value="Add to Order">
    </form>

    <br><br>
    <a href="allorders.jsp">View All Orders</a>

    <% 
        HttpSession sessionObj = request.getSession();
        List<String> orders = (List<String>) sessionObj.getAttribute("orders");

        if (orders == null) {
            orders = new ArrayList<>();
        }

        
        String foodItem = request.getParameter("food");
        if (foodItem != null && !foodItem.trim().isEmpty()) {
            orders.add(foodItem);
            sessionObj.setAttribute("orders", orders); // Save back to session
        }

    %>

</body>
</html>