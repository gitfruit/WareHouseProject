package com.app.service;

import java.util.List;

import com.app.model.OrderMethod;
import com.app.model.WHUserType;

public interface IOrderMethodService {


	public Integer saveOrderMethod(OrderMethod orderMethod);
	public void updateOrderMethod(OrderMethod orderMethod);
	public void deleteOrderMethod(Integer id);
	public OrderMethod getOrderMethod(Integer id);
	public List<OrderMethod> getAllOrderMethods();
	public List<Object[]> getOrderMethodCountbyMode();

}

