package com.vstu.entity.data;

import java.util.List;

/**
 * entity class for all load
 */
public class DataAllLoad {
    List<DataLoadSubject> loadSubjects;
    List<DataLoadDiploma> loadDiploma;
    List<DataLoadPractice> loadPractice;

    public DataAllLoad() {

    }

    public DataAllLoad(List<DataLoadSubject> loadSubjects, List<DataLoadDiploma> loadDiploma,
                       List<DataLoadPractice> loadPractice) {
        this.loadSubjects = loadSubjects;
        this.loadDiploma = loadDiploma;
        this.loadPractice = loadPractice;
    }


    public List<DataLoadSubject> getLoadSubjects() {
        return loadSubjects;
    }

    public void setLoadSubjects(List<DataLoadSubject> loadSubjects) {
        this.loadSubjects = loadSubjects;
    }

    public List<DataLoadDiploma> getLoadDiploma() {
        return loadDiploma;
    }

    public void setLoadDiploma(List<DataLoadDiploma> loadDiploma) {
        this.loadDiploma = loadDiploma;
    }

    public List<DataLoadPractice> getLoadPractice() {
        return loadPractice;
    }

    public void setLoadPractice(List<DataLoadPractice> loadPractice) {
        this.loadPractice = loadPractice;
    }

    @Override
    public String toString() {
        return "Subjects:[" + loadSubjects.toString() + "], [" + loadDiploma.toString() + "],[" + loadPractice.toString() + "]";
    }
}
