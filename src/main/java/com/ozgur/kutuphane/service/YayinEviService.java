package com.ozgur.kutuphane.service;

import java.util.List;

import com.ozgur.kutuphane.model.YayinEvi;

public interface YayinEviService {
	List<YayinEvi> getAllYayinEvi();

	void saveYayinEvi(YayinEvi yayınEvi);
}
