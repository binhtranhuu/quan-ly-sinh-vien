package com.example.qlsv.model;

public class StudentClass {

    private int id_student;
    private int id_class;
    private String term;
    private String credit;

    public StudentClass(int id_student, int id_class, String term, String credit) {
        this.id_student = id_student;
        this.id_class = id_class;
        this.term = term;
        this.credit = credit;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
}
