package com.vstu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the speciality database table.
 * 
 */
@Entity
public class Speciality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String name;

	private String shifr;

	// bi-directional many-to-one association to Plan
	@OneToMany(mappedBy = "speciality")
	@JsonIgnore
	private List<Plan> plans;

	public Speciality() {
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

	public List<Plan> getPlans() {
		return this.plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

}