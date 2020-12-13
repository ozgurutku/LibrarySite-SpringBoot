package com.ozgur.kutuphane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozgur.kutuphane.model.Yonetici;

@Repository
public interface YoneticiRepository extends JpaRepository<Yonetici, Long> {
	Yonetici findByuserName(String userName);

}
