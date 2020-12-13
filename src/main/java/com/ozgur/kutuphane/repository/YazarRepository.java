package com.ozgur.kutuphane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozgur.kutuphane.model.Yazar;

@Repository
public interface YazarRepository extends JpaRepository<Yazar, Long> {

}
