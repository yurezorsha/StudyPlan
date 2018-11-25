package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Type;

public interface TypeService {
	List<Type> getAllType();

	Type getTypeById(Long id);

	Type addType(Type t);

	Type updateType(Type t);

	void deleteType(Long id);

	boolean existsType(Long id);

}
