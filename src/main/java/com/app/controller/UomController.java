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

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.view.UomExcelView;

@Controller
@RequestMapping("/uom")
public class UomController {

	  @Autowired
	  private IUomService service;
	  
	//1.To show register page
	@RequestMapping("/register")
	public String show(ModelMap map)
	{
		map.addAttribute("uom",new Uom());
		return "UomRegister";
	}
	
	//2.Save the data into Database
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveDat(@ModelAttribute Uom uom,ModelMap map)
	{
		Integer id=service.saveUom(uom);
		String message="Your id Number'"+id+"'saved successfully";
		map.addAttribute("read",message);
		map.addAttribute("uom",new Uom());
		return "UomRegister";
	}
	
	//3.Show all the data stored in database
	@RequestMapping("/showall")
	public String showAll(ModelMap map)
	{
		List<Uom> list=service.getAllUoms();
		map.addAttribute("list",list);
		 return "UomData";
	}
	
	//4.Delete Data From DataBase by Id
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id,ModelMap map)
	{    service.deleteUom(id);
	      map.addAttribute("list",service.getAllUoms());
	      map.addAttribute("message","Successfully'"+id+"' deleted");
         	return "UomData";
	}
	
	//5.To show Edit Page
	@RequestMapping("/edit")
	public String edit(@RequestParam  Integer id,ModelMap map)
	{
		  Uom ob=service.getUomById(id);
		  map.addAttribute("uom",ob);	
		return "UomEdit";
	}
	
	//6.To update form date on click submit
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute Uom uom,ModelMap map)
	{ 
		service.updateUom(uom);
        List<Uom> list=service.getAllUoms();
        map.addAttribute("list",list);
     return "UomData";
	}
	
	//7.EXPORT EXCEL (all rows and id based)
	@RequestMapping("/excel")
	public ModelAndView doExportExcel(@RequestParam(value="id",required=false,defaultValue="0")Integer id)	
	{
		ModelAndView m=new ModelAndView();
		m.setView(new UomExcelView());
		if(id==0) {
			m.addObject("list",service.getAllUoms());
		}
		else {
			 m.addObject("list",Collections.singletonList(service.getUomById(id)));
		}
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView doPdfExcel(@RequestParam(value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new UomExcelView());
		if(id==0) {
		   m.addObject("list",service.getAllUoms());   	
		}
		else {
			Uom u=service.getUomById(id);
			m.addObject("list",Collections.singletonList(u));
		}
		return m;
	}
}
