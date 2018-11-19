package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Type;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
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
		if (!existsType(id))
			throw new EntityNotFoundException("Type with Id: " + id + " wasn't found!");

		return typeRepository.findById(id).get();
	}

	@Override
	public Type addType(Type c) {
		if (!existsType(c.getId()))
			throw new AlreadyExistException("Type with Id: " + c.getId() + " already exists!");

		return typeRepository.save(c);
	}

	@Override
	public Type updateType(Type c) {
		if (!existsType(c.getId()))
			throw new EntityNotFoundException("Type with Id: " + c.getId() + " wasn't found!");

		return typeRepository.save(c);

	}

	@Override
	public void deleteType(Long id) {
		if (!existsType(id))
			throw new EntityNotFoundException("Type with Id: " + id + " wasn't found!");
		else
			typeRepository.deleteById(id);

	}

	@Override
	public boolean existsType(Long id) {
		return typeRepository.existsById(id);
	}

}
