package com.app.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.ShipmentType;
import com.app.model.WHUserType;
import com.app.service.IWHUserTypeService;
import com.app.util.WHUserTypeUtil;
import com.app.view.WHUserTypeExcelView;
import com.app.view.WHUserTypePdfView;

@Controller
@RequestMapping("/whusertype")
public class WHUserTypeController {

	@Autowired
	private IWHUserTypeService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private WHUserTypeUtil util;
	
	@RequestMapping("/register")
     public String show(ModelMap map) {
    	 map.addAttribute("wHUserType",new WHUserType());
		return "WHUserTypeRegister";
     }
	
     @RequestMapping(value="/save",method=RequestMethod.POST)
     public String save(@ModelAttribute WHUserType wHUserType,ModelMap map) {
    	 Integer id=service.saveWHUserType(wHUserType);
    	 map.addAttribute("message","WHUserType Succesfully registered with '"+id+" '");
    	 map.addAttribute("wHUserType",new WHUserType());
    	 return "WHUserTypeRegister";
     }
	
    	
	@RequestMapping("/all")
	public String view(ModelMap map) {
		List<WHUserType> list=service.getAllWHUserType();
		map.addAttribute("list",list);
		return "WHUserTypeData";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id,ModelMap map) {
		service.deleteWHUseType(id);
		map.addAttribute("message","Successfully '"+id+"' deleted");
		map.addAttribute("list",service.getAllWHUserType());
		return "WHUserTypeData";
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam Integer id,ModelMap map) {
		WHUserType wh=service.getWHUserTypeByID(id);
		map.addAttribute("wHUserType",wh);
		return "WHUserTypeEdit";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute WHUserType wHUserType,ModelMap map) {
		service.updateWHUserType(wHUserType);
           List<WHUserType> list=service.getAllWHUserType();
           map.addAttribute("list",list);
		
		return "WHUserTypeData";
	}
	
	
	@RequestMapping("/excel")
	public ModelAndView excelShow(@RequestParam (value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new WHUserTypeExcelView());
		if(id==0) {
		   m.addObject("list",service.getAllWHUserType());
		}
		else {
			WHUserType wh=service.getWHUserTypeByID(id);
			m.addObject("list",Collections.singletonList(wh));
		}
		return m;
	}
	
	@RequestMapping("/pdf")
	public ModelAndView pdfShow(@RequestParam (value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new WHUserTypePdfView());
		if(id==0) {
			m.addObject("list",service.getAllWHUserType());
		}
		else {
			WHUserType wh=service.getWHUserTypeByID(id);
			m.addObject("list",Collections.singletonList(wh));
		}
		return m;
	}
	
	@RequestMapping("/charts")
	public String showCharts() {
		String path=context.getRealPath("/");
		List<Object[]> list=service.getWHUserTypeCountByType();
		System.out.println(path);
		util.generateBar(path, list);
		util.generatePie(path, list);
		
		return "WHUserTypeReports";
		}
	
	@RequestMapping("/viweone")
	public String getOneRow(@RequestParam Integer id,ModelMap map) {
		WHUserType wh=service.getWHUserTypeByID(id);
		map.addAttribute("wh",wh);
		return "WHUserTypeView";
	}
	
	
}
