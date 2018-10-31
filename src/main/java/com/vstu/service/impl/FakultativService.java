package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Fakultativ;
import com.vstu.repository.FakultativRepository;
import com.vstu.service.interfaces.IFakultativService;

@Service
public class FakultativService implements IFakultativService{

	@Autowired
	FakultativRepository fakultativRepository;

	@Override
	public List<Fakultativ> getAllFakultativ() {
		return fakultativRepository.findAll();
	}

	@Override
	public List<Fakultativ> getAllByPlanId(Long id) {
		return fakultativRepository.findAllByPlanId(id);
	}

	@Override
	public Fakultativ getFakultativById(Long id) {
		return fakultativRepository.findById(id).get();
	}

	@Override
	public boolean addFakultativ(Fakultativ f) {
		if (fakultativRepository.existsById(f.getId())) {
			return false;
		} else {
			fakultativRepository.save(f);
			return true;
		}
	}

	@Override
	public void updateFakultativ(Fakultativ f) {
		fakultativRepository.save(f);
		
	}

	@Override
	public void deleteFakultativ(Long id) {
		fakultativRepository.deleteById(id);
		
	}

	@Override
	public boolean existsFakultativ(Long id) {
		return fakultativRepository.existsById(id);
	}

	
	
}
