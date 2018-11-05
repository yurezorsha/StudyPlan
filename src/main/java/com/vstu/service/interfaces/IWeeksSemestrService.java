package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.WeeksSemestr;

public interface IWeeksSemestrService {

	
	List<WeeksSemestr> getAllWeeksSemestr();

	List<WeeksSemestr> getAllBySemestrId(Long id);

	WeeksSemestr getWeeksSemestrById(Long id);

	boolean addWeeksSemestr(WeeksSemestr w);

	void updateWeeksSemestr(WeeksSemestr w);

	void deleteWeeksSemestr(Long id);

	boolean existsWeeksSemestr(Long id);
}
