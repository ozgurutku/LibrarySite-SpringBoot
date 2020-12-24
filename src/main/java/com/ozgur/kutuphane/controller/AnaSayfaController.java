package com.ozgur.kutuphane.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AnaSayfaController {

	@GetMapping("/login")
	public String viewHomePage() {
		return "login";
	}

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("/default")
	public String defaultAfterLogin(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/showYoneticiPage";
		}
		return "redirect:/showUyePage";
	}
	
	@RequestMapping("/showYoneticiPage")
	public String showYoneticiLoginValidation() {
		return "yonetici_form";
	}
	
	@RequestMapping("/showUyePage")
	public String showUyeLoginValidation() {
		return "uye_form";
	}
}
