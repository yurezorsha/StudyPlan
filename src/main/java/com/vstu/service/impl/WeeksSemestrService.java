package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.WeeksSemestr;
import com.vstu.repository.WeeksSemestrRepository;
import com.vstu.service.interfaces.IWeeksSemestrService;

@Service
public class WeeksSemestrService implements IWeeksSemestrService{
	
	@Autowired
	WeeksSemestrRepository weeksSemestrRepository;

	@Override
	public List<WeeksSemestr> getAllWeeksSemestr() {
		return weeksSemestrRepository.findAll();
	}

	@Override
	public List<WeeksSemestr> getAllByPlanId(Long id) {
		return weeksSemestrRepository.findAllByPlanId(id);
	}

	@Override
	public WeeksSemestr getWeeksSemestrById(Long id) {
		return weeksSemestrRepository.findById(id).get();
	}

	@Override
	public boolean addWeeksSemestr(WeeksSemestr w) {
		if (weeksSemestrRepository.existsById(w.getId())) {
			return false;
		} else {
			weeksSemestrRepository.save(w);
			return true;
		}
	}

	@Override
	public void updateWeeksSemestr(WeeksSemestr w) {
		weeksSemestrRepository.save(w);
		
	}

	@Override
	public void deleteWeeksSemestr(Long id) {
		weeksSemestrRepository.deleteById(id);
		
	}

	@Override
	public boolean existsWeeksSemestr(Long id) {
		return weeksSemestrRepository.existsById(id);
	}


}
