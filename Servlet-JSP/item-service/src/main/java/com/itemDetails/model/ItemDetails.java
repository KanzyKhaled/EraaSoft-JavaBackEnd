package com.itemDetails.model;

public class ItemDetails {

	private int id;
	
	private String description;
	
	private int item_id;
	
	public ItemDetails(String description, int item_id) {
		this.description = description;
		this.item_id = item_id;
	}
	
	public ItemDetails(int id, String description, int item_id) {
		this.id = id;
		this.description = description;
		this.item_id = item_id;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

}
