package com.ozgur.kutuphane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozgur.kutuphane.model.Kitap;
import com.ozgur.kutuphane.service.KitapService;

@Controller
public class KitapController {

	@Autowired
	private KitapService kitapService;

	@GetMapping("/kitapForUye")
	public String kitapForUye(Model model) {
		model.addAttribute("listKitap", kitapService.getAllKitap());
		return "uye_form";
	}

	@GetMapping("/kitapForYonetici")
	public String kitapForYonetici(Model model) {
		model.addAttribute("listKitap", kitapService.getAllKitap());
		return "list_kitap";
	}

	@RequestMapping("/kitapSearchForm")
	public String kitapSearch(Model model) {
		Kitap kitap = new Kitap();
		model.addAttribute("kitap", kitap);
		return "search_kitap_form";
	}

	@RequestMapping("/kitapSearch")
	public String kitapSearchClick(@ModelAttribute("kitap") Kitap kitap, Model model) {
		Kitap findKitap = kitapService.getKitapByName(kitap.getBookName());
		model.addAttribute("findKitap", findKitap);
		return "search_kitap_form";
	}

	@RequestMapping("/showFormForKitapUpdate")
	public String kitapUpdate(Model model) {
		model.addAttribute("listKitap", kitapService.getAllKitap());
		return "update_kitap_form";
	}

	@GetMapping("/showFormForKitapUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Kitap kitap = kitapService.getKitapById(id);
		model.addAttribute("kitap", kitap);
		return "update_kitap";
	}

	@PostMapping("/saveKitap")
	public String saveKitapForUpdate(@ModelAttribute("kitap") Kitap kitap) {
		kitapService.saveKitap(kitap);
		return "redirect:showFormForKitapUpdate";
	}

	@GetMapping("/deleteKitap/{id}")
	public String deleteKitapForm(@PathVariable(value = "id") long id, Model model) {
		kitapService.deleteKitapById(id);
		return "redirect:/showFormForDeleteKitap";
	}

	@RequestMapping("/showFormForDeleteKitap")
	public String deleteKitap(Model model) {
		model.addAttribute("listKitap", kitapService.getAllKitap());
		return "delete_kitap";
	}

	@GetMapping("/showNewKitapForm")
	public String showNewKitapForm(Model model) {
		Kitap kitap = new Kitap();
		model.addAttribute("kitap", kitap);
		return "new_kitap";
	}

	@RequestMapping("/saveKitapNew")
	public String saveUyeForNewKitap(@ModelAttribute("kitap") Kitap kitap) {
		kitapService.saveKitap(kitap);
		return "redirect:/showNewKitapForm";
	}
}
