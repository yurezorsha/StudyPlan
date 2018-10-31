package com.vstu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity 
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="id_plan")
	private Plan plan;
	
	@Column(name="count_students")
	private int count_students;

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

	public int getCount_students() {
		return count_students;
	}

	public void setCount_students(int count_students) {
		this.count_students = count_students;
	}
	
	
	
	
}
