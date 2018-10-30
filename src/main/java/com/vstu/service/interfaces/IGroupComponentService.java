package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.GroupComponent;

public interface IGroupComponentService {
	List<GroupComponent> getAllGroupComponent();

	GroupComponent getGroupComponentById(Long idGr);

	boolean addGroupComponent(GroupComponent g);

	void updateGroupComponent(GroupComponent g);

	void deleteGroupComponent(Long idGr);

	boolean existsGroupComponent(Long idGr);
}
