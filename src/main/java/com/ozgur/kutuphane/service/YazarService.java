package com.ozgur.kutuphane.service;

import java.util.List;


import com.ozgur.kutuphane.model.Yazar;

public interface YazarService {
	List<Yazar> getAllYazar();

	void saveYazar(Yazar yazar);
	
	Yazar getAuthorByName(String authorName);
}
