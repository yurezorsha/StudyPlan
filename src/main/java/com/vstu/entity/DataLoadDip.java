package com.vstu.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class DataLoadDip {
	
	private Integer semestr_number;		
	private Long id_group;
	private Integer count_students;
	private Long id_subject;
	private String name_subject;
	private Integer diplom_ze;	
	private Integer diplom_hour;
	
	public DataLoadDip(Integer semestr_number, Long id_group, Integer count_students, Long id_subject,
			String name_subject, Integer diplom_ze, Integer diplom_hour) {
		
		this.semestr_number = semestr_number;
		this.id_group = id_group;
		this.count_students = count_students;
		this.id_subject = id_subject;
		this.name_subject = name_subject;
		this.diplom_ze = diplom_ze;
		this.diplom_hour = diplom_hour;
	}	

	 
	
	

}
