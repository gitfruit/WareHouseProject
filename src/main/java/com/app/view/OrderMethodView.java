package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition","attachment;filename=OrderMethod.xlsx");
		List<OrderMethod> list=(List<OrderMethod>)model.get("list");
		Sheet sheet=workbook.createSheet();
		setHead(sheet);
		setBody(sheet,list);
		
	}
	public void setHead(Sheet sheet) {
		Row r=sheet.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("MODE");
		r.createCell(2).setCellValue("EXETYPE");
		r.createCell(3).setCellValue("Accept");
	    r.createCell(4).setCellValue("NOTE");
	    
	}
	public void setBody(Sheet sheet,List<OrderMethod> list) {
            int rowId=1;
            for(OrderMethod or:list) {
            	Row r=sheet.createRow(rowId++);
            	r.createCell(0).setCellValue(or.getOrderId());
            	r.createCell(1).setCellValue(or.getOrderMode());
            	r.createCell(2).setCellValue(or.getExeType());
            	r.createCell(3).setCellValue(or.getOrderAccepts());
            	r.createCell(4).setCellValue(or.getNote());
            		
            	
            }
	}
}
