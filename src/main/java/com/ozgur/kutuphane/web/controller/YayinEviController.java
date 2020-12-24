package com.ozgur.kutuphane.web.controller;

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

	@GetMapping("/yayineviForUye")
	public String yayineviForUye(Model model) {
		model.addAttribute("listYayinEvi", yayinEviService.getAllYayinEvi());
		return "list_yayin_evi";
	}

	@GetMapping("/saveYayinEvi")
	public String saveYayinEvi(Model model) {
		YayinEvi newYayinEvi = new YayinEvi();
		model.addAttribute("yayinEvi", newYayinEvi);
		return "new_yayinevi";
	}

	@RequestMapping("/newSaveYayinEvi")
	public String newSaveYayinEvi(@ModelAttribute("yayinEvi") YayinEvi yayinEvi) {
		yayinEviService.saveYayinEvi(yayinEvi);
		return "redirect:/saveYayinEvi";
	}

	@GetMapping("/yayineviForYonetici")
	public String yayineviForYonetici(Model model) {
		model.addAttribute("listYayinEvi", yayinEviService.getAllYayinEvi());
		return "list_yayin_evi";
	}
}
