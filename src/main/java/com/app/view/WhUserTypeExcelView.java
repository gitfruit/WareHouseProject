package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
 		response.addHeader("Content-Disposition", "attachment;filename=WHUserType.xlsx");

         List<WhUserType> list= (List<WhUserType>) model.get("list");
         Sheet sheet=workbook.createSheet("WHUserTypes");
         setHead(sheet);
         setBody(sheet,list);
	}

	public void setHead(Sheet sheet) {
		Row r=sheet.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("FOR");
		r.createCell(4).setCellValue("EMAIL");
		r.createCell(5).setCellValue("CONTACT");
		r.createCell(6).setCellValue("IDTYPE");
		r.createCell(7).setCellValue("IDNUMBER");
		}
	public void setBody(Sheet sheet,List<WhUserType> list) {
		int rowId=1;
		for(WhUserType wh:list) {
			Row r=sheet.createRow(rowId++);
			r.createCell(0).setCellValue(wh.getIdNumber());
			r.createCell(1).setCellValue(wh.getUserType());
			r.createCell(2).setCellValue(wh.getUserCode());
			r.createCell(3).setCellValue(wh.getUserFor());
			r.createCell(4).setCellValue(wh.getUserEmail());
			r.createCell(5).setCellValue(wh.getUserContact());
			r.createCell(6).setCellValue(wh.getUserIDType());
			r.createCell(7).setCellValue(wh.getIdNumber());
		}
		
	}
}
