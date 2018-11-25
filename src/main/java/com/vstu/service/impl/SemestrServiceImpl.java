package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Node;
import com.vstu.entity.Semestr;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.SemestrRepository;
import com.vstu.service.interfaces.SemestrService;

/**
 * service for work with semester table
 * 
 */
@Service
public class SemestrServiceImpl implements SemestrService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SemestrServiceImpl.class);

	@Autowired
	SemestrRepository semestrRepository;

	@Autowired
	NodeServiceImpl nodeService;

	@Override
	public List<Semestr> getAllSemestr() {

		return semestrRepository.findAll();
	}

	@Override
	public List<Semestr> getAllByNodeId(Long id) {

		return semestrRepository.findAllByNodeId(id);
	}

	@Override
	public Semestr getSemestrById(Long id) {
		if (!existsSemestr(id)) {
			LOGGER.error("Semestr with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Semestr with Id:" + id + " wasn't found!");
		}

		return semestrRepository.findById(id).get();
	}

	/**
	 * adding semestr with node id
	 */
	@Override
	public Semestr addSemestr(Long id, Semestr s) {

		if (semestrRepository.existsByNumberAndNodeId(s.getNumber(), id)) {

			LOGGER.error("Semestr with number: " + s.getNumber() + " already exists in node with id: "
					+ s.getNode().getId());

			throw new AlreadyExistException("Semestr with number: " + s.getNumber()
					+ " already exists in node with id: " + s.getNode().getId());
		}

		Node node = nodeService.getNodeById(id);
		s.setNode(node);
		Semestr semestr = semestrRepository.save(s);
		LOGGER.info("Semestr with number: " + semestr.getNumber() + " has been added in node with id: "
				+ semestr.getNode().getId());

		return semestr;

	}

	/**
	 * updating semestr with node id
	 */
	@Override
	public Semestr updateSemestr(Long id, Semestr s) {
		if (!existsSemestr(s.getId())) {
			LOGGER.error("Semestr with Id:" + s.getId() + " wasn't found!");
			throw new EntityNotFoundException("Semestr with Id:" + s.getId() + " wasn't found!");
		}

		Node n = nodeService.getNodeById(id);
		s.setNode(n);
		Semestr semestr = semestrRepository.save(s);
		LOGGER.info("Semestr with number: " + semestr.getNumber() + " has been updated in node with id: "
				+ semestr.getNode().getId());
		return semestr;

	}

	@Override
	public void deleteSemestr(Long id) {
		if (!existsSemestr(id)) {
			LOGGER.error("Semestr with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Semestr with Id:" + id + " wasn't found!");
		}

		LOGGER.info("Semestr with Id:" + id + " has been deleted");
		semestrRepository.deleteById(id);

	}

	@Override
	public boolean existsSemestr(Long id) {
		return semestrRepository.existsById(id);
	}

	/**
	 * adding list of semesters with node id
	 */
	@Override
	public List<Semestr> addListSemestr(Long id, List<Semestr> s) {
		Node n = nodeService.getNodeById(id);
		for (Semestr semestr : s) {
			semestr.setNode(n);
			if (semestrRepository.existsByNumberAndNodeId(semestr.getNumber(), n.getId())) {
				LOGGER.error("Semestr with number: " + semestr.getNumber() + " already exists in node with id: "
						+ n.getId());
				throw new AlreadyExistException("Semestr with number: " + semestr.getNumber()
						+ " already exists in node with id: " + n.getId());
			}
		}
		List<Semestr> lst = semestrRepository.saveAll(s);
		LOGGER.info("List of semesters has been added in node with id: " + lst.get(0).getNode().getId());
		return lst;
	}

}
