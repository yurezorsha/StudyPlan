package com.vstu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the creator_study_programm database table.
 * 
 */
@Entity
@Table(name = "creator_study_programm")
public class CreatorStudyProgramm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "id_teacher")
	private int idTeacher;

	// bi-directional many-to-one association to StudyProgramm
	@ManyToOne
	@JoinColumn(name = "id_study_programm")
	private StudyProgramm studyProgramm;

	public CreatorStudyProgramm() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIdTeacher() {
		return this.idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	public StudyProgramm getStudyProgramm() {
		return this.studyProgramm;
	}

	public void setStudyProgramm(StudyProgramm studyProgramm) {
		this.studyProgramm = studyProgramm;
	}

}