package com.ashokit.pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ashokit.entity.InsuranceEntity;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;

@Component
public class PdfGeneratorUtil {
	public byte[] pdfGenerator(List<InsuranceEntity> listInsurance) throws IOException {
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-YYYY");
		// Creating a PdfWriter
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PdfWriter writer = new PdfWriter(outputStream);
		// Creating a PdfDocument
		PdfDocument pdfDoc = new PdfDocument(writer);

		// Adding a new page
		pdfDoc.addNewPage();

		// Creating a Document
		Document document = new Document(pdfDoc);
		
		String content = "Citizen Details";
		Paragraph paragraph = new Paragraph(content);
		paragraph.setFontSize(14);
		paragraph.setTextAlignment(TextAlignment.CENTER);
		paragraph.setBorder(Border.NO_BORDER);
		paragraph.setFirstLineIndent(20);
		paragraph.setItalic();
		paragraph.setBold();
		paragraph.setBackgroundColor(new DeviceRgb(245, 245, 245));
		paragraph.setMargin(10);
		paragraph.setPaddingLeft(10);
		paragraph.setPaddingRight(10);
		paragraph.setWidth(1000);
		//paragraph.setHeight(100);
		document.add(paragraph);
		
		float [] pointColumnWidths = {54F, 54F, 54F, 54F, 54F, 54F, 54F, 54F, 54F, 54F, 54F};
		Table table = new Table(pointColumnWidths);
		// Table table = new Table(4); init by number of columns
		table.addCell(new Cell().add(new Paragraph("Certizen Id")));
		table.addCell(new Cell().add(new Paragraph("Certizen Name")));
		table.addCell(new Cell().add(new Paragraph("Gender")));
		table.addCell(new Cell().add(new Paragraph("Benifit Amount")));
		table.addCell(new Cell().add(new Paragraph("Denial Reason")));
		table.addCell(new Cell().add(new Paragraph("Plan Name")));
		table.addCell(new Cell().add(new Paragraph("Plan Status")));
		table.addCell(new Cell().add(new Paragraph("Plan Start Dt.")));
		table.addCell(new Cell().add(new Paragraph("Plan End Dt.")));
		table.addCell(new Cell().add(new Paragraph("Terminated Dt.")));
		table.addCell(new Cell().add(new Paragraph("Termination Reason")));
		
		for(InsuranceEntity insuranceEntity:listInsurance) {
			table.addCell(new Cell().add(new Paragraph(insuranceEntity.getCitizen_id().toString()))); 
			table.addCell(new Cell().add(new Paragraph(insuranceEntity.getCitizen_name()))); 
			table.addCell(new Cell().add(new Paragraph(insuranceEntity.getGender()))); 
			table.addCell(new Cell().add(new Paragraph(insuranceEntity.getBenefit_amount().toString()))); 
			if(insuranceEntity.getDenial_reason()!=null)
				table.addCell(new Cell().add(new Paragraph(insuranceEntity.getDenial_reason())));
			else
				table.addCell(new Cell().add(new Paragraph("")));
			table.addCell(new Cell().add(new Paragraph(insuranceEntity.getPlan_name()))); 
			table.addCell(new Cell().add(new Paragraph(insuranceEntity.getPlan_status())));
			
			if(insuranceEntity.getPlan_start_date()!=null)
				table.addCell(new Cell().add(new Paragraph(format.format(insuranceEntity.getPlan_start_date()))));
			else
				table.addCell(new Cell().add(new Paragraph("")));
			
			if(insuranceEntity.getPlan_end_date()!=null)
			table.addCell(new Cell().add(new Paragraph(format.format(insuranceEntity.getPlan_end_date()))));
			else
				table.addCell(new Cell().add(new Paragraph("")));
			
			if(insuranceEntity.getTerminated_date()!=null)
			table.addCell(new Cell().add(new Paragraph(format.format(insuranceEntity.getTerminated_date()))));
			else
				table.addCell(new Cell().add(new Paragraph("")));
			
			if(insuranceEntity.getTermination_reason()!=null)
			table.addCell(new Cell().add(new Paragraph(insuranceEntity.getTermination_reason())));
			else
				table.addCell(new Cell().add(new Paragraph("")));
		}
		document.add(table);
		document.close();
		return outputStream.toByteArray();
	}
}
