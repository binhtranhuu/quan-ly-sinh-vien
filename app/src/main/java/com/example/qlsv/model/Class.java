package com.example.qlsv.model;

import androidx.annotation.NonNull;

public class Class {

    private int id;
    private String name;
    private String detail;

    public Class(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public Class(int id, String name, String detail) {
        this.id = id;
        this.name = name;
        this.detail = detail;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Class) {
            Class c = (Class) obj;
            if (c.getName().equals(name) && c.getId() == id) return true;
        }

        return false;
    }
}
