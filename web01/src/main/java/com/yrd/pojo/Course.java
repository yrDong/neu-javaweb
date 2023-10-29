package com.yrd.pojo;

public class Course {
    private int id;
    private String name;
    private String lecturerName;
    private String masterName;
    private String description;

    public Course(int id, String name, String lecturerName, String masterName, String description) {
        this.id = id;
        this.name = name;
        this.lecturerName = lecturerName;
        this.masterName = masterName;
        this.description = description;
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

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lecturerName='" + lecturerName + '\'' +
                ", masterName='" + masterName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
