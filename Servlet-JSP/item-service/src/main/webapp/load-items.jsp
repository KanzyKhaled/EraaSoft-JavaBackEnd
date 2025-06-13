<%@page import="java.util.ArrayList"%>
<%@page import="com.item.model.Item"%>
<%@page import="com.itemDetails.service.ItemDetailsService"%>
<%@page import="com.itemDetails.service.impl.ItemDetailsServiceImpl"%>
<%@page import="java.util.List"%>
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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Items</title>
    <link rel="stylesheet" href="css/general.css">
</head>
<body>

<div class="layer">
    <table>
        <h1>Items</h1>
        <thead>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>TOTAL_NUMBER</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <% 
        
     	  ItemDetailsService itemDetailsService = (ItemDetailsService) request.getAttribute("itemDetailsService");

  		  List<Item> items = (List<Item>) request.getAttribute("itemsData");
   		  
		%>

        <%
        	for(Item item: items){
        %>
        <tr>
            <td><strong><%=item.getId() %></strong></td>
            <td><%=item.getName() %></td>
            <td><%=item.getPrice() %></td>
            <td><%=item.getTotalNumber()%></td>
            <td>
	            <% if (itemDetailsService != null && itemDetailsService.checkItemDetailsExists(item.getId())) { %>
	            <a href="ItemDetailsController?action=show-item-details&id=<%= item.getId() %>">Show Details</a>
	        	<% } %>

				<% if (itemDetailsService != null && !itemDetailsService.checkItemDetailsExists(item.getId())) { %>
	            <a href="add-item-details.jsp?item_id=<%= item.getId() %>">Add Details</a>
	        	<% } %>

                <a href='ItemController?action=load-item&id=<%=item.getId() %>'>Update</a>
                <a href='ItemController?action=remove-item&id=<%=item.getId() %>'>Delete</a>
            </td>
        </tr>
        <%
        	}
        %>
        
        </tbody>
    </table>


    <button class="f"><a href="add-item.html">Add Item</a></button>


</div>

</body>
</html>
