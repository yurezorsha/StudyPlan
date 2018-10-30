package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Node;
import com.vstu.repository.NodeRepository;
import com.vstu.service.interfaces.INodeService;

@Service
public class NodeService implements INodeService {
	@Autowired
	NodeRepository nodeRepository;

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

		return nodeRepository.findById(id).get();
	}

	@Override
	public boolean addNode(Node n) {
		if (nodeRepository.existsById(n.getId())) {
			return false;
		} else {
			nodeRepository.save(n);
			return true;
		}
	}

	@Override
	public void updateNode(Node n) {
		nodeRepository.save(n);

	}

	@Override
	public void deleteNode(Long id) {
		nodeRepository.deleteById(id);

	}

	@Override
	public boolean existsNode(Long id) {
		return nodeRepository.existsById(id);
	}

}
