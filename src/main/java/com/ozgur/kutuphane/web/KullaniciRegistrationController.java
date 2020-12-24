package com.ozgur.kutuphane.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozgur.kutuphane.service.KullaniciService;
import com.ozgur.kutuphane.web.dto.KullaniciRegistrationDto;

@Controller
@RequestMapping("/registration")
public class KullaniciRegistrationController {

	private KullaniciService kullaniciService;
	
	public KullaniciRegistrationController(KullaniciService kullaniciService) {
		super();
		this.kullaniciService = kullaniciService;
	}
	
	@ModelAttribute("kullanici")
	public KullaniciRegistrationDto userRegistrationDto() {
		return new KullaniciRegistrationDto();
	}

	@GetMapping
	public String showKayıtForm() {
		return "kayıt";
	}

	@PostMapping
	public String registerKullaniciAccount(@ModelAttribute("user") KullaniciRegistrationDto registrationDto) {
		kullaniciService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
