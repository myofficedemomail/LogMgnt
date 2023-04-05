package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.entity.InsuranceEntity;
import com.ashokit.form.SearchRequest;
import com.ashokit.service.ReportService;

@Controller
public class ReportController {
	@Autowired
	private ReportService reportService;
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
		return "index";
	}
}
