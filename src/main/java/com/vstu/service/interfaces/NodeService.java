package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Node;

public interface NodeService {
	List<Node> getAllNode();

	List<Node> getAllByPlanId(Long id);

	List<Node> addListNodesByPlanId(Long id, List<Node> nodes);

	Node getNodeById(Long id);

	Node addNode(Long id, Node n);

	Node updateNode(Long id, Node n);

	void deleteNode(Long id);

	boolean existsNode(Long id);

}
