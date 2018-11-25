package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.GroupComponent;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.GroupComponentRepository;
import com.vstu.service.interfaces.GroupComponentService;

@Service
public class GroupComponentServiceImpl implements GroupComponentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(GroupComponentServiceImpl.class);

	@Autowired
	GroupComponentRepository groupComponentRepository;

	@Override
	public List<GroupComponent> getAllGroupComponent() {

		return groupComponentRepository.findAll();
	}

	@Override
	public GroupComponent getGroupComponentById(Long id) {
		if (!existsGroupComponent(id)) {
			LOGGER.error("GroupComponent with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("GroupComponent with Id:" + id + " wasn't found!");
		}

		return groupComponentRepository.findById(id).get();
	}

	@Override
	public GroupComponent addGroupComponent(GroupComponent g) {
		if (groupComponentRepository.existsByName(g.getName())) {
			LOGGER.error("GroupComponent with name: " + g.getName() + " already exists!");
			throw new AlreadyExistException("GroupComponent with name: " + g.getName() + " already exists!");
		}

		GroupComponent groupComponent = groupComponentRepository.save(g);
		;
		LOGGER.info("GroupComponent with id: " + groupComponent.getId() + " has been added!");
		return groupComponent;

	}

	@Override
	public GroupComponent updateGroupComponent(GroupComponent g) {
		if (!existsGroupComponent(g.getId())) {
			LOGGER.error("GroupComponent with Id: " + g.getId() + " wasn't found!");
			throw new EntityNotFoundException("GroupComponent with Id:" + g.getId() + " wasn't found!");
		}

		GroupComponent groupComponent = groupComponentRepository.save(g);
		;
		LOGGER.info("GroupComponent with id: " + groupComponent.getId() + " has been updated!");
		return groupComponent;

	}

	@Override
	public void deleteGroupComponent(Long id) {
		if (!existsGroupComponent(id)) {
			LOGGER.error("GroupComponent with Id: " + id + " already exists!");
			throw new EntityNotFoundException("GroupComponent with Id:" + id + " wasn't found!");
		}

		groupComponentRepository.deleteById(id);
		LOGGER.info("GroupComponent with id: " + id + " has been deleted!");

	}

	@Override
	public boolean existsGroupComponent(Long id) {

		return groupComponentRepository.existsById(id);
	}

}
