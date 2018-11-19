package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Node;
import com.vstu.entity.Plan;
import com.vstu.entity.Semestr;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.NodeRepository;
import com.vstu.service.interfaces.INodeService;

@Service
public class NodeService implements INodeService {
	@Autowired
	NodeRepository nodeRepository;

	@Autowired
	PlanService planService;

	@Autowired
	SemestrService semestrService;

	@Override
	public List<Node> getAllNode() {

		return nodeRepository.findAll();
	}

	@Override
	public List<Node> getAllByPlanId(Long id) {

		return nodeRepository.findAllByPlanId(id);
	}

	@Override
	public Node getNodeById(Long id) {
		if (!existsNode(id))
			throw new EntityNotFoundException("Node with Id:" + id + " wasn't found!");

		return nodeRepository.findById(id).get();
	}

	@Override
	public Node addNode(Long id, Node n) {
		Plan p = planService.getPlanById(id);
		if (nodeRepository.findBySubjectNameAndPlanId(p.getId(), n.getSubject().getName()) != null) {
			throw new AlreadyExistException("Node with subject: " + n.getSubject().getName()
					+ " already exists in plan with Id: " + n.getPlan().getId());
		} else {
			n.setPlan(p);
			n = nodeRepository.save(n);
			semestrService.addListSemestr(n.getId(), n.getSemestrs());

		}

		return n;
	}

	@Override
	public Node updateNode(Long id, Node n) {
		if (!existsNode(n.getId()))
			throw new EntityNotFoundException("Node with Id:" + n.getId() + " wasn't found!");

		Plan p = planService.getPlanById(id);

		n.setPlan(p);

		for (Semestr s : n.getSemestrs()) {
			semestrService.updateSemestr(n.getId(), s);
		}

		return nodeRepository.save(n);
	}

	@Override
	public void deleteNode(Long id) {
		if (!existsNode(id))
			throw new EntityNotFoundException("Node with Id:" + id + " wasn't found!");

		nodeRepository.deleteById(id);

	}

	@Override
	public boolean existsNode(Long id) {
		return nodeRepository.existsById(id);
	}

}
