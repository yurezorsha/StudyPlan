package com.vstu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the node database table.
 * 
 */
@Entity
public class Node implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "id_cathedra")
	private int idCathedra;

	// bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name = "id_subject")
	private Subject subject;

	// bi-directional many-to-one association to Plan
	@ManyToOne
	@JoinColumn(name = "id_plan")
	@JsonIgnore
	private Plan plan;

	// bi-directional many-to-one association to Semestr
	@OneToMany(mappedBy = "node")
	private List<Semestr> semestrs;

	public Node() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCathedra() {
		return this.idCathedra;
	}

	public void setIdCathedra(int idCathedra) {
		this.idCathedra = idCathedra;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public List<Semestr> getSemestrs() {
		return this.semestrs;
	}

	public void setSemestrs(List<Semestr> semestrs) {
		this.semestrs = semestrs;
	}

}