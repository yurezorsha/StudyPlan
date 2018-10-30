package com.vstu.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the certification database table.
 * 
 */
@Entity
@NamedQuery(name="Certification.findAll", query="SELECT c FROM Certification c")
public class Certification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Plan
	@ManyToOne
	@JoinColumn(name="id_plan")
	private Plan plan;

	public Certification() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

}