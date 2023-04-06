package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.email.EmailUtils;
import com.ashokit.entity.InsuranceEntity;
import com.ashokit.excel.ExcelGeneratorUtil;
import com.ashokit.form.SearchRequest;
import com.ashokit.pdf.PdfGeneratorUtil;
import com.ashokit.service.ReportService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {
	@Autowired
	private ReportService reportService;
	@Autowired
	private PdfGeneratorUtil pdfGeneratorUtil;
	@Autowired
	private ExcelGeneratorUtil excelGeneratorUtil;
	@Autowired
	private EmailUtils emailUtils;
	@GetMapping("/")
	public String reportPage(Model model) {
		model.addAttribute("searchform", new SearchRequest());
		model.addAttribute("list", null);
		return "index";
	}
	@PostMapping("/Reports")
	public String reportDetails(@ModelAttribute("searchform") SearchRequest searchform,Model model) throws Exception {
		List<InsuranceEntity> listInsuranceEntity=reportService.getReportDtls(searchform);
		model.addAttribute("list", listInsuranceEntity);
		model.addAttribute("searchform", searchform);
		return "index";
	}
	@PostMapping("/Pdf")
	public ResponseEntity<ByteArrayResource> pdfGenerator(@ModelAttribute("searchform") SearchRequest searchform,HttpServletRequest request,HttpServletResponse response) throws Exception {
		List<InsuranceEntity> listInsuranceEntity=reportService.getReportDtls(searchform);
		byte[] pdfByteArr=pdfGeneratorUtil.pdfGenerator(listInsuranceEntity);
		emailUtils.sendMail(pdfByteArr, "pdf");
	    ByteArrayResource resource = new ByteArrayResource(pdfByteArr);
	    
	    HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Content-Disposition", "attachment;filename=Citizen.pdf");
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(resource.getByteArray().length)
	            .contentType(MediaType.APPLICATION_OCTET_STREAM)
	            .body(resource);
	}
	@PostMapping("/Excel")
	public ResponseEntity<ByteArrayResource> excelGenerator(@ModelAttribute("searchform") SearchRequest searchform,HttpServletRequest request,HttpServletResponse response) throws Exception {
		List<InsuranceEntity> listInsuranceEntity=reportService.getReportDtls(searchform);
		byte[] excelByteArr=excelGeneratorUtil.excelGenerator(listInsuranceEntity);
		emailUtils.sendMail(excelByteArr, "excel");
		ByteArrayResource resource = new ByteArrayResource(excelByteArr);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.add("Content-Disposition", "attachment;filename=Citizen.xlsx");
		return ResponseEntity.ok()
				.headers(headers)
				.contentLength(resource.getByteArray().length)
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(resource);
	}
}
