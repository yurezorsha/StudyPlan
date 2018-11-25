package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Speciality;

public interface SpecialityService {

	List<Speciality> getAllSpeciality();

	Speciality getSpecialityById(Long id);

	Speciality addSpeciality(Speciality s);

	Speciality updateSpeciality(Speciality s);

	void deleteSpeciality(Long id);

	boolean existsSpeciality(Long id);
}
