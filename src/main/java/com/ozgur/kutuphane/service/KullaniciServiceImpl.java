package com.ozgur.kutuphane.service;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ozgur.kutuphane.model.Kullanici;
import com.ozgur.kutuphane.model.Rol;
import com.ozgur.kutuphane.repository.KullaniciRepository;
import com.ozgur.kutuphane.web.dto.KullaniciRegistrationDto;

@Service
public class KullaniciServiceImpl implements KullaniciService {

	private KullaniciRepository kullaniciRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public KullaniciServiceImpl(KullaniciRepository kullaniciRepository) {
		super();
		this.kullaniciRepository = kullaniciRepository;
	}
	
	@Override
	public Kullanici getKullaniciById(long id) {
		Optional<Kullanici> optional = kullaniciRepository.findById(id);
		Kullanici kullanici = null;
		if (optional.isPresent()) {
			kullanici = optional.get();
		} else {
			throw new RuntimeException("Uye bulunamadı id:" + id);
		}
		return kullanici;
	}

	@Override
	public void deleteKullaniciById(long id) {
		kullaniciRepository.deleteById(id);
	}
	
	@Override
	public List<Kullanici> getAllKullanici() {
		return kullaniciRepository.findAll();
	}

	@Override
	public void saveKullanici(Kullanici kullanici) {
		this.kullaniciRepository.save(kullanici);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Kullanici kullanici = kullaniciRepository.findByEmail(username);
		if (kullanici == null) {
			throw new UsernameNotFoundException("Geçersiz kullanıcı adı veya şifre.");
		}
		return new org.springframework.security.core.userdetails.User(kullanici.getEmail(), kullanici.getPassword(),
				mapRolesToAuthorities(kullanici.getRoles()));
	}

	@Override
	public Kullanici save(KullaniciRegistrationDto registrationDto) {
		Kullanici kullanici = new Kullanici(registrationDto.getFirstName(), registrationDto.getLastName(),
				registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),
				Arrays.asList(new Rol("ROLE_USER")));

		return kullaniciRepository.save(kullanici);
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Rol> roller) {
		return roller.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
