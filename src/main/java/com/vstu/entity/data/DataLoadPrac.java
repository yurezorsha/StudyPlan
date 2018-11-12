package com.vstu.entity.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class DataLoadPrac {
	
	private Integer semestr_number;		
	private Long id_group;
	private Integer count_students;
	private Long id_subject;
	private String name_subject;
	private Integer prac_ze;	
	private Integer prac_hour;
	
	public DataLoadPrac(Integer semestr_number, Long id_group, Integer count_students, Long id_subject,
			String name_subject, Integer prac_ze, Integer prac_hour) {
		
		this.semestr_number = semestr_number;
		this.id_group = id_group;
		this.count_students = count_students;
		this.id_subject = id_subject;
		this.name_subject = name_subject;
		this.prac_ze = prac_ze;
		this.prac_hour = prac_hour;
	}	

	 
	
	

}
