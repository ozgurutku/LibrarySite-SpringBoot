package com.ozgur.kutuphane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozgur.kutuphane.model.Kitap;
import com.ozgur.kutuphane.model.YayinEvi;

@Repository
public interface YayinEviRepostiory extends JpaRepository<YayinEvi, Long> {
	List<YayinEvi> findBypublisherName(String publisherName);
}
