package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		//filename
		response.addHeader("Content-Disposistion","attachment;filename=Uom.pdf");
		//Read data from model
		List<Uom> list=(List<Uom>) model.get("list");
		//create one element
		Paragraph p=new Paragraph("UomTable");
		//add  element to doc
		document.add(p);
		//Table with Column count
		PdfPTable t=new PdfPTable(7);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("CODE");
		t.addCell("ENABLED");
	    t.addCell("METACODE");
	    t.addCell("SIZE");
	    t.addCell("NOTE");
	    //Add Data to Table
	    for(Uom u:list) {
	    	t.addCell(u.getUomId().toString());
	    	t.addCell(u.getUomType());
	    	t.addCell(u.getUomCode());
	    	t.addCell(u.getEnableUom());
	    	t.addCell(u.getMetaCode());
	    	t.addCell(u.getAdjSize());
	    	t.addCell(u.getNote());
	    }
	    document.add(t);
	    document.add(new Paragraph(new Date().toString()));
	    
	}

}
