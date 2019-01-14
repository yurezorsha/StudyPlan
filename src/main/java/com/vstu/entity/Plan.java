package com.vstu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;

import com.fasterxml.jackson.annotation.JsonFormat;
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
						@ColumnResult(name = "idPractice", type = Long.class),
						@ColumnResult(name = "namePractice", type = String.class),
						@ColumnResult(name = "pracZe", type = Integer.class),
						@ColumnResult(name = "pracCountWeeks", type = Integer.class) })

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
		@NamedNativeQuery(name = "Plan.getDataLoadPractice", 
				          query = "SELECT g.id as idGroup, g.count_students as countStudents, pr.id as idPractice,"
				          + " pr.name as namePractice, pr.count_weeks as pracCountWeeks, "
				          + " pr.semestr_number as semestrNumber, pr.ze as pracZe "
				          + " FROM plan p, groups g, practice pr "
				          + " WHERE p.id = :id and g.id_plan= :id and pr.id_plan=:id and "
				          + " (pr.semestr_number = :num1 or pr.semestr_number = :num2) ",
				          resultSetMapping = "DataLoadPractice",
				          resultClass = DataLoadPractice.class),

		@NamedNativeQuery(name = "Plan.getDataLoadDiploma",
						  query = "SELECT g.id as idGroup, g.count_students as countStudents, sb.id as idSubject,"
						  + " s.diplom_ze as diplomZe, s.diplom_hour as diplomHour,"
						  + " sb.name as nameSubject, s.number as semestrNumber"
						  + " FROM plan p, groups g, node n, semestr s, subject sb "
						  + "WHERE p.id = :id and g.id_plan= :id  and n.id_plan=:id and"
						  + " (s.id_node=n.id and n.id_subject=sb.id and (s.number = :num1 or s.number = :num2) and"
						  + " (s.diplom_ze <> 0 and s.diplom_hour <> 0)) ",
						  resultSetMapping = "DataLoadDiploma",
						  resultClass = DataLoadDiploma.class),

		@NamedNativeQuery(name = "Plan.getDataLoadSubject",
		                  query = "SELECT s.id_teacher as idTeacher, g.id as idGroup, g.count_students as countStudents,"
		                  + " sb.id as idSubject, sb.name as nameSubject, s.number as semestrNumber, s.lecture as countLecture,"
		                  + " s.laboratory as countLaboratory, s.practice as countPractice, s.seminar as countSeminar,"
		                  + " t.name as type, s.cource_work_hours as courceWorkHours, (t.koff*g.count_students) as calcField"
				          + " FROM plan p, groups g, node n, semestr s, subject sb, Type t "
				          + "WHERE p.id = :id and g.id_plan= :id  and n.id_plan=:id and (s.id_node=n.id and n.id_subject=sb.id and"
				          + " (s.number = :num1 or s.number = :num2)) and s.diplom_hour = 0 and t.id=s.id_type",
				          resultSetMapping = "DataLoadSubject",
				          resultClass = DataLoadSubject.class) })

@Entity
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int setYearGroup;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Europe/Minsk")
	private Date dateApprove;
	
	private int countSemesters;
	
	private int firstYear;
	
	private int secondYear;
	
	private String registrationNumber;
	
	private String registrationNumberStandard;
	
	private int protocolNumber;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Europe/Minsk")
	private Date dateProtocol;
	
	@Lob
	@JsonIgnore
    private byte[] doc;
	
	@JsonIgnore
	private String fileName;
	
	// bi-directional many-to-one association to Certification
	@OneToMany(mappedBy = "plan")
	private List<Practice> practices;
	
	// bi-directional many-to-one association to Certification
	@OneToMany(mappedBy = "plan")
	private List<Certification> certifications;

	// bi-directional many-to-one association to Fakultativ
	@OneToMany(mappedBy = "plan")
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
		this.setYearGroup = date;
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

	public int getSetYearGroup() {
		return setYearGroup;
	}
	
	public void setSetYearGroup(int setYearGroup) {
		this.setYearGroup = setYearGroup;
	}

	public Date getDateApprove() {
		return dateApprove;
	}

	public void setDateApprove(Date dateApprove) {
		this.dateApprove = dateApprove;
	}

	public int getCountSemesters() {
		return countSemesters;
	}

	public void setCountSemesters(int countSemesters) {
		this.countSemesters = countSemesters;
	}

	public int getFirstYear() {
		return firstYear;
	}

	public void setFirstYear(int firstYear) {
		this.firstYear = firstYear;
	}

	public int getSecondYear() {
		return secondYear;
	}

	public void setSecondYear(int secondYear) {
		this.secondYear = secondYear;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getRegistrationNumberStandard() {
		return registrationNumberStandard;
	}

	public void setRegistrationNumberStandard(String registrationNumberStandard) {
		this.registrationNumberStandard = registrationNumberStandard;
	}

	public int getProtocolNumber() {
		return protocolNumber;
	}

	public void setProtocolNumber(int protocolNumber) {
		this.protocolNumber = protocolNumber;
	}

	public Date getDateProtocol() {
		return dateProtocol;
	}

	public void setDateProtocol(Date dateProtocol) {
		this.dateProtocol = dateProtocol;
	}

	public byte[] getDoc() {
		return doc;
	}

	public void setDoc(byte[] doc) {
		this.doc = doc;
	}
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<Practice> getPractices() {
		return practices;
	}

	public void setPractices(List<Practice> practices) {
		this.practices = practices;
	}

	public List<Groups> getGroup() {
		return group;
	}

	public void setGroup(List<Groups> group) {
		this.group = group;
	}

}