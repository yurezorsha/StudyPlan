package com.vstu.service.impl;

import java.util.List;

import com.vstu.entity.Plan;
import com.vstu.entity.data.GroupDTO;
import com.vstu.service.interfaces.PlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Groups;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.GroupsRepository;
import com.vstu.service.interfaces.GroupService;

/**
 * service for work with groups table
 */
@Service
public class GroupServiceImpl implements GroupService {
	private static final Logger LOGGER = LoggerFactory.getLogger(GroupServiceImpl.class);

	@Autowired
	private GroupsRepository groupRepository;

	@Autowired
	private PlanService planService;


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
		if (!existsGroups(id)) {
			LOGGER.error("Groups with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Groups with Id: " + id + " wasn't found!");
		}

		return groupRepository.findById(id).get();
	}

	@Override
	public Groups addGroups(GroupDTO groupDTO) {
		Plan plan = planService.getPlanById(groupDTO.getIdPlan());
		Groups groups = new Groups();
		groups.setCountStudents(groupDTO.getCountStudents());
		groups.setPlan(plan);
		groups= groupRepository.save(groups);
		LOGGER.info("Groups with Id: " + groups.getId() + " has been added!");
		return groups;
	}


	@Override
	public Groups updateGroups(Groups g) {
		if (!existsGroups(g.getId())) {
			LOGGER.error("Groups with Id: " + g.getId() + " wasn't found!");
			throw new EntityNotFoundException("Groups with Id: " + g.getId() + " wasn't found!");
		}

		Groups groups = groupRepository.save(g);
		LOGGER.info("Groups with Id: " + groups.getId() + " has been updated!");
		return groups;

	}

	@Override
	public void deleteGroups(Long id) {
		if (!existsGroups(id)) {
			LOGGER.error("Groups with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("Groups with Id: " + id + " wasn't found!");
		}

		groupRepository.deleteById(id);
		LOGGER.info("Groups with Id: " + id + " has been updated!");

	}

	@Override
	public boolean existsGroups(Long id) {
		return groupRepository.existsById(id);
	}

}
