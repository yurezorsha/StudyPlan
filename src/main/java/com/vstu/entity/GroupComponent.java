package com.vstu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the group_components database table.
 * 
 */
@Entity
@Table(name = "group_components")
public class GroupComponent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	// bi-directional many-to-one association to GroupUnit
	@OneToMany(mappedBy = "groupComponent")
	@JsonIgnore
	private List<GroupUnit> groupUnits;

	public GroupComponent() {
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

	public List<GroupUnit> getGroupUnits() {
		return this.groupUnits;
	}

	public void setGroupUnits(List<GroupUnit> groupUnits) {
		this.groupUnits = groupUnits;
	}

}