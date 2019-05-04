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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.util.WhUserTypeUtil;
import com.app.validator.WhUserTypeValidator;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whusertype")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private WhUserTypeUtil util;
	
	@Autowired
	private WhUserTypeValidator validator;
	
	@RequestMapping("/register")
     public String show(ModelMap map) {
    	 map.addAttribute("whUserType",new WhUserType());
		return "WHUserTypeRegister";
     }
	
     @RequestMapping(value="/save",method=RequestMethod.POST)
     public String save(@ModelAttribute WhUserType whUserType,Errors errors,ModelMap map) {
    	 validator.validate(whUserType, errors);
    	 if(!errors.hasErrors()) {
    	 Integer id=service.saveWhUserType(whUserType);
    	 map.addAttribute("message","WhUserType Succesfully registered with '"+id+" '");
    	 map.addAttribute("whUserType",new WhUserType());
    	 }else {
    		 map.addAttribute("message","Please Check Errors");
    	 }
    	 return "WHUserTypeRegister";
     }
    	
	@RequestMapping("/all")
	public String view(ModelMap map) {
		List<WhUserType> list=service.getAllWhUserType();
		map.addAttribute("list",list);
		return "WHUserTypeData";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id,ModelMap map) {
		service.deleteWhUseType(id);
		map.addAttribute("message","Successfully '"+id+"' deleted");
		map.addAttribute("list",service.getAllWhUserType());
		return "WHUserTypeData";
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam Integer id,ModelMap map) {
		WhUserType wh=service.getWhUserTypeByID(id);
		map.addAttribute("whUserType",wh);
		return "WHUserTypeEdit";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute WhUserType whUserType,ModelMap map) {
		service.updateWhUserType(whUserType);
		Integer id=whUserType.getUserId();
           List<WhUserType> list=service.getAllWhUserType();
           map.addAttribute("message","WhUserType with id '"+id+"' updated successfully ");
           map.addAttribute("list",list);
		
		return "WHUserTypeData";
	}
	
	
	@RequestMapping("/excel")
	public ModelAndView excelShow(@RequestParam (value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypeExcelView());
		if(id==0) {
		   m.addObject("list",service.getAllWhUserType());
		}
		else {
			WhUserType wh=service.getWhUserTypeByID(id);
			m.addObject("list",Collections.singletonList(wh));
		}
		return m;
	}
	
	@RequestMapping("/pdf")
	public ModelAndView pdfShow(@RequestParam (value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypePdfView());
		if(id==0) {
			m.addObject("list",service.getAllWhUserType());
		}
		else {
			WhUserType wh=service.getWhUserTypeByID(id);
			m.addObject("list",Collections.singletonList(wh));
		}
		return m;
	}
	
	@RequestMapping("/charts")
	public String showCharts() {
		String path=context.getRealPath("/");
		List<Object[]> list=service.getWhUserTypeCountByType();
		System.out.println(path);
		util.generateBar(path, list);
		util.generatePie(path, list);
		
		return "WHUserTypeReports";
		}
	
	
	
	@RequestMapping("/viweone")
	public String getOneRow(@RequestParam Integer id,ModelMap map) {
		WhUserType wh=service.getWhUserTypeByID(id);
		map.addAttribute("wh",wh);
		return "WHUserTypeView";
	}
	
	
}
