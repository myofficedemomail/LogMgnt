package com.ashokit.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReportExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public String nodata(Model model, Exception ex) {
		model.addAttribute("msg", ex.getMessage().toUpperCase());
		return "ErrorPage";
	}
}
