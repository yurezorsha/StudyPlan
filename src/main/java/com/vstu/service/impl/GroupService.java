package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Groups;
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
		return groupRepository.findById(id).get();
	}

	@Override
	public boolean addGroups(Groups gr) {
		if (groupRepository.existsById(gr.getId())) {
			return false;
		} else {
			groupRepository.save(gr);
			return true;
		}
	}

	@Override
	public void updateGroups(Groups gr) {
		groupRepository.save(gr);

	}

	@Override
	public void deleteGroups(Long id) {
		groupRepository.deleteById(id);

	}

	@Override
	public boolean existsGroups(Long id) {
		return groupRepository.existsById(id);
	}

}
