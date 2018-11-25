package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Speciality;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.SpecialityRepository;
import com.vstu.service.interfaces.SpecialityService;

/**
 * service for work with speciality table
 */
@Service
public class SpecialityServiceImpl implements SpecialityService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpecialityServiceImpl.class);

	@Autowired
	SpecialityRepository specialityRepository;

	@Override
	public List<Speciality> getAllSpeciality() {

		return specialityRepository.findAll();
	}

	@Override
	public Speciality getSpecialityById(Long id) {
		if (!existsSpeciality(id)) {
			LOGGER.error("Speciality with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("Speciality with Id: " + id + " wasn't found!");
		}

		return specialityRepository.findById(id).get();
	}

	@Override
	public Speciality addSpeciality(Speciality s) {
		if (existsSpeciality(s.getId())) {
			LOGGER.error("Speciality with Id: " + s.getId() + " already exists!");
			throw new AlreadyExistException("Speciality with Id: " + s.getId() + " already exists!");
		}

		Speciality speciality = specialityRepository.save(s);
		LOGGER.info("Speciality with id: " + speciality.getId() + " has been added!");
		return speciality;
	}

	@Override
	public Speciality updateSpeciality(Speciality s) {
		if (!existsSpeciality(s.getId())) {
			LOGGER.error("Speciality with Id: " + s.getId() + " wasn't found!");
			throw new EntityNotFoundException("Speciality with Id: " + s.getId() + " wasn't found!");
		}

		Speciality speciality = specialityRepository.save(s);
		LOGGER.info("Speciality with id: " + speciality.getId() + " has been updated!");
		return speciality;

	}

	@Override
	public void deleteSpeciality(Long id) {
		if (!existsSpeciality(id)) {
			LOGGER.error("Speciality with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("Speciality with Id: " + id + " wasn't found!");
		}
		specialityRepository.deleteById(id);
		LOGGER.info("Speciality with id: " + id + " has been deleted!");

	}

	@Override
	public boolean existsSpeciality(Long id) {

		return specialityRepository.existsById(id);
	}
}
