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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	public IShipmentTypeService service;	

	//1.To show register page(html form)
	@RequestMapping("/register")
	public String showRegisterPage(ModelMap map)
	{
		//form Backing objects
		map.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	}

	//2.Read the form data on click submit
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveShipmentType(@ModelAttribute ShipmentType shipmentType,ModelMap map)
	{
		Integer id=service.saveShipmentType(shipmentType);
		map.addAttribute("msg","Shipment '"+id+"' Saved Succesfully");
		map.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	}
	
	//3.Show all the data stored in database
	@RequestMapping("/all")
	public String showAll(ModelMap map)
	{
		List<ShipmentType> obs=service.getAllShipmentTypes();
		 map.addAttribute("list",obs);
		return "ShipmentTypeData";
	}
	//4.Delete Data based on Id
	 @RequestMapping("/delete")
	 public String deletebyId(@ModelAttribute("id") Integer sid,ModelMap map)
	 {
         service.deleteShipmentType(sid);
         map.addAttribute("list",service.getAllShipmentTypes());
         map.addAttribute("message","'"+sid+"' Successfully deleted");
         return "ShipmentTypeData";
	 }
          
	 //5.To show Edit Page
	 @RequestMapping("/edit")
	 public String editPage(@RequestParam ("id") Integer sid,ModelMap map)
	 {
		ShipmentType shipmentType=service.getShipmentTypeId(sid);
		 map.addAttribute("shipmentType",shipmentType);
		  return "ShipmentTypeEdit";
	 }
	
	 //6.Update form Data on click submit
	 @RequestMapping(value="/update",method=RequestMethod.POST)
	 public String update(@ModelAttribute ShipmentType shipmentType,ModelMap map){
		   service.updateShipmentType(shipmentType);
		   List<ShipmentType> list=service.getAllShipmentTypes();
		   map.addAttribute("list",list);
		   
		return "ShipmentTypeData";
	 }
	 
	 //7.Export to Excel (all rows and id based)
	 @RequestMapping("/excel")
	 public ModelAndView doExportExcel(@RequestParam(value="id",required=false,defaultValue="0")Integer id)
	 {
		 ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		 if(id==0)
		 {//export all
               m.addObject("list",service.getAllShipmentTypes());
		 }
		 
		 else {
			 m.addObject("list",Collections.singletonList(service.getShipmentTypeId(id)));
		 }
		 return m;
	 }
	 //8.Export data to Pdf file
	 @RequestMapping("/pdf ")
	 public ModelAndView doPdfExport(@RequestParam (value="id",required=false,defaultValue="0")Integer id) {
		 ModelAndView m=new ModelAndView();
		 //set View Object
		 m.setView(new ShipmentTypePdfView());
		 if(id==0) {
			 m.addObject("list",service.getAllShipmentTypes());
		 }
		 else {
			 ShipmentType s=service.getShipmentTypeId(id);
			 m.addObject("list",Collections.singletonList(s));
		 }
		 return m;
	 }
	 
}

