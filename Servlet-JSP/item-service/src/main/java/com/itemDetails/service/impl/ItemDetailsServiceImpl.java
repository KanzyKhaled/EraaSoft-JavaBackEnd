package com.itemDetails.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.item.model.Item;
import com.itemDetails.model.ItemDetails;
import com.itemDetails.service.ItemDetailsService;

public class ItemDetailsServiceImpl implements ItemDetailsService {
	
	private DataSource dataSource;
	
	public ItemDetailsServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean addItemDetails(ItemDetails item_details) {
		boolean haveDetails = checkItemDetailsExists(item_details.getItem_id());
		if(!haveDetails) {
		try {
			Connection connection = dataSource.getConnection();
			String query = "INSERT INTO item_details (DESCRIPTION,ITEM_ID)"
					+ " VALUES ('" + item_details.getDescription() + "', " 
				    + item_details.getItem_id() + ")";
			Statement statement = connection.createStatement();
			int res = statement.executeUpdate(query);
		
			return res == 1;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		}
		
		return false;
	}

	@Override
	public ItemDetails getItemDetailsById(int id) {
		try {
			Connection connection =  dataSource.getConnection();
			String query = "SELECT * FROM item_details where item_id = " + id;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			
			if (resultSet.next()) {
				return new ItemDetails(
						resultSet.getInt("id"),
						resultSet.getString("description"),
						resultSet.getInt("item_id")
				);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean checkItemDetailsExists(int itemId) {
	    String sql = "SELECT COUNT(*) FROM Item_Details WHERE item_id = ?";
	    try (Connection conn = dataSource.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, itemId);
	        try (ResultSet rs = stmt.executeQuery()) {
	            return rs.next() && rs.getInt(1) > 0;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}


	
}
