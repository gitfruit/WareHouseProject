package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView{

	@Override
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition","attachment;filename=WHUserType.pdf");
		List<WhUserType> list= (List<WhUserType>) model.get("list");
		Paragraph p=new Paragraph("WHUserTypeTable");
		document.add(p);
		
	     PdfPTable pt=new PdfPTable(8);
	     pt.addCell("ID");
	     pt.addCell("TYPE");
	     pt.addCell("CODE");
	     pt.addCell("FOR");
	     pt.addCell("EMAIL");
	     pt.addCell("CONTACT");
	     pt.addCell("IDTYPE");
	     pt.addCell("IDNUMBER");
		
	     for(WhUserType wh:list) {
	    	 pt.addCell(wh.getUserId().toString());
	    	 pt.addCell(wh.getUserIDType());
	    	 pt.addCell(wh.getUserCode());
	    	 pt.addCell(wh.getUserFor());
	    	 pt.addCell(wh.getUserEmail());
	    	 pt.addCell(wh.getUserContact().toString());
	    	 pt.addCell(wh.getUserIDType());
	    	 pt.addCell(wh.getIdNumber());
	    	
	     }
	     document.add(pt);
    	 document.add(new Paragraph(new Date().toString()));
	}

}
