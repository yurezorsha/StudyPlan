package com.vstu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

/**
 * The persistent class for the competence database table.
 * 
 */
@Entity
public class Competence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String code;
    @Length(max = 500)
	private String nameCompetence;

	// bi-directional many-to-one association to SubCompetence
	@OneToMany(mappedBy = "competence")
	@JsonIgnore
	private List<SubCompetence> subCompetences;

	public Competence() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNameCompetence() {
		return this.nameCompetence;
	}

	public void setNameCompetence(String nameCompetence) {
		this.nameCompetence = nameCompetence;
	}

	public List<SubCompetence> getSubCompetences() {
		return this.subCompetences;
	}

	public void setSubCompetences(List<SubCompetence> subCompetences) {
		this.subCompetences = subCompetences;
	}

}