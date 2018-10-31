package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Group;
import com.vstu.repository.GroupRepository;
import com.vstu.service.interfaces.IGroupService;

@Service
public class GroupService implements IGroupService {
	
	@Autowired
	GroupRepository groupRepository;

	@Override
	public List<Group> getAllGroup() {
		return groupRepository.findAll();
	}

	@Override
	public List<Group> getAllByPlanId(Long id) {
		return groupRepository.findAllByPlanId(id);
	}

	@Override
	public Group getGroupById(Long id) {		
		return groupRepository.findById(id).get();
	}

	@Override
	public boolean addGroup(Group gr) {
		if (groupRepository.existsById(gr.getId())) {
			return false;
		} else {
			groupRepository.save(gr);
			return true;
		}
	}

	@Override
	public void updateGroup(Group gr) {
		groupRepository.save(gr);
		

	}

	@Override
	public void deleteGroup(Long id) {
		groupRepository.deleteById(id);

	}

	@Override
	public boolean existsGroup(Long id) {
		return groupRepository.existsById(id);
	}

}
