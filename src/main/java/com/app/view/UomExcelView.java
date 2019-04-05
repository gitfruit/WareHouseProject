package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Uom;

public class UomExcelView extends AbstractXlsxView{

	@SuppressWarnings("unchecked")
	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		  
		//Change FileName
		response.addHeader("Content-Dispositin", "attachent;filename=Uom.xlsx");
		//Read Data from ModelMap
		List<Uom> list=(List<Uom>) model.get("list");
		//create Sheet with name Uom
		Sheet sheet=workbook.createSheet("Uoms");
		//create row#0 only headings
		setHead(sheet);
		//create row#1 onwards
		setBody(sheet,list);
		}
	
	private void setBody(Sheet sheet, List<Uom> list) {
               int rowId=1;
               for(Uom u:list) {
            	   Row r=sheet.createRow(rowId++);
            	   r.createCell(0).setCellValue(u.getUomId());
            	   r.createCell(1).setCellValue(u.getUomType());
            	   r.createCell(2).setCellValue(u.getUomCode());
            	   r.createCell(3).setCellValue(u.getEnableUom());
            	   r.createCell(4).setCellValue(u.getMetaCode());
            	   r.createCell(5).setCellValue(u.getAdjSize());
            	   r.createCell(6).setCellValue(u.getNote());

               }
	
	}

	public void setHead(Sheet sheet) {
		Row r=sheet.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("ENABLE");
		r.createCell(4).setCellValue("METACODE");
		r.createCell(5).setCellValue("SIZE");
		r.createCell(6).setCellValue("NOTE");


	}

	

}
