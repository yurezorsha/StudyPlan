package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Speciality;
import com.vstu.repository.SpecialityRepository;
import com.vstu.service.interfaces.ISpecialityService;

@Service
public class SpecialityService implements ISpecialityService{
	
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
	public boolean addSpeciality(Speciality s) {
		if (specialityRepository.existsById(s.getId())) {
			return false;
		} else {
			specialityRepository.save(s);
			return true;
		}

	}

	@Override
	public void updateSpeciality(Speciality s) {
		specialityRepository.save(s);

	}

	@Override
	public void deleteSpeciality(Long id) {

		specialityRepository.deleteById(id);

	}

	@Override
	public boolean existsSpeciality(Long id) {

		return specialityRepository.existsById(id);
	}
}
