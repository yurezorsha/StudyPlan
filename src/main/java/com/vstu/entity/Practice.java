package com.vstu.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the practice database table.
 * 
 */
@Entity
@NamedQuery(name="Practice.findAll", query="SELECT p FROM Practice p")
public class Practice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="count_week")
	private int countWeek;

	@Column(name="id_semestr")
	private int idSemestr;

	private String name;

	//bi-directional many-to-one association to Plan
	@ManyToOne
	@JoinColumn(name="id_plan")
	private Plan plan;

	public Practice() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountWeek() {
		return this.countWeek;
	}

	public void setCountWeek(int countWeek) {
		this.countWeek = countWeek;
	}

	public int getIdSemestr() {
		return this.idSemestr;
	}

	public void setIdSemestr(int idSemestr) {
		this.idSemestr = idSemestr;
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