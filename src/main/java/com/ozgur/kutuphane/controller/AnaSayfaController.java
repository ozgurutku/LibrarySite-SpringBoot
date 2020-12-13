package com.ozgur.kutuphane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AnaSayfaController {

	@GetMapping("/")
	public String viewHomePage(RedirectAttributes redirAttrs) {
		return "index";
	}

}
