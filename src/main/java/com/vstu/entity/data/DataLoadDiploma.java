package com.vstu.entity.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/**
 * entity class for the load data of diploma
 */

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class DataLoadDiploma {

	private Integer semestrNumber;
	private Long idGroup;
	private Integer countStudents;
	private Long idSubject;
	private String nameSubject;
	private Integer diplomZe;
	private Integer diplomHour;

	public DataLoadDiploma(Integer semestrNumber, Long idGroup, Integer countStudents, Long idSubject,
			String nameSubject, Integer diplomZe, Integer diplomHour) {

		this.semestrNumber = semestrNumber;
		this.idGroup = idGroup;
		this.countStudents = countStudents;
		this.idSubject = idSubject;
		this.nameSubject = nameSubject;
		this.diplomZe = diplomZe;
		this.diplomHour = diplomHour;
	}

	@Override
	public String toString() {
		return "DataLoadDiploma{" +
				"semestrNumber=" + semestrNumber +
				", idGroup=" + idGroup +
				", countStudents=" + countStudents +
				", idSubject=" + idSubject +
				", nameSubject='" + nameSubject + '\'' +
				", diplomZe=" + diplomZe +
				", diplomHour=" + diplomHour +
				'}';
	}
}
