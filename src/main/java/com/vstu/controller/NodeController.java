package com.vstu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.util.UriComponentsBuilder;

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

	@PostMapping("node")
	public ResponseEntity<Void> addNode(@RequestBody Node n, UriComponentsBuilder builder) {
		boolean flag = nodeService.addNode(n);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/node/{id}").buildAndExpand(n.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("node")
	public ResponseEntity<Node> updateNode(@RequestBody Node n) {
		if (nodeService.existsNode(n.getId())) {
			nodeService.updateNode(n);
			return new ResponseEntity<Node>(n, HttpStatus.OK);
		} else {
			n = null;
			return new ResponseEntity<Node>(n, HttpStatus.CONFLICT);

		}
	}

	@DeleteMapping("node/{id}")
	public ResponseEntity<Void> deleteNode(@PathVariable("id") Long id) {
		if (nodeService.existsNode(id)) {
			nodeService.deleteNode(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}
	}

}
