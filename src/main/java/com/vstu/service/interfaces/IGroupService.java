package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Group;

public interface IGroupService {
	
	List<Group> getAllGroup();

	List<Group> getAllByPlanId(Long id);

	Group getGroupById(Long id);

	boolean addGroup(Group gr);

	void updateGroup(Group gr);

	void deleteGroup(Long id);

	boolean existsGroup(Long id);

}
