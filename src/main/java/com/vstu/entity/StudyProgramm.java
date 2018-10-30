package com.vstu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the study_programm database table.
 * 
 */
@Entity
@Table(name = "study_programm")
@NamedQuery(name = "StudyProgramm.findAll", query = "SELECT s FROM StudyProgramm s")
public class StudyProgramm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_approve")
	private Date dateApprove;

	// bi-directional many-to-one association to CreatorStudyProgramm
	@OneToMany(mappedBy = "studyProgramm")
	@JsonIgnore
	private List<CreatorStudyProgramm> creatorStudyProgramms;

	// bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name = "id_subject")
	private Subject subject;

	public StudyProgramm() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateApprove() {
		return this.dateApprove;
	}

	public void setDateApprove(Date dateApprove) {
		this.dateApprove = dateApprove;
	}

	public List<CreatorStudyProgramm> getCreatorStudyProgramms() {
		return this.creatorStudyProgramms;
	}

	public void setCreatorStudyProgramms(List<CreatorStudyProgramm> creatorStudyProgramms) {
		this.creatorStudyProgramms = creatorStudyProgramms;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}