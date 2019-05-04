package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Item;

public class ItemExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         response.addHeader("Content-Disposition", "attachment;filename=Items.xlsx");
         //Read Data from modelMap
         List<Item> list= (List<Item>) model.get("list");
         //Create Sheet
         Sheet sheet=workbook.createSheet("Items");
         //create Row-0 in Head
         setHead(sheet);
         //create Row-1 in Body
         setBody(sheet, list);
	}
	
	

	private void setBody(Sheet sheet, List<Item> list) {
	     int id=1;
	        for(Item item:list) {
	            Row r2=sheet.createRow(id++);
	            r2.createCell(0).setCellValue(item.getId());
	            r2.createCell(1).setCellValue(item.getDimensions());
	            r2.createCell(2).setCellValue(item.getBaseCost());
	            r2.createCell(3).setCellValue(item.getBaseCurrency());
	            r2.createCell(4).setCellValue(item.getInote());

	        }
	}
	
	

	private void setHead(Sheet sheet) {
		 Row r=sheet.createRow(0);
         r.createCell(0).setCellValue("Item Code");
         r.createCell(1).setCellValue("Dimensions");
         r.createCell(2).setCellValue("BaseCost");
         r.createCell(3).setCellValue("BaseCurrency");
         r.createCell(4).setCellValue("Note");   
	}

}
