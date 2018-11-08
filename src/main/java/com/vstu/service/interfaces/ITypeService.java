package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Type;

public interface ITypeService {
	List<Type> getAllType();

	Type getTypeById(Long id);

	boolean addType(Type t);

	void updateType(Type t);

	void deleteType(Long id);

	boolean existsType(Long id);

}
