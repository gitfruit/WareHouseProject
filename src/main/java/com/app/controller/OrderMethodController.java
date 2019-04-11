package com.app.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.view.OrderMethodExcelView;

@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;
	@RequestMapping("/show")
	public String showRegister(ModelMap map) {
		//form Backing Object
		map.addAttribute("orderMethod",new OrderMethod());
		return "OrderMethodRegister";
	}
	
	@RequestMapping("/save")
	public String saveOrder(@ModelAttribute OrderMethod orderMethod,ModelMap map)
	{
		Integer id=service.saveOrderMethod(orderMethod);
		map.addAttribute("orderMethod",new OrderMethod());
		map.addAttribute("message","Order Method Created Successfully & Your Id is '"+id+"'");
		return "OrderMethodRegister";
	}
	
	@RequestMapping("/all")
	public String showall(ModelMap map) {
	       	
	     List<OrderMethod> list=service.getAllOrderMethods();
	     map.addAttribute("list",list);
	     return "OrderMethodData";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute ("id")Integer omid,ModelMap map) {
		service.deleteOrderMethod(omid);
		map.addAttribute("message"," '"+omid+"' Deleted Successfully");
		map.addAttribute("list",service.getAllOrderMethods());
		return"OrderMethodData";
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam ("id") Integer omid,ModelMap map) {
		OrderMethod orderMethod=service.getOrderMethod(omid);
		map.addAttribute("orderMethod",orderMethod);
		return "OrderMethodEdit";
	}
	
	                                                       
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute OrderMethod orderMethod,ModelMap map) {
		
		service.updateOrderMethod(orderMethod);
		List<OrderMethod> list=service.getAllOrderMethods();
		map.addAttribute("list",list);
		return "OrderMethodData";
	}
  
	@RequestMapping("/excel")
	public ModelAndView doExcel(@RequestParam (value="id",required=false,defaultValue="0")Integer id) {
        ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodExcelView());
		if(id==0) {
			m.addObject("list",service.getAllOrderMethods());
		}
		else {
			OrderMethod om=service.getOrderMethod(id);
			m.addObject("list",Collections.singletonList(om));
			
		}
		return m;
	}
}
