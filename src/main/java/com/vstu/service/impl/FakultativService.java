package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Fakultativ;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.FakultativRepository;
import com.vstu.service.interfaces.IFakultativService;

@Service
public class FakultativService implements IFakultativService {

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
		if (!existsFakultativ(id))
			throw new EntityNotFoundException("Fakultativ with Id: " + id + " wasn't found!");

		return fakultativRepository.findById(id).get();
	}

	@Override
	public Fakultativ addFakultativ(Fakultativ c) {
		if (existsFakultativ(c.getId()))
			throw new AlreadyExistException("Fakultativ with Id: " + c.getId() + " already exists!");

		return fakultativRepository.save(c);
	}

	@Override
	public Fakultativ updateFakultativ(Fakultativ c) {
		if (!existsFakultativ(c.getId()))
			throw new EntityNotFoundException("Fakultativ with Id: " + c.getId() + " wasn't found!");

		return fakultativRepository.save(c);

	}

	@Override
	public void deleteFakultativ(Long id) {
		if (!existsFakultativ(id))
			throw new EntityNotFoundException("Fakultativ with Id: " + id + " wasn't found!");
		else
			fakultativRepository.deleteById(id);

	}

	@Override
	public boolean existsFakultativ(Long id) {
		return fakultativRepository.existsById(id);
	}

}
