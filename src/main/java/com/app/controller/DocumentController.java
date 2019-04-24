package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/docs")
public class DocumentController {

	@Autowired
	private IDocumentService service;
	
	@RequestMapping("/all")
	public String showDocsPage(ModelMap map) {
		List<Object> list=service.getFileIdAndNames();
		map.addAttribute("list",list);
		return "Document";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadsDoc(@RequestParam CommonsMultipartFile fob) {
		if(fob!=null) {
			//Convert to model class Object
			Document doc=new Document();
		     doc.setFileName(fob.getOriginalFilename());
		     doc.setFileData(fob.getBytes());
			service.saveDocument(doc);
		     }
		//sendRedirect to above showDocsPage method
		return "redirect:all";
	}
//Download Documents
		@RequestMapping("/download")
		public void downloadDoc(@RequestParam Integer fileId,HttpServletResponse resp) {
			//read Object from Database using Primary key
			Document doc=service.getDocumentById(fileId);
			//add Header Parameter
			resp.addHeader("Content-Disposition", "attachment;filename="+doc.getFileName());
			try {
				//Copy Object Data to OutputStream
				  FileCopyUtils.copy(doc.getFileData(), resp.getOutputStream());
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
	
	}	

