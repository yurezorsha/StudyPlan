package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.GroupComponent;
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
	public GroupComponent getGroupComponentById(Long idGr) {

		return groupComponentRepository.findById(idGr).get();
	}

	@Override
	public boolean addGroupComponent(GroupComponent g) {
		if (groupComponentRepository.existsById(g.getId())) {
			return false;
		} else {
			groupComponentRepository.save(g);
			return true;
		}

	}

	@Override
	public void updateGroupComponent(GroupComponent g) {
		groupComponentRepository.save(g);

	}

	@Override
	public void deleteGroupComponent(Long idGr) {

		groupComponentRepository.deleteById(idGr);

	}

	@Override
	public boolean existsGroupComponent(Long idGr) {

		return groupComponentRepository.existsById(idGr);
	}

}
