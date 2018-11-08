package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Type;
import com.vstu.repository.TypeRepository;
import com.vstu.service.interfaces.ITypeService;

@Service
public class TypeService implements ITypeService {
	@Autowired
	TypeRepository typeRepository;

	@Override
	public List<Type> getAllType() {

		return typeRepository.findAll();
	}

	@Override
	public Type getTypeById(Long id) {

		return typeRepository.findById(id).get();
	}

	@Override
	public boolean addType(Type t) {
		if (typeRepository.existsById(t.getId())) {
			return false;
		} else {
			typeRepository.save(t);
			return true;
		}
	}

	@Override
	public void updateType(Type t) {
		typeRepository.save(t);

	}

	@Override
	public void deleteType(Long id) {
		typeRepository.deleteById(id);

	}

	@Override
	public boolean existsType(Long id) {
		return typeRepository.existsById(id);
	}

}
