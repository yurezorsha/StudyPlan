package com.vstu.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the plan database table.
 * 
 */
@Entity
@NamedQuery(name="Plan.findAll", query="SELECT p FROM Plan p")
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

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

	//bi-directional one-to-one association to Diplom
	@OneToOne
	@JoinColumn(name="id")
	private Diplom diplom;

	//bi-directional many-to-one association to Practice
	@OneToMany(mappedBy="plan")
	private List<Practice> practices;

	//bi-directional many-to-one association to WeeksSemestr
	@OneToMany(mappedBy="plan")
	private List<WeeksSemestr> weeksSemestrs;

	public Plan() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Certification> getCertifications() {
		return this.certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}

	public Certification addCertification(Certification certification) {
		getCertifications().add(certification);
		certification.setPlan(this);

		return certification;
	}

	public Certification removeCertification(Certification certification) {
		getCertifications().remove(certification);
		certification.setPlan(null);

		return certification;
	}

	public List<Fakultativ> getFakultativs() {
		return this.fakultativs;
	}

	public void setFakultativs(List<Fakultativ> fakultativs) {
		this.fakultativs = fakultativs;
	}

	public Fakultativ addFakultativ(Fakultativ fakultativ) {
		getFakultativs().add(fakultativ);
		fakultativ.setPlan(this);

		return fakultativ;
	}

	public Fakultativ removeFakultativ(Fakultativ fakultativ) {
		getFakultativs().remove(fakultativ);
		fakultativ.setPlan(null);

		return fakultativ;
	}

	public List<Node> getNodes() {
		return this.nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public Node addNode(Node node) {
		getNodes().add(node);
		node.setPlan(this);

		return node;
	}

	public Node removeNode(Node node) {
		getNodes().remove(node);
		node.setPlan(null);

		return node;
	}

	public Speciality getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public Diplom getDiplom() {
		return this.diplom;
	}

	public void setDiplom(Diplom diplom) {
		this.diplom = diplom;
	}

	public List<Practice> getPractices() {
		return this.practices;
	}

	public void setPractices(List<Practice> practices) {
		this.practices = practices;
	}

	public Practice addPractice(Practice practice) {
		getPractices().add(practice);
		practice.setPlan(this);

		return practice;
	}

	public Practice removePractice(Practice practice) {
		getPractices().remove(practice);
		practice.setPlan(null);

		return practice;
	}

	public List<WeeksSemestr> getWeeksSemestrs() {
		return this.weeksSemestrs;
	}

	public void setWeeksSemestrs(List<WeeksSemestr> weeksSemestrs) {
		this.weeksSemestrs = weeksSemestrs;
	}

	public WeeksSemestr addWeeksSemestr(WeeksSemestr weeksSemestr) {
		getWeeksSemestrs().add(weeksSemestr);
		weeksSemestr.setPlan(this);

		return weeksSemestr;
	}

	public WeeksSemestr removeWeeksSemestr(WeeksSemestr weeksSemestr) {
		getWeeksSemestrs().remove(weeksSemestr);
		weeksSemestr.setPlan(null);

		return weeksSemestr;
	}

}