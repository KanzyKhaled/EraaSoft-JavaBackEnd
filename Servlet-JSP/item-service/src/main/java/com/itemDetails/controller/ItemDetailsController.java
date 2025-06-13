package com.itemDetails.controller;

import java.io.IOException;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.item.model.Item;
import com.item.service.impl.ItemServiceImpl;
import com.itemDetails.model.ItemDetails;
import com.itemDetails.service.ItemDetailsService;
import com.itemDetails.service.impl.ItemDetailsServiceImpl;

/**
 * Servlet implementation class ItemDetailsController
 */
@WebServlet("/ItemDetailsController")
public class ItemDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/item-details")
	private DataSource dataSource;

	private ItemDetailsService itemDetailsService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init() throws ServletException {
		itemDetailsService = new ItemDetailsServiceImpl(dataSource);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 // action = {add-item, update-item, remove-item, load-item, load-items}
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		String action = request.getParameter("action");
 		
 		if (Objects.isNull(action)) {
 			action = "load-items";
 		}
 		
 		switch (action) {
 			case "add-item-details":
 				addItemDetails(request, response);
 				break;
 			case "show-item-details":
 				showItemDetails(request, response);
 				break;
 			default:
 				System.out.println("Wrong Action Selected");
 		}
 	}

	private void showItemDetails(HttpServletRequest request, HttpServletResponse response) {
	    try {
	        int Id = Integer.parseInt(request.getParameter("id"));
	        ItemDetails details = itemDetailsService.getItemDetailsById(Id);

	        request.setAttribute("itemDetails", details);
	        request.getRequestDispatcher("/show-item-details.jsp").forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

		
	

	private void addItemDetails(HttpServletRequest request, HttpServletResponse response) {
	    try {
	        ItemDetails itemDetails = extractItem(request);
	        Boolean addedItem = itemDetailsService.addItemDetails(itemDetails);
	       

	        if (addedItem) {
	            response.sendRedirect("ItemController?action=load-items"); 
	        } else {
	            request.setAttribute("errorMessage", "Failed to add item details.");
	            request.getRequestDispatcher("/add-item-details.jsp").forward(request, response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	
	private ItemDetails extractItem(HttpServletRequest request) {
	    String description = request.getParameter("description");
	    int item_id = Integer.parseInt(request.getParameter("item_id"));

	    ItemDetails itemDetails = new ItemDetails(description, item_id);

	    return itemDetails;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
