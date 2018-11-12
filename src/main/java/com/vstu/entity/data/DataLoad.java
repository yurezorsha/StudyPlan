package com.vstu.entity.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class DataLoad {
	private Long id_teacher;
	private Integer semestr_number;
	private Integer count_lecture;
	private Integer count_laboratory;
	private Integer count_practice;
	private Integer count_seminar;
	private String type;
	private Integer cource_work_hours;
	private Long id_group;
	private Integer count_students;
	private Long id_subject;
	private String name_subject;
	private Float calc_field;

	public DataLoad(Long id_teacher, Integer semestr_number, Integer count_lecture, Integer count_laboratory,
			Integer count_practice, Integer count_seminar, String type, Integer cource_work_hours, Long id_group,
			Integer count_students, Long id_subject, String name_subject, Float calc_field) {
		this.id_teacher = id_teacher;
		this.semestr_number = semestr_number;
		this.count_lecture = count_lecture;
		this.count_laboratory = count_laboratory;
		this.count_practice = count_practice;
		this.count_seminar = count_seminar;
		this.type = type;
		this.cource_work_hours = cource_work_hours;
		this.id_group = id_group;
		this.count_students = count_students;
		this.id_subject = id_subject;
		this.name_subject = name_subject;
		this.calc_field = calc_field;
	}

}
