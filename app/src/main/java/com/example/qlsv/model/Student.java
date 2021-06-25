package com.example.qlsv.model;

import androidx.annotation.NonNull;

public class Student {
    private int id;
    private String name;
    private String birthday;
    private String home;
    private String year;

    public Student(String name, String birthday, String home, String year) {
        this.name = name;
        this.birthday = birthday;
        this.home = home;
        this.year = year;
    }

    public Student(int id, String name, String birthday, String home, String year) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.home = home;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student s = (Student) obj;
            if (s.getName().equals(name) && s.getId() == id) return true;
        }

        return false;
    }
}
