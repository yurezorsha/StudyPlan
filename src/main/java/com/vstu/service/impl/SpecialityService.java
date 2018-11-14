package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Speciality;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.repository.SpecialityRepository;
import com.vstu.service.interfaces.ISpecialityService;

@Service
public class SpecialityService implements ISpecialityService {

	@Autowired
	SpecialityRepository specialityRepository;

	@Override
	public List<Speciality> getAllSpeciality() {

		return specialityRepository.findAll();
	}

	@Override
	public Speciality getSpecialityById(Long id) {

		return specialityRepository.findById(id).get();
	}

	@Override
	public Speciality addSpeciality(Speciality c) {
		if (existsSpeciality(c.getId()))
			throw new AlreadyExistException("Speciality with Id: " + c.getId() + " already exists!");

		return specialityRepository.save(c);
	}

	@Override
	public Speciality updateSpeciality(Speciality c) {
		if (!existsSpeciality(c.getId()))
			throw new AlreadyExistException("Speciality with Id: " + c.getId() + " wasn't found!");

		return specialityRepository.save(c);

	}

	@Override
	public void deleteSpeciality(Long id) {
		if (!existsSpeciality(id))
			throw new AlreadyExistException("Speciality with Id: " + id + " wasn't found!");
		else
			specialityRepository.deleteById(id);

	}

	@Override
	public boolean existsSpeciality(Long id) {

		return specialityRepository.existsById(id);
	}
}
