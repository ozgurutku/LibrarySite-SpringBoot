package com.ozgur.kutuphane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ozgur.kutuphane.model.Kitap;
import com.ozgur.kutuphane.model.YayinEvi;
import com.ozgur.kutuphane.model.Yazar;
import com.ozgur.kutuphane.service.KitapService;
import com.ozgur.kutuphane.service.YayinEviService;
import com.ozgur.kutuphane.service.YazarService;

@Controller
public class KitapController {

	@Autowired
	private KitapService kitapService;
	
	@Autowired
	private YayinEviService yayinEviService;
	
	@Autowired
	private YazarService yazarService;
	
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
		Yazar yazar = new Yazar();
		YayinEvi yayinEvi = new YayinEvi();
		model.addAttribute("kitap", kitap);
		model.addAttribute("author", yazar);
		model.addAttribute("publisher", yayinEvi);
		return "new_kitap";
	}

	@RequestMapping("/saveKitapNew")
	public String saveUyeForNewKitap(@ModelAttribute("kitap") Kitap kitap,@ModelAttribute("author") Yazar yazar,@ModelAttribute("publisher") YayinEvi yayinEvi,RedirectAttributes redirAttrs) {
		YayinEvi newYayinEvi = yayinEviService.getYayinEviByName(yayinEvi.getPublisherName());
		Yazar newYazar=yazarService.getAuthorByName(yazar.getAuthorName());
		if(newYazar==null) {
			redirAttrs.addFlashAttribute("error", "Böyle bir yazar bulunamadı,İlk önce yazarı ekleyin");
			return "redirect:/showNewKitapForm";
		}
		if(newYayinEvi==null) {
			redirAttrs.addFlashAttribute("error", "Böyle bir yayın evi bulunamadı,İlk önce yayın evini ekleyin");
			return "redirect:/showNewKitapForm";
		}
		System.out.println(newYazar);
		System.out.println(newYayinEvi);
		kitap.setAuthor(newYazar);
		kitap.getPublisher().add(newYayinEvi);
		kitapService.saveKitap(kitap);
		return "redirect:/showNewKitapForm";
	}
}
