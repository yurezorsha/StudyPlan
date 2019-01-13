package com.vstu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the semestr database table.
 * 
 */
@Entity
public class Semestr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int courceWorkHours;

	private int courceWorkZe;

	private String courseWorkType;

	private int idFaculty;

	private int idTeacher;

	private int laboratory;

	private int lecture;

	private int number;

	private int practice;

	private int rgr;

	private int seminar;

	@ManyToOne
	@JoinColumn(name = "id_type")
	private Type type;

	private int ze;

	private int diplomHour;

	private int diplomZe;

	// bi-directional many-to-one association to Node
	@ManyToOne
	@JoinColumn(name = "id_node")
	@JsonIgnore
	private Node node;

	// bi-directional many-to-one association to WeeksSemestr
	@OneToMany(mappedBy = "semestr")
	@JsonIgnore
	private List<WeeksSemestr> weeksSemestrs;

	public Semestr() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCourceWorkHours() {
		return this.courceWorkHours;
	}

	public void setCourceWorkHours(int courceWorkHours) {
		this.courceWorkHours = courceWorkHours;
	}

	public int getCourceWorkZe() {
		return this.courceWorkZe;
	}

	public void setCourceWorkZe(int courceWorkZe) {
		this.courceWorkZe = courceWorkZe;
	}

	public String getCourseWorkType() {
		return this.courseWorkType;
	}

	public void setCourseWorkType(String courseWorkType) {
		this.courseWorkType = courseWorkType;
	}

	public int getIdFaculty() {
		return this.idFaculty;
	}

	public void setIdFaculty(int idFaculty) {
		this.idFaculty = idFaculty;
	}

	public int getIdTeacher() {
		return this.idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	public int getLaboratory() {
		return this.laboratory;
	}

	public void setLaboratory(int laboratory) {
		this.laboratory = laboratory;
	}

	public int getLecture() {
		return this.lecture;
	}

	public void setLecture(int lecture) {
		this.lecture = lecture;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPractice() {
		return this.practice;
	}

	public void setPractice(int practice) {
		this.practice = practice;
	}

	public int getRgr() {
		return this.rgr;
	}

	public void setRgr(int rgr) {
		this.rgr = rgr;
	}

	public int getSeminar() {
		return this.seminar;
	}

	public void setSeminar(int seminar) {
		this.seminar = seminar;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getZe() {
		return this.ze;
	}

	public void setZe(int ze) {
		this.ze = ze;
	}

	public Node getNode() {
		return this.node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public int getDiplomHour() {
		return diplomHour;
	}

	public void setDiplomHour(int diplomHour) {
		this.diplomHour = diplomHour;
	}

	public int getDiplomZe() {
		return diplomZe;
	}

	public void setDiplomZe(int diplomZe) {
		this.diplomZe = diplomZe;
	}

}