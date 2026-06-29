package com.example;

public class Student {
    private final String fullName;
    private final String studentId;
    private final String major;
    private final String birthDate;
    private final String gender;
    private final String services;

    public Student(String fullName, String studentId, String major, String birthDate, String gender, String services) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.major = major;
        this.birthDate = birthDate;
        this.gender = gender;
        this.services = services;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getServices() {
        return services;
    }

    public String toDisplayText() {
        return "Full name: " + fullName + "\n"
                + "Student ID: " + studentId + "\n"
                + "Major: " + major + "\n"
                + "Birth date: " + birthDate + "\n"
                + "Gender: " + gender + "\n"
                + "Services: " + services;
    }
}