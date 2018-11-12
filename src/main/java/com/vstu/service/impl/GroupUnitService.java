package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.GroupUnit;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
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
	public GroupUnit getGroupUnitById(Long id) {

		return groupUnitRepository.findById(id).get();
	}

	@Override
	public GroupUnit addGroupUnit(GroupUnit g) {
		if (groupUnitRepository.existsByName(g.getName())) {
			throw new AlreadyExistException("GroupUnit with name: " + g.getName() + " already exists!");
		} else {
			groupUnitRepository.save(g);
		}

		return g;
	}

	@Override
	public void updateGroupUnit(GroupUnit g) {
		if (groupUnitRepository.existsById(g.getId()))
			groupUnitRepository.save(g);
		else
			throw new EntityNotFoundException("GroupUnit with Id:" + g.getId() + " wasn't found!");

	}

	@Override
	public void deleteGroupUnit(Long id) {
		if (groupUnitRepository.existsById(id))
			groupUnitRepository.deleteById(id);
		else
			throw new EntityNotFoundException("GroupUnit with Id:" + id + " wasn't found!");

	}

	@Override
	public boolean existsGroupUnit(Long id) {
		return groupUnitRepository.existsById(id);
	}

}
