package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Groups;
import com.vstu.entity.data.GroupDTO;

public interface GroupService {

	List<Groups> getAllGroups();

	List<Groups> getAllByPlanId(Long id);

	Groups getGroupsById(Long id);

	Groups addGroups(GroupDTO groupDTO);

	Groups updateGroups(Groups gr);

	void deleteGroups(Long id);

	boolean existsGroups(Long id);

}
