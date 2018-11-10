package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Node;

public interface INodeService {
	List<Node> getAllNode();

	List<Node> getAllByPlanId(Long id);

	Node getNodeById(Long id);

	Node addNode(Node n);

	void updateNode(Node n);

	void deleteNode(Long id);

	boolean existsNode(Long id);

}
