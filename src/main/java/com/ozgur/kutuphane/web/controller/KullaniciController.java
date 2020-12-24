package com.ozgur.kutuphane.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozgur.kutuphane.model.Kullanici;
import com.ozgur.kutuphane.service.KullaniciService;

@Controller
public class KullaniciController {

	@Autowired
	private KullaniciService kullaniciService;

	@GetMapping("/showFormForUyeUpdate/{id}")
	public String showFormForUyeUpdate(@PathVariable(value = "id") long id, Model model) {
		Kullanici kullanici = kullaniciService.getKullaniciById(id);
		model.addAttribute("kullanici", kullanici);
		return "update_uye";
	}

	@RequestMapping("/showFormForUyeUpdate")
	public String UyeUpdate(Model model) {
		model.addAttribute("listKullanici", kullaniciService.getAllKullanici());
		return "update_uye_form";
	}

	@GetMapping("/deleteUye/{id}")
	public String deleteUyeForm(@PathVariable(value = "id") long id, Model model) {
		kullaniciService.deleteKullaniciById(id);
		return "redirect:/showFormForDeleteUye";
	}

	@RequestMapping("/showFormForDeleteUye")
	public String deleteUye(Model model) {
		model.addAttribute("listKullanici", kullaniciService.getAllKullanici());
		return "delete_uye";
	}

	@PostMapping("/yoneticiSaveUye")
	public String yoneticiSaveUye(@ModelAttribute("kullanici") Kullanici kullanici) {
		kullaniciService.saveKullanici(kullanici);
		return "redirect:/showFormForUyeUpdate";
	}
}
