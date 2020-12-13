package com.ozgur.kutuphane.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozgur.kutuphane.model.Uye;
import com.ozgur.kutuphane.repository.UyeRepository;

@Service
public class UyeServiceImpl implements UyeService {

	@Autowired
	private UyeRepository uyeRepository;

	@Override
	public List<Uye> getAllUye() {
		return uyeRepository.findAll();
	}

	@Override
	public void saveUye(Uye uye) {
		this.uyeRepository.save(uye);
	}

	@Override
	public boolean getUyeByuserName(String userName, String password) {
		try {
			if (uyeRepository.findByuserName(userName).getUserName().equalsIgnoreCase(userName)
					&& uyeRepository.findByuserName(userName).getPassword().equalsIgnoreCase(password)) {
				return true;
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			return false;
		}
	}

	@Override
	public Uye getUyeById(long id) {
		Optional<Uye> optional = uyeRepository.findById(id);
		Uye uye = null;
		if (optional.isPresent()) {
			uye = optional.get();
		} else {
			throw new RuntimeException("Uye bulunamadı id:" + id);
		}
		return uye;
	}

	@Override
	public void deleteUyeById(long id) {
		uyeRepository.deleteById(id);
	}

}
