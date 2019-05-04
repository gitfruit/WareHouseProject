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

import com.app.model.Item;
import com.app.service.IItemService;
import com.app.view.ItemExcelView;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private IItemService service;
	
	//To Show Register Page
	@RequestMapping("/register")
	public String showregister(ModelMap map) {
		//form Backing Object
		map.addAttribute("item",new Item());
		return "ItemRegister";
	}
	
	//Read Form Data and Save into the DataBase
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savePage(@ModelAttribute Item item ,ModelMap map) {
	   Integer id=service.saveItem(item);
	   map.addAttribute("message","Item with '"+id+"' saved successfully");
	   //form Backing Object
	   map.addAttribute("item",new Item());
             return "ItemRegister";		
	}
	
	//Show All Data Using LoadAll Method
	@RequestMapping("/all")
	public String viewAll(ModelMap map) {
		     List<Item> list=service.getAllItems();
		     map.addAttribute("list",list);
		return "ItemData";
	}
	
	//Delete One row of DataBase Table by using Delete method of HibernatTemplate
	@RequestMapping("/delete")
	public String deleteMethod(@RequestParam ("id") Integer Id,ModelMap map) {
		service.deleteItem(Id);
		map.addAttribute("message","Item with Id '"+Id+"' deleted successfully");
		//Reload DataPage with new Data Page after deleting a row
		map.addAttribute("list",service.getAllItems());
		return "ItemData";
	}
	
	//To show Edit the Register Page  By using Update method in HibernateTemplate
	@RequestMapping("/edit")
	public String edit(@RequestParam ("id")Integer Id,ModelMap map)
	{
               Item item=service.getItemsById(Id);	
	                   map.addAttribute("item",item);
		return "ItemEdit";
	}
	
	//To Update Data using Update method in HibernateTemplate
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute Item item,ModelMap map) {
		service.updateItem(item);
		map.addAttribute("list",service.getAllItems());
		Integer id=item.getId();
		map.addAttribute("message"," Item with Id '"+id+"' updated Successfully");
		return "ItemData";
	}
	
	//ExcelExport Data
	@RequestMapping("/excel")
	public ModelAndView doExcelExport(@RequestParam (value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new ItemExcelView());
		if(id==0) {
			m.addObject("list",service.getAllItems());
		}
		else {
			m.addObject("list",Collections.singletonList(service.getItemsById(id)));
		}
		return m;
	}
	
}
