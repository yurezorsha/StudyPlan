package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.WeeksSemestr;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.repository.WeeksSemestrRepository;
import com.vstu.service.interfaces.IWeeksSemestrService;

@Service
public class WeeksSemestrService implements IWeeksSemestrService {

	@Autowired
	WeeksSemestrRepository weeksSemestrRepository;

	@Override
	public List<WeeksSemestr> getAllWeeksSemestr() {
		return weeksSemestrRepository.findAll();
	}

	@Override
	public List<WeeksSemestr> getAllBySemestrId(Long id) {
		return weeksSemestrRepository.findAllBySemestrId(id);
	}

	@Override
	public WeeksSemestr getWeeksSemestrById(Long id) {
		return weeksSemestrRepository.findById(id).get();
	}

	@Override
	public WeeksSemestr addWeeksSemestr(WeeksSemestr c) {
		if (!existsWeeksSemestr(c.getId()))
			throw new AlreadyExistException("WeeksSemestr with Id: " + c.getId() + " already exists!");

		return weeksSemestrRepository.save(c);
	}

	@Override
	public WeeksSemestr updateWeeksSemestr(WeeksSemestr c) {
		if (!existsWeeksSemestr(c.getId()))
			throw new AlreadyExistException("WeeksSemestr with Id: " + c.getId() + " wasn't found!");

		return weeksSemestrRepository.save(c);

	}

	@Override
	public void deleteWeeksSemestr(Long id) {
		if (!existsWeeksSemestr(id))
			throw new AlreadyExistException("WeeksSemestr with Id: " + id + " wasn't found!");
		else
			weeksSemestrRepository.deleteById(id);

	}

	@Override
	public boolean existsWeeksSemestr(Long id) {
		return weeksSemestrRepository.existsById(id);
	}

}
