package com.student;

import java.util.ArrayList;

public class Student implements java.io.Serializable {
    private int stdID;
    private String firstName;
    private String lastName;
    private ArrayList<String> courses;

    public Student(int stdID, String firstName, String lastName, ArrayList<String> courses) {
        this.stdID = stdID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = new ArrayList<String>(courses);
    }

    public Student(int stdID, String firstName, String lastName, String courses) {
        this.stdID = stdID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = new ArrayList<String>();
        try {
            // Divide each course
            String[] stringCourses = courses.split("\\s*,\\s*");
            // Assign courses into one ArrayList
            for(String course:stringCourses) {
               this.courses.add(course);
            }
        }catch(NullPointerException e) {
            e.printStackTrace();
        }
    }

    // Setters
    public void setStdId(int stdID) {
        this.stdID = stdID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    // Getters
    public int getStdId() {
        return this.stdID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public ArrayList<String> getCourses() {
        return this.courses;
    }
}
