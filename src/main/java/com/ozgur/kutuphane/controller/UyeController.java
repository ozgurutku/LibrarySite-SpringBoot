package com.ozgur.kutuphane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ozgur.kutuphane.model.Uye;
import com.ozgur.kutuphane.service.UyeService;

@Controller
public class UyeController {

	@Autowired
	private UyeService uyeService;

	@GetMapping("/showUyeLoginForm")
	public String showUyeLoginForm(Model model) {
		Uye uye = new Uye();
		model.addAttribute("uye", uye);
		return "uye_login_form";
	}

	@RequestMapping("/showUyePage")
	public String showUyeLoginValidation(@ModelAttribute("uye") Uye uye, Model model, RedirectAttributes redirAttrs) {
		if (uyeService.getUyeByuserName(uye.getUserName(), uye.getPassword()) == false) {
			redirAttrs.addFlashAttribute("error", "Kullanıcı adı veya şifre yanlış");
			return "redirect:/showUyeLoginForm";
		}
		return "redirect:/kitapForUye";
	}

	@GetMapping("/showNewUyeForm")
	public String showNewUyeForm(Model model, RedirectAttributes redirAttrs) {
		Uye uye = new Uye();
		model.addAttribute("uye", uye);
		return "new_uye";
	}

	@RequestMapping("/saveUye")
	public String saveUye(@ModelAttribute("uye") Uye uye, RedirectAttributes redirAttrs) {
		try {
			uyeService.saveUye(uye);
		} catch (DataIntegrityViolationException ex) {
			redirAttrs.addFlashAttribute("error", "Kullanıcı adı zaten kullanılmaktadır.");
			return "redirect:/showNewUyeForm";
		}
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Uye uye = uyeService.getUyeById(id);
		model.addAttribute("uye", uye);
		return "update_uye";
	}

	@GetMapping("/deleteUye/{id}")
	public String deleteUyeForm(@PathVariable(value = "id") long id, Model model) {
		uyeService.deleteUyeById(id);
		return "redirect:/showFormForDeleteUye";
	}

	@RequestMapping("/showFormForDeleteUye")
	public String deleteUye(Model model) {
		model.addAttribute("listUye", uyeService.getAllUye());
		return "delete_uye";
	}

	@RequestMapping("/showFormForUyeUpdate")
	public String UyeUpdate(Model model) {
		model.addAttribute("listUye", uyeService.getAllUye());
		return "update_uye_form";
	}

	@GetMapping("/showFormForUyeUpdate/{id}")
	public String showFormForUyeUpdate(@PathVariable(value = "id") long id, Model model) {
		Uye uye = uyeService.getUyeById(id);
		model.addAttribute("uye", uye);
		return "update_uye";
	}

	@PostMapping("/yoneticiSaveUye")
	public String yoneticiSaveUye(@ModelAttribute("uye") Uye uye) {
		uyeService.saveUye(uye);
		return "redirect:/showFormForUyeUpdate";
	}
}
