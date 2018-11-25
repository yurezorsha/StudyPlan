package com.vstu.entity.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/**
 * entity class for the load data of subjects
 */

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class DataLoadSubject {
	private Long idTeacher;
	private Integer semestrNumber;
	private Integer countLecture;
	private Integer countLaboratory;
	private Integer countPractice;
	private Integer countSeminar;
	private String type;
	private Integer courceWorkHours;
	private Long idGroup;
	private Integer countStudents;
	private Long idSubject;
	private String nameSubject;
	private Float calcField;

	public DataLoadSubject(Long idTeacher, Integer semestrNumber, Integer countLecture, Integer countLaboratory,
			Integer countPractice, Integer countSeminar, String type, Integer courceWorkHours, Long idGroup,
			Integer countStudents, Long idSubject, String nameSubject, Float calcField) {
		this.idTeacher = idTeacher;
		this.semestrNumber = semestrNumber;
		this.countLecture = countLecture;
		this.countLaboratory = countLaboratory;
		this.countPractice = countPractice;
		this.countSeminar = countSeminar;
		this.type = type;
		this.courceWorkHours = courceWorkHours;
		this.idGroup = idGroup;
		this.countStudents = countStudents;
		this.idSubject = idSubject;
		this.nameSubject = nameSubject;
		this.calcField = calcField;
	}

}
