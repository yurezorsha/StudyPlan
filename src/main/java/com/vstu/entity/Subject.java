package com.vstu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the subject database table.
 * 
 */
@Entity
@NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;

	/*@OneToOne(mappedBy="semestr")
	private Semestr semestr;*/
	
	private String name;

	private String shifr;
	
	

	// bi-directional many-to-one association to Node
	@OneToMany(mappedBy = "subject")
	@JsonIgnore
	private List<Node> nodes;

	// bi-directional many-to-one association to StudyProgramm
	@OneToMany(mappedBy = "subject")
	@JsonIgnore
	private List<StudyProgramm> studyProgramms;

	// bi-directional many-to-one association to SubCompetence
	@OneToMany(mappedBy = "subject")
	@JsonIgnore
	private List<SubCompetence> subCompetences;

	// bi-directional many-to-one association to GroupUnit
	@ManyToOne
	@JoinColumn(name = "id_unit")
	private GroupUnit groupUnit;
	
	

	public Subject() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShifr() {
		return this.shifr;
	}

	public void setShifr(String shifr) {
		this.shifr = shifr;
	}

	public List<Node> getNodes() {
		return this.nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<StudyProgramm> getStudyProgramms() {
		return this.studyProgramms;
	}

	public void setStudyProgramms(List<StudyProgramm> studyProgramms) {
		this.studyProgramms = studyProgramms;
	}

	public List<SubCompetence> getSubCompetences() {
		return this.subCompetences;
	}

	public void setSubCompetences(List<SubCompetence> subCompetences) {
		this.subCompetences = subCompetences;
	}

	public GroupUnit getGroupUnit() {
		return this.groupUnit;
	}

	public void setGroupUnit(GroupUnit groupUnit) {
		this.groupUnit = groupUnit;
	}


	
	

}