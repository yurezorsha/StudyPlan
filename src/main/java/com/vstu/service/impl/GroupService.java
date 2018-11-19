package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Groups;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.GroupsRepository;
import com.vstu.service.interfaces.IGroupService;

@Service
public class GroupService implements IGroupService {

	@Autowired
	GroupsRepository groupRepository;

	@Override
	public List<Groups> getAllGroups() {
		return groupRepository.findAll();
	}

	@Override
	public List<Groups> getAllByPlanId(Long id) {
		return groupRepository.findAllByPlanId(id);
	}

	@Override
	public Groups getGroupsById(Long id) {
		if (!existsGroups(id))
			throw new EntityNotFoundException("Groups with Id: " + id + " wasn't found!");

		return groupRepository.findById(id).get();
	}

	@Override
	public Groups addGroups(Groups c) {
		if (existsGroups(c.getId()))
			throw new AlreadyExistException("Groups with Id: " + c.getId() + " already exists!");

		return groupRepository.save(c);
	}

	@Override
	public Groups updateGroups(Groups c) {
		if (!existsGroups(c.getId()))
			throw new EntityNotFoundException("Groups with Id: " + c.getId() + " wasn't found!");

		return groupRepository.save(c);

	}

	@Override
	public void deleteGroups(Long id) {
		if (!existsGroups(id))
			throw new EntityNotFoundException("Groups with Id: " + id + " wasn't found!");
		else
			groupRepository.deleteById(id);

	}

	@Override
	public boolean existsGroups(Long id) {
		return groupRepository.existsById(id);
	}

}
