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
		if (!existsGroupUnit(id))
			throw new EntityNotFoundException("GroupUnit with Id:" + id + " wasn't found!");

		return groupUnitRepository.findById(id).get();
	}

	@Override
	public GroupUnit addGroupUnit(GroupUnit g) {
		if (groupUnitRepository.existsByName(g.getName()))
			throw new AlreadyExistException("GroupUnit with name: " + g.getName() + " already exists!");

		return groupUnitRepository.save(g);
	}

	@Override
	public GroupUnit updateGroupUnit(GroupUnit g) {
		if (!existsGroupUnit(g.getId()))
			throw new EntityNotFoundException("GroupUnit with Id:" + g.getId() + " wasn't found!");

		return groupUnitRepository.save(g);

	}

	@Override
	public void deleteGroupUnit(Long id) {
		if (!existsGroupUnit(id))
			throw new EntityNotFoundException("GroupUnit with Id:" + id + " wasn't found!");

		groupUnitRepository.deleteById(id);

	}

	@Override
	public boolean existsGroupUnit(Long id) {
		return groupUnitRepository.existsById(id);
	}

}
