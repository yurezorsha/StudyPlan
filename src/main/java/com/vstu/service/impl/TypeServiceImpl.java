package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Type;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.TypeRepository;
import com.vstu.service.interfaces.TypeService;

/**
 * service for work with table type
 */
@Service
public class TypeServiceImpl implements TypeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TypeServiceImpl.class);

	@Autowired
	TypeRepository typeRepository;

	@Override
	public List<Type> getAllType() {

		return typeRepository.findAll();
	}

	@Override
	public Type getTypeById(Long id) {
		if (!existsType(id)) {
			LOGGER.error("Type with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("Type with Id: " + id + " wasn't found!");
		}

		return typeRepository.findById(id).get();
	}

	@Override
	public Type addType(Type t) {
		if (existsType(t.getId())) {
			LOGGER.error("Type with Id: " + t.getId() + " already exists!");
			throw new AlreadyExistException("Type with Id: " + t.getId() + " already exists!");
		}

		Type type = typeRepository.save(t);
		LOGGER.info("Type with id: " + type.getId() + " has been added!");
		return type;
	}

	@Override
	public Type updateType(Type t) {
		if (!existsType(t.getId())) {
			LOGGER.error("Type with Id: " + t.getId() + " wasn't found!");
			throw new EntityNotFoundException("Type with Id: " + t.getId() + " wasn't found!");
		}

		Type type = typeRepository.save(t);
		LOGGER.info("Type with id: " + type.getId() + " has been updated!");
		return type;

	}

	@Override
	public void deleteType(Long id) {
		if (!existsType(id)) {
			LOGGER.error("Type with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("Type with Id: " + id + " wasn't found!");
		}

		typeRepository.deleteById(id);
		LOGGER.info("Type with id: " + id + " has been deleted!");

	}

	@Override
	public boolean existsType(Long id) {
		return typeRepository.existsById(id);
	}

}
