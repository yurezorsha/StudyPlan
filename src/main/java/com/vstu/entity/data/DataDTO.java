package com.vstu.entity.data;

import java.util.List;

public class DataDTO {
	List<DataLoad> load_subjects;
	List<DataLoadDip> load_diploma;
	List<DataLoadPrac> load_practice;

	public DataDTO() {

	}

	public DataDTO(List<DataLoad> load_subjects, List<DataLoadDip> load_diploma, List<DataLoadPrac> load_practice) {
		this.load_subjects = load_subjects;
		this.load_diploma = load_diploma;
		this.load_practice = load_practice;
	}

	public List<DataLoad> getLoad_subjects() {
		return load_subjects;
	}

	public void setLoad_subjects(List<DataLoad> load_subjects) {
		this.load_subjects = load_subjects;
	}

	public List<DataLoadDip> getLoad_diploma() {
		return load_diploma;
	}

	public void setLoad_diploma(List<DataLoadDip> load_diploma) {
		this.load_diploma = load_diploma;
	}

	public List<DataLoadPrac> getLoad_practice() {
		return load_practice;
	}

	public void setLoad_practice(List<DataLoadPrac> load_practice) {
		this.load_practice = load_practice;
	}

}
