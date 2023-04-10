package com.ashokit.excel;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.ashokit.entity.InsuranceEntity;

@Component
public class ExcelGeneratorUtil {
	public byte[] excelGenerator(List<InsuranceEntity> listInsuranceEntity) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		// creating an instance of HSSFWorkbook class
		XSSFWorkbook workbook = new XSSFWorkbook();
		// invoking creatSheet() method and passing the name of the sheet to be created
		XSSFSheet sheet = workbook.createSheet("Citizen Records");
		// creating the 0th row using the createRow() method
		XSSFRow rowhead = sheet.createRow((short) 0);
		// creating cell by using the createCell() method and setting the values to the
		// cell by using the setCellValue() method
		rowhead.createCell(0).setCellValue("Certizen Id");
		rowhead.createCell(1).setCellValue("Certizen Name");
		rowhead.createCell(2).setCellValue("Gender");
		rowhead.createCell(3).setCellValue("Benifit Amount");
		rowhead.createCell(4).setCellValue("Denial Reason");
		rowhead.createCell(5).setCellValue("Plan Name");
		rowhead.createCell(6).setCellValue("Plan Status");
		rowhead.createCell(7).setCellValue("Plan Start Dt.");
		rowhead.createCell(8).setCellValue("Plan End Dt.");
		rowhead.createCell(9).setCellValue("Terminated Dt.");
		rowhead.createCell(10).setCellValue("Termination Reason");
		for(int i=1;i<=listInsuranceEntity.size();i++) {
			rowhead = sheet.createRow((short) i);
			rowhead.createCell(0).setCellValue(listInsuranceEntity.get(i-1).getCitizen_id());
			rowhead.createCell(1).setCellValue(listInsuranceEntity.get(i-1).getCitizen_name());
			rowhead.createCell(2).setCellValue(listInsuranceEntity.get(i-1).getGender());
			rowhead.createCell(3).setCellValue(listInsuranceEntity.get(i-1).getBenefit_amount());
			rowhead.createCell(4).setCellValue(listInsuranceEntity.get(i-1).getDenial_reason());
			rowhead.createCell(5).setCellValue(listInsuranceEntity.get(i-1).getPlan_name());
			rowhead.createCell(6).setCellValue(listInsuranceEntity.get(i-1).getPlan_status());
			rowhead.createCell(7).setCellValue(listInsuranceEntity.get(i-1).getPlan_start_date());
			rowhead.createCell(8).setCellValue(listInsuranceEntity.get(i-1).getPlan_end_date());
			rowhead.createCell(9).setCellValue(listInsuranceEntity.get(i-1).getTerminated_date());
			rowhead.createCell(10).setCellValue(listInsuranceEntity.get(i-1).getTermination_reason());
		}
//		FileOutputStream fileOut = new FileOutputStream("download.xlsx");  
//		workbook.write(fileOut);  
		workbook.write(outputStream);
		workbook.close();
		return outputStream.toByteArray();
	}
}
