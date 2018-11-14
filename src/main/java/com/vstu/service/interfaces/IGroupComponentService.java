package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.GroupComponent;

public interface IGroupComponentService {
	List<GroupComponent> getAllGroupComponent();

	GroupComponent getGroupComponentById(Long id);

	GroupComponent addGroupComponent(GroupComponent g);

	GroupComponent updateGroupComponent(GroupComponent g);

	void deleteGroupComponent(Long id);

	boolean existsGroupComponent(Long id);
}
