package com.vstu.service.impl;

import java.util.Collections;
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
import com.vstu.service.interfaces.NodeService;
import com.vstu.service.interfaces.SemestrService;

/**
 * service for work with semester table
 * 
 */
@Service
public class SemestrServiceImpl implements SemestrService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SemestrService.class);

	@Autowired
	SemestrRepository semestrRepository;

	@Autowired
	NodeService nodeService;

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

	

	@Override
	public int sumAllHoursById(Long id) {
		Semestr s = getSemestrById(id);

		return s.getCourceWorkHours() + s.getDiplomHour() + s.getPractice() + s.getLaboratory() + s.getLecture()
				+ s.getSeminar();
	}

	/**
	 * updating list semestr with node id
	 */
	@Override
	public List<Semestr> updateListSemestrByNodeId(Long id, List<Semestr> s) {
		
		if(!nodeService.existsNode(id)) {
			LOGGER.error("Node with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Node with Id:" + id + " wasn't found!");
		}
		Node n = nodeService.getNodeById(id);
		if(!s.isEmpty()) {
			for (Semestr semestr : s) {
				semestr.setNode(n);
			}
			List<Semestr> lst = semestrRepository.saveAll(s);
			LOGGER.info("List of semesters has been updated in node with id: " + lst.get(0).getNode().getId());
			return lst;
		}

		return Collections.emptyList();
		

		
	}

	/**
	 * adding list of semesters with node id
	 */
	@Override
	public List<Semestr> addListSemestrByNodeId(Long id, List<Semestr> s) {
		
		if(!nodeService.existsNode(id)) {
			LOGGER.error("Node with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Node with Id:" + id + " wasn't found!");
		}
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
