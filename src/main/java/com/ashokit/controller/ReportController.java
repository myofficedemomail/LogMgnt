package com.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ashokit.form.SearchRequest;

@Controller
public class ReportController {
	@GetMapping("/")
	public String loginPage(Model model) {
		//model.addAttribute("searchform", new SearchRequest());
		//model.addAttribute("list", null);
		return "login";
	}
	@GetMapping("/login")
	public String reportPage(Model model) {
		//model.addAttribute("searchform", new SearchRequest());
		//model.addAttribute("list", null);
		return "index";
	}
}
