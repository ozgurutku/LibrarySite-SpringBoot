package com.ozgur.kutuphane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozgur.kutuphane.model.Uye;

@Repository
public interface UyeRepository extends JpaRepository<Uye, Long> {
	Uye findByuserName(String userName);
}
