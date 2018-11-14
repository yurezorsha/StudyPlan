package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Groups;

public interface IGroupService {

	List<Groups> getAllGroups();

	List<Groups> getAllByPlanId(Long id);

	Groups getGroupsById(Long id);

	Groups addGroups(Groups gr);

	Groups updateGroups(Groups gr);

	void deleteGroups(Long id);

	boolean existsGroups(Long id);

}
