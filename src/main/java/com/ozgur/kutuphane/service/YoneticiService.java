package com.ozgur.kutuphane.service;

import java.util.List;

import com.ozgur.kutuphane.model.Yonetici;

public interface YoneticiService {
	List<Yonetici> getAllYonetici();

	Yonetici getYöneticiById(long id);

	boolean getYoneticiByuserName(String userName, String password);
}
