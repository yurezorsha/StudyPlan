package com.vstu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the group_units database table.
 * 
 */
@Entity
@Table(name = "group_units")
@NamedQuery(name = "GroupUnit.findAll", query = "SELECT g FROM GroupUnit g")
public class GroupUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	// bi-directional many-to-one association to GroupComponent
	@ManyToOne
	@JoinColumn(name = "id_group_components")
	private GroupComponent groupComponent;

	// bi-directional many-to-one association to Subject
	@OneToMany(mappedBy = "groupUnit")
	@JsonIgnore
	private List<Subject> subjects;

	public GroupUnit() {
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

	public GroupComponent getGroupComponent() {
		return this.groupComponent;
	}

	public void setGroupComponent(GroupComponent groupComponent) {
		this.groupComponent = groupComponent;
	}

	public List<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}


}