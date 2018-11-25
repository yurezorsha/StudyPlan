package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Fakultativ;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.FakultativRepository;
import com.vstu.service.interfaces.FakultativService;

/**
 * service for work with fakultativ table
 */
@Service
public class FakultativServiceImpl implements FakultativService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FakultativServiceImpl.class);

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
		if (!existsFakultativ(id)) {
			LOGGER.error("Fakultativ with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Fakultativ with Id: " + id + " wasn't found!");
		}

		return fakultativRepository.findById(id).get();
	}

	@Override
	public Fakultativ addFakultativ(Fakultativ f) {
		if (existsFakultativ(f.getId())) {
			LOGGER.error("Fakultativ with Id: " + f.getId() + " already exists!");
			throw new AlreadyExistException("Fakultativ with Id: " + f.getId() + " already exists!");
		}

		Fakultativ fakultativ = fakultativRepository.save(f);
		LOGGER.info("Fakultativ with id: " + fakultativ.getId() + " has been added!");
		return fakultativ;
	}

	@Override
	public Fakultativ updateFakultativ(Fakultativ f) {
		if (!existsFakultativ(f.getId())) {
			LOGGER.error("Fakultativ with Id: " + f.getId() + " wasn't found!");
			throw new EntityNotFoundException("Fakultativ with Id: " + f.getId() + " wasn't found!");
		}

		Fakultativ fakultativ = fakultativRepository.save(f);
		LOGGER.info("Fakultativ with id: " + fakultativ.getId() + " has been updated!");
		return fakultativ;
	}

	@Override
	public void deleteFakultativ(Long id) {
		if (!existsFakultativ(id)) {
			LOGGER.error("Fakultativ with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("Fakultativ with Id: " + id + " wasn't found!");
		}
		fakultativRepository.deleteById(id);
		LOGGER.info("Fakultativ with id: " + id + " has been deleted!");

	}

	@Override
	public boolean existsFakultativ(Long id) {
		return fakultativRepository.existsById(id);
	}

}
