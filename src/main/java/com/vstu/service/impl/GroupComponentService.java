package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.GroupComponent;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.GroupComponentRepository;
import com.vstu.service.interfaces.IGroupComponentService;

@Service
public class GroupComponentService implements IGroupComponentService {
	@Autowired
	GroupComponentRepository groupComponentRepository;

	@Override
	public List<GroupComponent> getAllGroupComponent() {

		return groupComponentRepository.findAll();
	}

	@Override
	public GroupComponent getGroupComponentById(Long id) {

		return groupComponentRepository.findById(id).get();
	}

	@Override
	public GroupComponent addGroupComponent(GroupComponent g) {
		if (groupComponentRepository.existsByName(g.getName())) {
			throw new AlreadyExistException("GroupComponent with name: " + g.getName() + " already exists!");
		} else {
			groupComponentRepository.save(g);

		}

		return g;

	}

	@Override
	public void updateGroupComponent(GroupComponent g) {
		if (groupComponentRepository.existsById(g.getId()))
			groupComponentRepository.save(g);
		else
			throw new EntityNotFoundException("GroupComponent with Id:" + g.getId() + " wasn't found!");

	}

	@Override
	public void deleteGroupComponent(Long id) {
		if (groupComponentRepository.existsById(id))
			groupComponentRepository.deleteById(id);
		else
			throw new EntityNotFoundException("GroupComponent with Id:" + id + " wasn't found!");

	}

	@Override
	public boolean existsGroupComponent(Long id) {

		return groupComponentRepository.existsById(id);
	}

}
