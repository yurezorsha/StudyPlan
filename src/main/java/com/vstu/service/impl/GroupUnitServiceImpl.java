package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.GroupUnit;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.GroupUnitRepository;
import com.vstu.service.interfaces.GroupUnitService;

/**
 * service for work with group_units table
 */
@Service
public class GroupUnitServiceImpl implements GroupUnitService {
	private static final Logger LOGGER = LoggerFactory.getLogger(GroupUnitServiceImpl.class);

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
		if (!existsGroupUnit(id)) {
			LOGGER.error("GroupUnit with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("GroupUnit with Id:" + id + " wasn't found!");
		}

		return groupUnitRepository.findById(id).get();
	}

	@Override
	public GroupUnit addGroupUnit(GroupUnit g) {
		if (groupUnitRepository.existsByName(g.getName())) {
			LOGGER.error("GroupUnit with name: " + g.getName() + " already exists!");
			throw new AlreadyExistException("GroupUnit with name: " + g.getName() + " already exists!");
		}
		GroupUnit groupUnit = groupUnitRepository.save(g);
		LOGGER.info(" GroupUnit with id: " + groupUnit.getId() + " has been added!");
		return groupUnit;
	}

	@Override
	public GroupUnit updateGroupUnit(GroupUnit g) {
		if (!existsGroupUnit(g.getId())) {
			LOGGER.error("GroupUnit with Id:" + g.getId() + " wasn't found!");
			throw new EntityNotFoundException("GroupUnit with Id:" + g.getId() + " wasn't found!");
		}
		GroupUnit groupUnit = groupUnitRepository.save(g);
		LOGGER.info(" GroupUnit with id: " + groupUnit.getId() + " has been updated!");
		return groupUnit;

	}

	@Override
	public void deleteGroupUnit(Long id) {
		if (!existsGroupUnit(id)) {
			LOGGER.error("GroupUnit with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("GroupUnit with Id:" + id + " wasn't found!");
		}

		groupUnitRepository.deleteById(id);
		LOGGER.info(" GroupUnit with id: " + id + " has been deleted!");

	}

	@Override
	public boolean existsGroupUnit(Long id) {
		return groupUnitRepository.existsById(id);
	}

}
