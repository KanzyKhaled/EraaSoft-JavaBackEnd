package com.itemDetails.service;

import com.itemDetails.model.ItemDetails;

public interface ItemDetailsService {

	boolean checkItemDetailsExists(int itemId);
	boolean addItemDetails(ItemDetails item_details);
	ItemDetails getItemDetailsById(int id);
}
