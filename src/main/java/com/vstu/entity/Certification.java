package com.vstu.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The persistent class for the certification database table.
 * 
 */
@Entity
public class Certification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	// bi-directional many-to-one association to Plan
	@ManyToOne
	@JoinColumn(name = "id_plan")
	private Plan plan;

	public Certification() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

}