package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView { 

	@SuppressWarnings("unchecked")
	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//change filename
		response.addHeader("Content-Disposition", "attachment;filename=Shipments.xlsx");
		//Read Data from ModelMap
		List<ShipmentType> list=(List<ShipmentType>)model.get("list");
		//Create sheet With name Shipments
		Sheet sheet=workbook.createSheet("Shipments");
		//create Row#0 only headings
		setHead(sheet);
		//Create Row#1 Onwards
		  setBody(sheet,list);
		}
	
	public void setHead(Sheet sheet) {
		Row r=sheet.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("MODE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("ENABLE");
		r.createCell(4).setCellValue("GRADE");
		r.createCell(5).setCellValue("NOTE");


	}
	private void setBody(Sheet sheet,List<ShipmentType> list) {
		int rowId=1;
		for(ShipmentType s:list) {
			Row r=sheet.createRow(rowId++);
			r.createCell(0).setCellValue(s.getShipmentId());
			r.createCell(1).setCellValue(s.getShipmentMode());
			r.createCell(2).setCellValue(s.getShipmentCode());
			r.createCell(3).setCellValue(s.getShipmentEnable());
			r.createCell(4).setCellValue(s.getShipmentGrade());
            r.createCell(5).setCellValue(s.getSnote());
		}
	}
	

}
