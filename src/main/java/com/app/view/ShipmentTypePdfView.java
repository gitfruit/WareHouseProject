package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document,
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception {
		
		//filename
		response.addHeader("Content-Disposition","attachment;filename=shipments.pdf");
		//Read Data form Model
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		//create one element
		Paragraph p=new Paragraph("ShipmentsTable");
		
		//Add element to doc
		document.add(p);
		//Table with column count
		PdfPTable t=new PdfPTable(6);
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("ENABLED");
		t.addCell("GRADE");
		t.addCell("NOTE");
	//Add data to table
	   for(ShipmentType s:list)
	   {
		   t.addCell(s.getShipmentId().toString());
		   t.addCell(s.getShipmentMode());
		   t.addCell(s.getShipmentCode());
		   t.addCell(s.getShipmentEnable());
		   t.addCell(s.getShipmentGrade());
		   t.addCell(s.getSnote());
	   }
	   document.add(t);
	   document.add(new Paragraph(new Date().toString()));
	}
}
