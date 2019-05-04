package com.app.dao;

import java.util.List;

import com.app.model.Item;

public interface IItemDao {

	public Integer saveItem(Item item);
	public void deleteItem(Integer id);
	public void updateItem(Item item);
	public Item getItemsById(Integer id);
	public List<Item> getAllItems();
	public List<Object[]> getItemCountByBaseCurrency();
}
