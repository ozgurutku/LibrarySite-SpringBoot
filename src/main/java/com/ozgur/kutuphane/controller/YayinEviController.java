package com.ozgur.kutuphane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozgur.kutuphane.model.YayinEvi;
import com.ozgur.kutuphane.service.YayinEviService;

@Controller
public class YayinEviController {

	@Autowired
	private YayinEviService yayinEviService;

	@GetMapping("/yayinevi")
	public String viewHomePage(Model model) {
		model.addAttribute("listYayinEvi", yayinEviService.getAllYayinEvi());
		return "list_yayin_evi";
	}

	@RequestMapping("/saveYayinEvi")
	public String saveUye(@ModelAttribute("yayinEvi") YayinEvi yayinEvi, Model model) {
		YayinEvi newYayinEvi = new YayinEvi();
		model.addAttribute("yayinEvi", newYayinEvi);
		yayinEviService.saveYayinEvi(yayinEvi);
		return "new_yayinevi";
	}
}
