package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Node;
import com.vstu.entity.Semestr;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.SemestrRepository;
import com.vstu.service.interfaces.ISemestrService;

@Service
public class SemestrService implements ISemestrService {
	@Autowired
	SemestrRepository semestrRepository;

	@Autowired
	NodeService nodeServide;

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

		return semestrRepository.findById(id).get();
	}

	@Override
	public Semestr addSemestr(Semestr s) {

		if (semestrRepository.existsByNumberAndPlanId(s.getNumber(), s.getNode().getId())) {
			throw new AlreadyExistException("Semestr with number: " + s.getNumber()
					+ " already exists in node with id: " + s.getNode().getId());
		} else {

			semestrRepository.save(s);
		}
		return s;

	}

	@Override
	public void updateSemestr(Long id, Semestr s) {
		Node n = nodeServide.getNodeById(id);
		if (semestrRepository.existsById(s.getId())) {
			s.setNode(n);
			semestrRepository.save(s);
		} else
			throw new EntityNotFoundException("Semestr with Id:" + s.getId() + " wasn't found!");
	}

	@Override
	public void deleteSemestr(Long id) {
		if (semestrRepository.existsById(id))
			semestrRepository.deleteById(id);
		else
			throw new EntityNotFoundException("Semestr with Id:" + id + " wasn't found!");

	}

	@Override
	public boolean existsSemestr(Long id) {
		return semestrRepository.existsById(id);
	}

	@Override
	public List<Semestr> addListSemestr(Long id, List<Semestr> s) {
		Node n = nodeServide.getNodeById(id);
		for (Semestr semestr : s) {
			semestr.setNode(n);
			if (semestrRepository.existsByNumberAndPlanId(semestr.getNumber(), n.getId())) {
				throw new AlreadyExistException("Semestr with number: " + semestr.getNumber()
						+ " already exists in node with id: " + n.getId());
			}
		}
		return semestrRepository.saveAll(s);
	}

}
