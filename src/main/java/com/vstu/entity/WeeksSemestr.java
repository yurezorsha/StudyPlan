package com.vstu.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the weeks_semestr database table.
 * 
 */
@Entity
@Table(name="weeks_semestr")
@NamedQuery(name="WeeksSemestr.findAll", query="SELECT w FROM WeeksSemestr w")
public class WeeksSemestr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="count_weeks")
	private int countWeeks;

	@Column(name="number_semestr")
	private int numberSemestr;

	//bi-directional many-to-one association to Plan
	@ManyToOne
	@JoinColumn(name="id_plan")
	private Plan plan;

	public WeeksSemestr() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountWeeks() {
		return this.countWeeks;
	}

	public void setCountWeeks(int countWeeks) {
		this.countWeeks = countWeeks;
	}

	public int getNumberSemestr() {
		return this.numberSemestr;
	}

	public void setNumberSemestr(int numberSemestr) {
		this.numberSemestr = numberSemestr;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

}