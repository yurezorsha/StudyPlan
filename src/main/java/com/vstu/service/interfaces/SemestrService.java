package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Semestr;

public interface SemestrService {

	List<Semestr> getAllByNodeId(Long id);

	Semestr getSemestrById(Long id);

	List<Semestr> updateListSemestrByNodeId(Long id, List<Semestr> s);

	void deleteSemestr(Long id);

	boolean existsSemestr(Long id);

	List<Semestr> addListSemestrByNodeId(Long id, List<Semestr> s);

	int sumAllHoursById(Long id);

}
