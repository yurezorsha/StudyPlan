package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Node;
import com.vstu.entity.Plan;
import com.vstu.entity.Semestr;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.NodeRepository;
import com.vstu.service.interfaces.NodeService;
import com.vstu.service.interfaces.SemestrService;

/**
 * service for work with node table
 * 
 */
@Service
public class NodeServiceImpl implements NodeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(NodeServiceImpl.class);

	@Autowired
	NodeRepository nodeRepository;

	@Autowired
	PlanServiceImpl planService;

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
		if (!existsNode(id)) {
			LOGGER.error("Node with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Node with Id:" + id + " wasn't found!");
		}

		return nodeRepository.findById(id).get();
	}

	@Override
	public List<Node> addListNodesByPlanId(Long id, List<Node> nodes) {
		Plan p = planService.getPlanById(id);
		/*if (nodeRepository.findBySubjectNameAndPlanId(p.getId(), n.getSubject().getName()) != null) {
			LOGGER.error("Node with subject: " + n.getSubject().getName() + " already exists in plan with Id: "
					+ id);

			throw new AlreadyExistException("Node with subject: " + n.getSubject().getName()
					+ " already exists in plan with Id: " + id);
		} else {*/
			for(Node node: nodes) {
				node.setPlan(p);
				node = nodeRepository.save(node);
				semestrService.addListSemestrByNodeId(node.getId(), node.getSemestrs());
			}


		//}
		//LOGGER.info("Node with id: " + n.getId() + " has been added in plan with id: " + n.getPlan().getId());

		return nodes;
	}

	/**
	 * adding node with plan id
	 */
	@Override
	public Node addNode(Long id, Node n) {
		Plan p = planService.getPlanById(id);
		if (nodeRepository.findBySubjectNameAndPlanId(p.getId(), n.getSubject().getName()) != null) {
			LOGGER.error("Node with subject: " + n.getSubject().getName() + " already exists in plan with Id: "
					+ id);

			throw new AlreadyExistException("Node with subject: " + n.getSubject().getName()
					+ " already exists in plan with Id: " + id);
		} else {
			n.setPlan(p);
			n = nodeRepository.save(n);
			semestrService.addListSemestrByNodeId(n.getId(), n.getSemestrs());

		}
		LOGGER.info("Node with id: " + n.getId() + " has been added in plan with id: " + n.getPlan().getId());

		return n;
	}

	/**
	 * updating node with plan id
	 */
	@Override
	public Node updateNode(Long id, Node n) {
		if (!existsNode(n.getId())) {
			LOGGER.error("Node with Id:" + n.getId() + " wasn't found!");
			throw new EntityNotFoundException("Node with Id:" + n.getId() + " wasn't found!");
		} else {

			Plan p = planService.getPlanById(id);
			n.setPlan(p);
			semestrService.updateListSemestrByNodeId(n.getId(), n.getSemestrs());
			n = nodeRepository.save(n);
		}

		LOGGER.info("Node with Id:" + n.getId() + " has been updated in plan with id: " + n.getPlan().getId() + "!");

		return n;
	}

	@Override
	public void deleteNode(Long id) {
		if (!existsNode(id)) {
			LOGGER.error("Node with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Node with Id:" + id + " wasn't found!");
		}

		nodeRepository.deleteById(id);
		LOGGER.info("Node with Id:" + id + " has been deleted!");

	}

	@Override
	public boolean existsNode(Long id) {
		return nodeRepository.existsById(id);
	}

}
