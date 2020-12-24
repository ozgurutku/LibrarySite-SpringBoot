package com.ozgur.kutuphane.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozgur.kutuphane.model.YayinEvi;
import com.ozgur.kutuphane.repository.YayinEviRepostiory;

@Service
public class YayinEviServiceImpl implements YayinEviService {

	@Autowired
	private YayinEviRepostiory yayinEviRepository;

	@Override
	public List<YayinEvi> getAllYayinEvi() {
		return yayinEviRepository.findAll();
	}

	@Override
	public void saveYayinEvi(YayinEvi yayınEvi) {
		this.yayinEviRepository.save(yayınEvi);
	}

	@Override
	public YayinEvi getYayinEviById(long id) {
		Optional<YayinEvi> optional = yayinEviRepository.findById(id);
		YayinEvi yayinEvi = null;
		if (optional.isPresent()) {
			yayinEvi = optional.get();
		} else {
			throw new RuntimeException("Kitap bulunamadı id:" + id);
		}
		return yayinEvi;
	}

	@Override
	public YayinEvi getYayinEviByName(String publisherName) {
		yayinEviRepository.findBypublisherName(publisherName);
		for (YayinEvi yayinEvi : yayinEviRepository.findBypublisherName(publisherName)) {
			System.out.println(yayinEvi);
			return yayinEvi;
		}
		return null;
	}

}
