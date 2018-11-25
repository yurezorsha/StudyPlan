package com.vstu.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The persistent class for the groups database table.
 * 
 */

@Entity
public class Groups implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "id_plan")
	private Plan plan;

	private int countStudents;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public int getCountStudents() {
		return countStudents;
	}

	public void setCountStudents(int countStudents) {
		this.countStudents = countStudents;
	}

}
