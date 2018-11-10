package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Semestr;

public interface ISemestrService {
	List<Semestr> getAllSemestr();

	List<Semestr> getAllByNodeId(Long id);

	Semestr getSemestrById(Long id);

	Semestr addSemestr(Semestr s);

	void updateSemestr(Semestr s);

	void deleteSemestr(Long id);

	boolean existsSemestr(Long id);

	List<Semestr> addListSemestr(List<Semestr> s);

}
