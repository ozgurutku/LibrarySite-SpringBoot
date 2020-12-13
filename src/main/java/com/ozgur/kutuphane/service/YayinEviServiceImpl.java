package com.ozgur.kutuphane.service;

import java.util.List;

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

}
