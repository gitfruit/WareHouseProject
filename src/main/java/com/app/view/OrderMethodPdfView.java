package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=OrderMethod.pdf");
		List<OrderMethod> list=(List<OrderMethod>)model.get("list");
		Paragraph p=new Paragraph("ShipmentsTable");
		PdfPTable pt=new PdfPTable(6);
		pt.addCell("ID");
		pt.addCell("MODE");
		pt.addCell("CODE");
		pt.addCell("NOTE");
		pt.addCell("EXETYPE");
		pt.addCell("ORDERACCEPTS");
		
			for(OrderMethod or:list) {
				
				pt.addCell(or.getOrderId().toString());
				pt.addCell(or.getOrderMode());
				pt.addCell(or.getOrderCode());
				pt.addCell(or.getNote());
				pt.addCell(or.getExeType());
				pt.addCell(or.getOrderAccepts().toString());
			}
		
		document.add(pt);
		document.add(new Paragraph(new Date().toString()));
		
		
		
        
	}

}
