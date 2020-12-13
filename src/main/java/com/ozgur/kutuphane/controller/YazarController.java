package com.ozgur.kutuphane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozgur.kutuphane.model.Yazar;
import com.ozgur.kutuphane.service.YazarService;

@Controller
public class YazarController {

	@Autowired
	private YazarService yazarService;

	@GetMapping("/yazar")
	public String viewHomePage(Model model) {
		model.addAttribute("listYazar", yazarService.getAllYazar());
		return "list_yazar";
	}

	@RequestMapping("/saveYazar")
	public String saveUye(@ModelAttribute("yazar") Yazar yazar, Model model) {
		Yazar newYazar = new Yazar();
		model.addAttribute("yazar", newYazar);
		yazarService.saveYazar(yazar);
		return "new_yazar";
	}
}
