package com.ozgur.kutuphane.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozgur.kutuphane.model.Yazar;
import com.ozgur.kutuphane.repository.YazarRepository;

@Service
public class YazarServiceImpl implements YazarService {

	@Autowired
	private YazarRepository yazarRepository;

	@Override
	public List<Yazar> getAllYazar() {
		return yazarRepository.findAll();
	}

	@Override
	public void saveYazar(Yazar yazar) {
		this.yazarRepository.save(yazar);
	}

	@Override
	public Yazar getAuthorByName(String authorName) {
		yazarRepository.findByauthorName(authorName);
		for (Yazar yazar : yazarRepository.findByauthorName(authorName)) {
			System.out.println(yazar);
			return yazar;
		}
		return null;
	}

}
