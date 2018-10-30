package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.GroupUnit;
import com.vstu.repository.GroupUnitRepository;
import com.vstu.service.interfaces.IGroupUnitService;

@Service
public class GroupUnitService implements IGroupUnitService {
	@Autowired
	GroupUnitRepository groupUnitRepository;

	@Override
	public List<GroupUnit> getAllGroupUnit() {

		return groupUnitRepository.findAll();
	}

	@Override
	public List<GroupUnit> getAllByGroupComponentId(Long id) {

		return groupUnitRepository.findAllByGroupComponentId(id);
	}

	@Override
	public GroupUnit getGroupUnitById(Long idGr) {

		return groupUnitRepository.findById(idGr).get();
	}

	@Override
	public boolean addGroupUnit(GroupUnit g) {
		if (groupUnitRepository.existsById(g.getId())) {
			return false;
		} else {
			groupUnitRepository.save(g);
			return true;
		}
	}

	@Override
	public void updateGroupUnit(GroupUnit g) {
		groupUnitRepository.save(g);

	}

	@Override
	public void deleteGroupUnit(Long idGr) {
		groupUnitRepository.deleteById(idGr);

	}

	@Override
	public boolean existsGroupUnit(Long idGr) {
		return groupUnitRepository.existsById(idGr);
	}

}
