package com.vstu.entity;

import java.io.Serializable;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vstu.entity.data.DataLoadDiploma;
import com.vstu.entity.data.DataLoadPractice;
import com.vstu.entity.data.DataLoadSubject;

/**
 * The persistent class for the plan database table.
 * 
 */

// queries for full load
@SqlResultSetMappings({
		@SqlResultSetMapping(name = "DataLoadSubject", classes = {
				@ConstructorResult(targetClass = DataLoadSubject.class, columns = {
						@ColumnResult(name = "idTeacher", type = Long.class),
						@ColumnResult(name = "semestrNumber", type = Integer.class),
						@ColumnResult(name = "countLecture", type = Integer.class),
						@ColumnResult(name = "countLaboratory", type = Integer.class),
						@ColumnResult(name = "countPractice", type = Integer.class),
						@ColumnResult(name = "countSeminar", type = Integer.class),
						@ColumnResult(name = "type", type = String.class),
						@ColumnResult(name = "courceWorkHours", type = Integer.class),
						@ColumnResult(name = "idGroup", type = Long.class),
						@ColumnResult(name = "countStudents", type = Integer.class),
						@ColumnResult(name = "idSubject", type = Long.class),
						@ColumnResult(name = "nameSubject", type = String.class),
						@ColumnResult(name = "calcField", type = Float.class) }) }),

		@SqlResultSetMapping(name = "DataLoadPractice", classes = {
				@ConstructorResult(targetClass = DataLoadPractice.class, columns = {
						@ColumnResult(name = "semestrNumber", type = Integer.class),
						@ColumnResult(name = "idGroup", type = Long.class),
						@ColumnResult(name = "countStudents", type = Integer.class),
						@ColumnResult(name = "idSubject", type = Long.class),
						@ColumnResult(name = "nameSubject", type = String.class),
						@ColumnResult(name = "pracZe", type = Integer.class),
						@ColumnResult(name = "pracHour", type = Integer.class) })

		}),

		@SqlResultSetMapping(name = "DataLoadDiploma", classes = {
				@ConstructorResult(targetClass = DataLoadDiploma.class, columns = {
						@ColumnResult(name = "semestrNumber", type = Integer.class),
						@ColumnResult(name = "idGroup", type = Long.class),
						@ColumnResult(name = "countStudents", type = Integer.class),
						@ColumnResult(name = "idSubject", type = Long.class),
						@ColumnResult(name = "nameSubject", type = String.class),
						@ColumnResult(name = "diplomZe", type = Integer.class),
						@ColumnResult(name = "diplomHour", type = Integer.class) })

		}) })

@NamedNativeQueries({
		@NamedNativeQuery(name = "Plan.getDataLoadPractice", query = "SELECT g.id as idGroup, g.count_students as countStudents, sb.id as idSubject, s.prac_ze as pracZe, s.prac_hour as pracHour,"
				+ " sb.name as nameSubject, s.number as semestrNumber"
				+ " FROM plan p, groups g, node n, semestr s, subject sb "
				+ "WHERE p.id = :id and g.id_plan= :id  and n.id_plan=:id and (s.id_node=n.id and n.id_subject=sb.id and (s.number = :num1 or s.number = :num2) and  (s.prac_ze <> 0 and s.prac_hour <> 0)) ", resultSetMapping = "DataLoadPractice", resultClass = DataLoadPractice.class),

		@NamedNativeQuery(name = "Plan.getDataLoadDiploma", query = "SELECT g.id as idGroup, g.count_students as countStudents, sb.id as idSubject, s.diplom_ze as diplomZe, s.diplom_hour as diplomHour,"
				+ " sb.name as nameSubject, s.number as semestrNumber"
				+ " FROM plan p, groups g, node n, semestr s, subject sb "
				+ "WHERE p.id = :id and g.id_plan= :id  and n.id_plan=:id and (s.id_node=n.id and n.id_subject=sb.id and (s.number = :num1 or s.number = :num2) and  (s.diplom_ze <> 0 and s.diplom_hour <> 0)) ", resultSetMapping = "DataLoadDiploma", resultClass = DataLoadDiploma.class),

		@NamedNativeQuery(name = "Plan.getDataLoadSubject", query = "SELECT s.id_teacher as idTeacher, g.id as idGroup, g.count_students as countStudents, sb.id as idSubject,"
				+ " sb.name as nameSubject, s.number as semestrNumber, s.lecture as countLecture, s.laboratory as countLaboratory,"
				+ " s.practice as countPractice, s.seminar as countSeminar, t.name as type, s.cource_work_hours as courceWorkHours, (t.koff*g.count_students) as calcField"
				+ " FROM plan p, groups g, node n, semestr s, subject sb, Type t "
				+ "WHERE p.id = :id and g.id_plan= :id  and n.id_plan=:id and (s.id_node=n.id and n.id_subject=sb.id and (s.number = :num1 or s.number = :num2)) and s.prac_hour = 0 and s.diplom_hour = 0 and t.id=s.id_type", resultSetMapping = "DataLoadSubject", resultClass = DataLoadSubject.class) })

@Entity
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int setDataGroup;

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

	public Plan(int date, Speciality speciality) {
		this.setDataGroup = date;
		this.speciality = speciality;
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

	public int getSetDataGroup() {
		return setDataGroup;
	}

	public void setSetdatagroup(int setDataGroup) {
		this.setDataGroup = setDataGroup;
	}

	public List<Groups> getGroup() {
		return group;
	}

	public void setGroup(List<Groups> group) {
		this.group = group;
	}

}