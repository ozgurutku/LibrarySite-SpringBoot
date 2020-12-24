package com.ozgur.kutuphane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozgur.kutuphane.model.Kullanici;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici, Long>{
	Kullanici findByEmail(String email);
}
