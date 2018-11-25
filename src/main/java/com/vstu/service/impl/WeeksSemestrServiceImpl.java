package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.WeeksSemestr;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.WeeksSemestrRepository;
import com.vstu.service.interfaces.WeeksSemestrService;

/**
 * service for work with table weeks_semestr
 */
@Service
public class WeeksSemestrServiceImpl implements WeeksSemestrService {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeeksSemestrServiceImpl.class);

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
		if (!existsWeeksSemestr(id)) {
			LOGGER.error("WeeksSemestr with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("WeeksSemestr with Id: " + id + " wasn't found!");
		}
		return weeksSemestrRepository.findById(id).get();
	}

	@Override
	public WeeksSemestr addWeeksSemestr(WeeksSemestr w) {
		if (!existsWeeksSemestr(w.getId())) {
			LOGGER.error("WeeksSemestr with Id: " + w.getId() + " already exists!");
			throw new AlreadyExistException("WeeksSemestr with Id: " + w.getId() + " already exists!");
		}

		WeeksSemestr weeksSemestr = weeksSemestrRepository.save(w);
		LOGGER.info("WeeksSemestr with id: " + weeksSemestr.getId() + " has been added!");
		return weeksSemestr;
	}

	@Override
	public WeeksSemestr updateWeeksSemestr(WeeksSemestr w) {
		if (!existsWeeksSemestr(w.getId())) {
			LOGGER.error("WeeksSemestr with Id: " + w.getId() + " wasn't found!");
			throw new EntityNotFoundException("WeeksSemestr with Id: " + w.getId() + " wasn't found!");
		}

		WeeksSemestr weeksSemestr = weeksSemestrRepository.save(w);
		LOGGER.info("WeeksSemestr with id: " + weeksSemestr.getId() + " has been updated!");
		return weeksSemestr;

	}

	@Override
	public void deleteWeeksSemestr(Long id) {
		if (!existsWeeksSemestr(id)) {
			LOGGER.error("WeeksSemestr with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("WeeksSemestr with Id: " + id + " wasn't found!");
		}

		weeksSemestrRepository.deleteById(id);
		LOGGER.info("WeeksSemestr with id: " + id + " has been deleted!");

	}

	@Override
	public boolean existsWeeksSemestr(Long id) {
		return weeksSemestrRepository.existsById(id);
	}

}
