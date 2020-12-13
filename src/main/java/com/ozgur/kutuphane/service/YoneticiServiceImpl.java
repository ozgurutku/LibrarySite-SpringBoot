package com.ozgur.kutuphane.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozgur.kutuphane.model.Yonetici;
import com.ozgur.kutuphane.repository.YoneticiRepository;

@Service
public class YoneticiServiceImpl implements YoneticiService {

	@Autowired
	private YoneticiRepository yoneticiRepository;

	@Override
	public List<Yonetici> getAllYonetici() {
		return yoneticiRepository.findAll();
	}

	@Override
	public Yonetici getYöneticiById(long id) {
		Optional<Yonetici> optional = yoneticiRepository.findById(id);
		Yonetici yonetici = null;
		if (optional.isPresent()) {
			yonetici = optional.get();
		} else {
			throw new RuntimeException("Uye bulunamadı id:" + id);
		}
		return yonetici;
	}

	@Override
	public boolean getYoneticiByuserName(String userName, String password) {
		try {
			if (yoneticiRepository.findByuserName(userName).getUserName().equalsIgnoreCase(userName)
					&& yoneticiRepository.findByuserName(userName).getPassword().equalsIgnoreCase(password)) {
				return true;
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			return false;
		}
	}
}
