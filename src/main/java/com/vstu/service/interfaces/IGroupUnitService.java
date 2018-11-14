package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.GroupUnit;

public interface IGroupUnitService {
	List<GroupUnit> getAllGroupUnit();

	List<GroupUnit> getAllByGroupComponentId(Long id);

	GroupUnit getGroupUnitById(Long id);

	GroupUnit addGroupUnit(GroupUnit g);

	GroupUnit updateGroupUnit(GroupUnit g);

	void deleteGroupUnit(Long id);

	boolean existsGroupUnit(Long id);

}
