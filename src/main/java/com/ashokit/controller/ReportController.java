package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.form.SearchRequest;
import com.ashokit.form.ServerDtlsDto;
import com.ashokit.service.ServerService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ReportController {
	@Autowired
	private ServerService serverService;
	@GetMapping("/")
	public String loginPage(Model model) {
		//model.addAttribute("searchform", new SearchRequest());
		//model.addAttribute("list", null);
		return "login";
	}
	@PostMapping("/login")
	public String reportPage(Model model,HttpServletRequest request) {
		Object username=request.getParameter("username");
		Object password=request.getParameter("password");
		if(username !=null && password !=null) {
			if(username.toString().equals("admin") && password.toString().equals("admin")) {
				return "admin";
			}
		}
		//model.addAttribute("searchform", new SearchRequest());
		//model.addAttribute("list", null);
		List<ServerDtlsDto> allServerDtls = serverService.getAllServerDtls();
		model.addAttribute("allServiceDtls", allServerDtls);
		return "index";
	}
	@PostMapping("/addServer")
	public String savingServerDtls(@ModelAttribute ServerDtlsDto sreverDtlsDto,Model model) {
		String dtls = serverService.addServerDtls(sreverDtlsDto);
		model.addAttribute("msg",dtls);
		return "admin";
	}
	
}
