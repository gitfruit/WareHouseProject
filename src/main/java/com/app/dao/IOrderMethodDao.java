package com.app.dao;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodDao {

	public Integer saveOrderMethod(OrderMethod orderMethod);
	public void updateOrderMethod(OrderMethod orderMethod);
	public void deleteOrderMethod(Integer id);
	public OrderMethod getOrderMethod(Integer id);
	public List<OrderMethod> getAllOrderMethods();
	public List<Object[]> getOrderMethodCountbyMode();
}

