package com.vstu.entity.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/**
 * entity class for the load data of practice
 */

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class DataLoadPractice {

	private Integer semestrNumber;
	private Long idGroup;
	private Integer countStudents;
	private Long idSubject;
	private String nameSubject;
	private Integer pracZe;
	private Integer pracHour;

	public DataLoadPractice(Integer semestrNumber, Long idGroup, Integer countStudents, Long idSubject,
			String nameSubject, Integer pracZe, Integer pracHour) {

		this.semestrNumber = semestrNumber;
		this.idGroup = idGroup;
		this.countStudents = countStudents;
		this.idSubject = idSubject;
		this.nameSubject = nameSubject;
		this.pracZe = pracZe;
		this.pracHour = pracHour;
	}

}
