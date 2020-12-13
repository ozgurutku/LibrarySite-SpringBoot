package com.ozgur.kutuphane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozgur.kutuphane.model.Kitap;

@Repository
public interface KitapRepository extends JpaRepository<Kitap, Long> {
	List<Kitap> findBybookName(String bookName);

}
