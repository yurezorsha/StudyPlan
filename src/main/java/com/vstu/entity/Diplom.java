package com.vstu.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the diplom database table.
 * 
 */
@Entity
@NamedQuery(name="Diplom.findAll", query="SELECT d FROM Diplom d")
public class Diplom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional one-to-one association to Plan
	@OneToOne(mappedBy="diplom")
	private Plan plan;

	public Diplom() {
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