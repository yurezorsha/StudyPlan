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
	private Long idPractice;
	private String namePractice;
	private Integer pracZe;
	private Integer pracCountWeeks;

	public DataLoadPractice(Integer semestrNumber, Long idGroup, Integer countStudents, Long idPractice,
			String namePractice, Integer pracZe, Integer pracCountWeeks) {

		this.semestrNumber = semestrNumber;
		this.idGroup = idGroup;
		this.countStudents = countStudents;
		this.idPractice = idPractice;
		this.namePractice = namePractice;
		this.pracZe = pracZe;
		this.pracCountWeeks = pracCountWeeks;
	}

	@Override
	public String toString() {
		return "DataLoadPractice{" +
				"semestrNumber=" + semestrNumber +
				", idGroup=" + idGroup +
				", countStudents=" + countStudents +
				", idPractice=" + idPractice +
				", namePractice='" + namePractice + '\'' +
				", pracZe=" + pracZe +
				", pracCountWeeks=" + pracCountWeeks +
				'}';
	}
}
