package com.ozgur.kutuphane.service;

import java.util.List;

import com.ozgur.kutuphane.model.Uye;

public interface UyeService {

	List<Uye> getAllUye();

	void saveUye(Uye uye);

	Uye getUyeById(long id);

	void deleteUyeById(long id);

	boolean getUyeByuserName(String userName, String password);
}
