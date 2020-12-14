package com.ozgur.kutuphane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ozgur.kutuphane.model.Yonetici;
import com.ozgur.kutuphane.service.YoneticiService;

@Controller
public class YoneticiController {

	@Autowired
	private YoneticiService yoneticiService;

	@GetMapping("/showYoneticiLoginForm")
	public String showUyeLoginForm(Model model) {
		Yonetici yonetici = new Yonetici();
		model.addAttribute("yonetici", yonetici);
		return "yonetici_login_form";
	}

	@RequestMapping("/showYoneticiPage")
	public String showYoneticiLoginValidation(@ModelAttribute("yonetici") Yonetici yonetici, Model model,
			RedirectAttributes redirAttrs) {
		if (yoneticiService.getYoneticiByuserName(yonetici.getUserName(), yonetici.getPassword()) == false) {
			redirAttrs.addFlashAttribute("error", "Kullanıcı adı veya şifre yanlış");
			return "redirect:/showYoneticiLoginForm";
		}
		return "yonetici_form";
	}

}
