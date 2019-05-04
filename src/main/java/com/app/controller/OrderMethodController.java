package com.app.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.util.OrderMethodUtil;
import com.app.validator.OrderMethodValidator;
import com.app.view.OrderMethodExcelView;
import com.app.view.OrderMethodPdfView;

@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {

	@Autowired
	private OrderMethodUtil util;
	@Autowired
	private ServletContext context;
	
	@Autowired
	private IOrderMethodService service;
	
	@Autowired
	private OrderMethodValidator validator;
	
	@RequestMapping("/register")
	public String showRegister(ModelMap map) {
		//form Backing Object
		map.addAttribute("orderMethod",new OrderMethod());
		return "OrderMethodRegister";
	}
	
	@RequestMapping("/save")
	public String saveOrder(@ModelAttribute OrderMethod orderMethod,Errors errors,ModelMap map)
	{
		validator.validate(orderMethod, errors);
		if(!errors.hasErrors()) {
			Integer id=service.saveOrderMethod(orderMethod);
			map.addAttribute("message","Order Method Created Successfully & Your Id is '"+id+"'");
			//form backing object
       	 map.addAttribute("orderMethod",new OrderMethod());
		}else{
			map.addAttribute("message","Please Check Errors");
             }
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
		Integer id=orderMethod.getOrderId();
		List<OrderMethod> list=service.getAllOrderMethods();
		map.addAttribute("list",list);
		map.addAttribute("message"," OrderMethod with '"+id+"' updated successfully");
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
	
	@RequestMapping("/pdf")
	public ModelAndView doPdf(@RequestParam (value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodPdfView());
		if(id==0) {
			m.addObject("list",service.getAllOrderMethods());
		}
		else {
			OrderMethod om=service.getOrderMethod(id);
			m.addObject("list",Collections.singletonList(om));
		}
		return m;
	}
	@RequestMapping("/charts")
	public String generatecharts() {
		String path=context.getRealPath("/");
		List<Object[]> list=service.getOrderMethodCountbyMode();
		System.out.println(path);
		util.generateBar(path, list);
		util.generatPie(path, list);
		return "OrderMethodReports";
	}
	
	//To view One row Data
	@RequestMapping("/viewone")
	public String getOneRow(@RequestParam Integer id,ModelMap map) {
		OrderMethod orm=service.getOrderMethod(id);
		map.addAttribute("orm",orm);
		return "OrderMethodView";
	}
}
