package com.vstu.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the certification database table.
 * 
 */
@Entity
public class Certification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	
	private double ze;
	
	// bi-directional many-to-one association to Plan
	@ManyToOne
	@JoinColumn(name = "id_plan")
	@JsonIgnore
	private Plan plan;

	public Certification() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getZe() {
		return ze;
	}

	public void setZe(double ze) {
		this.ze = ze;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

}