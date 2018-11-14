package com.vstu.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the sub_competence database table.
 * 
 */
@Entity
@Table(name = "sub_competence")
public class SubCompetence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// bi-directional many-to-one association to Competence
	@ManyToOne
	@JoinColumn(name = "id_competence")
	private Competence competence;

	// bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name = "id_subject")
	private Subject subject;

	public SubCompetence() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Competence getCompetence() {
		return this.competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}