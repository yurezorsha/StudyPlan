package com.vstu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the plan database table.
 * 
 */

@NamedQuery(name = "Plan.findAll", query = "SELECT p FROM Plan p")
@SqlResultSetMappings({
		@SqlResultSetMapping(name = "DataLoad", classes = { @ConstructorResult(targetClass = DataLoad.class, columns = {
				@ColumnResult(name = "id_teacher", type = Long.class),
				@ColumnResult(name = "semestr_number", type = Integer.class),
				@ColumnResult(name = "count_lecture", type = Integer.class),
				@ColumnResult(name = "count_laboratory", type = Integer.class),
				@ColumnResult(name = "count_practice", type = Integer.class),
				@ColumnResult(name = "count_seminar", type = Integer.class),
				@ColumnResult(name = "type", type = String.class),
				@ColumnResult(name = "cource_work_hours", type = Integer.class),
				@ColumnResult(name = "id_group", type = Long.class),
				@ColumnResult(name = "count_students", type = Integer.class),
				@ColumnResult(name = "id_subject", type = Long.class),
				@ColumnResult(name = "name_subject", type = String.class),
				@ColumnResult(name = "calc_field", type = Float.class) }) }),

		@SqlResultSetMapping(name = "DataLoadPrac", classes = {
				@ConstructorResult(targetClass = DataLoadPrac.class, columns = {
						@ColumnResult(name = "semestr_number", type = Integer.class),
						@ColumnResult(name = "id_group", type = Long.class),
						@ColumnResult(name = "count_students", type = Integer.class),
						@ColumnResult(name = "id_subject", type = Long.class),
						@ColumnResult(name = "name_subject", type = String.class),
						@ColumnResult(name = "prac_ze", type = Integer.class),
						@ColumnResult(name = "prac_hour", type = Integer.class) })

		}),

		@SqlResultSetMapping(name = "DataLoadDip", classes = {
				@ConstructorResult(targetClass = DataLoadDip.class, columns = {
						@ColumnResult(name = "semestr_number", type = Integer.class),
						@ColumnResult(name = "id_group", type = Long.class),
						@ColumnResult(name = "count_students", type = Integer.class),
						@ColumnResult(name = "id_subject", type = Long.class),
						@ColumnResult(name = "name_subject", type = String.class),
						@ColumnResult(name = "diplom_ze", type = Integer.class),
						@ColumnResult(name = "diplom_hour", type = Integer.class) })

		}) })

@NamedNativeQueries({
		@NamedNativeQuery(name = "Plan.getDataPrac", query = "SELECT g.id as id_group, g.count_students as count_students, sb.id as id_subject, s.prac_ze as prac_ze, s.prac_hour as prac_hour,"
				+ " sb.name as name_subject, s.number as semestr_number"
				+ " FROM plan p, groups g, node n, semestr s, subject sb "
				+ "WHERE p.id = :id  and n.id_plan=:id and (s.id_node=n.id and n.id_subject=sb.id and (s.number = :num1 or s.number = :num2) and  (s.prac_ze <> 0 and s.prac_hour <> 0)) ", resultSetMapping = "DataLoadPrac", resultClass = DataLoadPrac.class),

		@NamedNativeQuery(name = "Plan.getDataDip", query = "SELECT g.id as id_group, g.count_students as count_students, sb.id as id_subject, s.diplom_ze as diplom_ze, s.diplom_hour as diplom_hour,"
				+ " sb.name as name_subject, s.number as semestr_number"
				+ " FROM plan p, groups g, node n, semestr s, subject sb "
				+ "WHERE p.id = :id  and n.id_plan=:id and (s.id_node=n.id and n.id_subject=sb.id and (s.number = :num1 or s.number = :num2) and  (s.diplom_ze <> 0 and s.diplom_hour <> 0)) ", resultSetMapping = "DataLoadDip", resultClass = DataLoadDip.class),

		@NamedNativeQuery(name = "Plan.getData", query = "SELECT s.id_teacher as id_teacher, g.id as id_group, g.count_students as count_students, sb.id as id_subject,"
				+ " sb.name as name_subject, s.number as semestr_number, s.lecture as count_lecture, s.laboratory as count_laboratory,"
				+ " s.practice as count_practice, s.seminar as count_seminar, t.name as type, s.cource_work_hours as cource_work_hours, (t.koff*g.count_students) as calc_field"
				+ " FROM plan p, groups g, node n, semestr s, subject sb, Type t "
				+ "WHERE p.id = :id  and n.id_plan=:id and (s.id_node=n.id and n.id_subject=sb.id and (s.number = :num1 or s.number = :num2)) and s.prac_hour = 0 and s.diplom_hour = 0 and t.id=s.id_type", resultSetMapping = "DataLoad", resultClass = DataLoad.class) })

@Entity
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "set_data_group")
	private int set_data_group;

	// bi-directional many-to-one association to Certification
	@OneToMany(mappedBy = "plan")
	@JsonIgnore
	private List<Certification> certifications;

	// bi-directional many-to-one association to Fakultativ
	@OneToMany(mappedBy = "plan")
	@JsonIgnore
	private List<Fakultativ> fakultativs;

	// bi-directional many-to-one association to Node
	@OneToMany(mappedBy = "plan")
	@JsonIgnore
	private List<Node> nodes;

	// bi-directional many-to-one association to Speciality
	@ManyToOne
	@JoinColumn(name = "id_speciality")
	private Speciality speciality;

	// bi-directional many-to-one association to Group
	@OneToMany(mappedBy = "plan")
	@JsonIgnore
	private List<Groups> group;

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

	public int getSet_data_group() {
		return set_data_group;
	}

	public void setSet_data_group(int set_data_group) {
		this.set_data_group = set_data_group;
	}

	public List<Groups> getGroup() {
		return group;
	}

	public void setGroup(List<Groups> group) {
		this.group = group;
	}

}