package com.vstu.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fakultativ database table.
 * 
 */
@Entity
@NamedQuery(name="Fakultativ.findAll", query="SELECT f FROM Fakultativ f")
public class Fakultativ implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to Plan
	@ManyToOne
	@JoinColumn(name="id_plan")
	private Plan plan;

	public Fakultativ() {
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

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

}