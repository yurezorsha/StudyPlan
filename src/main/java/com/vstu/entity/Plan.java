package com.vstu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.vstu.entity.Certification;
import com.vstu.entity.Fakultativ;
import com.vstu.entity.Group;
import com.vstu.entity.Node;
import com.vstu.entity.Speciality;
import com.vstu.entity.WeeksSemestr;
 


/**
 * The persistent class for the plan database table.
 * 
 */ 
@Entity 
@NamedQuery(name="Plan.findAll", query="SELECT p FROM Plan p")
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="set_data_group")
	private int set_data_group;

	//bi-directional many-to-one association to Certification
	@OneToMany(mappedBy="plan")
	private List<Certification> certifications;

	//bi-directional many-to-one association to Fakultativ
	@OneToMany(mappedBy="plan")
	private List<Fakultativ> fakultativs;

	//bi-directional many-to-one association to Node
	@OneToMany(mappedBy="plan")
	private List<Node> nodes;

	//bi-directional many-to-one association to Speciality
	@ManyToOne
	@JoinColumn(name="id_speciality")
	private Speciality speciality;
	
	//bi-directional many-to-one association to Group
	@OneToMany(mappedBy="plan")	
	private List<Group> group;

	//bi-directional many-to-one association to WeeksSemestr
	@OneToMany(mappedBy="plan")
	private List<WeeksSemestr> weeksSemestrs;

	public Plan() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Certification> getCertifications() {
		return this.certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}



	public List<Fakultativ> getFakultativs() {
		return this.fakultativs;
	}

	public void setFakultativs(List<Fakultativ> fakultativs) {
		this.fakultativs = fakultativs;
	}

	

	public List<Node> getNodes() {
		return this.nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}



	public Speciality getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}


	public List<WeeksSemestr> getWeeksSemestrs() {
		return this.weeksSemestrs;
	}

	public void setWeeksSemestrs(List<WeeksSemestr> weeksSemestrs) {
		this.weeksSemestrs = weeksSemestrs;
	}

	public int getSet_data_group() {
		return set_data_group;
	}

	public void setSet_data_group(int set_data_group) {
		this.set_data_group = set_data_group;
	}

	public List<Group> getGroup() {
		return group;
	}

	public void setGroup(List<Group> group) {
		this.group = group;
	}



}