package com.ozgur.kutuphane.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozgur.kutuphane.model.Kitap;
import com.ozgur.kutuphane.repository.KitapRepository;

@Service
public class KitapServiceImpl implements KitapService {

	@Autowired
	private KitapRepository kitapRepository;

	@Override
	public List<Kitap> getAllKitap() {
		return kitapRepository.findAll();
	}

	@Override
	public Kitap getKitapByName(String bookName) {
		kitapRepository.findBybookName(bookName);
		for (Kitap kitap : kitapRepository.findBybookName(bookName)) {
			return kitap;
		}
		return null;
	}

	@Override
	public void saveKitap(Kitap kitap) {
		this.kitapRepository.save(kitap);
	}

	@Override
	public void deleteKitapById(long id) {
		this.kitapRepository.deleteById(id);
	}

	@Override
	public Kitap getKitapById(long id) {
		Optional<Kitap> optional = kitapRepository.findById(id);
		Kitap kitap = null;
		if (optional.isPresent()) {
			kitap = optional.get();
			System.out.println(kitap.getAuthor());
			System.out.println(kitap.getPublisher());
		} else {
			throw new RuntimeException("Kitap bulunamadı id:" + id);
		}
		return kitap;
	}
}
