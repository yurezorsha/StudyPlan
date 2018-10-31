package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Speciality;

public interface ISpecialityService {

	List<Speciality> getAllSpeciality();

	Speciality getSpecialityById(Long id);	

	boolean addSpeciality(Speciality s);

	void updateSpeciality(Speciality s);

	void deleteSpeciality(Long id);

	boolean existsSpeciality(Long id);
}
