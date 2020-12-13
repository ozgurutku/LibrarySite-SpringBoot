package com.ozgur.kutuphane.service;

import java.util.List;

import com.ozgur.kutuphane.model.Kitap;

public interface KitapService {
	List<Kitap> getAllKitap();

	Kitap getKitapByName(String bookName);

	void saveKitap(Kitap Kitap);

	void deleteKitapById(long id);

	Kitap getKitapById(long id);
}
