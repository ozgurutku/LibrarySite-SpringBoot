package com.ozgur.kutuphane.web.controller;

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

	@GetMapping("/yazarForUye")
	public String yazarForUye(Model model) {
		model.addAttribute("listYazar", yazarService.getAllYazar());
		return "list_yazar";
	}

	@GetMapping("/saveYazar")
	public String saveYazar(Model model) {
		Yazar newYazar = new Yazar();
		model.addAttribute("yazar", newYazar);
		return "new_yazar";
	}

	@RequestMapping("/newSaveYazar")
	public String newSaveYazar(@ModelAttribute("yazar") Yazar yazar) {
		yazarService.saveYazar(yazar);
		return "redirect:/saveYazar";
	}

	@GetMapping("/yazarForYonetici")
	public String yazarForYonetici(Model model) {
		model.addAttribute("listYazar", yazarService.getAllYazar());
		return "list_yazar";
	}

}
