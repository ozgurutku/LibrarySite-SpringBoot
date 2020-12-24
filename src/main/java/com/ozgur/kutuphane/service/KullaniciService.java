package com.ozgur.kutuphane.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ozgur.kutuphane.model.Kullanici;
import com.ozgur.kutuphane.web.dto.KullaniciRegistrationDto;

public interface KullaniciService extends UserDetailsService {
	Kullanici save(KullaniciRegistrationDto registrationDto);

	List<Kullanici> getAllKullanici();

	void saveKullanici(Kullanici kullanici);

	Kullanici getKullaniciById(long id);

	void deleteKullaniciById(long id);
}
