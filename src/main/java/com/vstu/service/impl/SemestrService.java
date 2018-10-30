package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Semestr;
import com.vstu.repository.SemestrRepository;
import com.vstu.service.interfaces.ISemestrService;

@Service
public class SemestrService implements ISemestrService {
	@Autowired
	SemestrRepository semestrRepository;

	@Override
	public List<Semestr> getAllSemestr() {

		return semestrRepository.findAll();
	}

	@Override
	public List<Semestr> getAllByNodeId(Long id) {

		return semestrRepository.findAllByNodeId(id);
	}

	@Override
	public Semestr getSemestrById(Long id) {

		return semestrRepository.findById(id).get();
	}

	@Override
	public boolean addSemestr(Semestr s) {
		if (semestrRepository.existsById(s.getId())) {
			return false;
		} else {
			semestrRepository.save(s);
			return true;
		}
	}

	@Override
	public void updateSemestr(Semestr s) {
		semestrRepository.save(s);

	}

	@Override
	public void deleteSemestr(Long id) {
		semestrRepository.deleteById(id);

	}

	@Override
	public boolean existsSemestr(Long id) {
		return semestrRepository.existsById(id);
	}

}
