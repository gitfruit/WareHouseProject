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

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;
import com.app.validator.UomValidator;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	  @Autowired
	  private IUomService service;
	  
	  @Autowired
	  private ServletContext context;
	  
	  @Autowired
	  private UomUtil util;
	  
	  @Autowired
	  private UomValidator validator;
	  
	//1.To show register page
	@RequestMapping("/register")
	public String show(ModelMap map)
	{
		map.addAttribute("uom",new Uom());
		return "UomRegister";
	}
	
	//2.Save the data into Database
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveDat(@ModelAttribute Uom uom,Errors errors,ModelMap map)
	{
		 
	               validator.validate(uom, errors);
		if(!errors.hasErrors()) {
			//Call Service Layer
		Integer id=service.saveUom(uom);
		String message="Your id Number'"+id+"'saved successfully";
		map.addAttribute("read",message);
		//Clear Form Backing Object
		map.addAttribute("uom",new Uom());
		}
		else {
			map.addAttribute("read","Please Check Errors");
		}
		return "UomRegister";
	}
	
	//3.Show all the data stored in database
	@RequestMapping("/all")
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
	   Integer id=uom.getUomId();
        List<Uom> list=service.getAllUoms();
        map.addAttribute("list",list);
        map.addAttribute("message","Uom with '"+id+"' updated Successfully");
        
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
	//8.Pdf Export
	@RequestMapping("/pdf")
	public ModelAndView doPdfExport(@RequestParam(value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new UomPdfView());
		if(id==0) {
		   m.addObject("list",service.getAllUoms());   	
		}
		else {
			Uom u=service.getUomById(id);
			m.addObject("list",Collections.singletonList(u));
		}
		return m;
	}
	
	//9.Converting data to charts
	@RequestMapping("/charts")
	public String showCharts() {
           String path=context.getRealPath("/");
           List<Object[]> list=service.getUomCountByType();
           util.generateBar(path, list);
           util.generatePie(path, list);
           
		return "UomReports";
	}
		
		//10.To View One row Data
	@RequestMapping("/viewone")
		public String getOneRow(@RequestParam Integer id,ModelMap map) {
			Uom uom=service.getUomById(id);
			map.addAttribute("uom",uom);
		return "UomView";
	}
	
	
}
