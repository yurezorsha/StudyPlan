package com.vstu.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the speciality database table.
 * 
 */
@Entity
@NamedQuery(name="Speciality.findAll", query="SELECT s FROM Speciality s")
public class Speciality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private String shifr;

	//bi-directional many-to-one association to Plan
	@OneToMany(mappedBy="speciality")
	private List<Plan> plans;

	public Speciality() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public Plan addPlan(Plan plan) {
		getPlans().add(plan);
		plan.setSpeciality(this);

		return plan;
	}

	public Plan removePlan(Plan plan) {
		getPlans().remove(plan);
		plan.setSpeciality(null);

		return plan;
	}

}