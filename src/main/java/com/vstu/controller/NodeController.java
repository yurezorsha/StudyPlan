package com.vstu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vstu.entity.Node;
import com.vstu.service.interfaces.INodeService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class NodeController {

	@Autowired
	INodeService nodeService;

	@GetMapping("node/{id}")
	public ResponseEntity<Node> getNodeById(@PathVariable("id") Long id) {
		Node n = nodeService.getNodeById(id);
		return new ResponseEntity<Node>(n, HttpStatus.OK);
	}

	@GetMapping("nodes/{id}")
	public ResponseEntity<List<Node>> getAllPlanId(@PathVariable("id") Long id) {
		List<Node> list = nodeService.getAllByPlanId(id);
		return new ResponseEntity<List<Node>>(list, HttpStatus.OK);
	}

	@GetMapping("node")
	public ResponseEntity<List<Node>> getAllNode() {
		List<Node> list = nodeService.getAllNode();
		return new ResponseEntity<List<Node>>(list, HttpStatus.OK);
	}

	@PostMapping("node/{id}")
	public ResponseEntity<Node> addNode(@PathVariable("id") Long id, @RequestBody Node n) {
		Node node = nodeService.addNode(id, n);
		return new ResponseEntity<Node>(node, HttpStatus.CREATED);
	}

	@PutMapping("node/{id}")
	public ResponseEntity<Node> updateNode(@PathVariable("id") Long id, @RequestBody Node n) {
		nodeService.updateNode(id, n);
		return new ResponseEntity<Node>(n, HttpStatus.OK);

	}

	@DeleteMapping("node/{id}")
	public ResponseEntity<Void> deleteNode(@PathVariable("id") Long id) {
		nodeService.deleteNode(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
